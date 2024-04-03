package org.acdat.entitiesJPA;

import jakarta.persistence.*;
import org.acdat.negocio.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

@Entity
@Table(name = "clientes", schema = "public", catalog = "HibernatePrueba")
public class ClienteJPA {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cliente_id", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "nombre_cliente", length = 100, nullable = false)
    private String nombreCliente;
    @Basic
    @Column(name = "correo_cliente", length = 100, unique = true)
    private String correoCliente;
    @Basic
    @Column(name = "telefono_cliente", length = 20)
    private String telefonoCliente;

    public ClienteJPA() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public boolean crearCliente(Cliente cliente) {
        boolean respuesta;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            this.nombreCliente = cliente.getNombre();
            this.correoCliente = cliente.getCorreo();
            this.telefonoCliente = cliente.getTelefono();

            session.persist(this);
            session.flush();
            transaction.commit();
            respuesta = true;
        } else {
            respuesta = false;
        }
        return respuesta;
    }

    public ClienteJPA leerCliente(int idCliente) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        ClienteJPA cliente = session.get(ClienteJPA.class, idCliente);

        session.close();
        return cliente;
    }

    public boolean actualizarCliente(ClienteJPA cliente) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            ClienteJPA clienteExistente = session.get(ClienteJPA.class, cliente.getIdCliente());

            if (clienteExistente != null) {
                clienteExistente.setNombreCliente(cliente.getNombreCliente());
                clienteExistente.setCorreoCliente(cliente.getCorreoCliente());
                clienteExistente.setTelefonoCliente(cliente.getTelefonoCliente());

                session.update(clienteExistente);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public boolean borrarCliente(int idCliente) {
        boolean respuesta = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction;

        if (session != null) {
            transaction = session.beginTransaction();

            ClienteJPA cliente = session.get(ClienteJPA.class, idCliente);

            if (cliente != null) {
                session.delete(cliente);
                transaction.commit();
                respuesta = true;
            } else {
                transaction.rollback();
            }
            session.close();
        }
        return respuesta;
    }

    public List<ClienteJPA> mostrarClientes() {
        List<ClienteJPA> clientes = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Query<ClienteJPA> query = session.createQuery("FROM ClienteJPA", ClienteJPA.class);
            clientes = query.list();

            for (ClienteJPA cliente : clientes) {
                System.out.println("ID: " + cliente.getIdCliente());
                System.out.println("Nombre Cliente: " + cliente.getNombreCliente());
                System.out.println("Correo Cliente: " + cliente.getCorreoCliente());
                System.out.println("Teléfono Cliente: " + cliente.getTelefonoCliente());
                System.out.println("------------------------------");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientes;
    }
}
