package swordfish.controllers;

import org.gstreamer.*;
import org.gstreamer.swing.VideoComponent;

import javax.swing.*;
import java.awt.*;

/*
 * VideoStreamer Tasks:
 *  Initialize gstreamer pipeline
 *  Update UI with video component
 */

public class VideoStreamer {
    private Pipeline pipe;

    public void connect(final String addr, final int port, final JFrame ui) {
        /* init */
        String[] args = {};
        Gst.init("VideoStreamer", args);
        pipe = new Pipeline("VideoStreamer");

        /* create and run video streaming in seperate thread */
        SwingUtilities.invokeLater(new Runnable() {
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
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(videoComponent, BorderLayout.CENTER);
                videoComponent.setPreferredSize(new Dimension(720, 576));
                frame.pack();
                frame.setVisible(true);

                /* start the pipeline */
                pipe.setState(State.PLAYING);
            }
        });
    }

    public void disconnect() {
        //TODO: Figure out if I need to remove elements from pipeline
        pipe.setState(State.NULL);
    }
}
