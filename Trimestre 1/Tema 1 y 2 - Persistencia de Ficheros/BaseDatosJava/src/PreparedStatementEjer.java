import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedStatementEjer {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // Cargar el controlador JDBC
        String url = "jdbc:postgresql://localhost:5432/InstitutoFP"; // Corregir la URL JDBC
        String user = "postgres";
        String password = "alvaro";
        Connection con = DriverManager.getConnection(url, user, password); // Establecer la conexiÃ³n


        PreparedStatement pstmt = con.prepareStatement("INSERT INTO asignaturas (nombre, anyo) VALUES( ?, ?)");
        pstmt.setString(1, "Markup Languages");
        pstmt.setInt(2,1);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }
}

