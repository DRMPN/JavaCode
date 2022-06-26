package crud.model;

import java.util.Set;

public class Class extends AbstractClass{
    
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class [students=" + students + "]";
    }

}
