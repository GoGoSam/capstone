package swordfish.controllers;

import swordfish.views.MobileDirectionDisplayKeyboard;

import javax.swing.*;

/**
 *
 * @author Sam Coe and Joe Robinson
 *
 * @version 1.0
 *
 * Revisions: 1) December 17, 2013, JR - Updated according to external class
 * filename. MobileDirectionDisplay -> MobileDirectionDisplayKeyboard
 */

/*
 * Swordfish Tasks:
 *  Initialize UI
 *  Initialize RobotController
 *  Initialize VideoStreaming
 */
public class Swordfish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String addr = "192.168.1.1";
        int port = 5000;
        JFrame ui = new JFrame();
        //JFrame ui = new UI();
        //RobotController rc = new RobotController();
        //rc.connect(addr, port, ui);
        VideoStreamer vs = new VideoStreamer();
        vs.connect(addr, port, ui);
    }
}
