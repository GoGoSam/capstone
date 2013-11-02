//server.cpp
//Sam Coe

#include <cstdlib>
#include <iostream>
#include <boost/bind.hpp>
#include <boost/shared_ptr.hpp>
#include <boost/enable_shared_from_this.hpp>
#include <boost/asio.hpp>

//TODO: Move to header file
#define HEADER_SIZE 4

using boost::asio::ip::tcp;

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
            read_header();
        }

    private:
        session(boost::asio::io_service& io_service)
            : socket_(io_service)
        {
        }

        void read_header() {
            data_.resize(HEADER_SIZE);
            boost::asio::async_read(socket_,
                    boost::asio::buffer(data_),
                    boost::bind(&session::handle_read_header, shared_from_this(),
                        boost::asio::placeholders::error));
        }

        void handle_read_header(const boost::system::error_code& error)
        {
            if (!error) {
                //Received header
                //unsigned msg_len = m_packed_request.decode_header(data_);
                unsigned msg_len = 0;
                read_body(msg_len);
            }
        }

        void read_body(unsigned msg_len)
        {
        }

        tcp::socket socket_;
        std::vector<uint8_t> data_;
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
