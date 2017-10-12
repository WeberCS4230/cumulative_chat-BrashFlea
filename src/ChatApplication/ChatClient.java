package ChatApplication;

import java.io.*;
import java.net.*;

public class ChatClient {
    private int port = 8090;
    protected boolean connected = false;
    protected Socket client = null;
    protected DataOutputStream out = null;
    protected DataInputStream in = null;
    
    public ChatClient(String ipAddress) {
        startClient(ipAddress);
        
    }
    
    protected boolean startClient(String ipAddress) {
        try {
            client = new Socket (ipAddress, port);
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());
            connected = true;
                              
        } catch (IOException e) {
            System.out.println("Unable to connect using IPAddress: " + ipAddress);
            connected = false;
        }
        
        return connected;
             
    }
    
    protected void sendTextToServer(String text) {
        try {
            out.writeUTF(text);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
    
    protected void disconnectFromServer() {
        
    }
    
    protected boolean testConnection() {
        System.out.println("Testing connection to server");
        try {
            out.writeUTF("Test");
            connected = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            connected = false;
        }

        return connected;

    }
    
    protected void startNewServer() {
        
    }

}
