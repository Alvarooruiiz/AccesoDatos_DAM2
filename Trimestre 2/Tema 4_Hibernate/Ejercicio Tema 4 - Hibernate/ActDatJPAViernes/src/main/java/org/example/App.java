package org.example;

import org.example.entity.ConcesionarioJPAEntity;
import org.example.entity.VehiculoJPAEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {


        System.out.println( "Hello World!" );

        Transaction transaction;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if (session != null){
            System.out.println("Se inició la sesion");

            transaction = session.beginTransaction();
            ConcesionarioJPAEntity concesionario = new ConcesionarioJPAEntity("Concesionario Alvaro", "Empresa Alvaro", "Calle Tomas", 10, "alvaro@concesionaria.com");


            VehiculoJPAEntity vehiculo1 = new VehiculoJPAEntity("Toyota", "Corolla", "Rojo", "ABC123", new Date(23), 10000);
            VehiculoJPAEntity vehiculo2 = new VehiculoJPAEntity("Honda", "Civic", "Azul", "DEF456", new Date(23), 20000);
            VehiculoJPAEntity vehiculo3 = new VehiculoJPAEntity("Ford", "Fiesta", "Verde", "GHI789", new Date(23), 30000);

            concesionario.addVehiculo(vehiculo1);
            concesionario.addVehiculo(vehiculo2);
            concesionario.addVehiculo(vehiculo3);

            session.flush();

            transaction.commit();

        } else {
            System.out.println("Error abriendo la sesión");
        }
    }
}
