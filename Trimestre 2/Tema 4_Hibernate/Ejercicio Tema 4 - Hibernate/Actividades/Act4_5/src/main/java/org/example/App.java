package org.example;

import org.example.Entity.PersonaJPAEntity;
import org.example.Entity.TelefonoJPAEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class  App
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        if (session != null){

            System.out.println("Se inició la sesion");

            transaction = session.beginTransaction();

            PersonaJPAEntity persona = new PersonaJPAEntity("Alvaro");
            session.persist(persona);
            session.flush();
            TelefonoJPAEntity telefono = new TelefonoJPAEntity("123456789");
            telefono.setPersona(persona);
            session.persist(telefono);
            session.flush();
            transaction.commit();
        } else {
            System.out.println("Error abriendo la sesión");

        }

    }
}
