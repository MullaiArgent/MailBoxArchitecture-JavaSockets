package io.github.mullaiargent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws Exception{
        System.out.println("Server Started");
        ServerSocket socket = new ServerSocket(8888);
        socket.setSoTimeout(0);
        System.out.println("Waiting for the Client's Message");

        Socket s = socket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String clientData = br.readLine();
        System.out.println("Client's Data" + clientData);
    }
}
