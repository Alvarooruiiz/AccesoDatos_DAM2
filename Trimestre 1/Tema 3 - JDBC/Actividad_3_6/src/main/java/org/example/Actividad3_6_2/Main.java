package org.example.Actividad3_6_2;


public class Main {
    public static void main(String[] args) {
        Conexion con = new Conexion("postgres","alvaro","jdbc:postgresql://localhost:5432/InstitutoFP");
        boolean salir = true;
        if(con.probarConexion()){

            con.crearTabla();
            do{
                String nombre = org.example.Actividad3_6_1.EntradaTeclado.pedirCadena("Introduzca el nombre o salir si se desea dejar de introducir asignaturas: ");
                if(nombre.equals("salir")){
                    salir=true;
                }else{

                    con.introducirCurso(nombre);
                }


            }while(!salir);
        }
    }
}
