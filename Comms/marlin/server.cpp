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

class session : public boost::enable_shared_from_this<session>
{
    public:
        typedef boost::shared_ptr<session> pointer;

        static pointer create(boost::asio::io_service& io_service) {
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

        void read() {
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
                    codedInputStream.PopLimit(messageSize);
                }
            }
        }

        void write(RoboComms::RoboRes res) {
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

        void handle_write(const boost::system::error_code& error) {
            //TODO: Handle return from write

        }

        void process_request(RoboComms::RoboReq req) {
            //TODO: Implement
            std::cout << req.type() << std::endl;
        }

        tcp::socket socket_;
        enum { max_length = 5120 };
        char data_[max_length];
};

class server
{
    public:
        server(boost::asio::io_service& io_service, short port)
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
        if (argc != 2)
        {
            std::cerr << "Usage: server <port>\n";
            return 1;
        }

        boost::asio::io_service io_service;
        int port = std::atoi(argv[1]);
        std::cout << "Serving on port " << port << std::endl;
        server s(io_service, port);
        io_service.run();
    }
    catch (std::exception& e)
    {
        std::cerr << "Exception: " << e.what() << "\n";
    }

    return 0;
}
