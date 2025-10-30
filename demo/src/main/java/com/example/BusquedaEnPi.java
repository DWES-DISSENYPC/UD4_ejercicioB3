package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaEnPi {

    public static void main(String[] args) {
        // Reemplaza con la ruta real de tu fichero de Pi
        String rutaPi = "pi.txt";
        String opcion = "1";
        Scanner ent = new Scanner(System.in);
        
        while (!opcion.equals("0") && !opcion.equals("")) {

            opcion = menu(ent);
           if (!opcion.equals("0") && !opcion.equals("")) {

            recorrerDecimales(rutaPi, opcion);
           }
           
        }

        
    }
   
    private static void recorrerDecimales(String rutaPi, String opcion) {

        String todoPi;
        
        try ( BufferedReader br = new BufferedReader(new FileReader(rutaPi))) {

            todoPi = br.readLine();
            ArrayList<Character> secuencia = new ArrayList<>();
            ArrayList<Character> piDividido = new ArrayList<>();
            int posicion = 0;
            int posActual;
            

            for (int i = 0; i < opcion.length(); i++) {

                secuencia.add(opcion.charAt(i));
            }

            int digitosEncontrados = secuencia.size();

            for (int i = 0; i < todoPi.length(); i++) {

                piDividido.add(todoPi.charAt(i));

            }


            for (int j = 2; j < piDividido.size(); ) {
                 posActual = j;
                for ( int i = 0; i < secuencia.size(); ) {

                    if (piDividido.get(j) == secuencia.get(i)) {
                       
                        i++;
                        j++;
                        digitosEncontrados--;

                        if (digitosEncontrados == 0) {

                            System.out.println(("Encontrada la secuencia " + opcion + " en la posicion " + (j-secuencia.size()-1)));
                            return;

                        } 
                    }else{
                        j = posActual + 1;
                        i = 0;
                        digitosEncontrados = secuencia.size();
                        break;


                    } 

                }
            }

        }catch (IOException e) {

            System.out.println("Error al leer el fichero");

        }


    }

    private static String menu(Scanner ent) {

        System.out.println("¿Que secuencia quieres comporbar. 0 para salir del programa");
        return ent.nextLine();
    }

    
    
}