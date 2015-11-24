import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Will on 11/20/2015.
 */
public class Server implements Runnable {
    public static void server(int port) throws IOException {
        port = 56789;
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("Connection established");
            String inputLine, outputLine;
            out.println("Hello.");
            out.println("Which module would you like to use?");
            while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Bye.")) {
                out.println("Bye.");
                break;
            }
            if (inputLine.toLowerCase().matches("(enginnering*loud)")) EngineeringRoom.howLoudIsItRightNow();
            else if (inputLine.toLowerCase().matches("(smith*talk)")) MrSmiths.talk();
            else {
                out.println("Please stand by for a human operator...");
                //TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                //out.println("Hi");
                //if ((int) (Math.random() * 100) == 3) {
                //    out.println("SURPRISE SMITH!");
                //    MrSmiths.talk();
                //} else {
//
                //        if (inputLine.equals("Bye."))
                //            break;
                //        outputLine = human(inputLine);
                //        if (outputLine.equals("0xzfl1n4klhuioyxzcv"))
                //            break;
                //        out.println(outputLine);
                //    }
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        } //catch (InterruptedException e) {
           //e.printStackTrace();
        //}
    }

    private static String human(String input) {
        input = (input == "hello?") ? "yes, this is dog"
                : (input == "hello.") ? "hi, i am tech support, you have virus"
                : (input == "hello") ? "no one is home"
                : emptyResponse();
        return input;
    }

    private static int patience = (int) (Math.random() * 10);
    private static HashMap<Integer, String> responses;

    static {
        responses = new HashMap<>();
        responses.put(0, "Is anyone there?");
        responses.put(1, "Hello?");
        responses.put(2, "If you do not respond, this session will be close");
        responses.put(3, "...");
    }

    private static String emptyResponse() {

        patience--;
        if (patience <= 0) return "0xzfl1n4klhuioyxzcv";
        return responses.get((int) ((Math.random() * 10) % responses.size()));
    }

    @Override
    public void run() {
        try {
            server(56789);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
