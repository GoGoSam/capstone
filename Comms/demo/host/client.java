package host;

import java.io.*;
import java.net.*;

public class client {
    private static Socket socket;
    private static BufferedWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        setUpSocket(args[0]);
        MobileDirectionDisplay test = new MobileDirectionDisplay();
    }

    public static boolean setUpSocket(String ipAddress) {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, 9999), 5000);
            //socket = new Socket(ipAddress, 9999);
            out = new BufferedWriter(new OutputStreamWriter(
                                         socket.getOutputStream()), 1024);
            in = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + ipAddress);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + ipAddress);
            System.exit(1);
        }

        return true;
    }

    public static boolean takeDownSocket() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Take down socket failed");
            System.exit(1);
        }

        return true;
    }

    public static boolean writeToSocket(String output) {
        try {
            out.write(output);
            out.flush();
            System.out.println("echo: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Write to socket failed");
            System.exit(1);
        }

        return true;
    }

    public static String readFromSocket() {
        String input = null;

        try {
            input = in.readLine();
        } catch (IOException e) {
            System.err.println("Read from socket failed");
            System.exit(1);
        }

        return input;
    }
}
