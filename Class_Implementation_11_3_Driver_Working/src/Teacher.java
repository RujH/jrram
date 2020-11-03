
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Teacher extends Person{

    //data members
    int numCourses = 0;
    ArrayList<Course> courses;

    //constructors
    public Teacher(String name, String id)
    {
        //call person constructor
        super(name, id);
        courses = new ArrayList<Course>();
    }

    public Teacher(String name, String id, String courseName, double creditHours)
    {
        //call person constructor
        super(name, id);
        courses = new ArrayList<Course>();
        String classID = UUID.randomUUID().toString();
        courses.add(new Course(courseName, classID, creditHours));
    }



    // methods
    // adds a student to the class
    void addStudent(Course course, Student student) {
        course.students.add(student);
        student.classes.add(course);
    }

    // drops a student from the class
    void dropStudent(Course course, Student student) {
        course.students.removeIf(stu -> stu.uid.equals(student.uid));
        student.classes.removeIf(cor -> cor.courseid.equals(course.courseid));
    }

    // sets an assignment for the course
    void setAssignment(Course course, String type, String assignmentName, double weight, String description) {
        //String assignmentID = UUID.randomUUID().toString();
    	String assignmentID= course.courseid;
        course.assignments.add(new Assignment(type, assignmentID, assignmentName, weight, description));
    }

    void assignGrades() {
        for(Course course : courses) {
            for (Student student : course.students) {
                for (Assignment assignment : student.assignments) {
                    if (assignment.hasBeenGraded == true) {
                        continue;
                    }

                    if (assignment.turnedin == false) { // assign a grade of 0 is assignment was not turned in
                        assignment.grade = 0.0;
                    } else {
                        // calculate the grade
                        Random r = new Random();
                        int low = 40;
                        int high = 101;
                        double grade = r.nextInt(high-low) + low; // returns random number between 30 (inclusive) and 101 (exclusive)
                        if (assignment.isLate == true) { // deduct 10 points from grade if assignment is late
                            grade -= 10.0;
                        }
                        assignment.grade = grade;
                    }
                    assignment.hasBeenGraded = true;
                }
            }
        }
    }

    public String toString() {
        String str = "";
        str += "Name: " + name + "\n" + "UID: " + uid + "\n" + "Number of Courses: " + numCourses + "\n";
        str += "Courses: ";
        for(Course c : courses) {
            str += c.name + "   ";
        }
        str += "\n";

        return str;
    }

//end class
}