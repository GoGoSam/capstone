package swordfish.controllers;

import swordfish.views.MobileDirectionDisplayKeyboard;

import javax.swing.*;
import swordfish.views.InspectorRobot;
import swordfish.views.XBox360_DirectionDisplay;
import swordfish.views.live_streamer.LiveStreamerWindow;
import swordfish.views.image_processor.ImageAnalyzerWindow;

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

        boolean do_robot_controller = false,
                do_video_streamer = false,
                do_xbox_dir_diplay = false,
                do_mobile_dis_keyboard = false,
                do_inspector_robot = true,
                do_media_streamer_ui = false,
                do_image_processor = false;

        String addr = "192.168.1.1";
        int port = 5000;
        JFrame ui = new JFrame();
        //JFrame ui = new UI();

        if (do_robot_controller) {
            RobotController rc = new RobotController();
            rc.connect(addr, port, ui);
        }
        if (do_video_streamer) {
            VideoStreamer vs = new VideoStreamer();
            vs.connect(addr, port, ui);
        }
        if (do_xbox_dir_diplay) {
            XBox360_DirectionDisplay xboxDD = new XBox360_DirectionDisplay();
            xboxDD.setVisible(true);
        }
        if (do_mobile_dis_keyboard) {
            MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
            mddk.setVisible(true);
        }
        if (do_inspector_robot) {
            InspectorRobot ir = new InspectorRobot();
            ir.setVisible(true);
        }
        if (do_media_streamer_ui) {
            LiveStreamerWindow lsw = new LiveStreamerWindow();
            lsw.setVisible(true);
        }

        if (do_image_processor) {
            ImageAnalyzerWindow iaw = new ImageAnalyzerWindow();
            iaw.setVisible(true);
        }
    }
}
