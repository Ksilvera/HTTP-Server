package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class SimpleHTTPServer{
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening to connection on port 8080 ....");
        System.out.println("Enter 1 if want server info or 2 if want date time");
        int choice = sc.nextInt();

        if(choice == 1){

            while(true){
                //Continue forever
                Socket client = server.accept();
                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while(!line.isEmpty()){
                    System.out.println(line);
                    line = reader.readLine();
                }

            }
        }
        else if(choice == 2){
            while(true){
                try(Socket socket = server.accept()){
                    Date today = new Date();
                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                    System.out.println("Displaying date on localhost:8080");
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                    
                }
            }
        }
        else{
            System.out.println("Invalid Input");
        }
    }
}