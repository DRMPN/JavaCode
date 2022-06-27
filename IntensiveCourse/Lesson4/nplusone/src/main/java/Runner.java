import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Comment;
import model.Topic;

public class Runner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Runner runner = new Runner();

        runner.clearTables();
        runner.createTopics();
        runner.whenEagerThenProblem();
        runner.whenJoinFetchThenNoProblem();

    }

    public void clearTables() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Topic").executeUpdate();
        session.createQuery("delete from Comment").executeUpdate();

        transaction.commit();
        session.close();
    }

    public void createTopics() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 5; i++) {

            Topic topic = new Topic();
            topic.setTitle("topic: " + i);
            session.persist(topic);

            Comment comment = new Comment();
            comment.setText("comment" + i);
            comment.setTopic(topic);
            session.persist(comment);
        }
        transaction.commit();
        session.close();
    }

    public void whenEagerThenProblem() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Query<Comment> query = session.createQuery("select c from Comment c");
        List<Comment> comments = query.getResultList();
        comments.forEach(comment -> System.out.println(comment.getText() + " " + comment.getTopic().getTitle()));
        
        transaction.commit();
        session.close();
    }

    public void whenJoinFetchThenNoProblem() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Comment> query = session.createQuery("select c from Comment c join fetch c.topic t", Comment.class);
        List<Comment> comments = query.getResultList();
        comments.forEach(comment -> System.out.println(comment.getText() + " " + comment.getTopic().getTitle()));
        
        transaction.commit();
        session.close();
    }

}
