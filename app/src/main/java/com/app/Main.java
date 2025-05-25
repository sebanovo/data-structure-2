package com.app;

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
import tema2.tarea2.*;

public class Main {
    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.generarElem(10, 1, 9);
        A1.inOrden();
        A1.preOrden();
        A1.postOrden();
    }
}
