package io.github.mullaiargent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws Exception{

        System.out.println("Server Started");
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Waiting for the Client's Message");
        int noOfClients = 0;
        File file = new File("Test.txt");
        FileWriter fw = new FileWriter("Test.txt", true);

        while (!Thread.interrupted()) {
            Socket socket = serverSocket.accept();
            noOfClients++;
            System.out.println("1. Client " + noOfClients + "Connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientData = br.readLine();
            System.out.println("2. printing " + noOfClients + "'s Data" + clientData);



            if (file.createNewFile()) {
                System.out.println("File created");

                fw.write("id," + socket.getPort() + ","+ clientData + "\n");
            } else {
                String content =  "id " + socket.getPort() + "\n" + clientData;
                System.out.println("Already Created");

                BufferedWriter out = new BufferedWriter(new FileWriter("Test.txt", true));
                out.write("id," + socket.getPort() + ","+ clientData + "\n");
                out.close();
            }
            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println("response : your Data has been added to the File");
            os.flush();

            System.out.println("responded to the Client");

            System.out.println("3. Data saved in File System");

            fw.close();


            System.out.println();

            }
        }
    }

