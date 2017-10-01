package ChatApplication;

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
        this.ListGroup();
        System.out.println("Beginning chat");
        for(int i = 0; i < student1.responses.size(); i++) {
            System.out.println("Student 1: " + this.student1.GetResponse(i));
            System.out.println("Student 2: " + this.student2.GetResponse(i));
        }
        System.out.println("Chat has ended");
    }
    
    public void ListGroup() {
        System.out.print("Student 1: " + student1.firstName + " " +  student1.lastName);
        System.out.println(" | Student 2: " + student2.firstName + " "+  student2.lastName);
    }
    
}
