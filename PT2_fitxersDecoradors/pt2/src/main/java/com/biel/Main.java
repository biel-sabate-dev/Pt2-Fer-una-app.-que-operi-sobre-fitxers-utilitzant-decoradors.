package com.biel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    // Numero de traslacion para nuestro encriptado Cesar.
    static int cesar = 3;
    public static void main(String[] args) {
        try {

            System.out.println("Escoge el desplazamiento de cesar...");
            cesar = scanner.nextInt();

            System.out.println("Cifrando el fitxero...");
            System.out.println("");

            // Inicializado de Buffers con el constructor de los File* y la ruta de los arxivos.            
            System.out.println("Iniciando decoradores...");
            BufferedReader brNormal = new BufferedReader(new FileReader("Pt2-Fer-una-app.-que-operi-sobre-fitxers-utilitzant-decoradors./PT2_fitxersDecoradors/pt2/src/main/java/com/biel/fitxer.txt"));
            BufferedWriter bwCifrado = new BufferedWriter(new FileWriter("Pt2-Fer-una-app.-que-operi-sobre-fitxers-utilitzant-decoradors./PT2_fitxersDecoradors/pt2/src/main/java/com/biel/xifrar.txt"));
            System.out.println("Decoradores iniciados correctamente...");
            System.out.println("");

            System.out.println("Procesando...");
            System.out.println("");
            String linia;

            // Bucle While con la logica de inversion y cifrado.
            while ((linia = brNormal.readLine()) != null) {
                String liniaInvertida = "";
                String liniaCifrada = "";

                // Bucle ForEach con la logica de inversion de los caracteres.
                for (char c: linia.toCharArray()) {
                    liniaInvertida = c+liniaInvertida;
                }
                liniaCifrada = cifradoCesar(liniaInvertida);

                // Metodos con buffer para cargar en el buffer los strings cifrados.
                bwCifrado.write(liniaCifrada);
                bwCifrado.newLine();
            }

            // Finalización de los buffers para escribir el fichero cifrado.
            System.out.println("Finalizando decoradores...");
            brNormal.close();
            bwCifrado.close();
            System.out.println("Decoradores finalizados correctamente...");
            System.out.println("");

            System.out.println("Fichero cifrado correctamente...");

            System.out.println("Siguiente paso...");
            System.out.println("");

            System.out.println("Descifrando el cifrage...");
            System.out.println("");

            System.out.println("Iniciando decoradores...");
            BufferedReader brCifrado = new BufferedReader(new FileReader("Pt2-Fer-una-app.-que-operi-sobre-fitxers-utilitzant-decoradors./PT2_fitxersDecoradors/pt2/src/main/java/com/biel/xifrar.txt"));
            BufferedWriter bwDescifrado = new BufferedWriter(new FileWriter("Pt2-Fer-una-app.-que-operi-sobre-fitxers-utilitzant-decoradors./PT2_fitxersDecoradors/pt2/src/main/java/com/biel/desxifrar.txt"));
            System.out.println("Decoradores iniciados correctamente...");
            System.out.println("");

            System.out.println("Procesando...");
            System.out.println("");

            // Bucle While con la logica de descifrado de el fichero.
            while ((linia = brCifrado.readLine()) != null) {
                bwDescifrado.write(descifrarFichero(linia));
                bwDescifrado.newLine();
            }

            System.out.println("Finalizando decoradores...");
            brCifrado.close();
            bwDescifrado.close();
            System.out.println("Decoradores finalizados correctamente...");
            System.out.println("");

            System.out.println("Fichero descifrado correctamente...");
            System.out.println("");

        } catch (FileNotFoundException e) {
            System.err.println("Error crítico: No se encuentra la ruta del archivo.");
            System.err.println("Detalle del sistema: " + e.getMessage());
            System.err.println("Finalizando programa...");
        } catch (IOException e) {
            System.err.println("Error crítico: Problema de lectura o escritura en el archivo.");
            System.err.println("Detalle del sistema: " + e.getMessage());
            System.err.println("Finalizando programa...");
        }

    }

    // Metodo estatico con la logica necesaria para ejecutar la traslacion de posiciones segun la variable Cesar de cada caracter.
    private static String cifradoCesar(String input) {
        String liniaCifrada = "";

        // Bucle ForEach con la logica para extraer cada caracter del input, ejecutar traslacion y montar string cifrado
        for (char c: input.toCharArray()) {
            int ASCII = c+cesar;
            char letra = (char) ASCII;
            liniaCifrada = liniaCifrada+letra;
        }
        return liniaCifrada;
    }

    // Metodo estatico con la logica necesaria para ejecutar el descifrado de el metodo Cesar y invertir los string.
    private static String descifrarFichero(String input) {
        String liniaDescifrada = "";

        // Bucle ForEach actuando sobre input para realizar el descifrado y ordenación de el string.
        for (char c: input.toCharArray()) {
            int ASCII = c-cesar;
            char letra = (char) ASCII;
            liniaDescifrada = letra+liniaDescifrada;
        }
        return liniaDescifrada;
    }

}