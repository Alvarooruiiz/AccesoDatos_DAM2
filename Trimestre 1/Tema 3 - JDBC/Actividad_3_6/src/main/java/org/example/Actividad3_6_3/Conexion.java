package org.example.Actividad3_6_3;

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

    public void modificarTabla(){
        try {
            PreparedStatement ps = conn.prepareStatement("ALTER TABLE public.asignaturas ADD COLUMN curso INTEGER, ADD CONSTRAINT fk_curso FOREIGN KEY (curso) " +
                    "REFERENCES public.cursos (codigo)");

            if (ps.executeUpdate() == 0) {
                System.out.println("Se ha realizado el cambio correctamente");
            } else {
                System.out.println("Error");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
