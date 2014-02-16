package swordfish.controllers;

import org.gstreamer.*;
import org.gstreamer.swing.VideoComponent;

import javax.swing.*;
import java.awt.*;
import swordfish.views.window.LiveStreamerWindow;

public class VideoStreamer {
    private Pipeline pipe;
    private LiveStreamerWindow ui;

    JPanel pan = new JPanel();
    
    public void connect(final String addr, final int port, final LiveStreamerWindow ui) {
        /* init */
        String[] args = {};
        this.ui = ui;
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
                JInternalFrame frame2 = new JInternalFrame("VideoStreamer");
                pan = new JPanel();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.add(videoComponent, BorderLayout.CENTER);
//                videoComponent.setPreferredSize(new Dimension(720, 576));
//                frame.pack();
                pan.add(videoComponent, BorderLayout.CENTER);
                
                videoComponent.setPreferredSize(new Dimension(435,240));
                
                
//                frame2.add(pan);
                frame.add(pan);
                frame.pack();
//                pan.pack();
//                frame2.p 
//                frame.setVisible(true);

                /* start the pipeline */
                ui.p_mediaPlayer.add(frame.getContentPane());
                pipe.setState(State.PLAYING);
                
                /*Component [] cc;
                
//                System.out.println(ui.p_mediaPlayer);
               
//                frame.setVisible(true);
//                ui.p_media_player.add(frame.getContentPane());
//                pan.setVisible(true);
//                ui.p_media_player = pan;
//                  ui.p_media_player.setVisible(true);
                cc = ui.p_mediaPlayer.getComponents();
                
                System.out.println(cc[0].getLocation());*/
            }
        });
    }
    public void startPlaying()
    {
        pipe.setState(State.PLAYING);
    }
public JPanel getPanel()
{
    return pan;
}
    public void disconnect() {
        //TODO: Figure out if I need to remove elements from pipeline
        pipe.setState(State.NULL);
    }
}
