
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatServer {

    public static void main(String[] args) {

        int port = 1728;

        ServerSocket listener;
        Socket connection;

        BufferedReader incoming;
        PrintWriter outgoing;
        String messageOut;
        String messageIn;

        Scanner userInput;

        try {
            listener = new ServerSocket(port);
            System.out.println("Listening " + listener.getLocalPort());
            connection = listener.accept();
            listener.close();
            incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            outgoing = new PrintWriter(connection.getOutputStream(), true);

            System.out.println("Connected...");
        } catch (Exception e) {
            System.out.println("Error connecting: " + e.getMessage());
            return;
        }

        try {
            userInput = new Scanner(System.in);
            System.out.println("Enter 'quit' to end the program.\n");
            while (true) {
                System.out.println("WAITING...");
                messageIn = incoming.readLine();
                System.out.println("RECEIVED: " + messageIn);

                if (messageIn.equalsIgnoreCase("quit")) {
                    break;
                }

                System.out.print("SEND: ");
                messageOut = userInput.nextLine();
                outgoing.println(messageOut);

                if (messageOut.equalsIgnoreCase("quit")) {
                    break;
                }

                if (outgoing.checkError()) {
                    userInput.close();
                    throw new IOException("I/O Exception error")
                }
            }
        } catch (Exception e) {
            System.out.println("Error communicating: " + e.getMessage());
        } finally {
            try {
                connection.close();

            } catch (Exception e) {
            }
        }

    }
}
