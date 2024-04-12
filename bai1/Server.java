package bai1;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
            
            String clientInput;
            while ((clientInput = inFromClient.readLine()) != null) {
                System.out.println("Client: " + clientInput);
                String serverInput = inFromServer.readLine();
                outToClient.println(serverInput);
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
