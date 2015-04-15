/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise04_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppSchool {

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

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            School school = new School("Maharishi University");
            // Create new instance of Object and set values in it
            
            Student st1 = new Student( "Masudur", "Rahman");
            Student st2 = new Student( "Habibur", "Rahman");

            Map<Integer, Student> studentMap = new HashMap<Integer, Student>();

            studentMap.put(st1.getStudentid(), st1);
            studentMap.put(st2.getStudentid(), st2);

            school.setStudents(studentMap);
            
            session.persist(school);
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

        //retrieve book list from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all books
            @SuppressWarnings("unchecked")
            List<School> schoolList = session.createQuery("from School").list();
            for (School school : schoolList) {
                System.out.println("Name= " + school.getName());
            }

            List<Student> stList = session.createQuery("from Student").list();
            for (Student st : stList) {
                System.out.println("Student First Name= " + st.getFirstname() + ", Last Name= "
                        + st.getLastname());
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
