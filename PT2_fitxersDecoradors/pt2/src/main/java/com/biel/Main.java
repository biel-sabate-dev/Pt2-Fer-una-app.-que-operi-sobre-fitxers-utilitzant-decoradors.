package com.biel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static int cesar = 3;
    public static void main(String[] args) {
        try {

            System.out.println("Cifrando el fitxero...");
            System.out.println("");

            System.out.println("Iniciando decoradores...");
            BufferedReader brNormal = new BufferedReader(new FileReader("pt2\\src\\main\\java\\com\\biel\\fitxer.txt"));
            BufferedWriter bwCifrado = new BufferedWriter(new FileWriter("pt2\\src\\main\\java\\com\\biel\\xifrat.txt"));
            System.out.println("Decoradores iniciados correctamente...");
            System.out.println("");

            System.out.println("Procesando...");
            System.out.println("");
            String linia;
            while ((linia = brNormal.readLine()) != null) {
                String liniaInvertida = "";
                String liniaCifrada = "";
                for (char c: linia.toCharArray()) {
                    liniaInvertida = c+liniaInvertida;
                }
                liniaCifrada = cifradoCesar(liniaInvertida);
                bwCifrado.write(liniaCifrada);
                bwCifrado.newLine();
            }

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
            BufferedReader brCifrado = new BufferedReader(new FileReader("pt2\\src\\main\\java\\com\\biel\\xifrat.txt"));
            BufferedWriter bwDescifrado = new BufferedWriter(new FileWriter("pt2\\src\\main\\java\\com\\biel\\desxifrat.txt"));
            System.out.println("Decoradores iniciados correctamente...");
            System.out.println("");

            System.out.println("Procesando...");
            System.out.println("");
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

    private static String cifradoCesar(String input) {
        String liniaCifrada = "";
        for (char c: input.toCharArray()) {
            int ASCII = c+cesar;
            char letra = (char) ASCII;
            liniaCifrada = liniaCifrada+letra;
        }
        return liniaCifrada;
    }

    private static String descifrarFichero(String input) {
        String liniaDescifrada = "";
        for (char c: input.toCharArray()) {
            int ASCII = c-cesar;
            char letra = (char) ASCII;
            liniaDescifrada = letra+liniaDescifrada;
        }
        return liniaDescifrada;
    }

}