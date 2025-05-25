package com.app;

// import tarea1.Lista;
// import tarea2.Lista;
// import tarea3.Lista;
// import tarea4.Lista;
// import tarea5.Tabla;
// import modelos.examen1.*;
// import tarea7.Lista;
// import tarea8.ListaDoble;
// import tarea9.*;
// import tarea10.*;
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
