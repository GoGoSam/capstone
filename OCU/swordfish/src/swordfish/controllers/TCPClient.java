package swordfish.controllers;

import swordfish.models.RoboComms.RoboReq;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    Socket sock;
    DataOutputStream out;

    public boolean connect(String addr, int port) {
        try {
            sock = new Socket();
            sock.connect(new InetSocketAddress(addr, port), 5000);
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean disconnect() {
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean send(RoboReq req) {
        try {
            req.writeDelimitedTo(out);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
