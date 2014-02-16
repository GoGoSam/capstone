package swordfish.controllers;

import org.gstreamer.*;
import org.gstreamer.swing.VideoComponent;

import javax.swing.*;
import java.awt.*;
import swordfish.views.window.LiveStreamerWindow;

public class VideoStreamer {

    public static Pipeline pipe;
    private LiveStreamerWindow ui;

    JPanel pan = new JPanel();

    public void connect(final String addr, final int port, final LiveStreamerWindow lsw) {
        /* init */
        String[] args = {};
        this.ui = lsw;
        Gst.init("VideoStreamer", args);
        pipe = new Pipeline("VideoStreamer");

        /* create and run video streaming in seperate thread */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* create elements */
                Element source = ElementFactory.make("tcpclientsrc", "source");
                Element depayloader = ElementFactory.make("gdpdepay", "depayloader");
                Element decoder = ElementFactory.make("rtph264depay", "decoder");
                Element parser = ElementFactory.make("ffdec_h264", "parser");
                Element converter = ElementFactory.make("ffmpegcolorspace", "converter");
                VideoComponent videoComponent = new VideoComponent();
                Element sink = videoComponent.getElement();

                /* set element properties */
                source.set("host", addr);
                source.set("port", port);

                /* add elements to pipeline before linking them */
                pipe.addMany(source, depayloader, decoder, parser, converter, sink);

                /* link elements */
                Element.linkMany(source, depayloader, decoder, parser, converter, sink);

                /* create a JFrame to display the video output */
                /* TODO: Change this to be an inputed JFrame instead of being created */
                JFrame frame = new JFrame("VideoStreamer");
                pan = new JPanel();
                pan.add(videoComponent, BorderLayout.CENTER);

                videoComponent.setPreferredSize(new Dimension(lsw.p_mediaPlayer.getSize()));// 533,400));

                frame.add(pan);
                frame.pack();


                /* start the pipeline */
                lsw.p_mediaPlayer.add(frame.getContentPane());
//                startPlaying();
                pipe.setState(State.PLAYING);
                lsw.b_vid_pause.setEnabled(true);
                lsw.b_vid_play.setEnabled(false);
//                pipe.setState(State.PLAYING);
//                lsw.tf_video_port.setText(Integer.toString(port));
//                lsw.tf_source2_ip.setText(addr);

            }
        });
    }

    public void startPlaying() {
        pipe.setState(State.PLAYING);

    }

    public void pause() {
        pipe.setState(State.PAUSED);

    }

    public JPanel getPanel() {
        return pan;
    }

    public void disconnect() {
        //TODO: Figure out if I need to remove elements from pipeline
        pipe.setState(State.NULL);
    }
}
