package org.example.DAO;

import org.example.Conexion.Conexion;
import org.example.Entity.DepartamentosJPAEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartamentoDAO {

    public static List<DepartamentosJPAEntity> obtenerDepartamentos() {
        try (Session session = Conexion.openSession()) {
            Query<DepartamentosJPAEntity> query = session.createQuery("from DepartamentosJPAEntity", DepartamentosJPAEntity.class);
            return query.list();
        }
    }

    public static DepartamentosJPAEntity obtenerDepartamentoPorId(int id) {
        try (Session session = Conexion.openSession()) {
            return session.get(DepartamentosJPAEntity.class, id);
        }
    }

    public static void insertarDepartamento(DepartamentosJPAEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.save(departamento);
            Conexion.commitTransaction(session);
        }
    }

    public static void actualizarDepartamento(DepartamentosJPAEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.update(departamento);
            Conexion.commitTransaction(session);
        }
    }

    public static void eliminarDepartamento(DepartamentosJPAEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.delete(departamento);
            Conexion.commitTransaction(session);
        }
    }
}