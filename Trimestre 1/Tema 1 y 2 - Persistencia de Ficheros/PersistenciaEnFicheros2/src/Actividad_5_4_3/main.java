package Actividad_5_4_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new FileReader("bloc"))){
                String linea;
                int cont=0;
                boolean pausa=false;
                while ((linea=in.readLine())!=null){
                    if(!pausa){
                        System.out.println(linea);
                        cont++;
                    }
                    if(cont==3){
                        System.out.println("Presiona 'x' para continuar");
                        String caracterLeido = sc.next();
                        if(caracterLeido.equals("x")){
                            cont=0;
                            pausa=false;
                        }else pausa=true;
                    }
                }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
