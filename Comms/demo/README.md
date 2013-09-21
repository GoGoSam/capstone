This folder is for code specifically for Rob's demo day on Sept 26th

Setup
0. Hook up Pi to webcam and robot platform
1. Put Pi and Host on the same network
2. Open LXTerminal on Pi
3. Enter command: ifconfig
4. Record the ip address for later use
5. Enter command: cd /home/pi/Desktop/demo
6. Enter command: ./start.sh
7. Move back to Host
8. Open terminal
9. Enter command: cd {PATH TO TOP DIRECTORY OF REPO}
10. Enter command: cd Comms/demo
11. Enter command: java host.client {IP ADDRESS OF PI}
12. Open web browser and enter url: http://{IP ADDRESS OF PI}:8080/stream_simple.html

--Note: The curly braces are where user needs to enter information, the curly braces should not be included in the commands

Teardown
0. Open LXTerminal window on Pi where start.sh is running
1. Enter keyboard combination: Ctrl+c
2. Open terminal window on host where java host.client is running
3. Enter keyboard combination: Ctrl+c
4. Disconnect Pi peripherals
5. Shutdown Pi
