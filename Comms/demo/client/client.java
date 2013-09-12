import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        BufferedWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket("localhost", 9999);
            out = new BufferedWriter(new OutputStreamWriter(
                                         socket.getOutputStream()), 1024);
            in = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: localhost.");
            System.exit(1);
        }

        String userInput = "";
        while(userInput != "q") {
            userInput = System.console().readLine();
            System.out.println("user input: " + userInput);
            out.write(userInput);
            out.flush();
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        socket.close();
    }
}
