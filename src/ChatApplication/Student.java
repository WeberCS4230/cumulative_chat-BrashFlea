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
    
    
    public void addResponse(String response) {
        this.responses.add(response);
    }
    
    public void addResponses(String[] responses) {
	for (String response: responses) {
            this.responses.add(response);
        }
    }
    
    public String getResponse(int index) {
        //Add bounds checking
        return this.responses.get(index);  
    }
    
    public String getLastResponse() {
        //Returns the last response
        return this.responses.get(responses.size() -1);
    }
	
}
