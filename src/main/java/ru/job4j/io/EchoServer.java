package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    private static String answer(String str) {
        String tmp = Arrays
                .stream(str.split(" "))
                .filter(a -> a.contains("msg="))
                .findFirst()
                .orElse("No message.");
        return tmp.substring(tmp.indexOf("=") + 1);
    }
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String tmp = "";
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=")) {
                            tmp = str;
                        }
                    }
                    String rsl = answer(tmp);
                    if ("Exit".equals(rsl)) {
                        server.close();
                    }
                    out.write((rsl + "\r\n").getBytes());
                    out.flush();
                }
            }
        }
    }
}