
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
	boolean isLate;
	
	//constructors
	//6 arg constructor type id weight name weight and description
	public Assignment(String type, String id, String name, double weight, String description, boolean lateOrNah )
	{
		this.type = type;
		this.courseid = id;
		this.assgnName = name;
		this.weight = weight;
		this.description=description;
		this.isLate=lateOrNah;
	}

	//methods
	
	//compare assignment names. If they match, the assignment has been found successfully
	public boolean contains(String srchId)
	{
		boolean flag = false;
		if(srchId == this.assgnName)
		{
			flag=true;
		}
		return flag;
	}
	
	
	//getter methods 
	
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
					  "Assignment description: " + description + "\nAssignment not turned in.\n");
			
			
		}
		else //assignment has been turned in, print out relevent data
		{
			//Printout what course assignment is for, and type of assignment
			//Print out due date.
			//print out description
			output = ("Assignment for course: " + courseid + ", is a:" + type +
			           "\nAssignment description: " + description);
			
			if(this.hasBeenGraded==true)
			{
				//if Assignment has been graded yet
				output += "\nAssignment grade: " + grade;
				
			}
			else //grade hasn't been assigned yet
			{
				output += "\nAssignment has not been graded yet.";
			}
			
		}
		
		return output;
		
	}
	
	
//end class
}
