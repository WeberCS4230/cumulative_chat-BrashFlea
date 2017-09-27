package ChatApplication;

public class Student {
	
	protected String firstName;
	protected String lastName;
	protected Integer score;
	protected String[] responses = new String[5];
	
    public Student(String fName, String lName, Integer score, 
    		String hello, String response1, String response2, String response3, String goodbye){
    	this.firstName = fName;
    	this.lastName = lName;
    	this.score = score;
    	
    	this.responses[0] = hello;
    	this.responses[1] = response1;
    	this.responses[2] = response2;
    	this.responses[3] = response3;
    	this.responses[4] = goodbye;
    	
    }
	
}
