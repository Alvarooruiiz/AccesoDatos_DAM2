package org.example;

import java.sql.*;

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

    public void consulta_Actividad3_4_1(String query) {
        try(Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(query) ){

            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+ "\t" + resultSet.getString(2)
                        + "\t" + resultSet.getString(3));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarNuevoTema_Actividad3_4_2(String query){
        try(Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query)){
            System.out.println("Valores actualizados");


            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+ "\t" + resultSet.getString(2)
                        + "\t" + resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modificarTabla_Actividad3_4_3(String query){
        try(Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query)){
            st.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
