import java.util.ArrayList;

public class Course {

	//data members
	int curSize=0;
	int MAXSIZE = 25;
	String courseid;
	String name;
	double creditHours;
	ArrayList<Assignment> assignments;
	ArrayList<Student> students;
	
	//constructors
	//3 arg constructor
	public Course(String name, String id, double credits)
	{
		this.name = name;
		this.courseid = id;
		this.creditHours = credits;
		assignments = new ArrayList<Assignment>();
		students = new ArrayList<Student>();
	}
	//methods
	
	
	
	
//end class
}
