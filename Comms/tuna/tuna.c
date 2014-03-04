#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <gst/gst.h>

/*
 * TCP Pipeline
 * raspivid -t 0 -w 1280 -h 720 -fps 25 -hf -b 2500000 -o - | \
 * gst-launch-1.0 -v fdsrc ! h264parse ! rtph264pay config-interval=1 pt=96 \
 * ! gdppay ! tcpserversink host=192.168.1.7 port=5000
 */

/*
 * TODO: Implement UDP Pipeline
 * raspivid -t 0 -w 1280 -h 720 -fps 25 -hf -b 2500000 -o - | \
 * gst-launch-1.0 -v fdsrc ! h264parse ! rtph264pay config-interval=1 pt=96 \
 * ! udpsink host=192.168.1.16 port=5000
 */

void int_handler(int);

GMainLoop *loop;

int main(int argc, char *argv[]) {
    /* Check input arguments */
    if (argc != 3) {
        g_printerr ("Usage: <Input Video Stream> | %s <IP Address> <Port>\n", argv[0]);
        return -1;
    }

    signal(SIGINT, int_handler);

    char *address = argv[1];
    int port = atoi(argv[2]);
    GstElement *pipeline;
    GstElement *source, *parser, *encoder, *payloader, *sink;

    /* init */
    gst_init (&argc, &argv);
    loop = g_main_loop_new (NULL, FALSE);

    /* create pipeline */
    pipeline = gst_pipeline_new ("pipeline");

    /* create elements */
    source = gst_element_factory_make ("fdsrc", "source");
    parser = gst_element_factory_make ("h264parse", "parser");
    encoder = gst_element_factory_make ("rtph264pay", "encoder");
    payloader = gst_element_factory_make ("gdppay", "payloader");
    sink = gst_element_factory_make ("tcpserversink", "sink");

    /* make sure elements are created */
    if (!source || !parser || !encoder || !payloader || !sink) {
        g_printerr ("One or more elements could not be created. Exiting.\n");
        return -1;
    }

    /* set element properties */
    g_object_set(G_OBJECT(source), "fd", STDIN_FILENO, NULL);
    g_object_set(G_OBJECT(encoder), "config-interval", 1, "pt", 96, NULL);
    g_object_set(G_OBJECT(sink), "host", address, "port", port, NULL);

    /* add elements to pipeline before linking them */
    gst_bin_add_many (GST_BIN (pipeline), source, parser, encoder, payloader, sink, NULL);

    /* link elements */
    if (!gst_element_link_many (source, parser, encoder, payloader, sink, NULL)) {
        g_printerr ("Failed to link elements. Exiting.\n");
        return -1;
    }

    /* change pipeline state to playing */
    g_print ("Starting Pipeline\n");
    gst_element_set_state (pipeline, GST_STATE_PLAYING);

    g_print ("Running...\n");
    g_main_loop_run (loop);

    /* change pipeline state to null and clean up */
    g_print ("\nStopping Pipeline\n");
    gst_element_set_state (pipeline, GST_STATE_NULL);
    gst_object_unref (pipeline);
    g_main_loop_unref (loop);

    return 0;
}

void int_handler(int sig) {
    g_main_loop_quit(loop);
}
