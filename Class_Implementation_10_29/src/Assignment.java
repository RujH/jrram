
import java.util.Calendar;

 public class Assignment {

	//data members
	double grade;
	double weight;
	String courseid;
	String description;
	String type;
	String assgnName;
	boolean turnedin = false;
	boolean hasBeenGraded=false;
	Calendar duedate;
	char [] multChoice;
	String essay;
	
	//constructors
	//6 arg constructor type id weight dayAway description
	public Assignment(String type, String id, String name, double weight, int dayAway, String description )
	{
		this.type = type;
		this.courseid = id;
		this.assgnName = name;
		this.weight = weight;
		duedate = Calendar.getInstance();
		duedate.add(Calendar.DATE, + dayAway);
		this.description=description;
	}
	
	//7 arg constructor type id weight monthAway dayAway description
	public Assignment(String type, String id, String name, double weight, int monthAway, int dayAway, String description )
	{
		this.type = type;
		this.courseid = id;
		this.assgnName = name;
		this.weight=weight;
		duedate = Calendar.getInstance();
		duedate.add(Calendar.DATE, + dayAway);
		duedate.add(Calendar.MONTH, monthAway);
		this.description = description;
	}
	
	//Decide if the assignment object is of a certain type
	public boolean contains(String srchId)
	{
		boolean flag = false;
		if(srchId == this.courseid)
		{
			flag=true;
		}
		return flag;
	}
	
	//methods
	
	//getter methods 
	
	//return the due date of the assignment
	public String getDueDate()
	{
		return this.courseid;
	}
	
	//return the grade of the asisgnmnet
	public String getGrade()
	{
		String strGrade;
		//if the assignment has been graded, return the grade
		if (hasBeenGraded==true)
		{
			
			strGrade =  String.valueOf(this.grade);
		}
		else
		{
			//if it hasn't been graded return that.
			strGrade="The assignment hasn't been graded yet";
		}
		return strGrade;
		
	}
	
	//return the assignment weight
	public double getWeight()
	{
		return this.weight;
	}
	
	public String toString()
	{
		String output="";
		
		//the assignment hasn't been completed yet, print out relevant data
		if(turnedin ==false)
		{
			//print out what course the assignment it for, what type of assignment it it
			//print out date assignment is due
			//Print out assignment description for user. Inform them they have not turned it in
			output = ("Assignment for course: " + courseid + ", is a:" + type + "\n" +
					  "Assignment due on: " + duedate + "\n" +
					  "Assignment description: " + description + "\nAssignment not turned in.\n");
			
			
		}
		else //assignment has been turned in, print out relevent data
		{
			//Printout what course assignment is for, and type of assignment
			//Print out due date.
			//print out description
			output = ("Assignment for course: " + courseid + ", is a:" + type +
			          "Assignment due on: " + duedate +
			           "Assignment description: " + description);
			if(grade > 0)
			{
				//if Assignment has been graded yet
				output += "Assignment grade: " + grade;
				
			}
			else //grade hasn't been assigned yet
			{
				output += "Assignment has not been graded yet.";
			}
			
		}
		
		return output;
		
	}
	
	
//end class
}
