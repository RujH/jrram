import java.util.ArrayList;

public class Student extends Person{

	//data members
	private double gpa;
	private int numCourses=0;
	private ArrayList<Assignment>assignments;
	public ArrayList<Course> classes;
	
	//constructors
	//2 arg costructor
	public Student(String name, String id) 
	{
		//call person class constructor to set name and student id
		super(name, id);
		classes = new ArrayList<Course>();
		assignments = new ArrayList<Assignment>();

	}
	//3 arg constructor
	public Student(String name, String id, double pointAvg)
	{
		//call superclass constructor to set name and id
		super(name, id);
		//assign gpa
		this.gpa = pointAvg;
		classes = new ArrayList<Course>();
		assignments = new ArrayList<Assignment>();
	}
	
	//methods
	
	//turnin methods
	//assignment just needs an esay
	public void turnin(Assignment assgnm, String essay)
	{
		//store student essay in assignment essay data member
		assgnm.essay = essay;
		assgnm.turnedin = true;
		assignments.add(assgnm);
			
		
	}
	
	//assignment just needs a multiple choice array
	public void turnin(Assignment assgnm, char [] mcAnswers)
	{
		//store student multiple choice answers to assignment multiple choice array
		for(int i=0; i<assgnm.multChoice.length; i++)
		{
			assgnm.multChoice[i] = mcAnswers[i];
		}
		
		assgnm.turnedin = true;
		
		assignments.add(assgnm);
	}
	
	//assignment needs both an essay and multiple choice array
	public void turnin(Assignment assgnm, String essay, char [] mcAnswers)
	{
		//store student essay in assignment essay data member
		assgnm.essay = essay;
		//store student multiple choice answers to assignment multiple choice array
		for(int i=0; i<assgnm.multChoice.length; i++)
		{
			assgnm.multChoice[i] = mcAnswers[i];
		}		
		
		assgnm.turnedin = true;
		
		assignments.add(assgnm);
	}
	
	//getter methods
	
	//get the due date for an assignment
	public String getDueDate(Course course, String id)
	{
		//variables
		boolean exists = false;
		String dueDate="";
		
		//search the assignments in the course
		for(int i =0; i < course.assignments.size(); i++)
		{
			//if the assignment is the one we are searching for
			if(course.assignments.get(i).contains(id))
			{
				//store the due date 
				dueDate = course.assignments.get(i).getDueDate();
				
				//correct assignment has been found, change exist flag
				exists=true;
			}
		}
		
		//if the correct assignment is not found, let user know
		if(exists == false)
		{
			dueDate = "Could not find assingment. Please check you have the right search ID and course.";
		}
		
		return dueDate;
	}
	
	//get the grade of the assignment 
	public String getAssignmentGrade(Course course, String id)
	{
		//variables
		String assgnGrade="";
		boolean exists=false;
		
		//search the assignments in the course
		for(int i =0; i < course.assignments.size(); i++)
		{
			//if the assignment is the one we are searching for
			if(course.assignments.get(i).contains(id))
			{
				//store the due date 
				 assgnGrade = course.assignments.get(i).getGrade();
				 //indicate we have succesfully found the assignment
				 exists=true;
				
			}
		}
		
		//the asignment could not be found
		if(exists==false)
		{
			//return failed search
			assgnGrade="Could not find assignment. Please check you have the right search ID and course";
		}
		
		return assgnGrade;
	}
	
	//return grade of the student 
	public double getCourseGrade(Course course)
	{
		//variables
		double classGrade;
		double pointsMade= 0.0;
		double pointsPossible=0.0;
		
		//Accumulate points made, and points possible in the course
		for(int i =0; i < course.assignments.size(); i++)
		{
			//if the assignment is the one we are searching for
			pointsPossible += course.assignments.get(i).getWeight();
			pointsMade += Double.valueOf(course.assignments.get(i).getGrade());
		}
		
		//calculate grade
		classGrade= pointsMade/pointsPossible;
		
		
		return classGrade;
	}
	
	//return overall gpa
	public double getGPA(ArrayList<Course> courselist)
	{
		//variables
		double GPA;
		double pointsMade= 0.0;
		double pointsPossible=0.0;
		
		//Accumulate points made, and points possible in the course
		for(int i =0; i < courselist.size(); i++)
		{
			//if the assignment is the one we are searching for
			pointsPossible += courselist.get(i).assignments.get(i).getWeight();
			pointsMade += Double.valueOf(courselist.get(i).assignments.get(i).getGrade());
		}
		
		//calculate grade
		GPA= pointsMade/pointsPossible;
		
		this.gpa = GPA;
		
		return GPA;
	}
	
	//Printout Student object
	public String toString()
	{
		String stuStr;
		
		stuStr = "Student: " + this.name + " UID: " + uid;
		
		return stuStr;
	}
	
//end class
}
