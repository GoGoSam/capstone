package swordfish.controllers;

import javax.swing.*;

import swordfish.views.MobileDirectionDisplayKeyboard;
import swordfish.views.XBox360_DirectionDisplay;
import swordfish.views.window.ImageAnalyzerWindow;
import swordfish.views.window.LiveStreamerWindow;

/**
 *
 * @author Sam Coe and Joe Robinson
 *
 */
public class Swordfish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean do_robot_controller = true,
                do_video_streamer = false,
                do_xbox_dir_diplay = false,
                do_mobile_dis_keyboard = false,
                do_media_streamer_ui = false,
                do_image_processor = false;

        String addr = "192.168.1.69";
        int video_port = 6789;
        int controller_port = 5555;
        JFrame ui = new JFrame();

        if (do_robot_controller) {
            RobotController rc = new RobotController();
            rc.connect(ui);
//            rc.connect(addr, controller_port, ui);
        }
        if (do_video_streamer) {
            VideoStreamer vs = new VideoStreamer();
            vs.connect(addr, video_port, ui);
        }
        if (do_xbox_dir_diplay) {
            XBox360_DirectionDisplay xboxDD = new XBox360_DirectionDisplay();
            xboxDD.setVisible(true);
        }
        if (do_mobile_dis_keyboard) {
            MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
            mddk.setVisible(true);
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
