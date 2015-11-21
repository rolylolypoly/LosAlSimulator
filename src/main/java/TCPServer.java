import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Will on 11/20/2015.
 */
public class TCPServer {
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

            // Initiate conversation with client
            while ((inputLine = in.readLine()) != null) {
                outputLine = processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
    private static String processInput(String input) {
        input = (input == "hello?") ? "yes" : (input == "hello.") ? "hi" : (input == "hello") ? "hi" : "rawr";
        return input;
    }

}
