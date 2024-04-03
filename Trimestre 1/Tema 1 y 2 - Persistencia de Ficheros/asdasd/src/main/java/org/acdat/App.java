package org.acdat;

import org.acdat.jdbc.MiJDBC;
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
//        MiJDBC miJDBC = new MiJDBC();
//        miJDBC.abrirConexion();
//
//        miJDBC.sqlDDL("INSERT INTO clientes_vuelos (cliente_id, vuelo_id) VALUES\n" +
//                "                                                       (1, 1), (1, 2),\n" +
//                "                                                       (2, 2), (2, 3);");
//
//
//        miJDBC.cerrarConexion();
        VistaCliente vistaCliente = new VistaCliente();
        VistaVuelo vistaVuelo = new VistaVuelo();

        //vistaCliente.crudCliente();
        vistaVuelo.crudVuelo();
    }
}
