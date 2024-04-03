public class App {
    public static void main( String[] args ) {

        CRUD crud = new CRUD("postgres","alvaro", "jdbc:postgresql://localhost:5432/CRUD_Ejemplo");

        if(crud.probarConexion()){
            // Crear un usuario con dirección
            int idUsuario = crud.insertUsuario("John Doe", 25);
            int idDireccion = crud.insertDireccion(idUsuario, "123 Main St", "Cityville");

            // Obtener y mostrar todos los usuarios con direcciones
            System.out.println("Usuarios con direcciones:");
            crud.selectUsuariosConDirecciones();

            // Crear un pedido asociado al usuario
            crud.insertPedido(idUsuario, "2023-01-01", 100.0);

            // Obtener y mostrar todos los usuarios con sus pedidos
            System.out.println("\nUsuarios con pedidos:");
            crud.selectUsuariosConPedidos();
        }

    }
}


/*
Primera tabla:
CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT
);

Segunda tabla:
CREATE TABLE direcciones (
    id_direccion SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario),
    calle VARCHAR(100),
    ciudad VARCHAR(50)
);

Tercera tabla:
CREATE TABLE pedidos (
    id_pedido SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario),
    fecha_pedido DATE,
    monto DOUBLE PRECISION
);


 */