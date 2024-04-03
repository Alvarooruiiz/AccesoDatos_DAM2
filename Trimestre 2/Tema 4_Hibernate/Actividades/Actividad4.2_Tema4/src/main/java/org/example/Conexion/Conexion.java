package org.example.Conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Conexion {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void beginTransaction(Session session) {
        Transaction transaction = session.beginTransaction();
        session.getTransaction();
    }

    public static void commitTransaction(Session session) {
        if (session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
    }

    public static void rollbackTransaction(Session session) {
        if (session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }
}