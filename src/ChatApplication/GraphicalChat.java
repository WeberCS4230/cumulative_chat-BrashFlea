package ChatApplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicalChat extends JFrame {
    
    private static final long serialVersionUID = 1L;
    protected JTextArea chatArea = null;
    protected JTextArea chatInput = null;
    protected JButton inputSend = null;
    protected GridBagConstraints gbc1 = new GridBagConstraints();
    protected static final Font HELVETICA = new Font("Helvetica", Font.PLAIN, 14);
    protected static final Font COURIER = new Font("Courier", Font.ITALIC, 12);
    
    
    public GraphicalChat(String textToDisplay) {
        initUI();
        showTextArea(textToDisplay);
        addScrollBar();
        showChatInput();
        showInputButton();
        
        // One thing to note is that creating a new JFrame (which GraphicalChat extends) begins it's own UI thread - you don't have to call the EventQueue to get that functionality.
	    // Setting up GraphicalChat (in it's constructor) to call setVisible(true) at the end actually gives you the following to invoke the constructor: new GraphicalChat(String). Done.
        setVisible(true);
    }

    private void initUI() {
        setTitle("CS3230 Graphical Chat - Jonathan Mirabile");
        setLayout(new GridBagLayout());
        setSize(400,515);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void showTextArea(String textToDisplay) {
        chatArea = new JTextArea(textToDisplay, 10, 25);
        chatArea.setFont(HELVETICA);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);
        
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 6;
        gbc1.gridheight = 7;
        gbc1.weightx = 1;
        gbc1.weighty = 1;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        
        add(chatArea, gbc1);
                
    }
    
    private void addScrollBar() {
        JScrollPane scroll = new JScrollPane(chatArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.weightx = 1;
        gbc1.weighty = 1;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        
        add(scroll, gbc1);
        
    }
    
    private void showChatInput() {
        chatInput = new JTextArea("Enter chat text here", 15, 10);
        chatInput.setFont(COURIER);
        chatInput.setLineWrap(true);
        chatInput.setWrapStyleWord(true);
        chatInput.setEditable(true);
        
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.gridwidth = 6;
        gbc1.gridheight = 1;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        
        add(chatInput, gbc1);
        
        chatInput.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(chatInput.getText().trim().equals("Enter chat text here")) {
                    chatInput.setText("");
                }
            }
        });
        
        chatInput.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if((e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK)) {
                    //Add the message text to the chat box
                    chatArea.append(chatInput.getText() + '\n');
                    //Clear the input box
                    chatInput.setText("");
                    //Scroll to the bottom of the chat box
                    chatArea.setCaretPosition(chatArea.getDocument().getLength());
                }
            }
        });
                      
    }
    
    protected void showInputButton() {
        inputSend = new JButton("Send");
        
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.gridwidth = 6;
        gbc1.gridheight = 3;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        add(inputSend, gbc1);
        
        inputSend.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //Add the message text to the chat box
                chatArea.append(chatInput.getText() + '\n');
                //Clear the input box
                chatInput.setText("");
                //Scroll to the bottom of the chat box
                chatArea.setCaretPosition(chatArea.getDocument().getLength());
            }
        });
             
    }
       
}
