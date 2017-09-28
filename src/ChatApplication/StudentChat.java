package ChatApplication;

import ChatApplication.Student;
import ChatApplication.Group;

public class StudentChat {

    public static void main(String[] args) {
      Student student1 = new Student("Jonathan", "Mirabile", 1);
      String[] JonathanResponses = {"Test1", "Test2"};
      
      student1.AddResponse(JonathanResponses);
      student1.AddResponse("Hello");
      System.out.println(student1.GetResponse());
      System.out.println(student1.GetResponse(0));

    }
    

}
