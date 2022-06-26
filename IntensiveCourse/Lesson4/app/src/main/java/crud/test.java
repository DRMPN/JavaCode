package crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.LocationBasedClass;
import crud.model.PaidClass;
import crud.model.PartnershipClass;
import crud.utility.HibernateDataSource;

public class test {

    public static void main(String[] args) {
        Session session = HibernateDataSource.getSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from AbstractClass").executeUpdate();

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

        session.save(lbc);
        session.save(psc);
        session.save(pc);
        
        transaction.commit();
        session.close();
    }

}
