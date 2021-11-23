package c2c.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        try(Socket socket = new Socket("localhost", 5000)){
            BufferedReader input = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String username;
            String userInput;
            String clientName = "empty";
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            do{
                if (clientName.endsWith("empty")){
                    System.out.println("Enter the name");
                }
                else{
                    String message = ( "(" + clientName + ")" + "message: ");
                    System.out.println(message);
                }
                userInput = scanner.nextLine();
                clientName = userInput;
                output.println(userInput);
                output.flush();
                if (userInput.equals("exit")){
                    break;
                }

            }while(!userInput.endsWith("exit"));
        }catch (Exception e){
            System.out.println("Exception occured");
        }
    }
}
