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
        showChatInput();
        
    }

    private void initUI() {
        setTitle("CS3230 Graphical Chat");
        setLayout(new GridLayout(2,1));
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    private void showTextArea(String textToDisplay) {
        JTextArea chatArea = new JTextArea(textToDisplay, 10, 25);
        Font hv = new Font("Helvetica", Font.PLAIN, 14);
        chatArea.setFont(hv);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);
        add(chatArea);
        
        JScrollPane scroll = new JScrollPane(chatArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
        
    }
    
    private void showChatInput() {
        JTextArea chatInput = new JTextArea("Enter chat text here", 15, 10);
        Font co = new Font("Courier", Font.ITALIC, 12);
        chatInput.setFont(co);
        chatInput.setLineWrap(true);
        chatInput.setWrapStyleWord(true);
        chatInput.setEditable(true);
        add(chatInput);
        
        chatInput.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                chatInput.setText("");
            }
        });
        
    }
    
    


}
