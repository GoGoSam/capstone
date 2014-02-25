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
        
        String p1_addr = "192.168.1.9";
        String p2_addr = "192.168.1.9";        
//        String p1_addr = "192.168.1.69";
//        String p2_addr = "192.168.1.69";
        int p1_port = 5555;
        int p2_port = 45678;        
        int video_port = 6789;

        VideoStreamer vs;
        RobotController rc;
        LiveStreamerWindow lsw = new LiveStreamerWindow();
        lsw.setVisible(true);
        if (do_robot_controller) {
            rc = new RobotController();
            rc.connect(p1_addr, p2_addr, p1_port, p2_port, lsw);
        }
        if (do_video_streamer) {
            vs = new VideoStreamer();
            vs.connect(p1_addr, video_port, lsw);
            lsw.setVideoStreamer(vs);
            vs.start();
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
