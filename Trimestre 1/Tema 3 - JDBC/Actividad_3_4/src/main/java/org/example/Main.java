package org.example;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        Conexion conn = new Conexion("postgres","alvaro", "jdbc:postgresql://localhost:5432/InstitutoFP");

        String query = "SELECT * FROM public.asignaturas order by codigo;";
        String temaNuevo = "INSERT INTO public.asignaturas(codigo, nombre, anyo)VALUES (5, 'Lenguaje de marcas', 1);";
        String alterarTabla = "ALTER TABLE public.asignaturas ADD COLUMN horas INT;";

        if(conn.probarConexion()){

            conn.insertarNuevoTema_Actividad3_4_2(temaNuevo);
            conn.modificarTabla_Actividad3_4_3(alterarTabla);
            conn.consulta_Actividad3_4_1(query);
        }




    }
}