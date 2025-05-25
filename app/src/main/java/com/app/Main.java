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
import modelos.examen2.*;

public class Main {
    public static void main(String[] args) {
        ListaDoble l1 = new ListaDoble();
        l1.insertarUlt(1);
        l1.insertarUlt(2);
        l1.insertarUlt(3);
        l1.insertarUlt(4);
        l1.insertarUlt(2);
        System.out.println(l1);
        l1.eliminarTodo(2);
        System.out.println(l1);
    }
}
