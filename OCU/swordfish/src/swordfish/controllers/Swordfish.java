package swordfish.controllers;

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
        
        boolean do_robot_controller = false,
                do_video_streamer = true,
                do_xbox_dir_diplay = false,
                do_mobile_dis_keyboard = false,
                do_image_processor = false;

        //Pi 1 controls driving
        String p1_addr = "192.168.1.9";
        //Pi 2 controls servos and lift system
        String p2_addr = "192.168.1.69";
        int marlin_port = 5555;
        int tuna_port = 6789;

        VideoStreamer vs;
//        RobotController rc;
        LiveStreamerWindow lsw = new LiveStreamerWindow();
        lsw.setVisible(true);
//        if (do_robot_controller) {
//            rc = new RobotController();
//            rc.connect(p1_addr, p2_addr, marlin_port, lsw);
//        }
        if (do_video_streamer) {
            vs = new VideoStreamer();
            vs.connect(p1_addr, tuna_port, lsw);
            lsw.setVideoStreamer(vs);
        }
            
        VideoStreamer vs2;
        RobotController rc;
        LiveStreamerWindow2 lsw2 = new LiveStreamerWindow2();
        lsw.setVisible(true);
        if (do_robot_controller) {
            rc = new RobotController();
            rc.connect(p2_addr, p2_addr, marlin_port, lsw);
        }
        if (do_video_streamer) {
            vs2 = new VideoStreamer();
            vs2.connect(p2_addr, tuna_port, lsw2);
            lsw.setVideoStreamer(vs2);
        }
        
        
        if (do_xbox_dir_diplay) {
            XBox360_DirectionDisplay xboxDD = new XBox360_DirectionDisplay();
            xboxDD.setVisible(true);
        }
        if (do_mobile_dis_keyboard) {
            MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
            mddk.setVisible(true);
        }
        if (do_image_processor) {
            ImageAnalyzerWindow iaw = new ImageAnalyzerWindow();
            iaw.setVisible(true);
        }
    }
}
