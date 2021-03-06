package swordfish.controllers;

import com.google.protobuf.ByteString;
import swordfish.models.device.Axis;
import swordfish.models.device.Button;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;
import swordfish.models.RoboComms.RoboReq;

import java.util.List;
import swordfish.views.window.LiveStreamerWindow;

public class RobotController {

    private volatile PollerThread thread;
    private LiveStreamerWindow ui;
    private JInputXboxController controller;
    private final RobotControllerListener listener;
    private final TCPClient p1_client;
    private final TCPClient p2_client;
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
    //Servo commands
    private static final String SD0 = "0=150";
    private static final String SD1 = "1=150";
    private static final String SR = "0=-10";
    private static final String SL = "0=+10";
    private static final String SD = "1=-10";
    private static final String SU = "1=+10";
    //Keep track of controller state
    private int LX = 0;
    private int LY = 0;
    private int RX = 0;
    private int RY = 0;
    private int LT = 0;
    private int RT = 0;

    public RobotController() {
        p1_client = new TCPClient();
        p2_client = new TCPClient();
        listener = new RobotControllerListener();
    }

    public void connect(String p1_addr, String p2_addr, int port, LiveStreamerWindow lsw) {
        ui = lsw;
        if (!p1_client.connect(p1_addr, port)) {
            System.out.format("Unable to Connect to %s at %d\n", p1_addr, port);
        } else {
            ui.tf_source1_ip.setText(p1_addr);
            ui.tf_motor_port.setText(Integer.toString(port));
        }
        if (!p2_client.connect(p2_addr, port)) {
            System.out.format("Unable to Connect to %s at %d\n", p2_addr, port);
        } else {
            ui.tf_base_video_port.setText(p2_addr);
            ui.tf_controller_port.setText(Integer.toString(port));
        }
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.isEmpty()) {
            System.out.println("No Xbox Controller Found");
        } else {
            System.out.println("Xbox Controller Found");
            controller = (JInputXboxController) XboxController.getAll().get(0);
            controller.addListener(listener);
            startPolling();
        }
    }

    private void buildCommand(Button button, boolean pressed) {
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
                ui.b_capture_moment.doClick();
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
                // set servo to default position for both axes
                if (pressed) {
                    String[] sCmd = new String[2];
                    sCmd[0] = SD0;
                    sCmd[1] = SD1;
                    for (int i = 0; i < 2; i++) {
                        RoboReq.Builder req = RoboReq.newBuilder();
                        req.setType(RoboReq.Type.MSENS);
                        RoboReq.MoveSensCmd.Builder sreq = RoboReq.MoveSensCmd.newBuilder();
                        sreq.setCmd(sCmd[i]);
                        req.setSens(sreq);
                        sendCommand(req.build(), p2_client);
                    }
                }
                break;
        }
    }

    private void buildCommand(Axis axis, float state) {
        RoboReq.Builder req = RoboReq.newBuilder();

        switch (axis) {
            case leftTrigger:
                int ltState = Math.round(state);
                if (ltState == 0) {
                    ltState = -1;
                }
                if (LT != ltState) {
                    LT = ltState;
                } else {
                    break;
                }
                req.setType(RoboReq.Type.MLIFT);
                byte lcmd = BM;
                byte lval;
                if (ltState == 1) {
                    lval = 127;
                } else {
                    lval = 0;
                }
                byte[] l = {ADDRESS, lcmd, lval, checksum(ADDRESS, lcmd, lval)};
                RoboReq.MoveLiftCmd.Builder lreq = RoboReq.MoveLiftCmd.newBuilder();
                lreq.setCmd(ByteString.copyFrom(l));
                req.setLift(lreq);
                sendCommand(req.build(), p2_client);
                break;
            case rightTrigger:
                int rtState = Math.round(state);
                if (rtState == 0) {
                    rtState = -1;
                }
                if (RT != rtState) {
                    RT = rtState;
                } else {
                    break;
                }
                req.setType(RoboReq.Type.MLIFT);
                byte rcmd = FM;
                byte rval;
                if (rtState == 1) {
                    rval = 127;
                } else {
                    rval = 0;
                }
                byte[] r = {ADDRESS, rcmd, rval, checksum(ADDRESS, rcmd, rval)};
                RoboReq.MoveLiftCmd.Builder rreq = RoboReq.MoveLiftCmd.newBuilder();
                rreq.setCmd(ByteString.copyFrom(r));
                req.setLift(rreq);
                sendCommand(req.build(), p2_client);
                break;
            case leftStickX:
            case leftStickY:
                //Round to 0, 2 or 3
                int lState = Math.round(state * 3);
                if (lState == 1 || lState == -1) {
                    lState = 0;
                }
                //If LX or LY already is equal to rState then no need send another cmd
                if (axis == Axis.leftStickX && LX != lState) {
                    LX = lState;
                } else if (axis == Axis.leftStickY && LY != lState) {
                    LY = lState;
                } else {
                    break;
                }
                req.setType(RoboReq.Type.MBASE);
                byte cmd = -1;
                byte val = -1;
                if (LX == 0 && LY == 0) {
                    cmd = FM;
                    val = 0;
                } else if (LX == 0 && LY > 0) {
                    //LY can be 2 or 3
                    cmd = BM;
                    val = LY == 2 ? (byte) 64 : (byte) 127;
                } else if (LX == 0 && LY < 0) {
                    //LY can be -2 or -3
                    cmd = FM;
                    val = LY == -2 ? (byte) 64 : (byte) 127;
                } else if (LX > 0 && LY == 0) {
                    //LX can be 2 or 3
                    cmd = RM;
                    val = LX == 2 ? (byte) 64 : (byte) 127;
                } else if (LX < 0 && LY == 0) {
                    //LX can be -2 or -3
                    cmd = LM;
                    val = LX == -2 ? (byte) 64 : (byte) 127;
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
                sendCommand(req.build(), p1_client);
                break;
            case rightStickX:
            case rightStickY:
                //Round to 0, 2 or 3
                int rState = Math.round(state * 3);
                if (rState == 1 || rState == -1) {
                    rState = 0;
                }
                //If RX or RY already is equal to rState then no need send another cmd
                if (axis == Axis.rightStickX && RX != rState) {
                    RX = rState;
                } else if (axis == Axis.rightStickY && RY != rState) {
                    RY = rState;
                } else {
                    break;
                }
                req.setType(RoboReq.Type.MSENS);
                String sCmd = "";
                if (RX == 0 && RY == 0) {
                    break;
                } else if (RX == 0 && RY > 0) {
                    //RY can be 2 or 3
                    sCmd = SD;
                } else if (RX == 0 && RY < 0) {
                    //RY can be -2 or -3
                    sCmd = SU;
                } else if (RX > 0 && RY == 0) {
                    //RX can be 2 or 3
                    sCmd = SR;
                } else if (RX < 0 && RY == 0) {
                    //RX can be -2 or -3
                    sCmd = SL;
                } else if (RX > 0 && RY < 0) {
                    //TODO: Up Right cmd
                    //RX can be 2 or 3
                    //RY can be -2 or -3
                    System.out.println("UP RIGHT");
                    break;
                } else if (RX < 0 && RY < 0) {
                    //TODO: Up Left cmd
                    //RX can be -2 or -3
                    //RY can be -2 or -3
                    System.out.println("UP LEFT");
                    break;
                } else if (RX > 0 && RY > 0) {
                    //TODO: Down Right cmd
                    //RX can be 2 or 3
                    //RY can be 2 or 3
                    System.out.println("DOWN RIGHT");
                    break;
                } else if (RX < 0 && RY > 0) {
                    //TODO: Down Left cmd
                    //RX can be -2 or -3
                    //RY can be 2 or 3
                    System.out.println("DOWN LEFT");
                    break;
                }

                RoboReq.MoveSensCmd.Builder sreq = RoboReq.MoveSensCmd.newBuilder();
                sreq.setCmd(sCmd);
                req.setSens(sreq);
                sendCommand(req.build(), p2_client);
                break;
        }
    }

    private byte checksum(byte addr, byte command, byte data) {
        return (byte) ((addr + command + data) & 0x7F);
    }

    private void sendCommand(RoboReq req, TCPClient client) {
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

        @Override
        public void run() {
            controller.poll();
            while (running) {
                controller.poll();
                try {

                    Thread.yield();
                    //Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class RobotControllerListener extends XboxController.Listener {

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
