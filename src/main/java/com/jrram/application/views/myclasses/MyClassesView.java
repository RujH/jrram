package com.jrram.application.views.myclasses;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Include;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.jrram.application.views.myclasses.MyClassesView.MyClassesViewModel;
import com.jrram.application.views.main.MainView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "classes", layout = MainView.class)
@PageTitle("My Classes")
@JsModule("./src/views/myclasses/my-classes-view.js")
@Tag("my-classes-view")
public class MyClassesView extends PolymerTemplate<MyClassesViewModel> {

    boolean addCoursePressed = false;

    public static interface MyClassesViewModel extends TemplateModel {
        @Include({"name", "newCourseInput"})
        void setClasses(List<Course> classes);
        List<Course> getClasses();

        String getNewCourseInput();
        void setNewCourseInput(String newCourseInput);

        void setAddCoursePressed(boolean addCoursePressed);

    }

    public void setIsValidConfig(boolean addCoursePressed) {
        getModel().setAddCoursePressed(addCoursePressed);
    }

    public void setNewCourseInput(String newCourseInput) {

    }


    public MyClassesView() {
        Teacher rafet = new Teacher("tobasei", "1");
        rafet.classes = new ArrayList<Course>(Arrays.asList(
                new Course("Java2", "123", 10),
                new Course("This2OtherClass", "123", 10)
        ));

        getModel().setAddCoursePressed(addCoursePressed);
        System.out.print(rafet.getClasses());

        getModel().setClasses(rafet.classes);
    }


    @EventHandler
    private void onAddCourse() {
        addCoursePressed = !addCoursePressed;
        getModel().setAddCoursePressed(addCoursePressed);
//        getModel().getClasses().add(new Course("Justadded", "123", 10));
    };

    @EventHandler
    private void confirmAddCourse() {
        String input = getModel().getNewCourseInput();
        System.out.println(input);
        getModel().getClasses().add(new Course(input, "123", 10));
    };

    public static class Course {

        //data members
        int curSize=0;
        int MAXSIZE = 25;
        String courseid;
        String name;
        double creditHours;
        ArrayList<Assignment> assignments;
        ArrayList<Student> students;

        //constructors
        public Course() {
        }

        //3 arg constructor
        public Course(String name, String id, double credits)
        {
            this.name = name;
            this.courseid = id;
            this.creditHours = credits;
            assignments = new ArrayList<Assignment>();
            students = new ArrayList<Student>();
        }

        public String getName() {
            return name;
        }
    };

    public static class Assignment {

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
        public Assignment(String type, String id, String name, double weight, String description, boolean lateOrNah ) {
            this.type = type;
            this.courseid = id;
            this.assgnName = name;
            this.weight = weight;
            this.description=description;
            this.isLate=lateOrNah;
        }

        //methods

        //compare assignment names. If they match, the assignment has been found successfully
        public boolean contains(String srchId) {
            boolean flag = false;
            if(srchId == this.assgnName)
                flag=true;
            return flag;
        }


        //getter methods

        //return the grade of the asisgnmnet
        public String getGrade() {
            String strGrade;
            //if the assignment has been graded, return the grade
            if (hasBeenGraded==true)
                strGrade =  String.valueOf(this.grade);
            else
                //if it hasn't been graded return that.
                strGrade="The assignment hasn't been graded yet";
            return strGrade;

        }

        //return the assignment weight
        public double getWeight() {
            return this.weight;
        }

        public String toString() {
            String output="";

            //the assignment hasn't been completed yet, print out relevant data
            if(turnedin == false) {
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
                    //if Assignment has been graded yet
                    output += "\nAssignment grade: " + grade;
                else //grade hasn't been assigned yet
                    output += "\nAssignment has not been graded yet.";

            }
            return output;
        }
    };

    public static class Teacher extends Person {

        //data members
        ArrayList<Course> classes;

        public Teacher() {
        };

        //constructors
        public Teacher(String name, String id) {
            //call person constructor
            super(name, id);
            classes = new ArrayList<Course>();
        }

        public ArrayList<Course> getClasses() {
            return classes;
        }
    };

    public static class Student extends Person{

        //data members
        private double gpa;
        public ArrayList<Assignment>assignments;
        public ArrayList<Course> classes;

        //constructors

        //2 arg costructor
        public Student(String name, String id) {
            //call person class constructor to set name and student id
            super(name, id);
            classes = new ArrayList<Course>();
            assignments = new ArrayList<Assignment>();

        }
        //3 arg constructor
        public Student(String name, String id, double pointAvg) {
            //call superclass constructor to set name and id
            super(name, id);
            //assign gpa
            this.gpa = pointAvg;
            classes = new ArrayList<Course>();
            assignments = new ArrayList<Assignment>();
        }

