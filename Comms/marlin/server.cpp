//server.cpp
//Sam Coe

#include <cstdlib>
#include <iostream>
#include <boost/bind.hpp>
#include <boost/shared_ptr.hpp>
#include <boost/enable_shared_from_this.hpp>
#include <boost/asio.hpp>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/io/zero_copy_stream_impl.h>
#include "robocomms.pb.h"

using boost::asio::ip::tcp;
using google::protobuf::io::CodedInputStream;
using google::protobuf::io::CodedOutputStream;
using google::protobuf::io::ArrayInputStream;
using google::protobuf::io::OstreamOutputStream;

class serial_connection : public boost::enable_shared_from_this<serial_connection>
{
    public:
        typedef boost::shared_ptr<serial_connection> pointer;

        static pointer create(boost::asio::io_service& io_service,
                              const std::string name)
        {
            return pointer(new serial_connection(io_service, name));
        }

        void write(unsigned char* data, int size)
        {
            boost::asio::async_write(serial_port_,
                    boost::asio::buffer(data, size),
                    boost::bind(&serial_connection::handle_write, shared_from_this(),
                        boost::asio::placeholders::error,
                        boost::asio::placeholders::bytes_transferred));
        }

    private:
        serial_connection(boost::asio::io_service& io_service,
            const std::string name,
            const unsigned int baud_rate = 19200,
            const unsigned int char_size = 8,
            const enum boost::asio::serial_port_base::flow_control::type flow_control =
                boost::asio::serial_port_base::flow_control::none,
            const enum boost::asio::serial_port_base::parity::type parity =
                boost::asio::serial_port_base::parity::none,
            const enum boost::asio::serial_port_base::stop_bits::type stop_bits =
                boost::asio::serial_port_base::stop_bits::one
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

        void open()
        {
            if (!serial_port_.is_open())
            {
                boost::system::error_code error_code;
                serial_port_.open(name_, error_code);

                if (error_code == boost::system::errc::no_such_file_or_directory )
                {
                   //TODO: handle the error somehow
                   //for example you tried to open "COM1" on a linux machine.
                }

                serial_port_.set_option(boost::asio::serial_port::baud_rate(baud_rate_));
                serial_port_.set_option(boost::asio::serial_port::flow_control(flow_control_));
                serial_port_.set_option(boost::asio::serial_port::parity(parity_));
                serial_port_.set_option(boost::asio::serial_port::stop_bits(stop_bits_));
                serial_port_.set_option(boost::asio::serial_port::character_size(char_size_));
            }
        }

        void read()
        {
            //TODO: Should this be async_read_some
            boost::asio::async_read(serial_port_,
                    boost::asio::buffer(data_),
                    boost::asio::transfer_at_least(1),
                    boost::bind(&serial_connection::handle_read, shared_from_this(),
                        boost::asio::placeholders::error));
        }

        void handle_read(const boost::system::error_code& error)
        {
            //TODO: Handle return from read
        }

        void handle_write(const boost::system::error_code& error,
                          std::size_t bytes)
        {
            //TODO: Handle return from write
            std::cout << error.message() << std::endl;
            std::cout << bytes << std::endl;
        }

        boost::asio::io_service& io_service_;
        boost::asio::serial_port serial_port_;
        std::string name_;
        const unsigned int baud_rate_;
        const unsigned int char_size_;
        const enum boost::asio::serial_port_base::flow_control::type flow_control_;
        const enum boost::asio::serial_port_base::parity::type parity_;
        const enum boost::asio::serial_port_base::stop_bits::type stop_bits_;
        static const int max_length = 512;
        char data_[max_length];
};

serial_connection::pointer serial;

class session : public boost::enable_shared_from_this<session>
{
    public:
        typedef boost::shared_ptr<session> pointer;

        static pointer create(boost::asio::io_service& io_service)
        {
            return pointer(new session(io_service));
        }

        tcp::socket& socket()
        {
            return socket_;
        }

        void start()
        {
            read();
        }

    private:
        session(boost::asio::io_service& io_service)
            : socket_(io_service)
        {
        }

        void read()
        {
            boost::asio::async_read(socket_,
                    boost::asio::buffer(data_),
                    boost::asio::transfer_at_least(1),
                    boost::bind(&session::handle_read, shared_from_this(),
                        boost::asio::placeholders::error));
        }

        void handle_read(const boost::system::error_code& error)
        {
            if (!error) {
                ArrayInputStream arrayInputStream(data_, max_length);
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

        void write(RoboComms::RoboRes res)
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

        void handle_write(const boost::system::error_code& error)
        {
            //TODO: Handle return from write
        }

        void process_request(RoboComms::RoboReq req)
        {
            //TODO: Implement
            std::cout << req.type() << std::endl;
            unsigned char *test = (unsigned char*) req.base().cmd().c_str();
            for (int i = 0; i < req.base().cmd().length(); i++) {
                std::cout << (int)test[i] << " ";
            }
            std::cout << std::endl;
            serial->write(test, req.base().cmd().length());
        }

        static const int max_length = 5120;
        char data_[max_length];
        tcp::socket socket_;
};

class server
{
    public:
        server(boost::asio::io_service& io_service, int port, const char* device)
            : io_service_(io_service),
              acceptor_(io_service, tcp::endpoint(tcp::v4(), port))
        {
            listen();
        }

    private:
        void listen()
        {
            session::pointer new_session = session::create(io_service_);
            acceptor_.async_accept(new_session->socket(),
                    boost::bind(&server::accept, this, new_session,
                        boost::asio::placeholders::error));
        }

        void accept(session::pointer new_session,
                const boost::system::error_code& error)
        {
            if (!error)
            {
                new_session->start();
                listen();
            }

        }

        boost::asio::io_service& io_service_;
        tcp::acceptor acceptor_;
};

int main(int argc, const char* argv[])
{
    try
    {
        if (argc != 3)
        {
            std::cerr << "Usage: <port> <device>\n";
            return 1;
        }

        boost::asio::io_service io_service;
        int port = std::atoi(argv[1]);
        const char* device = argv[2];
        std::cout << "Serving on port " << port << std::endl;
        std::cout << "Controlling device " << device << std::endl;
        serial = serial_connection::create(io_service, device);
        server s(io_service, port, device);
        io_service.run();
    }
    catch (std::exception& e)
    {
        std::cerr << "Exception: " << e.what() << "\n";
    }

    return 0;
}
