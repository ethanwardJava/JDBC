package com.arcade;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        PersonEntity person = new PersonEntity("Sam", 35);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(PersonEntity.class);
        configuration.configure("Hibernate.cfg.xml");

        // Build SessionFactory
        try (SessionFactory factory = configuration.buildSessionFactory()) {
            // Open session
            Session session = factory.openSession();
            // Begin transaction
            Transaction tx = session.beginTransaction();

            // Persist entity
            session.persist(person);

            // Commit transaction
            tx.commit();

            PersonEntity value = session.find(PersonEntity.class, 1);
            System.out.println(value);
            // Close session
            session.close();
        }
    }
}
