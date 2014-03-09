//server.h
//Sam Coe

#ifndef __SERVER_H__
#define __SERVER_H__

#include <boost/asio.hpp>
#include <boost/enable_shared_from_this.hpp>
#include "robocomms.pb.h"

class session : public boost::enable_shared_from_this<session>
{
    public:
        typedef boost::shared_ptr<session> pointer;
        static pointer create(boost::asio::io_service&);
        boost::asio::ip::tcp::socket& socket();
        void start();

    private:
        session(boost::asio::io_service&);
        void read();
        void handle_read(const boost::system::error_code&);
        void write(const RoboComms::RoboRes&);
        void handle_write(const boost::system::error_code&);
        void process_request(const RoboComms::RoboReq&);

        static const int max_length_ = 5120;
        char data_[max_length_];
        boost::asio::ip::tcp::socket socket_;
};

class server
{
    public:
        server(boost::asio::io_service&, int);

    private:
        void listen();
        void accept(session::pointer, const boost::system::error_code&);

        boost::asio::io_service& io_service_;
        boost::asio::ip::tcp::acceptor acceptor_;
};

class serial_connection : public boost::enable_shared_from_this<serial_connection>
{
    public:
        typedef boost::shared_ptr<serial_connection> pointer;
        static pointer create(boost::asio::io_service&, const std::string);
        void write(unsigned char*, int);
        void read(unsigned char*, int);

    private:
        serial_connection(boost::asio::io_service& io_service,
            const std::string name,
            const unsigned int baud_rate = 38400,
            const unsigned int char_size = 8,
            const enum boost::asio::serial_port_base::flow_control::type flow_control =
                boost::asio::serial_port_base::flow_control::none,
            const enum boost::asio::serial_port_base::parity::type parity =
                boost::asio::serial_port_base::parity::none,
            const enum boost::asio::serial_port_base::stop_bits::type stop_bits =
                boost::asio::serial_port_base::stop_bits::one
            );
        void open();
        void handle_read(const boost::system::error_code&, std::size_t);
        void handle_write(const boost::system::error_code&, std::size_t);

        boost::asio::io_service& io_service_;
        boost::asio::serial_port serial_port_;
        std::string name_;
        const unsigned int baud_rate_;
        const unsigned int char_size_;
        const enum boost::asio::serial_port_base::flow_control::type flow_control_;
        const enum boost::asio::serial_port_base::parity::type parity_;
        const enum boost::asio::serial_port_base::stop_bits::type stop_bits_;
};

#endif
