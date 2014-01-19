package swordfish.controllers;

import com.google.protobuf.ByteString;
import swordfish.models.device.Axis;
import swordfish.models.device.Button;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;
import swordfish.models.RoboComms.RoboReq;

import javax.swing.*;
import java.util.List;

public class RobotController {

    private volatile PollerThread thread;
    private JInputXboxController controller;
    private RobotControllerListener listener;
    private TCPClient client;

    public RobotController() {
        client = new TCPClient();
        listener = new RobotControllerListener();
    }

    public void connect(String addr, int port, JFrame ui) {
        if (!client.connect(addr, port)) System.out.println("Unable to Connect to Robot");
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.size() == 0) {
            System.out.println("No Xbox Controller Found");
        }
        controller = (JInputXboxController) XboxController.getAll().get(0);
        controller.addListener(listener);
        startPolling();
    }

    private void buildCommand(Button button, boolean pressed) {
        //TODO: Determine if this needs to be done asynch
        //TODO: Implement this function
        byte[] test = {127, 7, 127, (127+7+127)&0xF7};
        RoboReq.Builder req = RoboReq.newBuilder();
        req.setType(RoboReq.Type.MBASE);
        RoboReq.MoveBaseCmd.Builder mreq = RoboReq.MoveBaseCmd.newBuilder();
        mreq.setCmd(ByteString.copyFrom(test));
        req.setBase(mreq);
        sendCommand(req.build());
    }

    private void buildCommand(Axis axis, float state) {
        //TODO: Determine if this needs to be done asynch
        //TODO: Implement this function
    }

    private void sendCommand(RoboReq req) {
        //TODO: Determine if this needs to be done asynch
        client.send(req);
    }

    private void startPolling() {
        if (thread == null || !thread.running) {
            thread = new PollerThread(controller);
            thread.start();
        }
    }

    private void stopPolling() {
        if (thread != null && thread.running) {
            thread.running = false;
            thread = null;
        }
    }

    private void updateUI(Axis axis, float state) {
        //TODO: Implement this function
    }

    private void updateUI(Button button, boolean pressed) {

    }

    private class PollerThread extends Thread {

        JInputXboxController controller;
        boolean running;

        public PollerThread(JInputXboxController c) {
            this.controller = c;
            running = true;
        }

        public void run() {
            controller.poll();
            while (running) {
                Thread.yield();
                controller.poll();
            }
        }
    }

    private class RobotControllerListener extends XboxController.Listener {
        //TODO: Determine if these functions get called in the poller thread

        @Override
        public void connected() {
            //Handle what happens when a controller is connected
        }

        @Override
        public void disconnected() {
            //Handle what happens when a controller is disconnected
            stopPolling();
        }

        @Override
        public void buttonChanged(Button button, boolean pressed) {
            buildCommand(button, pressed);
            updateUI(button, pressed);
        }

        @Override
        public void axisChanged(Axis axis, float state) {
            buildCommand(axis, state);
            updateUI(axis, state);
        }
    }
}
