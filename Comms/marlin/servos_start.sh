#!/bin/bash

port=45678
device="/dev/servoblaster"

#sudo servod
./marlin ${port} ${device}
