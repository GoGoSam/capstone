//server.cpp
//Sam Coe

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <boost/bind.hpp>
#include <boost/shared_ptr.hpp>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/io/zero_copy_stream_impl.h>
#include "server.hpp"

using boost::asio::ip::tcp;
using google::protobuf::io::CodedInputStream;
using google::protobuf::io::CodedOutputStream;
using google::protobuf::io::ArrayInputStream;
using google::protobuf::io::OstreamOutputStream;

serial_connection::pointer base_serial;
serial_connection::pointer lift_serial;
std::ofstream servos;

//TODO: Handle cleanup when killed
//Close servos and serial
int main(int argc, const char* argv[])
{
    try
    {
        if (argc != 3)
        {
            std::cerr << "Usage: <port> <base/lift>" << std::endl;
            return 1;
        }

        boost::asio::io_service io_service;
        int port = std::atoi(argv[1]);
        const char* component = argv[2];
        if(strcmp(component, "lift") == 0) {
            const char* s = "/dev/servoblaster";
            const char* d = "/dev/ttyUSB0";
            servos.open(s, std::ofstream::out | std::ofstream::trunc);
            lift_serial = serial_connection::create(io_service, d);
        } else {
            const char* d = "/dev/ttyUSB0";
            base_serial = serial_connection::create(io_service, d);
        }
        std::cout << "Serving on port " << port << std::endl;
        std::cout << "Controlling " << component << std::endl;
        server s(io_service, port);
        io_service.run();
    }
    catch (std::exception& e)
    {
        std::cerr << "Exception: " << e.what() << "\n";
    }

    return 0;
}

server::server(boost::asio::io_service& io_service, int port)
: io_service_(io_service),
  acceptor_(io_service, tcp::endpoint(tcp::v4(), port))
{
    listen();
}

void server::listen()
{
    session::pointer new_session = session::create(io_service_);
    acceptor_.async_accept(new_session->socket(),
            boost::bind(&server::accept, this, new_session,
                boost::asio::placeholders::error));
}

void server::accept(session::pointer new_session,
        const boost::system::error_code& error)
{
    if (!error)
    {
        new_session->start();
        listen();
    }
}

session::pointer session::create(boost::asio::io_service& io_service)
{
    pointer p(new session(io_service));
    return p;
}

session::session(boost::asio::io_service& io_service)
: socket_(io_service)
{
}

tcp::socket& session::socket()
{
    return socket_;
}

void session::start()
{
    read();
}

void session::read()
{
    boost::asio::async_read(socket_,
            boost::asio::buffer(data_),
            boost::asio::transfer_at_least(1),
            boost::bind(&session::handle_read, shared_from_this(),
                boost::asio::placeholders::error));
}

void session::handle_read(const boost::system::error_code& error)
{
    if (!error) {
        ArrayInputStream arrayInputStream(data_, max_length_);
        CodedInputStream codedInputStream(&arrayInputStream);
        uint32_t messageSize;
        if(codedInputStream.ReadVarint32(&messageSize)) {
            //TODO: Check that whole message is in buffer
            CodedInputStream::Limit msgLimit = codedInputStream.PushLimit(messageSize);
            RoboComms::RoboReq req;
            req.ParseFromCodedStream(&codedInputStream);
            process_request(req);
            codedInputStream.PopLimit(msgLimit);
        }
    }
}

void session::write(const RoboComms::RoboRes& res)
{
    boost::asio::streambuf request;
    std::ostream request_stream(&request);

    OstreamOutputStream raw_output(&request_stream);
    CodedOutputStream coded_output(&raw_output);

    coded_output.WriteVarint32(res.ByteSize());
    res.SerializeToCodedStream(&coded_output);

    boost::asio::async_write(socket_,
            request,
            boost::bind(&session::handle_write, shared_from_this(),
                boost::asio::placeholders::error));
}

void session::handle_write(const boost::system::error_code& error)
{
    //TODO: Handle return from write
}

void session::process_request(const RoboComms::RoboReq& req)
{
    switch(req.type()) {
        case 0:
            //Robot base move command
            if (base_serial) {
                base_serial->write((unsigned char*) req.base().cmd().c_str(),
                             req.base().cmd().length());
            } else {
                std::cout << "Request for wrong component" << std::endl;
            }
            break;
        case 1:
            //Robot lift move command
            if (lift_serial) {
                lift_serial->write((unsigned char*) req.lift().cmd().c_str(),
                            req.lift().cmd().length());
            } else {
                std::cout << "Request for wrong component" << std::endl;
            }
            break;
        case 2:
            //Robot sensor move command
            servos << req.sens().cmd() << std::endl;
            break;
        case 3:
            //Robot data request command
            break;
        default:
            //Shouldn't ever get here
            break;
    }
    read();
}

serial_connection::pointer serial_connection::create(boost::asio::io_service& io_service,
        const std::string name)
{
    pointer p(new serial_connection(io_service, name));
    return p;
}

serial_connection::serial_connection(boost::asio::io_service& io_service,
        const std::string name,
        const unsigned int baud_rate,
        const unsigned int char_size,
        const enum boost::asio::serial_port_base::flow_control::type flow_control,
        const enum boost::asio::serial_port_base::parity::type parity,
        const enum boost::asio::serial_port_base::stop_bits::type stop_bits
        )
: io_service_(io_service),
  serial_port_(io_service),
  name_(name),
  baud_rate_(baud_rate),
  char_size_(char_size),
  flow_control_(flow_control),
  parity_(parity),
  stop_bits_(stop_bits)
{
    open();
}

void serial_connection::open()
{
    if (!serial_port_.is_open())
    {
        boost::system::error_code error_code;
        serial_port_.open(name_, error_code);

        if (error_code == boost::system::errc::no_such_file_or_directory )
        {
            //TODO: handle the error
        }

        serial_port_.set_option(boost::asio::serial_port::baud_rate(baud_rate_));
        serial_port_.set_option(boost::asio::serial_port::flow_control(flow_control_));
        serial_port_.set_option(boost::asio::serial_port::parity(parity_));
        serial_port_.set_option(boost::asio::serial_port::stop_bits(stop_bits_));
        serial_port_.set_option(boost::asio::serial_port::character_size(char_size_));
    }
}

void serial_connection::write(unsigned char* data, int size)
{
    boost::asio::async_write(serial_port_,
            boost::asio::buffer(data, size),
            boost::bind(&serial_connection::handle_write, shared_from_this(),
                boost::asio::placeholders::error,
                boost::asio::placeholders::bytes_transferred));
}

void serial_connection::handle_write(const boost::system::error_code& error,
        std::size_t bytes)
{
    //TODO: Handle return from write
}

void serial_connection::read()
{
    //TODO: Should this be async_read_some
    boost::asio::async_read(serial_port_,
            boost::asio::buffer(data_),
            boost::asio::transfer_at_least(1),
            boost::bind(&serial_connection::handle_read, shared_from_this(),
                boost::asio::placeholders::error));
}

void serial_connection::handle_read(const boost::system::error_code& error)
{
    //TODO: Handle return from read
}
