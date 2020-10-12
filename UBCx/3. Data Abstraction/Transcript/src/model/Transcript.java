package model;

import java.util.ArrayList;

public class Transcript {
    /**
     * INVARIANT: course list and grade list are the same size
     * each course has a grade associated, and vice versa, at matching indices
     */

    private final String StudentName;
    private final int ID;
    private final ArrayList<String> CourseNames;
    private final ArrayList<Double> CourseGrades;

    public Transcript(String fn, int id) {
        StudentName = fn;
        ID = id;
        CourseNames = new ArrayList<>();
        CourseGrades = new ArrayList<>();
    }

    // GETTERS

    // TODO: Decide what getters should return i.e object or copy of it.
    public String getStudentName() {
        return StudentName;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<String> getCourseNames() {
        return CourseNames;
    }

    public ArrayList<Double> getCourseGrades() {
        return CourseGrades;
    }

    public boolean isCourseNameExists(String CourseName) {
        return CourseNames.contains(CourseName);
    }

    // METHODS

    //REQUIRES 0 <= grade <= 5
    //MODIFIES CourseNames and CourseGrades
    //EFFECTS  adds new grade to an existing course
    //          or creates new course with grade
    public void addCourseAndGrade(String course, double grade) {
        if (0 > grade | grade > 5) {
            System.out.println("Grade must be in bound between 0 and 5.");
        }
        else {
            int courseIndex = CourseNames.indexOf(course);

            if (isCourseNameExists(course)) {
                CourseGrades.set(courseIndex, grade);
            } else {
                CourseNames.add(course);
                CourseGrades.add(grade);
            }
        }
    }

    //EFFECTS  returns name and grade of existing course
    //          otherwise returns error string
    public String getCourseAndGrade(String course){
      if (isCourseNameExists(course)) {
          double grade = getGradeByCourse(course);
          return course+": "+grade;
      }
      else {
          return course+" doesn't exist!";
      }
    }

    //EFFECTS  prints full transcript
    public void printTranscript(){
        for (String Cname : CourseNames)
        {
            double Cgrade = getGradeByCourse(Cname);
            System.out.print(Cname+": "+Cgrade+", ");
        }
        System.out.println();
    }

    //EFFECTS  returns grand point average of this student transcript
    public double getGPA(){
        return calculateAverage(CourseGrades);
    }

    //REQUIRES existing course
    //EFFECTS  returns gpa of selected courses
    public double getAverageOverSelectedCourses(ArrayList<String> selectedCourses){
        ArrayList<Double> listOfGradesOfSelectedCourses = new ArrayList<>();
        for (String singleCourse : selectedCourses) {
            double courseGrade = getGradeByCourse(singleCourse);
            listOfGradesOfSelectedCourses.add(courseGrade);
        }
        return calculateAverage(listOfGradesOfSelectedCourses);
    }

    //EFFECTS  returns grand point average from any list of grades
    private double calculateAverage(ArrayList<Double> selectedGrades){
        double gpa = 0.0;
        int n = 0;
        for (double grade : selectedGrades)
        {
            gpa += grade;
            n += 1;
        }
        return gpa/n;
    }

    //REQUIRES existing course
    //EFFECTS  returns grade of the course
    private double getGradeByCourse(String course){
        int pos = CourseNames.indexOf(course);
        return CourseGrades.get(pos);
    }

}
