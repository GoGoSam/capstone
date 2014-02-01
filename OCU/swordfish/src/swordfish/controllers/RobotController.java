package swordfish.controllers;

import com.google.protobuf.ByteString;
import swordfish.models.RoboComms;
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
    //Packet mode
    private static final byte ADDRESS = (byte) 128;
    //Standard commands
    private static final byte FM1 = 0;
    private static final byte BM1 = 1;
    private static final byte FM2 = 4;
    private static final byte BM2 = 5;
    private static final byte FBM1 = 6;
    private static final byte FBM2 = 7;
    //Mixed-mode commands
    private static final byte FM = 8;
    private static final byte BM = 9;
    private static final byte RM = 10;
    private static final byte LM = 11;
    private static final byte FBM = 12;
    private static final byte LRM = 13;
    //Keep track of controller state
    private int LX = 0;
    private int LY = 0;

    public RobotController() {
        client = new TCPClient();
        listener = new RobotControllerListener();
    }

    public void connect(String addr, int port, JFrame ui) {
        if (!client.connect(addr, port)) {
            System.out.println("Unable to Connect to Robot");
        }
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.size() == 0) {
            System.out.println("No Xbox Controller Found");
        }
        controller = (JInputXboxController) XboxController.getAll().get(0);
        controller.addListener(listener);
        startPolling();
    }

    //TODO: Delete after testing
    public void testCommand() {
        byte[] test = {ADDRESS, FM1, 127, checksum(ADDRESS, FM1, (byte) 127)};
        RoboReq.Builder req = RoboReq.newBuilder();
        req.setType(RoboReq.Type.MBASE);
        RoboReq.MoveBaseCmd.Builder mreq = RoboReq.MoveBaseCmd.newBuilder();
        mreq.setCmd(ByteString.copyFrom(test));
        req.setBase(mreq);
        sendCommand(req.build());
    }

    private void buildCommand(Button button, boolean pressed) {
        //TODO: Determine if this needs to be done asynch
        //TODO: Implement this function
        switch (button) {
            case up:
                break;
            case down:
                break;
            case left:
                break;
            case right:
                break;
            case start:
                break;
            case guide:
                break;
            case a:
                break;
            case b:
                break;
            case x:
                break;
            case y:
                break;
            case leftShoulder:
                break;
            case rightShoulder:
                break;
            case back:
                break;
            case leftStick:
                break;
            case rightStick:
                break;
        }
    }

    private void buildCommand(Axis axis, float state) {
        //TODO: Determine if this needs to be done asynch
        RoboReq.Builder req = RoboReq.newBuilder();

        switch (axis) {
            case leftTrigger:
            case rightTrigger:
                req.setType(RoboReq.Type.MLIFT);
                break;
            case leftStickX:
            case leftStickY:
                //Round to 0, 2 or 3
                int rState = Math.round(state * 3);
                if (rState == 1 || rState == -1) rState = 0;
                //If LX or RX already is equal to rState then no need send another cmd
                if (axis == Axis.leftStickX && LX != rState) LX = rState;
                else if (axis == Axis.leftStickY && LY != rState) LY = rState;
                else break;
                req.setType(RoboReq.Type.MBASE);
                byte cmd = 0;
                byte val = 0;
                //TODO: build cmd and val based on LX and LY
                if (LX == 0 && LY == 0) {
                    //TODO: Stop cmd
                    System.out.println("STOP");
                } else if (LX == 0 && LY > 0) {
                    //TODO: Backward cmd
                    //LY can be 2 or 3
                    System.out.println("BACKWARD");
                } else if (LX == 0 && LY < 0) {
                    //TODO: Forward cmd
                    //LY can be -2 or -3
                    System.out.println("FORWARD");
                } else if (LX > 0 && LY == 0) {
                    //TODO: Right cmd
                    //LX can be 2 or 3
                    System.out.println("RIGHT");
                } else if (LX < 0 && LY == 0) {
                    //TODO: Left cmd
                    //LX can be -2/3 or 1
                    System.out.println("LEFT");
                } else if (LX > 0 && LY < 0) {
                    //TODO: Forward Right cmd
                    //LX can be 2 or 3
                    //LY can be -2 or -3
                    System.out.println("FORWARD RIGHT");
                } else if (LX < 0 && LY < 0) {
                    //TODO: Forward Left cmd
                    //LX can be -2 or -3
                    //LY can be -2 or -3
                    System.out.println("FORWARD LEFT");
                } else if (LX > 0 && LY > 0) {
                    //TODO: Backward Right cmd
                    //LX can be 2 or 3
                    //LY can be 2 or 3
                    System.out.println("BACKWARD RIGHT");
                } else if (LX < 0 && LY > 0) {
                    //TODO: Backward Left cmd
                    //LX can be -2 or -3
                    //LY can be 2 or 3
                    System.out.println("BACKWARD LEFT");
                }

                byte[] t = {ADDRESS, cmd, val, checksum(ADDRESS, cmd, val)};
                RoboReq.MoveBaseCmd.Builder mreq = RoboReq.MoveBaseCmd.newBuilder();
                mreq.setCmd(ByteString.copyFrom(t));
                req.setBase(mreq);
                sendCommand(req.build());
                break;
            case rightStickX:
            case rightStickY:
                req.setType(RoboReq.Type.MSENS);
                break;
        }
    }

    private byte checksum(byte addr, byte command, byte data) {
        return (byte) ((addr + command + data) & 0x7F);
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
