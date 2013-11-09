package swordfish.controllers;

import swordfish.models.RoboComms.RoboReq;

import java.net.Socket;
import java.io.DataOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Sam
 * Date: 11/8/13
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class ProtobufTest {
    public static void main(String[] args) throws Exception {
        RoboReq.Builder req = RoboReq.newBuilder();
        RoboReq.DataReq.Builder dreq = RoboReq.DataReq.newBuilder();
        dreq.setCmd("Testing");
        req.setType(RoboReq.Type.RDATA);
        req.setData(dreq);
        RoboReq t = req.build();

        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        t.writeDelimitedTo(outToServer);
        clientSocket.close();
    }
}
