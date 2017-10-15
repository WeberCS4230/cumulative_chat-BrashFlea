package ChatApplication;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Group {
	protected Student student1;
	protected Student student2;
	
    public Group(Student student1, Student student2){
    	this.student1 = student1;
    	this.student2 = student2;
    	this.SortGroup();   	
    }
    
    public void SortGroup(){
        int compareFirstName = this.student1.firstName.compareToIgnoreCase(this.student2.firstName);
        
        if (compareFirstName < 0) {
            //Already sorted
        }
        else if (compareFirstName > 0) {
            Student temp = student2;
            this.student2 = this.student1;
            this.student1 = temp;         
        }
        else if (compareFirstName == 0) {
            //Same first name, check last name
            int compareLastName = this.student1.lastName.compareToIgnoreCase(this.student2.lastName);
            
            if (compareLastName < 0) {
                //Already sorted
            }
            else if (compareLastName > 0) {
                Student temp = student2;
                this.student2 = this.student1;
                this.student1 = temp;         
            }
            else if (compareLastName == 0) {
                //Same last name. No sort needed
            }
        }                    
    }
    
    public void RunChat() {
        for(int i = 0; i < student1.responses.size(); i++) {
            System.out.println(this.student1.firstName + ": " + this.student1.GetResponse(i));
            System.out.println(this.student2.firstName + ": " + this.student2.GetResponse(i));
        }
    }
    
    public String GetChatText() {
	// um - overcomplicated much? When we're talking about extensible, I shouldn't have to intercept System.out in order to get the ouptut of a method.
        //Redirect the out stream to a ByteArrayOutputStream
        //to collect the chat contents and return it as a string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        PrintStream old = System.out;
        System.setOut(ps);
        this.RunChat();
        System.out.flush();
        System.setOut(old);
        
        return baos.toString();
    }
    
    public void ListGroup() {
        System.out.print("Student 1: " + student1.firstName + " " +  student1.lastName);
        System.out.println(" | Student 2: " + student2.firstName + " "+  student2.lastName);
    }
    
}
