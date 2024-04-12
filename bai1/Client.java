package bai1;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            while ((userInput = inFromUser.readLine()) != null) {
                outToServer.println(userInput);
                String serverResponse = inFromServer.readLine();
                System.out.println("Server: " + serverResponse);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
