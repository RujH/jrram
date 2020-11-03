import java.util.ArrayList;

public class Student extends Person{

    //data members
    private double gpa;
    public ArrayList<Assignment>assignments;
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

    //3 arg constructor no gpa, course supplied
    public Student(String name, String id, Course course)
    {
        //call person class constructor to set name and student id
        super(name, id);
        //create course array, ad the course to it
        classes = new ArrayList<Course>();
        classes.add(course);
        //create assignment array
        assignments = new ArrayList<Assignment>();
    }

    //4 arg constructor
    public Student(String name, String id, double pointAvg, Course course)
    {
        //call person class constructor to set name and student id
        super(name, id);
        //assign gpa
        this.gpa = pointAvg;
        //create course array, add course to it
        classes = new ArrayList<Course>();
        classes.add(course);
        //create assignment array
        assignments = new ArrayList<Assignment>();
    }

    //methods

    public void turnin(Assignment assgnm)
    {
        //indicate the assignment has been turned in
        assgnm.turnedin = true;
        double random = Math.random();
        if (random <= 0.30) {
            assgnm.isLate = true;
        } else {
            assgnm.isLate = false;
        }
    }

    //getter methods

    //if found, add assignment to the student's assignments array
    void getAssignment(Course course, String assgnName)
    {
        boolean found=false;
        //search through the course for a specified assignment
        for(int i=0; i<course.assignments.size(); i++)
        {
            if(course.assignments.get(i).assgnName.equals(assgnName))
            {
                //if the assignment is found, add it to the students asignment array
                this.assignments.add(course.assignments.get(i));
                found = true;
            }
        }

        //if the assignment has not been found
        if(found ==false)
        {
            System.out.println("Assignment not found. Please check you have the right course or assignment name");
        }
    }

    //return string of the assignment grade, or return a string indicating the assignment hasn't been graded yet
    public String getAssignmentGrade(Assignment assgn)
    {
        String assgnGrade;

        //Assignment assign = assignments.get(assignments.indexOf(assgn));
        assgnGrade = assgn.getGrade();

        return assgnGrade;
    }

    //return grade of the student in a particular course
    public double getCourseGrade(Course course)
    {
        //variables
        double classGrade;
        double pointsMade= 0.0;
        double pointsPossible=0.0;
        String courseid = course.courseid;
        
      //Go through students assignment, looking for assignments of the right course
        for(int i =0; i < assignments.size(); i++)
        {
            if(assignments.get(i).courseid == courseid)
            {
                //if the assignment is for the class we are searching for
            	if(assignments.get(i).hasBeenGraded==true)
            	{
            		
            		pointsMade += ( (Double.valueOf(assignments.get(i).getGrade())/100) * assignments.get(i).getWeight() );	//get the number of ponts made
            		pointsPossible += assignments.get(i).getWeight();
            	}
            }
       }
   
        //calculate grade
        classGrade= 100*(pointsMade/pointsPossible);
        return classGrade;
    }

    //return overall gpa
    public void calcGPA()
    {
        //variables
        double GPA;
        double totalCreditsEarned= 0.0;
        double courseGrade;
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
            courseGrade= getCourseGrade(classes.get(i));
            //calculate the the grade for the course, store in an array
            gradeArray[i] = courseGrade;  
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
            totalCreditsEarned+= gradeArray[i] * classes.get(i).creditHours;
        }
        
        //calculate GPA
        GPA = totalCreditsEarned/creditHourSum;

        //set GPA
        this.gpa = GPA;
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
