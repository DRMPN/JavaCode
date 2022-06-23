package cglibproxy;

public class test {

    public static void main(String[] args) {
        Student student = (Student) new CglibProxy().getInstance(Student.class);
        System.out.println("Class of proxy: " + student.getClass());
        student.findHouse();
    }
    
}
