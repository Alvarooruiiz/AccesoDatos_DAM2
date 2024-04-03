package org.example.Actividad3_6_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    private String usuario;
    private String passw;
    private String url;
    private Connection conn = null;



    public Conexion(String usuario, String passw, String url) {
        this.usuario = usuario;
        this.passw = passw;
        this.url = url;
    }

    public boolean probarConexion(){
        try {
            Class.forName("org.postgresql.Driver"); // Cargar el controlador JDBC
            conn = DriverManager.getConnection(url, usuario, passw); // Establecer la conexión
            System.out.println("Conexión establecida.");
            return true;

        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el controlador.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
        }
        return false;
    }

    public void introducirAsignatura(Asignatura asignatura){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO public.asignaturas(codigo, nombre, anyo, horas) VALUES (?, ?, ?, ?)");
            ps.setInt(1,6);
            ps.setString(2,asignatura.getNombre());
            ps.setInt(3,asignatura.getAnyo());
            ps.setInt(4,asignatura.getHoras());
            if(ps.executeUpdate() > 0)
                System.out.println("La asignatura se ha introducido correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