        //3 arg constructor no gpa, course supplied
        public Student(String name, String id, Course course) {
            //call person class constructor to set name and student id
            super(name, id);
            //create course array, ad the course to it
            classes = new ArrayList<Course>();
            classes.add(course);
            //create assignment array
            assignments = new ArrayList<Assignment>();
        }

        //4 arg constructor
        public Student(String name, String id, double pointAvg, Course course) {
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

        public void turnin(Assignment assgnm) {
            //indicate the assignment has been turned in
            assgnm.turnedin = true;
        }

        //getter methods

        //if found, add assignment to the student's assignments array
        void getAssignment(Course course, String assgnName) {
            boolean found=false;
            //search through the course for a specified assignment
            for(int i=0; i<course.assignments.size(); i++) {
                if(course.assignments.get(i).assgnName == assgnName) {
                    //if the assignment is found, add it to the students asignment array
                    this.assignments.add(course.assignments.get(i));
                    found = true;
                }
            }

            //if the assignment has not been found
            if(found ==false)
                System.out.println("Assignment not found. Please check you have the right course or assignment name");
        }

        //return string of the assignment grade, or return a string indicating the assignment hasn't been graded yet
        public String getAssignmentGrade(Assignment assgn) {
            String assgnGrade;

            assgnGrade = assgn.getGrade();

            return assgnGrade;
        }

        //return grade of the student in a particular course
        public double getCourseGrade(Course course) {
            //variables
            double classGrade;
            double pointsMade= 0.0;
            double pointsPossible=0.0;
            String courseid = course.courseid;

            //Go through students assignment, looking for assignments of the right course
            for(int i =0; i < assignments.size(); i++) {
                if(assignments.get(i).courseid == courseid) {
                    //if the assignment is for the class we are searching for
                    pointsPossible += assignments.get(i).getWeight();				//get the number of points possible
                    pointsMade += Double.valueOf(assignments.get(i).getGrade());	//get the number of ponts made
                }
            }

            //calculate grade
            classGrade= pointsMade/pointsPossible;
            return classGrade;
        }

        //return overall gpa
        public void calcGPA() {
            //variables
            double GPA;
            double pointsMade=  0.0;
            double pointsPossible= 0.0;
            double totalCreditsEarned= 0.0;
            double creditHourSum=0.0;
            double[] gradeArray = new double[this.classes.size()];
            String curClassId;
            //get the total number of credit hours the student took
            for(int i = 0; i < classes.size(); i++) {
                creditHourSum += classes.get(i).creditHours;
            }

            //Accumulate the grades in each course
            for(int i =0; i < classes.size(); i++) {
                //get the course id, use this id to fiter through assignments by course
                curClassId= classes.get(i).courseid;
                //for each assignment in the course
                for(int j =0; j < assignments.size(); j++) {
                    //if the assignment belongs to the class we are accumulating.
                    if(assignments.get(j).courseid == curClassId) {
                        //accumulate the points possible and points made
                        pointsPossible += assignments.get(j).getWeight();
                        pointsMade += Double.valueOf(assignments.get(j).getGrade());
                    }
                }

                //calculate the the grade for the course, store in an array
                gradeArray[i] = pointsMade/pointsPossible;
            }

            //convert grade to a 4.0 scale
            //A=4 B=3 C=2 D=1 F=0
            for(int i=0; i < gradeArray.length; i++) {
                if (gradeArray[i]>=90) 		//Grade is A
                    gradeArray[i]=4.0;
                else if(gradeArray[i]>=80)	//Grade is B
                    gradeArray[i]=3.0;
                else if (gradeArray[i]>=70)	//Grade is C
                    gradeArray[i] = 2.0;
                else if (gradeArray[i] >= 60)//Grade is D
                    gradeArray[i]=1.0;
                else 						 //Grade is F
                    gradeArray[i]=0.0;
            }

            //accumulate the credits earned
            for(int i =0; i<gradeArray.length; i++) {
                totalCreditsEarned+=gradeArray[i] * classes.get(i).creditHours;
            }

            //calculate GPA
            GPA = totalCreditsEarned/creditHourSum;

            //set GPA
            this.gpa = GPA;
        }

        //Printout Student object
        public String toString() {
            String stuStr;
            stuStr = "Student: " + this.name + " UID: " + uid + " GPA: " + this.gpa;
            return stuStr;
        }
    };

    public static class Person {

        //data members
        String name;
        String uid;

        //constructors
        //empty constructor
        public Person() {
            this.name = "\0";
            this.uid = "\0";
        }

        //2arg constructor
        public Person(String name, String id) {
            this.name = name;
            this.uid = id;
        }

        //print out details of person object if necessary.
        public String toString() {
            String output;
            output = "Person: " + name +" UID: " + uid + "\n";
            return output;
        }
    };
}
