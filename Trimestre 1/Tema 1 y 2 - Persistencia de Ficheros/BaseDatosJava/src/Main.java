import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("org.postgresql.Driver"); // Cargar el controlador JDBC
        String url = "jdbc:postgresql://localhost:5432/InstitutoFP"; // Corregir la URL JDBC
        String user = "postgres";
        String password = "alvaro";
        Connection con = DriverManager.getConnection(url, user, password); // Establecer la conexiÃ³n
        Statement statement = con.createStatement();
        String SQLsentence = "SELECT * FROM asignaturas ORDER BY codigo";
        ResultSet rs = statement.executeQuery(SQLsentence);
        System.out.println("Codigo" + "\t" + "Nombre");
        System.out.println("-----------------");

        while (rs.next()){
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));

        }
        rs.close();
        con.close();

    }
}