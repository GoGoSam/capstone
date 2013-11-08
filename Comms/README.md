Comm System Overview

    Marlin - This is the code running on the Pi that does all the routing of data from Robot to Host
        -C++
        -Boost.Asio Library
            -Event driven architecture
            -Proactor pattern
            -Not thread/process architecture

    Tuna - This is the code to run the webcam that is going to be used to drive the robot
        -This is as close to "live" as possible
        -Hardware video H.264 encoding
        -Video streaming using GStreamer
