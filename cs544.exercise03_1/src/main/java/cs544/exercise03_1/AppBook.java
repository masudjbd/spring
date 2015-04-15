/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise03_1;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {

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

            // Create new instance of Book and set values in it
            Book book1 = new Book("Spring in Action", "8574524578451", "Rob Jhonshon", 54.21, new Date());
            // save the book1
            session.persist(book1);

            // Create new instance of Book2 and set values in it
            Book book2 = new Book("Expert in Spring", "3434524578451", "Habibur Rahman", 74.21, new Date());
            // save the book1
            session.persist(book2);

            // Create new instance of Book3 and set values in it
            Book book3 = new Book("Spring in Spring", "533524578451", "Amit Jhonshon", 44.21, new Date());
            // save the book1
            session.persist(book3);
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
            List<Book> bookList = session.createQuery("from Book").list();
            for (Book book : bookList) {
                System.out.println("name= " + book.getTitle() + ", ISBN= "
                        + book.getISBN() + ", author= " + book.getAuthor());
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

        //retrieve one book list from db
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all books
            @SuppressWarnings("unchecked")

            Book book = (Book) session.get(Book.class, 1);

            System.out.println("name= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", author= " + book.getAuthor());

            //set new author name for book id 1
            book.setAuthor("Masudur Rahman");

            //update new book attribute
            session.update(book);

            
            //retrive one book again and will delete
            Book bookInstance = (Book) session.load(Book.class, 3);

            //remove data from database
            session.delete(bookInstance);

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
            List<Book> bookList = session.createQuery("from Book").list();
            for (Book book : bookList) {
                System.out.println("name= " + book.getTitle() + ", ISBN= "
                        + book.getISBN() + ", author= " + book.getAuthor());
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
        
        
        
        
        
        
        
        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }

    
}
