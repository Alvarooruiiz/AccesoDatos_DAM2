package org.acdat.entitiesJPA;

import org.acdat.negocio.Vuelo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelos")
public class VueloJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuelo_id")
    private int idVuelo;

    @Column(name = "origen", length = 50)
    private String origen;

    @Column(name = "destino", length = 50)
    private String destino;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "fecha_llegada")
    private LocalDate fechaLlegada;

    @Column(name = "costo", precision = 10, scale = 2)
    private double costo;

    public VueloJPA() {
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean crearVuelo(Vuelo vuelo) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            this.origen = vuelo.getOrigen();
            this.destino = vuelo.getDestino();
            this.fechaSalida = vuelo.getFechaSalida();
            this.fechaLlegada = vuelo.getFechaLlegada();
            this.costo = vuelo.getCosto();

            session.persist(this);
            transaction.commit();
            respuesta = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return respuesta;
    }

    public List<VueloJPA> mostrarVuelos() {
        List<VueloJPA> vuelos = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Query<VueloJPA> query = session.createQuery("FROM VueloJPA", VueloJPA.class);
            vuelos = query.list();

            for (VueloJPA vuelo : vuelos) {
                System.out.println("ID Vuelo: " + vuelo.getIdVuelo());
                System.out.println("Origen: " + vuelo.getOrigen());
                System.out.println("Destino: " + vuelo.getDestino());
                System.out.println("Fecha de Salida: " + vuelo.getFechaSalida());
                System.out.println("Fecha de Llegada: " + vuelo.getFechaLlegada());
                System.out.println("Costo: " + vuelo.getCosto());
                System.out.println("------------------------------");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vuelos;
    }


    public VueloJPA leerVuelo(int idVuelo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        VueloJPA vuelo = session.get(VueloJPA.class, idVuelo);

        session.close();
        return vuelo;
    }

    public boolean actualizarVuelo(VueloJPA vuelo) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.update(vuelo);
            transaction.commit();
            respuesta = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return respuesta;
    }

    public boolean borrarVuelo(int idVuelo) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            VueloJPA vuelo = session.get(VueloJPA.class, idVuelo);
            session.delete(vuelo);

            transaction.commit();
            respuesta = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return respuesta;
    }
}
