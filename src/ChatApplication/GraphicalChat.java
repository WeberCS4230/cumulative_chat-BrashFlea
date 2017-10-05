package ChatApplication;

import ChatApplication.Group;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicalChat extends JFrame {
    private JLabel mainFrame;
    
    
    public GraphicalChat(String textToDisplay) {
        initUI();
        showTextArea(textToDisplay);
    }

    private void initUI() {
        setTitle("CS3230 Graphical Chat");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    private void showTextArea(String textToDisplay) {
        JTextArea chatArea = new JTextArea(textToDisplay, 10, 25);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);
        add(chatArea);
        
    }
    
    


}
