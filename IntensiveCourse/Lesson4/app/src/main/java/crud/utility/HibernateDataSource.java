package crud.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDataSource {

    public static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }

    public static Session getSession() {
        Session session = getSessionFactory().openSession();
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
    
}
