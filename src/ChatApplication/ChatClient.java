package ChatApplication;

import java.io.*;
import java.net.*;

public class ChatClient {
    private int port = 8090;
    protected boolean connected = false;
    protected Socket client = null;
    protected DataOutputStream out = null;
    protected InputStreamReader in = null;
    protected PrintWriter pw = null;
    protected BufferedReader br = null;
    
    public ChatClient(String ipAddress) {
        startClient(ipAddress);
        
    }
    
    protected boolean startClient(String ipAddress) {
        try {
            client = new Socket (ipAddress, port);
            out = new DataOutputStream(client.getOutputStream());
            in = new InputStreamReader(client.getInputStream());

            pw = new PrintWriter(out, true);
            br = new BufferedReader(in);
            connected = true;
                                 
        } catch (IOException e) {
            System.out.println("Unable to connect using IPAddress: " + ipAddress);
            connected = false;
        }
        
        return connected;
             
    }
    
    protected void sendTextToServer(String text) {
        pw.println(text);
        pw.flush();    
    }
    
    protected String readTextFromServer() {
        String input;
        String output = "";

        try {
            while((input = br.readLine()) != null && !(input.equalsIgnoreCase("EOM"))) {
                if(input.equalsIgnoreCase("ACK")) {
                    input = "";
                }
                output += input;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output;
    }
    
    protected void disconnectFromServer() {
         pw.close();
         try {
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         try {
            client.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    protected boolean testConnection() {
        System.out.println("Testing connection to server");
        pw.println("Test");
        connected = true;

        return connected;

    }
    
    protected void startNewServer() {
        
    }

}
