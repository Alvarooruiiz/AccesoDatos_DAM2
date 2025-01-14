package org.acdat;

import org.acdat.jdbc.MiJDBC;
import org.acdat.vista.VistaAgencia;
import org.acdat.vista.VistaCliente;
import org.acdat.vista.VistaVuelo;

import java.nio.charset.MalformedInputException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        VistaCliente vistaCliente = new VistaCliente();
        VistaVuelo vistaVuelo = new VistaVuelo();
        VistaAgencia vistaAgencia = new VistaAgencia();

        vistaAgencia.crudagencia();
//        MiJDBC jdbc = new  MiJDBC();
//
//        jdbc.abrirConexion();
//        try {
//            jdbc.iniciarTransaccion();
//            jdbc.executeCreate("""
//                    CREATE TABLE destinos (
//                    destino_id SERIAL PRIMARY KEY,
//                    nombre_destino VARCHAR(100) NOT NULL,
//                    descripcion TEXT,
//                    costo_estadia NUMERIC
//                    );
//                    """);
//            jdbc.executeCreate("""
//                    CREATE TABLE clientes (
//                    cliente_id SERIAL PRIMARY KEY,
//                    nombre_cliente VARCHAR(100) NOT NULL,
//                    correo_cliente VARCHAR(100) UNIQUE,
//                    telefono_cliente VARCHAR(20)
//                    );
//                    """);
//            jdbc.executeCreate("""
//                    CREATE TABLE agencias (
//                    agencia_id SERIAL PRIMARY KEY,
//                    nombre_agencia VARCHAR(100) NOT NULL,
//                    direccion_agencia TEXT,
//                    telefono_agencia VARCHAR(20)
//                    );
//                    """);
//            jdbc.executeCreate("""
//                    CREATE TABLE clientes_destinos (
//                    cliente_id INTEGER REFERENCES clientes(cliente_id),
//                    destino_id INTEGER REFERENCES destinos(destino_id),
//                    PRIMARY KEY (cliente_id, destino_id)
//                    );
//                    """);
//            jdbc.executeCreate("""
//                    CREATE TABLE destinos_agencias (
//                    destino_id INTEGER REFERENCES destinos(destino_id),
//                    agencia_id INTEGER REFERENCES agencias(agencia_id),
//                    PRIMARY KEY (destino_id, agencia_id)
//                    );
//                    """);
//        } catch (RuntimeException e) {
//            System.out.println(e.toString());
//            jdbc.rollbackTransaccion();
//        } finally {
//            jdbc.commitTransaccion();
//        }
//
//
//        try{
//            jdbc.iniciarTransaccion();
//            jdbc.executeInsert("""
//                    INSERT INTO destinos (nombre_destino, descripcion, costo_estadia) VALUES
//                                                                                          ('París', 'Ciudad del amor y la moda', 1500),
//                                                                                          ('Tokio', 'Capital de Japón con una mezcla única de tradición y tecnología', 2000),
//                                                                                          ('Nueva York', 'La Gran Manzana con rascacielos icónicos', 1800),
//                                                                                          ('Roma', 'Cuna de la civilización romana y arte renacentista', 1600),
//                                                                                          ('Sídney', 'Puente del puerto y la Ópera, destino emblemático en Australia', 2200),
//                                                                                          ('Barcelona', 'Arquitectura modernista y playas mediterráneas', 1700),
//                                                                                          ('Kioto', 'Antigua capital de Japón con templos y jardines zen', 1900),
//                                                                                          ('Marrakech', 'Ciudad imperial de Marruecos con zocos y palacios', 1400),
//                                                                                          ('Estambul', 'Puente entre Europa y Asia con la Mezquita Azul y Hagia Sophia', 2000),
//                                                                                          ('Ciudad del Cabo', 'Ciudad costera con la Montaña de la Mesa', 2100),
//                                                                                          ('Praga', 'Ciudad de las cien torres con un encanto medieval', 1600),
//                                                                                          ('Bali', 'Isla indonesia famosa por sus playas y arrozales', 1800),
//                                                                                          ('Machu Picchu', 'Ciudadela inca en lo alto de los Andes', 2500),
//                                                                                          ('Toronto', 'Ciudad cosmopolita con la Torre CN y las Cataratas del Niágara', 1900),
//                                                                                          ('Dubái', 'Ciudad del lujo y la modernidad en medio del desierto', 2300);
//                    """);
//            jdbc.executeInsert("""
//                    INSERT INTO agencias (nombre_agencia, direccion_agencia, telefono_agencia) VALUES
//                                                                                                   ('Viajes Fantásticos', 'Calle Principal 123', '+999888777'),
//                                                                                                   ('Aventuras Globales', 'Avenida Central 456', '+333222111'),
//                                                                                                   ('Destinos Soñados', 'Plaza de la Libertad 789', '+555444333'),
//                                                                                                   ('Mundo Viajero', 'Calle Viajera 101', '+777666555'),
//                                                                                                   ('Turismo Excelente', 'Avenida de los Sueños 202', '+888777666'),
//                                                                                                   ('Rutas Inolvidables', 'Paseo del Descanso 303', '+111000999'),
//                                                                                                   ('Viajes y Más', 'Carrera Aventurera 505', '+222111000'),
//                                                                                                   ('Explora el Mundo', 'Rincón del Viajero 606', '+444333222'),
//                                                                                                   ('Destinos Únicos', 'Calle de la Aventura 707', '+666555444'),
//                                                                                                   ('Aventuras Extremas', 'Plaza del Viajero 808', '+000999888');
//                    """);
//            jdbc.executeInsert("""
//                    INSERT INTO clientes (nombre_cliente, correo_cliente, telefono_cliente) VALUES
//                                                                                                ('Luisa Martínez', 'luisa@email.com', '+1234567890'),
//                                                                                                ('Pedro González', 'pedro@email.com', '+2345678901'),
//                                                                                                ('María Rodríguez', 'maria@email.com', '+3456789012'),
//                                                                                                ('Alejandro López', 'alejandro@email.com', '+4567890123'),
//                                                                                                ('Ana Sánchez', 'ana@email.com', '+5678901234'),
//                                                                                                ('Javier Ramírez', 'javier@email.com', '+6789012345'),
//                                                                                                ('Isabel Fernández', 'isabel@email.com', '+7890123456'),
//                                                                                                ('Carlos Pérez', 'carlos@email.com', '+8901234567'),
//                                                                                                ('Elena Gómez', 'elena@email.com', '+9012345678'),
//                                                                                                ('Andrés Díaz', 'andres@email.com', '+0123456789'),
//                                                                                                ('Laura Torres', 'laura@email.com', '+9876543210'),
//                                                                                                ('Roberto Herrera', 'roberto@email.com', '+8765432109'),
//                                                                                                ('Silvia Castro', 'silvia@email.com', '+7654321098'),
//                                                                                                ('Juan García', 'juan@email.com', '+6543210987'),
//                                                                                                ('Carmen Ruiz', 'carmen@email.com', '+5432109876'),
//                                                                                                ('Fernando Méndez', 'fernando@email.com', '+4321098765'),
//                                                                                                ('Sara Vargas', 'sara@email.com', '+3210987654'),
//                                                                                                ('Héctor Navarro', 'hector@email.com', '+2109876543'),
//                                                                                                ('Lucía Medina', 'lucia@email.com', '+1098765432'),
//                                                                                                ('Diego Ríos', 'diego@email.com', '+9876543210'),
//                                                                                                ('Patricia Silva', 'patricia@email.com', '+8765432109'),
//                                                                                                ('Adrián Mendoza', 'adrian@email.com', '+7654321098'),
//                                                                                                ('Natalia Romero', 'natalia@email.com', '+6543210987'),
//                                                                                                ('Martín Castro', 'martin@email.com', '+5432109876'),
//                                                                                                ('Eva Morales', 'eva@email.com', '+4321098765'),
//                                                                                                ('Raúl Guzmán', 'raul@email.com', '+3210987654'),
//                                                                                                ('Lorena Ortega', 'lorena@email.com', '+2109876543'),
//                                                                                                ('Pablo Roca', 'pablo@email.com', '+1098765432'),
//                                                                                                ('Beatriz León', 'beatriz@email.com', '+9876543210'),
//                                                                                                ('Andrea Díaz', 'andrea@email.com', '+8765432109'),
//                                                                                                ('Óscar Muñoz', 'oscar@email.com', '+7654321098'),
//                                                                                                ('Marta Cordero', 'marta@email.com', '+6543210987'),
//                                                                                                ('Ricardo Soto', 'ricardo@email.com', '+5432109876'),
//                                                                                                ('Cristina Paredes', 'cristina@email.com', '+4321098765'),
//                                                                                                ('Jorge Gallego', 'jorge@email.com', '+3210987654'),
//                                                                                                ('Natalie Rojas', 'natalie@email.com', '+2109876543'),
//                                                                                                ('Gabriel Gil', 'gabriel@email.com', '+1098765432'),
//                                                                                                ('Ana Rosa', 'anarosa@email.com', '+9876543210'),
//                                                                                                ('Manuel Mora', 'manuel@email.com', '+8765432109'),
//                                                                                                ('Rosa Serrano', 'rosa@email.com', '+7654321098'),
//                                                                                                ('Hugo Guerra', 'hugo@email.com', '+6543210987'),
//                                                                                                ('Julia Torres', 'julia@email.com', '+5432109876'),
//                                                                                                ('Eduardo Alvarado', 'eduardo@email.com', '+4321098765'),
//                                                                                                ('Mónica Pinto', 'monica@email.com', '+3210987654'),
//                                                                                                ('Gustavo Ramos', 'gustavo@email.com', '+2109876543'),
//                                                                                                ('Paola Jiménez', 'paola@email.com', '+1098765432'),
//                                                                                                ('Daniel Salgado', 'daniel@email.com', '+9876543210');
//                    """);
//            jdbc.executeInsert("""
//                    INSERT INTO clientes_destinos (cliente_id, destino_id)
//                    VALUES
//                        (1, 1), (1, 3), (1, 5), (1, 7), (1, 9),
//                        (2, 2), (2, 4), (2, 6), (2, 8), (2, 10),
//                        (3, 3), (3, 5), (3, 7), (3, 9), (3, 11),
//                        (10, 10), (10, 12), (10, 14), (10, 11), (10, 2);
//                    """);
//            jdbc.executeInsert("""
//                    INSERT INTO destinos_agencias (destino_id, agencia_id)
//                    VALUES
//                        (1, 1), (1, 3), (1, 5), (1, 7), (1, 9),
//                        (2, 2), (2, 4), (2, 6), (2, 8), (2, 10),
//                        (3, 3), (3, 5), (3, 7), (3, 9), (3, 10),
//                        (10, 10), (10, 2), (10, 4);
//                    """);
//        } catch (RuntimeException e){
//            System.out.println(e.toString());
//            jdbc.rollbackTransaccion();
//        } finally {
//            jdbc.commitTransaccion();
//        }
//
//
//        try {
//            jdbc.iniciarTransaccion();
//            jdbc.executeCreate("""
//                    CREATE TABLE vuelos (
//                                            vuelo_id SERIAL PRIMARY KEY,
//                                            origen VARCHAR(50),
//                                            destino VARCHAR(50),
//                                            fecha_salida DATE,
//                                            fecha_llegada DATE,
//                                            costo NUMERIC(10, 2)
//                    );
//                    """);
//            jdbc.executeCreate("""
//                    CREATE TABLE clientes_vuelos (
//                                                     cliente_id INTEGER REFERENCES clientes(cliente_id),
//                                                     vuelo_id INTEGER REFERENCES vuelos(vuelo_id),
//                                                     PRIMARY KEY (cliente_id, vuelo_id)
//                    );
//                    """);
//        } catch (RuntimeException e) {
//            System.out.println(e.toString());
//            jdbc.rollbackTransaccion();
//        } finally {
//            jdbc.commitTransaccion();
//        }
//
//        try {
//            jdbc.iniciarTransaccion();
//            jdbc.executeInsert("""
//                    INSERT INTO vuelos (origen, destino, fecha_salida, fecha_llegada, costo) VALUES
//                                                                                                 ('Ciudad A', 'Ciudad B', '2023-12-01', '2023-12-05', 500.00),
//                                                                                                 ('Ciudad C', 'Ciudad D', '2023-12-10', '2023-12-15', 700.00),
//                                                                                                 ('Ciudad E', 'Ciudad F', '2023-12-20', '2023-12-25', 900.00);
//                    """);
//            jdbc.executeInsert("""
//                    INSERT INTO clientes (nombre_cliente, correo_cliente, telefono_cliente) VALUES
//                                                                                                ('Juan Pérez', 'juanito@email.com', '+123456789'),
//                                                                                                ('Ana López', 'anita@email.com', '+987654321');
//                    """);
//        } catch (RuntimeException e) {
//            System.out.println(e.toString());
//            jdbc.rollbackTransaccion();
//        } finally {
//            jdbc.commitTransaccion();
//        }
//
//        try{
//            jdbc.iniciarTransaccion();
//            jdbc.executeInsert("""
//        INSERT INTO clientes_vuelos (cliente_id, vuelo_id) VALUES
//                (1, 1), (1, 2),
//        (2, 2), (2, 3);
//        """);
//        } catch (RuntimeException e){
//            System.out.println(e.toString());
//            jdbc.rollbackTransaccion();
//        } finally {
//            jdbc.commitTransaccion();
//        }
//

    //vistaCliente.crudCliente();
//    vistaVuelo.crudVuelo();
        //vistaAgencia.crudagencia();
    }
}
