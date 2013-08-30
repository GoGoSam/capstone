Comm System Overview

    Router - This is the code running on the Pi that does all the routing of data from Robot to Host
        -C++
        -Boost.Asio Library
            -Event driven architecture
            -Reactive pattern
            -Not thread/process architecture

    Host - This is the code running on remote laptop that will communicate with the robot and display information to the user
        -Java
        -Swing GUI
        -FFMPEG or GStreamer for displaying webcam stream
            -Figure out which has better Java bindings

    Webcam - This is the webcam that is going to be used to drive the robot
        -This needs to be as close to "live" as possible
        -Hardware video encoding to either H.264 or MJPEG4
        -Video streaming using GStreamer
        -Network interface not limited to USB 2.0 Speeds
        -Haven't decided if this needs to be routed through the router or if that will cause slow down

    Sensors - These are the sensors on the robot that will be used to carry out inspections
        -Talk to Pi over SRI interface
