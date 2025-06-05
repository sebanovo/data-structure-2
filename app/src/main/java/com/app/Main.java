package com.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// import tema1.tarea1.Lista;
// import tema1.tarea2.Lista;
// import tema1.tarea3.Lista;
// import tema1.tarea4.Lista;
// import tema1.tarea5.Tabla;
// import modelos.examen1.*;
// import tema1.tarea7.Lista;
// import tema1.tarea8.ListaDoble;
// import tema1.tarea9.*;
// import tema1.tarea10.*;
// import modelos.examen2.*;
// import tema2.tarea2.*;
import tema2.tarea3.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // ArbolEntero A1 = new ArbolEntero();
        // System.out.println("\n");
        // A1.generarElemRandom(10, 1, 9);
        // A1.mostrarMenorMayor();
        // A1.mostrarMayorMenor();
        ArbolCadena A2 = new ArbolCadena();
        System.out.println(new File("documento.txt").getAbsolutePath());
        System.out.println("\n");
        BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
        String linea;
        while ((linea = reader.readLine()) != null) {
            A2.leerCadena(linea.toLowerCase());
        }
        reader.close();

        A2.mostrarMenorMayor();
        A2.mostrarMayorMenor();
    }
}
