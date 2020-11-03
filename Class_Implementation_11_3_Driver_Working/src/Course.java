
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

//    void printassign() {
//        for (Assignment assignment : assignments) {
//            System.out.println(assignment.assgnName);
//        }
//        System.out.println("DONE");
//    }

    public String toString() {
        String str = "";
        str += "Course ID: " + courseid + "\n" + "Course Name: " + name + "\n" + "Credit Hours: " + creditHours + "\n";

        str += "Students: ";
        for(Student student : students) {
            str += student.name + "   ";
        }
        str += "\n";

        return str;
    }
//end class
}
