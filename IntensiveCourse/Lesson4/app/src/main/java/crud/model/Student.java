package crud.model;

import java.util.Set;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String program;

    private Set<Class> classes;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, String program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.program = program;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", program=" + program + ", studentId="
                + studentId + "]";
    }

}
