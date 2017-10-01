package ChatApplication;

import java.util.*;

public class Student {
	
	protected String firstName;
	protected String lastName;
	protected Integer score;
	protected List<String> responses = new ArrayList<String>();
	
    public Student(String fName, String lName, Integer score){
    	this.firstName = fName;
    	this.lastName = lName;
    	this.score = score;   	
    }
    
    
    public void AddResponse(String Response) {
        this.responses.add(Response);
    }
    
    public void AddResponse(String[] Response) {
        for(int i=0; i < Response.length; i++) {
            this.responses.add(Response[i]);
        }
    }
    
    public String GetResponse(int index) {
        //Add bounds checking
        return this.responses.get(index);  
    }
    
    public String GetResponse() {
        //Returns the last response
        return this.responses.get(responses.size() -1);
    }
	
}
