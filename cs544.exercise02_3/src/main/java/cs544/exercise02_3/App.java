package cs544.exercise02_3;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Students
 *
 */
public class App{

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        //retrieve students list from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all books
            @SuppressWarnings("unchecked")
            List<Students> studentList = session.createQuery("from Students").list();
            for (Students student : studentList) {
                System.out.println("Name= " + student.getName() + ", Email= "
                        + student.getEmail()+ ", password= " + student.getPassword());
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        
        
        
         try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Create new instance of Book and set values in it
            Students student = new Students();
            
            student.setName("Masudur Rahman");
            student.setEmail("masdudjbd@gmail.com");
            student.setPassword("MUM@123");
            // save the student
            session.persist(student);

          
             tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
         
          //retrieve students list from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all books
            @SuppressWarnings("unchecked")
            List<Students> studentList = session.createQuery("from Students").list();
            for (Students student : studentList) {
                System.out.println("Name= " + student.getName() + ", Email= "
                        + student.getEmail()+ ", password= " + student.getPassword());
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        
    }
}
