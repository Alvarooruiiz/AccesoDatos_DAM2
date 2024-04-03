package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            abrirSesion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Session abrirSesion() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        if (session == null){
            throw new Exception("Error abriendo la sesión");
        } else {
            System.out.println("Conectado");
        }
        return session;
    }
}

