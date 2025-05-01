package com.app;

// import tarea1.Lista;
// import tarea2.Lista;
// import tarea3.Lista;
// import tarea4.Lista;
//import tarea5.Tabla;
// import modelos.Lista;
// import tarea7.Lista;
import tarea8.ListaDoble;

public class Main {
    public static void main(String[] args) {
        ListaDoble l1 = new ListaDoble();
        l1.insertarUlt(5);
        l1.insertarUlt(1);
        l1.insertarUlt(4);
        l1.insertarUlt(3);
        l1.insertarUlt(2);

        System.out.println(l1);
        l1.intercalarParImpar1();
        System.out.println(l1);
    }
}
