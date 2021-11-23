package io.github.mullaiargent;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class SocClient {

    public static void main(String[] args) throws Exception{
	    String ip = "localhost";
        int port = 8888;
        Socket socket = new Socket(ip, port);
        
        String str = "MailMessage";

        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        os.write(str);
        os.flush();
        Thread.sleep(4);
        socket.close();
    }
}
