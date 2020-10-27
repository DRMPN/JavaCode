package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        this.name = studentName;
        this.year = academicYear;
        this.id = studentID;
        this.gpa = 0.0;
        this.currentCourses = new ArrayList<>();
        this.pastCourses = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAcademicYear() {
        return year;
    }
    public int getId() {
        return id;
    }
    public List<Course> getCurrentCourses() {
        return currentCourses;
    }
    public List<Course> getPastCourses() {
        return pastCourses;
    }

    // EFFECTS: computes cGPA
    //          if the list of past courses is empty, throws NoCoursesTakenException
    public double computeGPA() throws NoCoursesTakenException {
        if (pastCourses.isEmpty()) {throw new NoCoursesTakenException();}
        int totalSum = 0;
        for (Course c : pastCourses) {
            totalSum+=c.getGrade();
        }
        double average = totalSum/pastCourses.size();
        return (average/20) - 1;
    }

    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if GPA is over 2.6 on a 4.0 scale, and return true
    //          else return false with no change to the year field
    //          if GPA is not over 2.6 on a 4.0 scale, throws GPATooLowException
    //          if no courses have been taken, throws NoCoursesTakenException
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        if (this.computeGPA() <= 2.6) {throw new GPATooLowException();}
        this.year++;
        return true;
    }


    // MODIFIES: this
    // EFFECTS: adds the given course to the list of past courses and returns true,
    //          unless pastCourses contains given course, then does not add and returns false
    public boolean addToPastCourses(Course c) {
        if (pastCourses.contains(c)) {return false;}
        else {pastCourses.add(c); return true;}
    }

    // MODIFIES: this
    // EFFECTS: adds a course (c) into the record
    //          if the transcript is missing prerequisites, throws a MissingPrereqException
    //          if the course has no space for more students to register, throws a CourseFullException
    public void addCourse(Course course) throws MissingPrereqException, CourseFullException {
        if (pastCourses.isEmpty() && !course.getPrereq().isEmpty()) {throw new MissingPrereqException();}
        else if (course.isCourseFull()) {throw new CourseFullException();}
        else if (course.getPrereq().isEmpty()) {currentCourses.add(course); course.addStudent();}
        else {
            for (Course c : course.getPrereq()) {
                if (!pastCourses.contains(c)) {throw new MissingPrereqException();}
            }
            currentCourses.add(course);
            course.addStudent();
        }
    }


}
