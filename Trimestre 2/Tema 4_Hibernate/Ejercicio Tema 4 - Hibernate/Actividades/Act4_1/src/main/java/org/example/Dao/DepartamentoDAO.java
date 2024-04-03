package org.example.Dao;

import org.example.Conexion.Conexion;
import org.example.Entity.DepartamentosEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartamentoDAO {

    public static List<DepartamentosEntity> obtenerDepartamentos() {
        try (Session session = Conexion.openSession()) {
            Query<DepartamentosEntity> query = session.createQuery("from DepartamentosEntity", DepartamentosEntity.class);
            return query.list();
        }
    }

    public static DepartamentosEntity obtenerDepartamentoPorId(int id) {
        try (Session session = Conexion.openSession()) {
            return session.get(DepartamentosEntity.class, id);
        }
    }

    public static void insertarDepartamento(DepartamentosEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.save(departamento);
            Conexion.commitTransaction(session);
        }
    }

    public static void actualizarDepartamento(DepartamentosEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.update(departamento);
            Conexion.commitTransaction(session);
        }
    }

    public static void eliminarDepartamento(DepartamentosEntity departamento) {
        try (Session session = Conexion.openSession()) {
            Conexion.beginTransaction(session);
            session.delete(departamento);
            Conexion.commitTransaction(session);
        }
    }
}