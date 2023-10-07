import java.net.ServerSocket;

public class SimpleHTTPServer{
    
    public static void main(String[] args) throws Exception{
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening to connection on port 8080 ....");
        while(true){
            //Continue forever
        }
    }
}