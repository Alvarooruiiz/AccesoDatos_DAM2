package org.example.Actividad3_6_2;

import org.example.Actividad3_6_1.Asignatura;

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

    public void introducirCurso(String nuevoNombre){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO public.cursos(nombre) VALUES (?)");
            ps.setString(1,nuevoNombre);


            if(ps.executeUpdate() > 0)
                System.out.println("La asignatura se ha introducido correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearTabla(){
        try{
            PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS public.cursos (codigo SERIAL, nombre VARCHAR(90))");
            if(ps.executeUpdate()==0){
                System.out.println("Tabla creada");
            }else System.out.println("No se ha podido crear la tabla");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
