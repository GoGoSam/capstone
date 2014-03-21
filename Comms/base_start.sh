#!/bin/bash

timeout=0
width=1280
height=720
framerate=25
bitrate=2500000
output="-"
ip=$(hostname -I | cut -f 1 -d ' ')
vport=6789
cport=5555
component="base"

raspivid \
-t ${timeout} \
-w ${width} \
-h ${height} \
-fps ${framerate} \
-b ${bitrate} \
-o ${output} | \
./tuna/tuna ${ip} ${vport} &

./marlin/marlin ${cport} ${component}
