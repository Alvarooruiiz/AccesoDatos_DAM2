package org.example.Dao;

import org.example.Conexion.Conexion;
import org.example.Entity.EmpleadosEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmpleadoDAO {

    public static List<EmpleadosEntity> obtenerEmpleados() {
        try (Session session = Conexion.openSession()) {
            Query<EmpleadosEntity> query = session.createQuery("from EmpleadosEntity", EmpleadosEntity.class);
            return query.list();
        }
    }

    public static EmpleadosEntity obtenerEmpleadoPorId(int id) {
        try (Session session = Conexion.openSession()) {
            return session.get(EmpleadosEntity.class, id);
        }
    }

    public static void actualizarEmpleado(EmpleadosEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.update(empleado);
            Conexion.commitTransaction(session);
        }
    }

    public static void eliminarEmpleado(EmpleadosEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.delete(empleado);
            Conexion.commitTransaction(session);
        }
    }

    public static void insertarEmpleado(EmpleadosEntity empleado) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.save(empleado);
            Conexion.commitTransaction(session);
        }
    }
}