#!/bin/bash

cport=5555
vport=6789
cpid=$(lsof -i:${cport} -t)
vpid=$(lsof -i:${vport} -t)

kill -TERM ${cpid} || kill -KILL ${cpid}
kill -TERM ${vpid} || kill -KILL ${vpid}
