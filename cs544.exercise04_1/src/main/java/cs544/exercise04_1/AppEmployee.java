/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise04_1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppEmployee {

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

            // Create new instance of Object and set values in it
            Laptop laptop1 = new Laptop("Sonny", "VAIO");
            Laptop laptop2 = new Laptop("Dell", "INSPIRON");

           Set<Laptop> laptops = new HashSet<Laptop>();
 
            laptops.add(laptop1);
            laptops.add(laptop2);
            
            Employee employee = new Employee("Fahim", "Muntasir");
            laptop1.setEmployee(employee);
            laptop2.setEmployee(employee);
            employee.setLaptop(laptops);
            session.persist(employee);
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
            List<Employee> employeeList = session.createQuery("from Employee").list();
            for (Employee empployee : employeeList) {
                System.out.println("FirstName= " + empployee.getFirstname() + ", lastName= "
                        + empployee.getLastname());
            }
            
             List<Laptop> laptopList = session.createQuery("from Laptop").list();
            for (Laptop laptop : laptopList) {
                System.out.println("Brand= " + laptop.getBrand()+ ", Type= "
                        + laptop.getType());
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
