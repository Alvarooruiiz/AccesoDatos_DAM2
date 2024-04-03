package org.example.Actividad3_6_1;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        Conexion con = new Conexion("postgres","alvaro","jdbc:postgresql://localhost:5432/InstitutoFP");
        if(con.probarConexion()){
            do{
                String nombre = EntradaTeclado.pedirCadena("Introduzca el nombre o salir si se desea dejar de introducir asignaturas: ");
                if(nombre.equals("salir")){
                    salir=true;
                }else{
                    int horas= EntradaTeclado.pedirEntero("Inrtoduzca el numero de horas: ");
                    int anyo = EntradaTeclado.pedirEntero("Introducir el curso: ");

                    Asignatura a = new Asignatura(nombre,horas,anyo);

                    con.introducirAsignatura(a);
                }


            }while(!salir);
        }
    }
}