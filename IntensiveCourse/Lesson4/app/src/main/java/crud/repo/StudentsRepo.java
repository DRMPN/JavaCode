package crud.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.Student;
import crud.utility.HibernateDataSource;

// TODO: add SET methods
public class StudentsRepo {

    public static Student findStudentById(int studentId) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        Student student = (Student) session.get(Student.class, studentId);
        
        transaction.commit();
        session.close();

        return student;
       }

    public static int addStudent(Student student) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();
        
        int studentId = (int) session.save(student);

        transaction.commit();
        session.close();

        return studentId;
    }

    public static void updateStudent(Student student) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
    }

    public static List<Student> listStudents() {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createQuery("FROM Student").list();

        transaction.commit();
        session.close();

        return list;
    }

    public static void deleteStudent(int studentId) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        Student student = (Student) session.get(Student.class, studentId);
        session.delete(student);

        transaction.commit();
        session.close();
    }
    
}
