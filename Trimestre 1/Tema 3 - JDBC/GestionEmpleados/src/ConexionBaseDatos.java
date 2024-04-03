import java.sql.*;

public class ConexionBaseDatos {
    private String usuario;
    private String passw;
    private String url;
    private Connection conn = null;



    public ConexionBaseDatos(String usuario, String passw, String url) {
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

    public void crearTablas(String[] sentencia){
        for (String s:sentencia){
            try(Statement statement = conn.createStatement()){
                statement.execute(s);
                System.out.println("Tabla creada exitosamente");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta: " + e.getMessage());

            }
        }
    }

    public void insertarDatos(String[] sentencia){
        for(String s : sentencia){
            try(Statement statement = conn.createStatement()){
                statement.executeUpdate(s);
                System.out.println("Valores de la tabla actualizados exitosamente");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta: " + e.getMessage());

            }
        }

    }

    public void consultaApellido(String sentencia){
        try(PreparedStatement preparedStatement = conn.prepareStatement(sentencia)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    System.out.println(resultSet.getString("apellido1"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);;
        }
    }

    public void consulta3(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                String nombreDepartamento = resultSet.getString("nombre");
                double gastos = resultSet.getDouble("gastos");
                System.out.println("Departamento: " + nombreDepartamento + ", Gasto: " + gastos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consulta4(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                String nombreDepartamento = resultSet.getString("nombre");
                double presupuesto = resultSet.getDouble("presupuesto");
                System.out.println("Departamento: " + nombreDepartamento + ", Presupuesto: " + presupuesto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consulta5(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                int idEmpleado = resultSet.getInt("id");
                String nombreEmpleado = resultSet.getString("nombre_empleado");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                int idDepartamento = resultSet.getInt("id_departamento");
                String nombreDepartamento = resultSet.getString("nombre_departamento");

                System.out.println("ID Empleado: " + idEmpleado +
                        ", Empleado: " + nombreEmpleado + " " + apellido1 + " " + apellido2 +
                        ", ID Departamento: " + idDepartamento +
                        ", Departamento: " + nombreDepartamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consulta6(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                int idEmpleado = resultSet.getInt("id");
                String nombreEmpleado = resultSet.getString("nombre_empleado");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                int idDepartamento = resultSet.getInt("id_departamento");
                String nombreDepartamento = resultSet.getString("nombre_departamento");

                System.out.println("ID Empleado: " + idEmpleado +
                        ", Empleado: " + nombreEmpleado + " " + apellido1 + " " + apellido2 +
                        ", ID Departamento: " + idDepartamento +
                        ", Departamento: " + nombreDepartamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consulta7(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                int idDepartamento = resultSet.getInt("id");
                String nombreDepartamento = resultSet.getString("nombre");

                System.out.println("ID Departamento: " + idDepartamento + ", Nombre Departamento: " + nombreDepartamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consulta8(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {
            String nifBuscado = "38382980M";
            if (resultSet.next()) {
                String nombreDepartamento = resultSet.getString("nombre");
                System.out.println("Departamento del empleado con NIF " + nifBuscado + ": " + nombreDepartamento);
            } else {
                System.out.println("No se encontró empleado con NIF " + nifBuscado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consulta9(String consulta){
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {
            String nifBuscado = "38382980M";
            if (resultSet.next()) {
                double sumaPresupuesto = resultSet.getDouble("suma_presupuesto");
                System.out.println("Suma del presupuesto de todos los departamentos: " + sumaPresupuesto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarConexion(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
}
