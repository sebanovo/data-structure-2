package com.data_structure_2;

import java.io.IOException;
import java.util.ArrayList;

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
// import tema2.tarea5.*;
import tema2.tarea6.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArbolEntero a1 = new ArbolEntero();
        a1.insertar(15);
        a1.insertar(10);
        a1.insertar(50);
        a1.insertar(40);
        a1.insertar(60);
        a1.insertar(30);
        a1.insertar(20);
        a1.insertar(35);
        a1.insertar(18);
        a1.insertar(25);
        a1.insertar(55);
        a1.insertar(70);
        a1.insertar(90);
        a1.insertar(80);
        a1.insertar(75);
        a1.insertar(85);
        a1.inOrden();
        // a1.eliminarNivel(3);
        // a1.eliminarHojas();
        // a1.eliminarPares();
        // a1.eliminarMenor();
        // a1.eliminarMayor();
        // a1.eliminarRaices();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(15);
        a1.eliminar(list);
        a1.inOrden();
    }
}
