/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.views;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author jrob
 */
public class MyMediaPlayer {

//    JFrame frame = new JFrame("");
    JPanel p;
    MediaPlayerFactory mediaPlayerFactory;
    EmbeddedMediaPlayer mediaPlayer;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    MyMediaPlayer() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "/Applications/VLC.app/Contents/MacOS/lib/");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        mediaPlayerFactory = new MediaPlayerFactory();

        Canvas c = new Canvas();
        c.setBackground(Color.black);
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(c, BorderLayout.CENTER);
//        frame.add(p, BorderLayout.CENTER);

        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
//        frame.setLocation(100, 100);
//        frame.setSize(1280, 720);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getF() {
        return p;
    }

    public void playz(String vpath) {

        mediaPlayer.playMedia(vpath);

        mediaPlayer.setAdjustVideo(true);

//        System.out.print((mediaPlayer.isAdjustVideo()));
        mediaPlayer.setBrightness(2.0f);

        /* while (mediaPlayer.getBrightness() >
         0.0f) {
         mediaPlayer.setBrightness(mediaPlayer.getBrightness() - 0.02f);
         System.out.println(mediaPlayer.getBrightness());
         }*/
    }

    public long getLength() {
        return mediaPlayer.getLength();
    }

    public long getTime() {
        return mediaPlayer.getTime();
    }

    public void playz() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
//        System.out.println(mediaPlayer.getMediaDetails());
//        System.out.println(Long.toString(mediaPlayer.getLength()));

//        System.out.println(Long.toString(mediaPlayer.getTime()));
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void mute() {
        mediaPlayer.mute(!mediaPlayer.isMute());
//        mediaPlayer .addMediaOptions(strings);
    }

    public boolean save_snap_shot() {
        return mediaPlayer.saveSnapshot();
    }

    public void ff(JButton j_in) {
        float rate = mediaPlayer.getRate();
        if (rate == 1.0f) {
            mediaPlayer.setRate(1.5f);
            j_in.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/ff_icon_1_5x.jpg"));

        } else if (rate == 1.5f) {
            mediaPlayer.setRate(2.0f);
            j_in.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/ff_icon_2x.jpg"));
        } else {
            mediaPlayer.setRate(1.0f);
            j_in.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/ff_icon.jpg"));
        }
        // mediaPlayer.setTime((long) mediaPlayer.getRate());
        mediaPlayer.setTitle((int) (mediaPlayer.getRate()));
    }
}
