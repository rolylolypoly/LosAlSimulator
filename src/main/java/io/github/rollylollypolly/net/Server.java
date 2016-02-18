package io.github.rollylollypolly.net;

import io.github.rollylollypolly.EngineeringRoom;
import io.github.rollylollypolly.MrSmiths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Will on 11/20/2015.
 */
public class Server implements Runnable {
    protected static ServerSocket socket;
    protected static Socket client;
    protected static String clientResponse;
    protected static boolean running = true;

    public void initialize() {
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
        SocketWatch();
    }

    private synchronized void SocketWatch() {
        while (running) {
            try {
                socket.wait();
            } catch (InterruptedException e) {
                ClientResponse.class.notify();
            }
        }
    }

    public class ClientResponse implements Runnable {
        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()))
            ) {
                while (running) {
                    synchronized (this) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            while (in.ready() && (clientResponse = in.readLine()) != null) {
                                System.out.println("Client: " + clientResponse);
                                if (clientResponse.equals("asf;lasdkf;asdkf")) running = false;
                            }
                        }

                    }
                }
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
                while (running) {
                    out.println(serverOut(clientResponse));
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String serverOut(String input) {
        String out = null;
        if (input.equals("asf;lasdkf;asdkf")) {
            running = false;
            return "Connection closed. Have a nice life";
        }
        else if (clientResponse.matches("^(?=.*engineering)(?=.*room)(?=.*loud).*$")) out = EngineeringRoom.howLoudIsItRightNow();
        else if (clientResponse.matches("^(?=.*mr)(?=.*smith)(?=.*talk).*$")) out = MrSmiths.responses();
        else if ((int) (Math.random() * 10) == 3) out = "Jooooooooooooooooooooooooooooooooooooooohn Ceeeeeeeeeeeeenaaaaaaaa";
        return out;
    }
}