package ChatApplication;

import ChatApplication.Student;
import ChatApplication.Group;
import ChatApplication.ChatClient;
import ChatApplication.ChatServer;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Random;

public class StudentChat {

    public static void main(String[] args) {
                
      //Create the student objects
      Student student1 = new Student("Jonathan", "Mirabile", 1);
      Student student2 = new Student("Justin", "Behunin", 2);
      Student student3 = new Student("Kenyon", "Brown", 3);
      Student student4 = new Student("Austin", "Forsling", 4);
      Student student5 = new Student("Nicholas", "Goldberg", 5);
      Student student6 = new Student("Tyler", "Hoyer", 6);
      Student student7 = new Student("Steven", "Julien", 7);
      Student student8 = new Student("Christopher", "Nash", 8);
      
      //Create the responses for each student
      String[] JonathanResponses = {"Hello", "Just playing some Overwatch", "I really like Soldier 76, you?", "Awesome, we should play together some time", "Will do"};
      String[] JustinResponses = {"How do you do?", "I'm doing ok", "Yup", "Agreed", "Bye"};
      String[] KenyonResponses = {"Hola", "I love it! How is Hawaii?", "Awesome", "Have a good one", "Bye"};
      String[] AustinResponses = {"Aloha", "How are you enjoying Mexico?", "I like it", "Well gotta run", "You too"};
      String[] NicholasResponses = {"Pretty well, yourself?", "That's good to hear", "Well this is strange", "Ok...", "Peace out"};
      String[] TylerResponses = {"What's up?", "Sweet! Who's your favorite character?", "I'm pretty good with Reaper", "Ok, let me know when you want to", "Ok bye"};
      String[] StevenResponses = {"What's happening?", "Just working on CS3230 homework", "It's a lot of fun!", "I would highly recommend it", "Cya later"};
      String[] ChristopherResponses = {"Good day", "Not much, how about you? ", "Very nice, how do you like the class?", "Awesome! I'll have to take it next semester", "Thanks, gotta run"};
      
      //Add the responses to each student
      student1.AddResponse(JonathanResponses);
      student2.AddResponse(JustinResponses);
      student3.AddResponse(KenyonResponses);
      student4.AddResponse(AustinResponses);
      student5.AddResponse(NicholasResponses);
      student6.AddResponse(TylerResponses);
      student7.AddResponse(StevenResponses);
      student8.AddResponse(ChristopherResponses);
      
      //Create groups
      Group group1 = new Group(student3, student4);
      Group group2 = new Group(student2, student5);
      Group group3 = new Group(student1, student6);
      Group group4 = new Group(student7, student8);
      
      //Run a random group chat
      Random rand = new Random();
      int n = rand.nextInt(4) + 1;
      
      System.out.println("Starting Client");
      ChatClient client = new ChatClient("127.0.0.1");
      client.testConnection();
      client.sendTextToServer("Test Sending Text To Server");
      
      
      switch(n){
          case 1:
              EventQueue.invokeLater(() -> {
                  GraphicalChat ex = new GraphicalChat(group1.GetChatText());
                  ex.setVisible(true);
              });
              break;
          case 2:
              EventQueue.invokeLater(() -> {
                  GraphicalChat ex = new GraphicalChat(group2.GetChatText());
                  ex.setVisible(true);
              });
              break;
          case 3:
              EventQueue.invokeLater(() -> {
                  GraphicalChat ex = new GraphicalChat(group3.GetChatText());
                  ex.setVisible(true);
              });
              break;
          case 4:
              EventQueue.invokeLater(() -> {
                  GraphicalChat ex = new GraphicalChat(group4.GetChatText());
                  ex.setVisible(true);
              });
              break;     
      }
      
     
    }
    
}
