package swordfish.controllers;

import com.google.protobuf.ByteString;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import swordfish.models.device.Axis;
import swordfish.models.device.Button;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;
import swordfish.models.RoboComms.RoboReq;

import javax.swing.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static swordfish.models.device.Button.guide;
import swordfish.models.input.InputDevice;
import swordfish.models.input.JInputJoystick;

public class RobotController {

    private volatile PollerThread thread;
    private JInputXboxController controller;
    private RobotControllerListener listener;
    private TCPClient client;
    private ServoController servo;     // SSH connection for servoblaster
    private boolean do_debug = true;
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

    public RobotController() {
        client = new TCPClient();
        servo = new ServoController();
        listener = new RobotControllerListener();
    }

    public void connect(String addr, int port, JFrame ui) {
        if (!client.connect(addr, port)) {
            System.out.println("Warning: Unable to Connect to Robot\n");
        }
        if (!servo.connect()) {
            System.out.println("Warning: Unable to SSH onto Pi for Servoblaster\n");
        }
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.isEmpty()) {
            System.out.println("Warning: No Xbox Controller Found\n");
        }
        controller = (JInputXboxController) XboxController.getAll().get(0);
        controller.addListener(listener);
        startPolling();
    }

    public void connect(JFrame ui) {
        if (!servo.connect()) {
            System.out.println("Warning: Unable to SSH onto Pi for Servoblaster\n");
        }

//        try {
//            servo.default_position();
//        } catch (JSchException | IOException ex) {
//            Logger.getLogger(RobotController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.isEmpty()) {
            System.out.println("Warning: No Xbox Controller Found\n");
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
        try {

            if (button.isDpad()) {
            }
            switch (button) {
                case up:
                    servo.execute("echo 1=" + Integer.toString(100) + " > /dev/servoblaster;");
                    break;
                case down:
                    servo.execute("echo 1=" + Integer.toString(150) + " > /dev/servoblaster;");
                    break;
                case left:
                    servo.execute("echo 0=" + Integer.toString(100) + " > /dev/servoblaster;");
                    break;
                case right:
                    servo.execute("echo 0=150 > /dev/servoblaster;");
                    break;
                case guide:
                    break;
                case start:
                    servo.exit();
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
//                    servo.default_position();
                    break;
            }
        } catch (JSchException | IOException ee) {
            System.out.println(ee.getMessage());
        }

        if (do_debug) {
            System.out.println(button.name());
        }
    }

    private void buildCommand(Axis axis, float state) {
        //TODO: Determine if this needs to be done asynch
        //TODO: Implement this function
        /*
         String joystick_name = axis.toString();
         System.out.println("1\n" + axis.toString() + "\n");
         if (joystick_name.contains("Left")) {
         // left joystick
         //                      Need to make seperate class

         String instr = "echo > 0=150";
         File outfile = new File("/Users/jrob/Desktop/test.txt");
         boolean append = false;
         try {

         FileWriter fout = new FileWriter(outfile, append);
         PrintWriter fileout = new PrintWriter(fout, true);
         fileout.println(instr);
         fileout.flush();

         } catch (IOException e) {
         if (do_debug) {
         System.out.println(e.getMessage());

         }
         }

         if (joystick_name.equals("leftstick")) { // trigger was pushed
         } else if (joystick_name.contains("axis")) {
         // Left Stick Y axis
         // Left Stick X axis
         }
         } else if (joystick_name.contains("Right Stick")) {
         }
         */
//
//        axis.getStick().getAxisX().
        switch (axis) {
            case leftTrigger:
                break;
            case rightTrigger:
                break;
            case leftStickX:

                if (do_debug) {
                    System.out.println("1\n" + axis.toString() + "\n");
                }
                break;
            case leftStickY:

                if (do_debug) {
                    System.out.println("1.a\n" + axis.toString() + "\n");
                }
                break;
            case rightStickX:

                if (do_debug) {
                    System.out.println("2\n");
                }
                break;
            case rightStickY:

                if (do_debug) {
                    System.out.println(axis.rightStickY);
                }
                break;
        }
        {
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

            System.out.println("\n");
            buildCommand(axis, state);

            updateUI(axis, state);
        }
    }
}
