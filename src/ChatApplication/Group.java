package ChatApplication;

public class Group implements Comparable<Group> {
	protected Student student1;
	protected Student student2;
	
    public Group(Student student1, Student student2){
    	this.student1 = student1;
    	this.student2 = student2;
    	this.SortGroup();   	
    }
    
    @Override
    public int compareTo(Group otherGroup) {
	    // TODO implement your comparison code here
	    return 0;
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
