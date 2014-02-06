#!/bin/bash

port=5555
device="/dev/servoblaster"

#sudo servod
./marlin ${port} ${device}
