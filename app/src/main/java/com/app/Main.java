package com.app;

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
// import tema2.tarea3.*;
// import tema2.tarea4.*;
import tema2.tarea5.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Lista l1 = new Lista();
        l1.cargarArchivo(
                "C:\\Users\\HP\\Documents\\Ejercicios\\Java\\app\\app\\src\\\\main\\java\\tema2\\tarea5\\Startup.txt");
        l1.mostrarMenorMayor();
    }
}
