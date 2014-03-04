#!/bin/bash

timeout=0
width=1280
height=720
framerate=25
bitrate=2500000
output="-"
ip=$(hostname -I)
port=6789

raspivid \
-t ${timeout} \
-w ${width} \
-h ${height} \
-fps ${framerate} \
-b ${bitrate} \
-o ${output} | \
./tuna ${ip} ${port}
