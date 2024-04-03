import java.sql.*;

public class CRUD {
    private String usuario;
    private String passw;
    private String url;
    private Connection conn = null;

    public CRUD(String usuario, String passw, String url ) {
        this.usuario = usuario;
        this.passw = passw;
        this.url = url;

    }

    public boolean probarConexion() {
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

    public int insertUsuario(String nombre, int edad) {
        String query = "INSERT INTO usuarios (nombre,edad) VALUES (?, ?) RETURNING id_usuario";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, edad);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return -1;//No se ha podido introducir
    }

    public int insertDireccion(int idUsuario, String calle, String ciudad) {
        String query = "INSERT INTO direcciones (id_usuario, calle, ciudad) VALUES (?, ?, ?) RETURNING id_direccion";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setString(2, calle);
            preparedStatement.setString(3, ciudad);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return -1;
    }

    public void insertPedido(int idUsuario, String fechaPedido, double monto) {
        String query = "INSERT INTO pedidos (id_usuario, fecha_pedido, monto) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setDate(2, Date.valueOf(fechaPedido));
            preparedStatement.setDouble(3, monto);
            preparedStatement.executeUpdate();
            System.out.println("Pedido creado con éxito.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



    public void selectUsuariosConDirecciones() {
        String query = "SELECT u.id_usuario, u.nombre, u.edad, d.id_direccion, d.calle, d.ciudad " +
                "FROM usuarios u INNER JOIN direcciones d ON u.id_usuario = d.id_usuario";
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                int idDireccion = resultSet.getInt("id_direccion");
                String calle = resultSet.getString("calle");
                String ciudad = resultSet.getString("ciudad");
                System.out.println("ID Usuario: " + idUsuario + ", Nombre: " + nombre + ", Edad: " + edad +
                        ", ID Dirección: " + idDireccion + ", Calle: " + calle + ", Ciudad: " + ciudad);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    public void selectUsuariosConPedidos() {
        String query = "SELECT u.id_usuario, u.nombre, u.edad, p.id_pedido, p.fecha_pedido, p.monto " +
                "FROM usuarios u INNER JOIN pedidos p ON u.id_usuario = p.id_usuario";
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                int idPedido = resultSet.getInt("id_pedido");
                Date fechaPedido = resultSet.getDate("fecha_pedido");
                double monto = resultSet.getDouble("monto");
                System.out.println("ID Usuario: " + idUsuario + ", Nombre: " + nombre + ", Edad: " + edad +
                        ", ID Pedido: " + idPedido + ", Fecha Pedido: " + fechaPedido + ", Monto: " + monto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
