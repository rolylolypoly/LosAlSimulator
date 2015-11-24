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

    private class ClientResponse implements Runnable {
        @Override
        public void run() {
            while (running) {
                try (
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()))
                ) {
                    System.out.println(in.readLine());
                    clientResponse = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ServerOut implements Runnable {
        @Override
        public void run() {
            while (running) {
                try (
                        PrintWriter out =
                                new PrintWriter(client.getOutputStream(), true)
                ) {
                    out.println("Hello.");
                    out.println("Which module would you like to use?");
                    while (clientResponse != null) {
                        out.println(serverOut(clientResponse));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String serverOut(String input) {
        if (input.equals("asf;lasdkf;asdkf")) {
            running = false;
            return "Connection closed. Have a nice life";
        }
            if (Math.random() * 10 == 3) return "Jooooooooooooooooooooooooooooooooooooooohn Ceeeeeeeeeeeeenaaaaaaaa";
        return "Hello?";
    }
}