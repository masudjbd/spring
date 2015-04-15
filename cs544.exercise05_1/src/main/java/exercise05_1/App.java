/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

    private static final ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;

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

            //List<Order> orders=new ArrayList();
            Customer customer1 = new Customer("Masudur", "Rahman");
            Customer customer2 = new Customer("Fahim", "Muntasir");

            Order order1 = new Order(new Date("1/2/2015"));
            Order order2 = new Order(new Date("2/2/2015"));
            Order order3 = new Order(new Date("3/2/2015"));
            Order order4 = new Order(new Date("4/2/2015"));

            OrderLine orderline1 = new OrderLine(11);
            OrderLine orderline2 = new OrderLine(12);
            OrderLine orderline3 = new OrderLine(13);
            OrderLine orderline4 = new OrderLine(14);
            OrderLine orderline5 = new OrderLine(15);

            Product product1 = new Product("Laptop", "HP 430") {
            };
            Product product2 = new Product("Pen", "Fountain Pen") {
            };
            Product product3 = new Product("Chair", "delux Chair") {
            };
            Product product4 = new Product("Book", "Spring MVC") {
            };

            Product cd1 = new CD("Andrew Kishor", "Singerr");
            Product dvd1 = new DVD("Horror DVD");

            //Product  book1=new Book("Science Fiction Book");
            Product cd2 = new CD("Kumar Shanu", "Singer2");
            Product dvd2 = new DVD("Sci-Fie DVD");
            Product book2 = new Book("Literature book");

//        orderline1.setProduct(product1);
//        orderline2.setProduct(product1);
//        orderline3.setProduct(product2);
//        orderline4.setProduct(product4);
//        orderline5.setProduct(product3);
            orderline1.setProduct(cd1);
            orderline2.setProduct(cd1);
            orderline3.setProduct(dvd1);
            orderline4.setProduct(book2);
            //orderline5.setProduct(dvd2);
            orderline5.setProduct(cd2);

            order1.addOrderLine(orderline1);
            order1.addOrderLine(orderline2);

            order2.addOrderLine(orderline3);
            order3.addOrderLine(orderline4);
            order4.addOrderLine(orderline5);

            customer1.addOrders(order1);
            customer1.addOrders(order3);

            customer2.addOrders(order2);
            customer2.addOrders(order4);

            session.persist(customer1);
            session.persist(customer2);
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
