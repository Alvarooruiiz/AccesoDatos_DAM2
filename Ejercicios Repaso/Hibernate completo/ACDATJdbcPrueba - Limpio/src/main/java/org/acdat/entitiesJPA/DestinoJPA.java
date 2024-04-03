package org.acdat.entitiesJPA;

import jakarta.persistence.*;
import org.acdat.negocio.Destino;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

@Entity
@Table(name = "destinos", schema = "public", catalog = "HibernatePrueba")
public class DestinoJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "destino_id", nullable = false)
    private int idDestino;
    @Basic
    @Column(name = "nombre_destino", length = 100, nullable = false)
    private String nombreDestino;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "costo_estadia")
    private double costoEstadia;

    public DestinoJPA() {
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoEstadia() {
        return costoEstadia;
    }

    public void setCostoEstadia(double costoEstadia) {
        this.costoEstadia = costoEstadia;
    }

    public boolean crearDestino(Destino destino) {
        boolean respuesta;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            this.nombreDestino = destino.getDestino();
            this.descripcion = destino.getDescripcion();
            this.costoEstadia = destino.getCoste();

            session.persist(this);
            session.flush();
            transaction.commit();
            respuesta = true;
        } else {
            respuesta = false;
        }
        return respuesta;
    }

    public DestinoJPA leerDestino(int idDestino) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        DestinoJPA destino = session.get(DestinoJPA.class, idDestino);

        session.close();
        return destino;
    }

    public boolean actualizarDestino(DestinoJPA destino) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            DestinoJPA destinoExistente = session.get(DestinoJPA.class, destino.getIdDestino());

            if (destinoExistente != null) {
                destinoExistente.setNombreDestino(destino.getNombreDestino());
                destinoExistente.setDescripcion(destino.getDescripcion());
                destinoExistente.setCostoEstadia(destino.getCostoEstadia());

                session.update(destinoExistente);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public boolean borrarDestino(int idDestino) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            DestinoJPA destino = session.get(DestinoJPA.class, idDestino);

            if (destino != null) {
                session.delete(destino);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public List<DestinoJPA> mostrarDestinos() {
        List<DestinoJPA> destinos = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Query<DestinoJPA> query = session.createQuery("FROM DestinoJPA", DestinoJPA.class);
            destinos = query.list();

            for (DestinoJPA destino : destinos) {
                System.out.println("ID: " + destino.getIdDestino());
                System.out.println("Nombre Destino: " + destino.getNombreDestino());
                System.out.println("Descripción: " + destino.getDescripcion());
                System.out.println("Costo de Estadía: " + destino.getCostoEstadia());
                System.out.println("------------------------------");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return destinos;
    }
}
