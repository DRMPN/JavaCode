package crud.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.Class;
import crud.utility.HibernateDataSource;

// TODO: add SET methods
// TODO: add abstract classes
public class ClassesRepo {

    public static Class findClassById(int classId) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        Class clazz = (Class) session.get(Class.class, classId);
        
        transaction.commit();
        session.close();

        return clazz;
       }

    public static int addClass(Class clazz) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();
        
        int classId = (int) session.save(clazz);

        transaction.commit();
        session.close();

        return classId;
    }

    public static void updateClass(Class clazz) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(clazz);

        transaction.commit();
        session.close();
    }

    public static List<Class> listClasses() {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        List<Class> list = session.createQuery("FROM Class").list();

        transaction.commit();
        session.close();

        return list;
    }

    public static void deleteClass(int classId) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        Class clazz = (Class) session.get(Class.class, classId);
        session.delete(clazz);

        transaction.commit();
        session.close();
    }
    
}

