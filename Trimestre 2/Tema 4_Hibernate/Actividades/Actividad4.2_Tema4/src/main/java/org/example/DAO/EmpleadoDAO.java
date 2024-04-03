package org.example.DAO;

import org.example.Conexion.Conexion;
import org.example.Entity.EmpleadosJPAEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmpleadoDAO {

    public static List<EmpleadosJPAEntity> obtenerEmpleados() {
        try (Session session = Conexion.openSession()) {
            Query<EmpleadosJPAEntity> query = session.createQuery("from EmpleadosJPAEntity", EmpleadosJPAEntity.class);
            return query.list();
        }
    }

    public static EmpleadosJPAEntity obtenerEmpleadoPorId(int id) {
        try (Session session = Conexion.openSession()) {
            return session.get(EmpleadosJPAEntity.class, id);
        }
    }

    public static void actualizarEmpleado(EmpleadosJPAEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.update(empleado);
            Conexion.commitTransaction(session);
        }
    }

    public static void eliminarEmpleado(EmpleadosJPAEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.delete(empleado);
            Conexion.commitTransaction(session);
        }
    }

    public static void insertarEmpleado(EmpleadosJPAEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.save(empleado);
            Conexion.commitTransaction(session);
        }
    }
}