package swordfish.controllers;

import org.gstreamer.*;

/**
 * Sam Coe
 * GStreamerTest
 */
public class GstreamerTest {
    public static void main(String[] args) {
        //
        // Initialize the gstreamer framework, and let it interpret any command
        // line flags it is interested in.
        //
        args = Gst.init("SimplePipeline", args);

        Pipeline pipe = new Pipeline("SimplePipeline");
        Element src = ElementFactory.make("fakesrc", "Source");
        Element sink = ElementFactory.make("fakesink", "Destination");


        // Add the elements to the Bin
        pipe.addMany(src, sink);

        // Link fakesrc to fakesink so data can flow
        src.link(sink);

        // Start the pipeline playing
        pipe.play();
        Gst.main();
        pipe.stop();
    }
}
