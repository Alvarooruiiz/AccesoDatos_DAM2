import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver"); // Cargar el controlador JDBC
            String url = "jdbc:postgresql://localhost:5432/InstitutoFP"; // Corregir la URL JDBC
            String user = "postgres";
            String password = "alvaro";
            conn = DriverManager.getConnection(url, user, password); // Establecer la conexión
            System.out.println("Conexión establecida.");

        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el controlador.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
            }
        }
    }
}