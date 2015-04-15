/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise04_1;

import java.util.ArrayList;
import java.util.Date;
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

public class AppPassenger {

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
            Flight flight1 = new Flight("FL001", new Date(), new Date(), new Date());
            Flight flight2 = new Flight("FL002", new Date(), new Date(), new Date());

            List<Flight> flights = new ArrayList<Flight>();

            flights.add(flight1);
            flights.add(flight2);

            Passenger passenger = new Passenger("Masudur Rahman");
            passenger.setFlights(flights);

            session.persist(passenger);
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
            List<Passenger> passList = session.createQuery("from Passenger").list();
            for (Passenger pass : passList) {
                System.out.println("Name= " + pass.getName());
            }

            List<Flight> flList = session.createQuery("from Flight").list();
            for (Flight fl : flList) {
                System.out.println("No= " + fl.getFlightnumber() + ", from= "
                        + fl.getFrom() + " To= " + fl.getTo() + ", date= "
                        + fl.getDate());
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
