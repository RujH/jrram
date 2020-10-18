
import java.util.Calendar;

 public class Assignment {

	//data members
	double grade;
	double weight;
	String courseid;
	String description;
	String type;
	boolean turnedin = false;
	Calendar duedate;
	char [] multChoice;
	String essay;
	
	//constructors
	//5 arg constructor type id weight dayAway description
	public Assignment(String type, String id, double weight, int dayAway, String description )
	{
		this.type = type;
		this.courseid = id;
		this.weight = weight;
		duedate = Calendar.getInstance();
		duedate.add(Calendar.DATE, + dayAway);
		this.description=description;
	}
	
	//6 arg constructor type id weight monthAway dayAway description
	public Assignment(String type, String id, double weight, int monthAway, int dayAway, String description )
	{
		this.type = type;
		this.courseid = id;
		this.weight=weight;
		duedate = Calendar.getInstance();
		duedate.add(Calendar.DATE, + dayAway);
		duedate.add(Calendar.MONTH, monthAway);
		this.description = description;
	}
	
	
	//methods
	
	
	
	
	
	
//end class
}
