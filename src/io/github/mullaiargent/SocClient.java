package io.github.mullaiargent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class SocClient {

    public static void main(String[] args) throws Exception{
	    String ip = "localhost";
        int port = 8888;
        Socket socket = new Socket(ip, port, InetAddress.getByName(ip), 8000);

        String str = " ClientOne's MailMessage";

        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(str);
        os.flush();

        //Thread.sleep(400);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String serverData = br.readLine();
        System.out.println(serverData);
        socket.close();
    }
}
