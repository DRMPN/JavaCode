package crud.model;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int classId;

    public Enrollment() {
    }

    public Enrollment(int studentId, int classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Enrollment [classId=" + classId + ", studentId=" + studentId + "]";
    }

}
