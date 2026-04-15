
import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatClient {

    public static void main(String[] args) {

        String ipAddress;
        int port = 1728;

        Socket connection = null;

        BufferedReader incoming;
        PrintWriter outgoing;
        String messageOut;
        String messageIn;

        Scanner userInput;

        userInput = new Scanner(System.in);
        System.out.print("Enter server IP address: ");
        ipAddress = userInput.nextLine();

        try {
            InetAddress address = InetAddress.getByName(ipAddress);

            try {
                System.out.println("Connecting to " + ipAddress + " on port " + port);
                connection = new Socket(address, port);
                System.out.println("Connected.  Enter your first message.");
            } catch (Exception e) {
                System.out.println("Connection failed: " + e.getMessage());
                return;
            }

            try {
                System.out.println("NOTE: Enter 'quit' to end the program.\n");
                while (true) {
                    System.out.print("SEND:      ");

                    incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    outgoing = new PrintWriter(connection.getOutputStream(), true);
                    messageOut = userInput.nextLine();
                    outgoing.println(messageOut);

                    if (messageOut.equalsIgnoreCase("quit")) {
                        System.out.println("Connection closed.");
                        break;
                    }

                    if (outgoing.checkError()) {
                        userInput.close();
                        connection.close();
                        throw new IOException("Error occurred while transmitting message.");
                    }

                    System.out.println("WAITING...");

                    messageIn = incoming.readLine();
                    System.out.println("RECEIVED:  " + messageIn);

                    if (messageIn.equalsIgnoreCase("quit")) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error during communication: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid IP address.");
        } finally {
            userInput.close();
            try {
                connection.close();
            } catch (Exception e) {
            }
        }

    }
}
