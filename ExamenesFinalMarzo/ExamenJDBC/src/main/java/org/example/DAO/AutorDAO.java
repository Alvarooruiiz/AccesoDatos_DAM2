package org.example.DAO;

import org.example.Negocio.Autor;
import org.example.JDBC.miJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO extends miJDBC {
    public List<Autor> buscarAutores() {
        List<Autor> autores = new ArrayList<>();
        try {
            abrirConexion();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Autores");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Autor autor = new Autor();
                autor.setId(resultSet.getInt("id_autor"));
                autor.setNombre(resultSet.getString("nombre_autor"));
                autor.setPais(resultSet.getString("pais"));
                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return autores;
    }

    public Autor buscarAutorPorId(int id) {
        Autor autor = null;
        try {
            abrirConexion();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Autores WHERE id_autor = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                autor = new Autor();
                autor.setId(resultSet.getInt("id_autor"));
                autor.setNombre(resultSet.getString("nombre_autor"));
                autor.setPais(resultSet.getString("pais"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return autor;
    }

    public void guardarAutor(String nombreAutor, String pais) {
        try {
            abrirConexion();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Autores (nombre_autor, pais) VALUES (?, ?)");
            statement.setString(1, nombreAutor);
            statement.setString(2, pais);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void borrarAutor(int id) {
        try {
            abrirConexion();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Autores WHERE id_autor = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void actualizarAutor(Autor autor) {
        try {
            abrirConexion();
            PreparedStatement statement = connection.prepareStatement("UPDATE Autores SET nombre_autor = ?, pais = ? WHERE id_autor = ?");
            statement.setString(1, autor.getNombre());
            statement.setString(2, autor.getPais());
            statement.setInt(3, autor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
}
