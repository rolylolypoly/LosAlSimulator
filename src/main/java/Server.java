import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

/**
 * Created by Will on 11/20/2015.
 */
public class Server {
    public  static void server(int port) throws IOException {
        port = 56789;
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {

            String inputLine, outputLine;
            inputLine = in.readLine();
            if (inputLine.equals("Bye.")) clientSocket.close();
            out.println("Hello.");
            out.println("Which module would you like to use?");
            if (inputLine.toLowerCase().matches("(enginnering*loud)")) EngineeringRoom.howLoudIsItRightNow();
            else if (inputLine.toLowerCase().matches("(smith*talk)")) MrSmiths.talk();
            else {
                out.println("Please stand by for a human operator...");
                TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                out.println("Hi");
                if ((int)(Math.random() * 100) ==3) {
                    out.println("SURPRISE SMITH!");
                    MrSmiths.talk();
                }
                else {
                    while ((inputLine = in.readLine()) != null) {
                        outputLine = human(inputLine);
                        out.println(outputLine);
                        if (inputLine.equals("Bye."))
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static String human(String input) {
        input = (input == "hello?") ? "yes" : (input == "hello.") ? "hi" : (input == "hello") ? "hi" : "rawr";
        return input;
    }

}
