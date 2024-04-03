import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        String crearTablas[] = {"CREATE TABLE IF NOT EXISTS empleado ("
//                + "id SERIAL PRIMARY KEY,"
//                + "nif VARCHAR(9) NOT NULL UNIQUE,"
//                + "nombre VARCHAR(100) NOT NULL,"
//                + "apellido1 VARCHAR(100) NOT NULL,"
//                + "apellido2 VARCHAR(100),"
//                + "id_departamento INT,"
//                + "FOREIGN KEY (id_departamento) REFERENCES departamento(id))"};
//
//        String[] datos = {"INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);","INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);"
//                ,"INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000)",
//                "INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000)",
//                "INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0)",
//                "INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000)",
//                "INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1)",
//                "INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2)",
//                "INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3)",
//                "INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4)",
//                "INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5)",
//                "INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1)",
//                "INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2)",
//                "INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3)",
//                "INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2)",
//                "INSERT INTO empleado VALUES(10, '46384486H', 'Diego','Flores', 'Salas', 5)",
//                "INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1)",
//                "INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL)",
//                "INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL)"
//        };

        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos("postgres","alvaro", "jdbc:postgresql://localhost:5432/empleado");

        if(conexionBaseDatos.probarConexion()){
            //conexionBaseDatos.crearTablas(crearTablas);
            //conexionBaseDatos.insertarDatos(datos);
            int x;

            do{
                System.out.println("1. Consulta primer apellido de la tabla empleado");
                System.out.println("2. Consulta el primer apellido eliminando repetidos de la tabla empleado");
                System.out.println("3. Devuelve una lista con el nombre y el gasto, de los 2 departamentos que" +
                        " tienen menor gasto.");
                System.out.println("4. Devuelve una lista con el nombre de los departamentos y el presupuesto," +
                        " de aquellos que tienen un presupuesto mayor o igual a 150000 euros.");
                System.out.println("5. Devuelve un listado con los empleados y los datos de los departamentos " +
                        "donde trabaja cada uno.");
                System.out.println("6. Devuelve un listado con los empleados y los datos de los departamentos " +
                        "donde trabaja cada uno. Ordena el resultado, en primer lugar por el nombre del departamento " +
                        "(en orden alfabético) y en segundo lugar por los apellidos y el nombre de los empleados.");
                System.out.println("7. Devuelve un listado con el identificador y el nombre del departamento, solamente" +
                        " de aquellos departamentos que tienen empleados.");
                System.out.println("8. Devuelve el nombre del departamento donde trabaja el empleado que tiene el " +
                        "nif 38382980M.");
                System.out.println("9. Calcula la suma del presupuesto de todos los departamentos.");
                x = EntradaTeclado.pedirEntero("Introduzca la opción: ");

                switch (x){
                    case 1->{
                        System.out.println("------- Listado de primer apellido --------");
                        conexionBaseDatos.consultaApellido("SELECT apellido1 FROM empleado");

                    }
                    case 2->{
                        System.out.println("------- Listado de primer apellido eliminando repetidos -------");
                        conexionBaseDatos.consultaApellido("SELECT DISTINCT apellido1 FROM empleado");
                    }
                    case 3->{
                        System.out.println("------- Listado con el nombre y el gasto, de los 2 departamentos que tienen menor gasto -------");
                        conexionBaseDatos.consulta3("SELECT nombre, gastos FROM departamento ORDER BY gastos ASC LIMIT 2");
                    }
                    case 4->{
                        System.out.println("------- Listado con el nombre de los departamentos y el presupuesto, de aquellos que tienen" +
                                " un presupuesto mayor o igual a 150000 euros. -------");
                        conexionBaseDatos.consulta4("SELECT nombre, presupuesto FROM departamento WHERE presupuesto >= 150000");
                    }case 5->{
                        System.out.println("------- Listado con los empleados y los datos de los departamentos donde trabaja cada uno. -------");
                        conexionBaseDatos.consulta5("SELECT e.id, e.nombre as nombre_empleado, e.apellido1, e.apellido2, d.id as id_departamento, " +
                                "d.nombre as nombre_departamento FROM empleado e JOIN departamento d ON e.id_departamento = d.id");
                    }case 6->{
                        System.out.println("------- Listado con los empleados y los datos de los departamentos donde trabaja cada uno." +
                                " Ordena el resultado, en primer lugar por el nombre del departamento (en orden alfabético) " +
                                "y en segundo lugar por los apellidos y el nombre de los empleados. -------");
                        conexionBaseDatos.consulta6("SELECT e.id, e.nombre as nombre_empleado, e.apellido1, e.apellido2, " +
                                "d.id as id_departamento, d.nombre as nombre_departamento " +
                                "FROM empleado e JOIN departamento d ON e.id_departamento = d.id " +
                                "ORDER BY d.nombre, e.apellido1, e.apellido2, e.nombre");
                    }case 7->{
                        System.out.println("------- Listado con el identificador y el nombre del departamento, solamente de aquellos departamentos que tienen empleados. -------");
                        conexionBaseDatos.consulta7("SELECT d.id, d.nombre " +
                                "FROM departamento d " +
                                "JOIN empleado e ON d.id = e.id_departamento " +
                                "GROUP BY d.id, d.nombre");
                    }case 8->{
                        System.out.println("------- Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif -> 38382980M.. -------");
                        String nifBuscado = "38382980M";
                        conexionBaseDatos.consulta8("SELECT d.nombre " +
                                "FROM empleado e " +
                                "JOIN departamento d ON e.id_departamento = d.id " +
                                "WHERE e.nif = '" + nifBuscado + "'");
                    }case 9->{
                        System.out.println("------- Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif -> 38382980M.. -------");
                        conexionBaseDatos.consulta9("SELECT SUM(presupuesto) as suma_presupuesto FROM departamento");
                    }
                }
            }while(x!=0);
        }









        conexionBaseDatos.cerrarConexion();



    }
}