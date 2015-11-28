package io.github.rollylollypolly.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import io.github.rollylollypolly.EngineeringRoom;
import io.github.rollylollypolly.MrSmiths;

/**
 * Created by Will on 11/20/2015.
 */
public class Server implements Runnable {
    private static ServerSocket socket;
    private static Socket client;
    private static String clientResponse;
    private static boolean running = true;

    public static void initialize() {
        try {
            socket = new ServerSocket(56789);
            client = socket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        initialize();
        (new Thread(new ClientResponse())).start();
        (new Thread(new ServerOut())).start();
    }

    public class ClientResponse implements Runnable {
        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()))
            ) {
                while ((clientResponse = in.readLine()) != null)
                System.out.println("Client :" + clientResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ServerOut implements Runnable {
        @Override
        public void run() {
            try (
                    PrintWriter out =
                            new PrintWriter(client.getOutputStream(), true)
            ) {
                out.println("Hello.");
                out.println("Which module would you like to use?");
                while (clientResponse != null && running) {
                    out.println(serverOut(clientResponse));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String serverOut(String input) {
        String out;
        if (input.equals("asf;lasdkf;asdkf")) {
            running = false;
            return "Connection closed. Have a nice life";
        }
        else if (clientResponse.matches("^(?=.*engineering)(?=.*room)(?=.*loud).*$")) out = EngineeringRoom.howLoudIsItRightNow();
        else if (clientResponse.matches("^(?=.*mr)(?=.*smith)(?=.*talk).*$")) out = MrSmiths.responses();
        else if (Math.random() * 10 == 3) out = "Jooooooooooooooooooooooooooooooooooooooohn Ceeeeeeeeeeeeenaaaaaaaa";
        else out = "Hello?";
        return out;
    }
}