package ChatApplication;

import java.io.*;
import java.net.*;
// Unused import -2pts
import ChatApplication.GraphicalChat;

public class ChatClient {
    private int port = 8090;
    protected boolean connected = false;
    protected Socket client = null;
    protected DataOutputStream out = null;
    protected InputStreamReader in = null;
    protected PrintWriter pw = null;
    protected BufferedReader br = null;
    protected String clientName = "";
    
    public ChatClient(String ipAddress) {
        // Chat does not start it's own copy of the server if none is found -5pts
        startClient(ipAddress);
        
    }
    
    protected boolean startClient(String ipAddress) {
        // ChatClient blocks waiting for the server and doesn't tell the user what is happening
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
    
    // Note that doing an explicit read is not required if you're using threads for the input portion
    protected String readTextFromServer() {
        String input;
        String output = "";

        try {
            // ChatClient blocks when it hasn't received EOM - this is not a requirement, and breaks interoperability with other clients
            while((input = br.readLine()) != null && !(input.equalsIgnoreCase("EOM"))) {
                if(input.equalsIgnoreCase("ACK")) {
                    input= "";
                    input = br.readLine();
                    this.setClientName(input);
                    input= "Has joined the chat";
                }
                output += input;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Message Recieved from Server: "  + "\n" + this.getClientName() + ": " + output);
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
    
    public void setClientName(String chatName) {
        this.clientName = chatName;
    }
    
    public String getClientName() {
        return this.clientName;
    }
    

    
    protected void startNewServer() {
        
    }

}
