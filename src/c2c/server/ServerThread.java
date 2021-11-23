package c2c.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private final Socket socket;
    private final ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads){
        this.socket  = socket;
        this.threadList = threads;
    }
    @Override
    public  void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            while (true){
                String outputString = input.readLine();
                if (outputString.equals("exit")){
                    break;
                }
                printToAllClient(outputString);
                System.out.println("Server got the chat" + outputString);
            }
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }
    public void printToAllClient(String outputString){
        for (ServerThread st : threadList){
            st.output.println(outputString);
        }
    }
}
