package bai2;

import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server đang chạy...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client đã kết nối: " + socket);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String request = in.readLine();
                if (request.equals("time")) {
                    String currentTime = getCurrentTime();
                    out.println(currentTime);
                    System.out.println("Đã gửi thời gian cho client: " + currentTime);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTime() {
        Date date = new Date();
        return date.toString();
    }
}
