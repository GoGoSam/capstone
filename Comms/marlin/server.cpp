//server.cpp
//Sam Coe

#include <cstdlib>
#include <iostream>
#include <boost/asio.hpp>
#include <boost/shared_ptr.hpp>
#include <boost/bind.hpp>
#include <boost/enable_shared_from_this.hpp>
#include "db_server.h"
#include "packedmessage.h"
#include "stringdb.pb.h"

using boost::asio::ip::tcp;

class session : public boost::enable_shared_from_this<session>
{
    public:
        session(boost::asio::io_service& io_service)
            : socket_(io_service)
        {
        }

        tcp::socket& socket()
        {
            return socket_;
        }

        void start()
        {
            read_header();
        }

    private:
        void read_header() {
            data_.resize(HEADER_SIZE);
            boost::asio::async_read(socket_,
                    asio::buffer(data_),
                    boost::bind(&session::handle_read_header, shared_from_this(),
                        asio::placeholders::error));
        }

        void handle_read_header(const boost::system::error_code& error)
        {
            if (!error) {
                //Received header
                unsigned msg_len = m_packed_request.decode_header(m_readbuf);
                read_body(msg_len);
            }
        }

        void handle_read(const boost::system::error_code& error,
                size_t bytes_transferred)
        {
            if (!error)
            {
                boost::asio::async_write(socket_,
                        boost::asio::buffer(data_, bytes_transferred),
                        boost::bind(&session::handle_write, shared_from_this(),
                            boost::asio::placeholders::error));
            }
        }

        void handle_write(const boost::system::error_code& error)
        {
            if (!error)
            {
                socket_.async_read_some(boost::asio::buffer(data_, max_length),
                        boost::bind(&session::handle_read, shared_from_this(),
                            boost::asio::placeholders::error,
                            boost::asio::placeholders::bytes_transferred));
            }
        }

        tcp::socket socket_;
        vector<uint8_t> data_;
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
            boost::shared_ptr<session> new_session(new session(io_service_));
            acceptor_.async_accept(new_session->socket(),
                    boost::bind(&server::accept, this, new_session,
                        boost::asio::placeholders::error));
        }

        void accept(session* new_session,
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
        port = std::atoi(argv[1]);
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
