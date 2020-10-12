package ui;

import model.Transcript;

public class Main {

    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);

        t1.addCourseAndGrade("CPSC-210", 3.5);
        t1.addCourseAndGrade("ENGL-201", 4.0);
        t1.addCourseAndGrade("CPSC-110", 3.1);

        t2.addCourseAndGrade("CPSC-210", 4.5);
        t2.addCourseAndGrade("ENGL-201", 5.0);
        t2.addCourseAndGrade("CPSC-110", 4.6);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();
        System.out.println("GPA: "+t1.getGPA());

        System.out.print(t2.getStudentName() + ": ");
        t2.printTranscript();
        System.out.println("GPA: "+t2.getGPA());
    }
}
