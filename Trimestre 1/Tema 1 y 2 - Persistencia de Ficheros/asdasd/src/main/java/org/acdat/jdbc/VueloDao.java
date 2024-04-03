package org.acdat.jdbc;

import org.acdat.negocio.Cliente;
import org.acdat.negocio.Vuelo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VueloDao {
    public List<Vuelo> mostrarVuelos(Connection connection) throws SQLException, SQLException {
        List<Vuelo> vueloList = new ArrayList<Vuelo>();
        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            //System.out.println("ID\tNombre\t\tCorreo\t\tTeléfono");
            //System.out.println("--------------------------------------------------------------------------");
            while (resultSet.next()) {
                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("vuelo_id"));
                vuelo.setOrigen(resultSet.getString("origen"));
                vuelo.setDestino(resultSet.getString("destino"));
                vuelo.setFecha_salida(resultSet.getString("fecha_salida"));
                vuelo.setFecha_llegada(resultSet.getString("fecha_llegada"));
                vuelo.setCosto(resultSet.getDouble("costo"));
                vueloList.add(vuelo);
            }
            // System.out.println();
            return vueloList;
        }
    }

    public boolean agregarVuelo(Connection connection, Vuelo vuelo) throws SQLException {
        boolean respuesta = false;
        String pattern = "yyyy-mm-dd";
        SimpleDateFormat formater = new SimpleDateFormat( pattern );
            int res = 0;
            String sql = "INSERT INTO vuelos (origen, destino, fecha_salida, fecha_llegada, costo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, vuelo.getOrigen());
                preparedStatement.setString(2, vuelo.getDestino());
                java.sql.Date fecha = null;
                try {
                    fecha = (Date) formater.parse(vuelo.getFecha_salida());
                } catch(Exception e) {
                    System.out.println("Error occurred"+ e.getMessage());
                }
                preparedStatement.setDate(3, fecha);
                try {
                    fecha = (Date) formater.parse(vuelo.getFecha_salida());
                } catch(Exception e) {
                    System.out.println("Error occurred"+ e.getMessage());
                }
                preparedStatement.setDate(4, fecha);
                preparedStatement.setDouble(5, vuelo.getCosto());
                res = preparedStatement.executeUpdate();
                if (res > 0) respuesta = true;
            }
        return respuesta;
    }

    public boolean actualizarVuelo(Connection connection,  Vuelo vuelo) throws SQLException {
        boolean respuesta = false;
        int res = 0;

        String sql = "UPDATE vuelos SET origen=?, destino=?, fecha_salida=?, fecha_llegada=?, costo=?,  WHERE cliente_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vuelo.getOrigen());
            preparedStatement.setString(2, vuelo.getDestino());
            preparedStatement.setString(3, vuelo.getFecha_salida());
            preparedStatement.setString(4, vuelo.getFecha_llegada());
            preparedStatement.setDouble(5, vuelo.getCosto());
            preparedStatement.setInt (6, vuelo.getId());
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;
        }

        return respuesta;
    }

    public Vuelo cargarVuelo (Connection connection, int id) throws SQLException {

        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos WHERE vuelo_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            //System.out.println("ID\tNombre\t\tCorreo\t\tTeléfono");
            //System.out.println("--------------------------------------------------------------------------");
            while (resultSet.next()) {
                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("vuelo_id"));
                vuelo.setOrigen(resultSet.getString("origen"));
                vuelo.setDestino(resultSet.getString("destino"));
                vuelo.setFecha_salida(resultSet.getString("fecha_salida"));
                vuelo.setFecha_llegada(resultSet.getString("fecha_llegada"));
                vuelo.setCosto(resultSet.getDouble("costo"));
            }

            return vuelo;
        }
    }

    public boolean existeVuelo (Connection connection, int id) throws SQLException {
        boolean respuesta = true;
        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos WHERE vuelo_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()  ) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean eliminarVuelo(Connection connection, int VueloId) throws SQLException {
        boolean respuesta = false;
        int res = 0;

        String sql = "DELETE FROM vuelos WHERE vuelo_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, VueloId);
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;
        }
        return respuesta;
    }

    public boolean consulta(Connection connection){
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.nombre_cliente, v.*\n" +
                "FROM vuelos v\n" +
                "         JOIN clientes_vuelos cv ON v.vuelo_id = cv.vuelo_id\n" +
                "         JOIN clientes c ON cv.cliente_id = c.cliente_id;")) {

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
