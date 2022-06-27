package crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.AbstractClass;
import crud.model.Class;
import crud.model.LocationBasedClass;
import crud.model.PaidClass;
import crud.model.PartnershipClass;
import crud.utility.HibernateDataSource;

public class test {

    public static void main(String[] args) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        //session.createQuery("delete from AbstractClass").executeUpdate();   
        
        Class c = new Class();
        c.setTitle("Computer Science 101");
        c.setDescription("General class");
        
        LocationBasedClass lbc = new LocationBasedClass();
        lbc.setTitle("LBC Title");
        lbc.setDescription("LBC Description");
        lbc.setLocation("LBC Location");

        PartnershipClass psc = new PartnershipClass();
        psc.setTitle("PSC Title");
        psc.setDescription("PSC Description");
        psc.setPartner("PSC Partner");

        PaidClass pc = new PaidClass();
        pc.setTitle("PC Title");
        pc.setDescription("PC Description");
        pc.setPrice(9.99);

        //session.save(c);
        //session.save(lbc);
        //session.save(psc);
        //session.save(pc);

        List<AbstractClass> list = session.createQuery("FROM AbstractClass").list();
        List<AbstractClass> list0 = session.createQuery("FROM Class").list();
        List<AbstractClass> list1 = session.createQuery("FROM LocationBasedClass").list();
        List<AbstractClass> list2 = session.createQuery("FROM PartnershipClass").list();
        List<AbstractClass> list3 = session.createQuery("FROM PaidClass").list();

        System.out.println("===========================================");
        list.forEach(System.out::println);
        System.out.println("===========================================");
        list0.forEach(System.out::println);
        System.out.println("===========================================");
        list1.forEach(System.out::println);
        System.out.println("===========================================");
        list2.forEach(System.out::println);
        System.out.println("===========================================");
        list3.forEach(System.out::println);
        
        transaction.commit();
        session.close();
    }

}
