package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
    }

    @Test
    public void testStudentFieldsOfTranscript(){
        assertEquals(testTranscript.getStudentName(), "Student Name");
        assertEquals(testTranscript.getID(), 1000);
    }

    @Test
    public void testGetCourseAndGrade_NotFound(){
        assertEquals(testTranscript.getCourseAndGrade("Berendei"),"Berendei doesn't exist!");
    }

    @Test
    public void testAddCourseAndGrade_reEntry(){
        testTranscript.addCourseAndGrade("TestCourse",4);
        testTranscript.addCourseAndGrade("TestCourse",3.1);
        assertEquals(testTranscript.getCourseAndGrade("TestCourse"),"TestCourse: 3.1");
        assertEquals(testTranscript.getCourseNames().size(),1);
        assertEquals(testTranscript.getCourseGrades().size(),1);
    }

    @Test
    public void testAddCourseAndGrade_GradeBounds() {
        testTranscript.addCourseAndGrade("TestCourse < 0",-0.1);
        testTranscript.addCourseAndGrade("TestCourse = 0",0);
        testTranscript.addCourseAndGrade("TestCourse = 5",5);
        testTranscript.addCourseAndGrade("TestCourse > 5",5.1);
        assertEquals(testTranscript.getCourseNames().size(),2);
        assertEquals(testTranscript.getCourseGrades().size(),2);
    }

    @Test
    public void testGPA(){
        testTranscript.addCourseAndGrade("Course A",4.44);
        testTranscript.addCourseAndGrade("Course B",4.33);
        testTranscript.addCourseAndGrade("Course C",3.69);
        assertEquals(testTranscript.getGPA(), 12.46/3,0.1);
    }

    @Test
    public void testGetAverageOverSelectedCourses(){
        testTranscript.addCourseAndGrade("Course A",4.44);
        testTranscript.addCourseAndGrade("Course B",4.33);
        testTranscript.addCourseAndGrade("Course C",3.69);
        testTranscript.addCourseAndGrade("Course D",5.0);
        testTranscript.addCourseAndGrade("Course E",3.21);
        ArrayList<String> testList = new ArrayList<>();
        int n = 1;
        for (String CourseName : testTranscript.getCourseNames()) {
            if (n%2!=0) {
                testList.add(CourseName);
            }
            n+=1;
        }
        assertEquals(3, testList.size());
        assertEquals(testTranscript.getAverageOverSelectedCourses(testList),11.34/3,0.01);
    }

    @Test
    public void testTemplate1(){
    }
}
