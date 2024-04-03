import java.util.Arrays;
import java.util.Scanner;

public class Act_3_3_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Scanner sc1= new Scanner(System.in);

        int dia,mes,ano;
        MiFechaHeredada mf;

        String nombre = sc1.nextLine();
        String apellidos = sc1.nextLine();

        System.out.println("¡Hola, " + nombre + " " + apellidos + "!");

        do{
            System.out.println("Introduzca la fecha de hoy (dd-mm-yyyy)");
            String fecha = sc.nextLine();
            String[] fechaSeparada = fecha.split("-");
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            ano = Integer.parseInt(fechaSeparada[2]);
            mf = new MiFechaHeredada(dia,mes,ano);
        }while(mf.getDia()==null|| mf.getMes()==null || mf.getDia()==0);

        System.out.println(mf);
       }

}
