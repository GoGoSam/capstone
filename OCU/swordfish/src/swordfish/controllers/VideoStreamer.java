package swordfish.controllers;

import javax.swing.*;
import java.awt.*;
import org.gstreamer.*;
import org.gstreamer.swing.VideoComponent;
import swordfish.views.window.streamerInterface;

public class VideoStreamer {
    public static Pipeline pipe;
    private streamerInterface ui;

    public void connect(final String addr, final int port, final streamerInterface lsw) {
        /* init */
        ui = lsw;
        String[] args = {};
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
                JFrame frame = new JFrame("VideoStreamer");
                JPanel pan = new JPanel();
                pan.add(videoComponent, BorderLayout.CENTER);
                videoComponent.setPreferredSize(ui.getMediaPlayer().getSize());
                frame.add(pan);
                frame.pack();
                ui.getMediaPlayer().add(frame.getContentPane());

                /* start the pipeline */
                start();
            }
        });
    }

    public void start() {
        pipe.setState(State.READY);
        pipe.setState(State.PLAYING);
        updateGUI();
    }

    public void pause() {
        pipe.setState(State.PAUSED);
        updateGUI();
    }

    public void disconnect() {
        pipe.setState(State.NULL);
        updateGUI();
    }

    private void updateGUI() {       
        ui.setVideoFlag(pipe.isPlaying());
        ui.set_button_states();
    }
}
