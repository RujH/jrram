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
	public double getGPA()
	{
		//variables
		double GPA;
		double pointsMade=  0.0;
		double pointsPossible= 0.0;
		double totalCreditsEarned= 0.0;
		double creditHourSum=0.0;
		double gradeArray [] = new double[this.classes.size()];		
	
		//get the total number of credit hours the student took
		for(int i = 0; i < classes.size(); i++)
		{
			creditHourSum += classes.get(i).creditHours;
		}
		
		
		//Accumulate the grades in each course
		for(int i =0; i < classes.size(); i++)
		{
			//get a course to begin work on
			Course curCourse = classes.get(i);
			
			//for each assignment in the course
			for(int j =0; j < curCourse.assignments.size(); j++)
			{
				//accumulate the points possible and points made
				pointsPossible += curCourse.assignments.get(j).getWeight();
				pointsMade += Double.valueOf(curCourse.assignments.get(j).getGrade());
			}
			//calculate the the grade for the course
			gradeArray[i] = pointsMade/pointsPossible;
		}
		
		//convert grade to a 4.0 scale
		//A=4 B=3 C=2 D=1 F=0
		for(int i=0; i < gradeArray.length; i++)
		{
			if (gradeArray[i]>=90) 		//Grade is A
			{
				gradeArray[i]=4.0;
			}
			else if(gradeArray[i]>=80)	//Grade is B
			{
				gradeArray[i]=3.0;
			}
			else if (gradeArray[i]>=70)	//Grade is C
			{
				gradeArray[i] = 2.0;
			}
			else if (gradeArray[i] >= 60)//Grade is D
			{
				gradeArray[i]=1.0;
			}
			else 						 //Grade is F
			{
				gradeArray[i]=0.0;
			}
		}
		
		//accumulate the credits earned
		for(int i =0; i<gradeArray.length; i++)
		{
			totalCreditsEarned+=gradeArray[i] * classes.get(i).creditHours;
		}
		
		//calculate GPA
		GPA = totalCreditsEarned/creditHourSum;
		
		this.gpa = GPA;
		
		return GPA;
	}
	
	//Printout Student object
	public String toString()
	{
		String stuStr;
		
		stuStr = "Student: " + this.name + " UID: " + uid + " GPA: " + this.gpa;
		
		return stuStr;
	}
	
//end class
}
