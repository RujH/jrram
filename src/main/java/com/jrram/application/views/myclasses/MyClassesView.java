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
    // Class members
    Teacher rafet = new Teacher("tobasei", "1");
    ArrayList<Student> students;

    // Adding course members
    boolean addCoursePressed = false; // If add course button has been pressed
    String newCourseInput; // Store input for new course
    int selectedCourse = -1; // Index for which course has been selected

    // Adding student members
    boolean addStudentPressed = false; // If add student button has been pressed
    String newStudentInput; // Store input for new student
    int selectedStudent = -1; // Index for which student has been selected

    // Adding assignment members
    boolean addAssgnPressed = false; // If add student button has been pressed
    String newAssgnInput; // Store input for new assignment
    String newTypeInput; // Store input for assignment type
    double newWeightInput; // Store input for assignment weight

    // Model for data binding server-client
    public static interface MyClassesViewModel extends TemplateModel {
        // For dynamically loading class array into view
        @Include({"name"})
        void setClasses(List<Course> classes);
        List<Course> getClasses();

        // For dynamically loading student array into view
        @Include({"name"})
        void setStudents(List<Student> students);
        List<Student> getStudents();

        // For dynamically loading assignment array into view
        @Include({"assgnName", "type", "weight"})
        void setAssignments(List<Assignment> assignments);
        List<Assignment> getAssignments();

        // For dynamically loading student stats into view
        @Include({"assgnName", "grade"})
        void setStudentStats(List<Assignment> assignments);
        List<Assignment> getStudentStats();

        // Adding new courses
        String getNewCourseInput();
        void setNewCourseInput(String newCourseInput);

        // Which course has been selected?
        Double getSelectedCourse();
        void setSelectedCourse(Double selectedCourse);

        // Adding new students
        String getNewStudentInput();
        void setNewStudentInput(String newStudentInput);

        // Which student has been selected?
        Double getSelectedStudent();
        void setSelectedStudent(Double selectedStudent);

        // Adding new assignments
        String getNewAssgnInput();
        void setNewAssgnInput(String newAssgnInput);
        String getNewTypeInput();
        void setNewTypeInput(String newTypeInput);
        String getNewWeightInput();
        void setNewWeightInput(String newWeightInput);

        // Flag that controls whether or not an input field will be rendered
        void setAddCoursePressed(boolean addCoursePressed);

        // Flag that controls whether or not an input field will be rendered
        void setAddStudentPressed(boolean addStudentPressed);

        // Flag that controls whether or not an input field will be rendered
        void setAddAssgnPressed(boolean addAssgnPressed);

    }

    // Main Driver
    public MyClassesView() {
        // Instructors create classes
        rafet.classes = new ArrayList<Course>(Arrays.asList(
                new Course("Intro to Java", "1", 3),
                new Course("React Web-Apps", "2", 3)
        ));

        // Get class references
        Course class1 = rafet.classes.get(0);
        Course class2 = rafet.classes.get(1);

        // These are the assignments for the classes taught by this professor
        class1.assignments = new ArrayList<Assignment>(Arrays.asList(
                new Assignment("HW", "1", "Homework 1", 20, "hw assignment", false),
                new Assignment("HW", "2", "Homework 2", 20, "hw assignment", false)
                ));

        class2.assignments = new ArrayList<Assignment>(Arrays.asList(
                new Assignment("PROJ", "1", "Project 1", 50, "proj assignment", false),
                new Assignment("PROJ", "2", "Project 2", 50, "proj assignment", false)
        ));

        // Create some students
        Student student1 = new Student("Little Timmy", "1", class1, class1.assignments);
        Student student2 = new Student("Big Joe", "2", class1, class1.assignments);
        Student student3 = new Student("Tony S", "1", class2, class2.assignments);
        Student student4 = new Student("John C", "2", class2, class2.assignments);

        // Add these students to the class objects
        class1.students = new ArrayList<Student>(Arrays.asList(student1, student2));
        class2.students = new ArrayList<Student>(Arrays.asList(student3, student4));


        getModel().setAddCoursePressed(addCoursePressed);
        getModel().setClasses(rafet.classes);

        // Event Listeners
        getElement().addPropertyChangeListener("newCourseInput", event -> {
            newCourseInput = getModel().getNewCourseInput();
        });

        getElement().addPropertyChangeListener("selectedCourse", event -> {
            selectedCourse = (int) Math.round(getModel().getSelectedCourse());

            Course selCourse = rafet.classes.get(selectedCourse);

            getModel().setAssignments(selCourse.assignments);
            getModel().setStudents(selCourse.students);

            if (selectedStudent >= 0) {
                Student selStudent = selCourse.students.get(selectedStudent);
                getModel().setStudentStats(selStudent.assignments);
            }
        });

        getElement().addPropertyChangeListener("newStudentInput", event -> {
            newStudentInput = getModel().getNewStudentInput();
        });

        getElement().addPropertyChangeListener("selectedStudent", event -> {
            selectedStudent = (int) Math.round(getModel().getSelectedStudent());
            selectedCourse = (int) Math.round(getModel().getSelectedCourse());

            Course selCourse = rafet.classes.get(selectedCourse);
            Student selStudent = selCourse.students.get(selectedStudent);

            getModel().setStudentStats(selStudent.assignments);
        });

        getElement().addPropertyChangeListener("newAssgnInput", event -> {
            newAssgnInput = getModel().getNewAssgnInput();
        });

        getElement().addPropertyChangeListener("newTypeInput", event -> {
            newTypeInput = getModel().getNewTypeInput();
        });

        getElement().addPropertyChangeListener("newWeightInput", event -> {
            newWeightInput = Double.parseDouble(getModel().getNewWeightInput());
        });
    }


    @EventHandler
    private void onAddCourse() {
        addCoursePressed = !addCoursePressed;
        getModel().setAddCoursePressed(addCoursePressed);
    };

    @EventHandler
    private void confirmAddCourse() {
        if (newCourseInput != null) {
            if (!newCourseInput.matches("\\s*")) {
                // add new course
                rafet.classes.add(new Course(newCourseInput, "123", 10));

                // update model
                getModel().setClasses(rafet.classes);

                // reset input field value
                getModel().setNewCourseInput(null);

                // hide input field again
                addCoursePressed = !addCoursePressed;
                getModel().setAddCoursePressed(addCoursePressed);
            }
        }
    };

    @EventHandler
    private void onAddStudent() {
        if (selectedCourse >= 0) {
            addStudentPressed = !addStudentPressed;
            getModel().setAddStudentPressed(addStudentPressed);
        }
    };

    @EventHandler
    private void confirmAddStudent() {
        if (newStudentInput != null) {
            if (!newStudentInput.matches("\\s*")) {

                // Grab which course has been selected to add student to corresponding course
                selectedCourse = (int) Math.round(getModel().getSelectedCourse());
                Course selCourse = rafet.classes.get(selectedCourse);

                // add new student
                Student newStudent = new Student(newStudentInput, "123", selCourse, selCourse.assignments);
                selCourse.students.add(newStudent);

                // update model
                getModel().setStudents(selCourse.students);

                // reset input field value
                getModel().setNewStudentInput(null);

                // hide input field again
                addStudentPressed = !addStudentPressed;
                getModel().setAddStudentPressed(addStudentPressed);
            }
        }
    };

    @EventHandler
    private void onAddAssgn() {
        if (selectedCourse >= 0) {
            addAssgnPressed = !addAssgnPressed;
            getModel().setAddAssgnPressed(addAssgnPressed);
        }
    };

    @EventHandler
    private void confirmAddAssgn() {
        String newWeightString = getModel().getNewWeightInput();
        if (newAssgnInput != null && newTypeInput != null && newWeightString != null) {
            if (!newAssgnInput.matches("\\s*") && !newTypeInput.matches("\\s*") && !newWeightString.matches("\\s*")) {

                // Grab which course has been selected to add assignment to corresponding course
                selectedCourse = (int) Math.round(getModel().getSelectedCourse());
                Course selCourse = rafet.classes.get(selectedCourse);

                // add new student
                Assignment newAssignment = new Assignment(newTypeInput, "1", newAssgnInput, newWeightInput, "assignment", false);
                selCourse.assignments.add(newAssignment);

                // update model
                getModel().setAssignments(selCourse.assignments);

                selCourse.students.forEach(student -> {
                    student.assignments.add(newAssignment);
                    getModel().setStudentStats(student.assignments);
                });

                // reset input field value
                getModel().setNewAssgnInput(null);
                getModel().setNewTypeInput(null);
                getModel().setNewWeightInput(null);


                // hide input field again
                addAssgnPressed = !addAssgnPressed;
                getModel().setAddAssgnPressed(addAssgnPressed);
            }
        }
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
        public Assignment() {
        };

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
        public String getAssgnName() {
            return assgnName;
        }
        
        //return the assignment weight
        public double getWeight() {
            return weight;
        }

        public String getType() {
            return type;
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
        public ArrayList<Assignment> assignments;
        public ArrayList<Course> classes;

        //constructors
        public Student() {

        }

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

        //4 arg constructor no gpa, course supplied
        public Student(String name, String id, Course course, ArrayList<Assignment> existingAssignments) {
            //call person class constructor to set name and student id
            super(name, id);
            //create course array, ad the course to it
            classes = new ArrayList<Course>();
            classes.add(course);
            //create assignment array
            assignments = new ArrayList<Assignment>();
            assignments.addAll(existingAssignments);
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

        public ArrayList<Assignment> getAssignments() {
            return assignments;
        }

        // Assign course assignment to the student
        public void assignAssignment(Course course, String assgnName) {
            boolean found = false;
            //search through the course for a specified assignment
            for (int i = 0; i < course.assignments.size(); i++) {
                if (course.assignments.get(i).assgnName == assgnName) {
                    //if the assignment is found, add it to the students asignment array
                    this.assignments.add(course.assignments.get(i));
                    found = true;
                }
            }

            //if the assignment has not been found
            if (found == false) {
                System.out.println("Assignment not found. Please check you have the right course or assignment name");
            }
        }
    };

    public static class Person {

        //data members
        String name;
        String uid;


        //empty constructor
        public Person() {

        }

        //2arg constructor
        public Person(String name, String id) {
            this.name = name;
            this.uid = id;
        }


        public String getName() {
            return name;
        }
    };
}
