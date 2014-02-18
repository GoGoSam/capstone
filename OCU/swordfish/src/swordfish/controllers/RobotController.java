package swordfish.controllers;

import com.google.protobuf.ByteString;
import swordfish.models.device.Axis;
import swordfish.models.device.Button;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;
import swordfish.models.RoboComms.RoboReq;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import swordfish.views.window.LiveStreamerWindow;

public class RobotController {

    private volatile PollerThread thread;
    private LiveStreamerWindow ui;
    private JInputXboxController controller;
    private RobotControllerListener listener;
    private TCPClient p1_client;
    private TCPClient p2_client;
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

//    public JLabel cur;
    
    public RobotController() {
        p1_client = new TCPClient();
        p2_client = new TCPClient();
        listener = new RobotControllerListener();
    }

    public void connect(String p1_addr, String p2_addr, int p1_port, int p2_port, LiveStreamerWindow ui) {
        this.ui = ui;
        if (!p1_client.connect(p1_addr, p1_port)) {
            System.out.format("Unable to Connect to %s at %d\n", p1_addr, p1_port);
        } else {
            ui.tf_source1_ip.setText(p1_addr);
            ui.tf_motor_port.setText(Integer.toString(p1_port));

        }
        if (!p2_client.connect(p2_addr, p2_port)) {
            System.out.format("Unable to Connect to %s at %d\n", p2_addr, p2_port);
        } else {
            ui.tf_source2_ip.setText(p2_addr);
            ui.tf_controller_port.setText(Integer.toString(p2_port));

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
        List<XboxController> controllerList = XboxController.getAll();
        if (controllerList.isEmpty()) {
            System.out.println("No Xbox Controller Found");
        } else {
            System.out.println("Xbox Controller Found");
            controller = (JInputXboxController) XboxController.getAll().get(0);
            controller.addListener(listener);
            startPolling();
//            listener.setDirectionals(this.ui.l_dArrow);
        }

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
                // set servo to default position for both axices
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
                    System.out.println("STOP");
                } else if (LX == 0 && LY > 0) {
                    //LY can be 2 or 3
                    cmd = BM;
                    val = LY == 2 ? (byte) 64 : (byte) 127;
                    System.out.println("BACKWARD");
                } else if (LX == 0 && LY < 0) {
                    //LY can be -2 or -3
                    cmd = FM;
                    val = LY == -2 ? (byte) 64 : (byte) 127;
                    System.out.println("FORWARD");
                } else if (LX > 0 && LY == 0) {
                    //LX can be 2 or 3
                    cmd = RM;
                    val = LX == 2 ? (byte) 64 : (byte) 127;
                    System.out.println("RIGHT");
                } else if (LX < 0 && LY == 0) {
                    //LX can be -2 or -3
                    cmd = LM;
                    val = LX == -2 ? (byte) 64 : (byte) 127;
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
                sendCommand(req.build(), p1_client);
                
                ui.set_button_states();
                break;
            case rightStickX:
            case rightStickY:
                //Round to 0, 2 or 3
                int rState = Math.round(state * 3);
                if (rState == 1 || rState == -1) {
                    rState = 0;
                }
                //If RX or RY already is equal to rState then no need send another cmd
                //TODO: This may need to be modified to continue to send commands while controller is being held in a direction
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
                    System.out.println("STOP");
                    break;
                } else if (RX == 0 && RY > 0) {
                    //RY can be 2 or 3
                    sCmd = SD;
                    System.out.println("DOWN");
                } else if (RX == 0 && RY < 0) {
                    //RY can be -2 or -3
                    sCmd = SU;
                    System.out.println("UP");
                    this.ui.icon_dArrow.setEnabled(true);
                         
//            DirectionalThread dt = new DirectionalThread(ui.l_dArrow);
//                    if (servo_positions[1] < 220) {
//                        servo.execute(1, 1);
//                        servo_positions[1] += 10;
//                        System.out.println("UP");

//                    }
//                    this.ui.icon_uArrow.setEnabled(false);
                } else if (RX > 0 && RY == 0) {
                    //RX can be 2 or 3
                    sCmd = SR;
                    System.out.println("RIGHT");
                } else if (RX < 0 && RY == 0) {
                    //RX can be -2 or -3
                    sCmd = SL;
                    System.out.println("LEFT");
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
//        try {
//            ui.l_lArrow.setEnabled(true);
//           Thread.sleep(2000);
//            ui.l_lArrow.setEnabled(false);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(RobotController.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
    
    /*
    private class DirectionalThread extends Thread {

       JLabel directional;
        
//        boolean running;

        public DirectionalThread(JLabel in) {
           this.directional = in;
//            this.controller = c;
//            running = true;
        }

        @Override
        public void run() {
            try {
                directional.setEnabled(true);
                Thread.sleep(2000);
                directional.setEnabled(false);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RobotController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

     
    private class DirectionalTask extends SwingWorker<Void, JLabel> {
        
        JLabel directional;
//                protected void doInBackground(JLabel directional) {
//            this.directional = directional;
//
//
//        }

        @Override
        protected Void doInBackground() throws Exception {
            directional.setEnabled(true);
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
 
    }
 
    */
}
