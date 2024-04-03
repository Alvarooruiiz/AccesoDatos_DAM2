package org.example.Actividad3_6_3;


public class Main {
    public static void main(String[] args) {
        Conexion con = new Conexion("postgres","alvaro","jdbc:postgresql://localhost:5432/InstitutoFP");
        boolean salir = true;
        if(con.probarConexion()){


            con.modificarTabla();
        }
    }
}
