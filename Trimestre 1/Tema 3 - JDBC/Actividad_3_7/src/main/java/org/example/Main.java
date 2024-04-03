package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Conexion con = new Conexion("postgres","alvaro","jdbc:postgresql://localhost:5432/empleado");
        if(con.probarConexion()){
            System.out.println("1. Enumerar empleados por puesto");
            System.out.println("2. Listar empleados pertenecientes a un departamento");
            System.out.println("3. Listar empleados que coincidan con patron");
            System.out.println("0. Salir");
            int x = EntradaTeclado.pedirEntero("Introduzca la opcion: ");
            do{
                switch (x){
                    case 1->con.funcionMostrarNumeroEmpleados();
                    case 2->con.funcionMostrarEmpleadosDepartamento();
                    case 3->con.funcionMostrarEmpleadosPatronNombre();
                }
            }while (x!=0);
        }

    }

    static Session abrirSesion() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        if (session == null){
            throw new Exception("Error abriendo la sesión");
        } else {
            System.out.println("Conectado");
        }
        return session;
    }
}