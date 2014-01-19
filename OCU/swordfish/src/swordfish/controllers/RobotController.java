package swordfish.controllers;

import swordfish.models.device.Axis;
import swordfish.models.device.Button;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;
import swordfish.models.RoboComms.RoboReq;

import javax.swing.*;
import java.util.List;

/*
 * RobotController Tasks:
 *  Create/Initialize XboxController
 *  Create/Initialize Poller Thread
 *  Create/Initialize TCPClient
 *  Listen To Changes in XboxController
 *  Update UI for XboxController Changes
 *  Build Protobuf messages to send to robot
 *  Send message to robot through TCPClient
 */
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
        //if (!client.connect(addr, port)) System.out.println("Unable to Connect to Robot");
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.size() == 0) {
            System.out.println("No Xbox Controller Found");
        }
        controller = (JInputXboxController) XboxController.getAll().get(0);
        controller.addListener(listener);
        startPolling();
    }

    private void buildCommand() {
        //TODO: Determine if this needs to be done asynch
        //TODO: Implement this function
        RoboReq.Builder req = RoboReq.newBuilder();
        RoboReq.DataReq.Builder dreq = RoboReq.DataReq.newBuilder();
        dreq.setCmd("Testing");
        req.setType(RoboReq.Type.RDATA);
        req.setData(dreq);
        sendCommand(req.build());
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

    private void updateUI() {
        //TODO: Implement this function
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
            //TODO: Handle what happens when a controller is connected
        }

        @Override
        public void disconnected() {
            //TODO: Handle what happens when a controller is disconnected
            stopPolling();
        }

        @Override
        public void buttonChanged(Button button, boolean pressed) {
            //TODO: Handle what happens when a button is changed
            buildCommand();
            updateUI();
        }

        @Override
        public void axisChanged(Axis axis, float state) {
            //TODO: Handle what happens when a axis is changed
            buildCommand();
            updateUI();
        }
    }
}
