package ChatApplication;

import java.io.*;
import java.net.*;

public class ChatServer {
    private int port = 8090;
    private ServerSocket serverSocket;
    protected DataOutputStream out = null;
    protected DataInputStream in = null;
    
    public ChatServer() throws IOException {
        serverSocket = new ServerSocket(port);       
    }
    
    
    public void run() {
        while(true) {
            try {
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                
                in = new DataInputStream(server.getInputStream());
                out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("ACK");
                out.flush();
                
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    
    protected void sendTextToClient(String text) {
        try {
            out.writeUTF(text);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
    
    public static void main(String[] args) {
        //Start the server and client
        System.out.println("Starting Server");
        try {
          ChatServer server = new ChatServer();
          server.run();
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
        
    }

}
