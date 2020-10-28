package my.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");

            out.println("Write your name");
            final String userName = in.readLine();

            out.println("Are you child? (yes/no)");
            final String answer = in.readLine().trim();
            if ("yes".equals(answer)) {
                out.println("Welcome to the kids area, " + userName + "! Let's play!");
            } else if ("no".equals(answer)) {
                out.println("Welcome to the adult zone, " + userName + "! Have a good rest, or a good working day!");
            } else {
                out.println("Welcome, " + userName + "!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
