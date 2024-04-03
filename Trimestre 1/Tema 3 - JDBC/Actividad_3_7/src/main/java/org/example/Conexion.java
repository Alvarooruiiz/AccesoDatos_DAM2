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

    public void funcionMostrarNumeroEmpleados(){
        String puesto = EntradaTeclado.pedirCadena("Introduzca el puesto: ");
        try {
            CallableStatement cs = conn.prepareCall("{call listasEmpleados('"+puesto+"')}");
            ResultSet resultSet = cs.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getInt(3) + resultSet.getInt(4));
            }
            cs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void funcionMostrarEmpleadosDepartamento(){
        String departamento = EntradaTeclado.pedirCadena("Introduzca el departamento: ");
        try {
            CallableStatement cs = conn.prepareCall("{call listasEmpleadosDepar('"+departamento+"')}");
            ResultSet resultSet = cs.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getInt(3) + resultSet.getInt(4));
            }
            cs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void funcionMostrarEmpleadosPatronNombre(){
        String departamento = EntradaTeclado.pedirCadena("Introduzca el departamento: ");
        try {
            CallableStatement cs = conn.prepareCall("{call listaPatron('"+departamento+"')}");
            ResultSet resultSet = cs.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getInt(3) + resultSet.getInt(4));
            }
            cs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
