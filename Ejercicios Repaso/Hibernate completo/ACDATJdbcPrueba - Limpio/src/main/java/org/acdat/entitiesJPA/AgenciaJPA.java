package org.acdat.entitiesJPA;

import jakarta.persistence.*;
import org.acdat.negocio.Agencia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

@Entity
@Table(name = "agencias", schema = "public", catalog = "HibernatePrueba")
public class AgenciaJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "agencia_id", nullable = false)
    private int idAgencia;
    @Basic
    @Column(name = "nombre_agencia", length = 100, nullable = false)
    private String nombreAgencia;
    @Basic
    @Column(name = "direccion_agencia")
    private String direccionAgencia;
    @Basic
    @Column(name = "telefono_agencia", length = 20)
    private String telefonoAgencia;

    public AgenciaJPA() {
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getDireccionAgencia() {
        return direccionAgencia;
    }

    public void setDireccionAgencia(String direccionAgencia) {
        this.direccionAgencia = direccionAgencia;
    }

    public String getTelefonoAgencia() {
        return telefonoAgencia;
    }

    public void setTelefonoAgencia(String telefonoAgencia) {
        this.telefonoAgencia = telefonoAgencia;
    }

    public boolean crearAgencia(Agencia agencia) {
        boolean respuesta;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            this.nombreAgencia = agencia.getNombre();
            this.direccionAgencia = agencia.getDireccion();
            this.telefonoAgencia = agencia.getTelefono();

            session.persist(this);
            session.flush();
            transaction.commit();
            respuesta = true;
        } else {
            respuesta = false;
        }
        return respuesta;
    }

    public AgenciaJPA leerAgencia(int idAgencia) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        AgenciaJPA agencia = session.get(AgenciaJPA.class, idAgencia);

        session.close();
        return agencia;
    }

    public boolean actualizarAgencia(AgenciaJPA agencia) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            AgenciaJPA agenciaExistente = session.get(AgenciaJPA.class, agencia.getIdAgencia());

            if (agenciaExistente != null) {
                agenciaExistente.setNombreAgencia(agencia.getNombreAgencia());
                agenciaExistente.setDireccionAgencia(agencia.getDireccionAgencia());
                agenciaExistente.setTelefonoAgencia(agencia.getTelefonoAgencia());

                session.update(agenciaExistente);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public boolean borrarAgencia(int idAgencia) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            AgenciaJPA agencia = session.get(AgenciaJPA.class, idAgencia);

            if (agencia != null) {
                session.delete(agencia);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public List<AgenciaJPA> mostrarAgencias() {
        List<AgenciaJPA> agencias = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Query<AgenciaJPA> query = session.createQuery("FROM AgenciaJPA", AgenciaJPA.class);
            agencias = query.list();

            for (AgenciaJPA agencia : agencias) {
                System.out.println("ID: " + agencia.getIdAgencia());
                System.out.println("Nombre Agencia: " + agencia.getNombreAgencia());
                System.out.println("Dirección Agencia: " + agencia.getDireccionAgencia());
                System.out.println("Teléfono Agencia: " + agencia.getTelefonoAgencia());
                System.out.println("------------------------------");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return agencias;
    }
}
