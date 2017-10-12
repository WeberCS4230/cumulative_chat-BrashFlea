package ChatApplication;

import java.io.*;
import java.net.*;

public class ChatServer {
    private int port = 8090;
    private ServerSocket serverSocket;
    protected DataOutputStream out = null;
    protected InputStreamReader in = null;
    protected PrintWriter pw = null;
    protected BufferedReader br = null;
    protected Socket server = null;
    
    public ChatServer() throws IOException {
        serverSocket = new ServerSocket(port);       
    }
    
    
    public void run() {
        while(true) {
            try {
                server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                
                in = new InputStreamReader(server.getInputStream());
                out = new DataOutputStream(server.getOutputStream());
                
                pw = new PrintWriter(out, true);
                pw.println("ACK");
                pw.flush();
                
                br = new BufferedReader(in);
                
                String input;
                
                while((input = br.readLine()) != null) {
                    System.out.println("Message Recieved: " + input);                   
                }


            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            finally {
                pw.close();
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    server.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    protected void sendTextToClient(String text) {
        pw.println(text);
        pw.flush();    
    }
    
    public static void main(String[] args) {
        //Start the server and client
        System.out.println("Starting Server");
        try {
          ChatServer server = new ChatServer();
          server.run();
      } catch (IOException e) {
          System.out.println("Error starting server");
      }
           
    }

}
