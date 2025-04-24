package com.app;

// import tarea1.Lista;
// import tarea2.Lista;
// import tarea3.Lista;
// import tarea4.Lista;
//import tarea5.Tabla;
// import modelos.Lista;
import tarea7.Lista;

public class Main {
    public static void main(String[] args) {
        Lista l1 = new Lista();
        l1.insertarUlt(2);
        l1.insertarUlt(3);
        l1.insertarUlt(4);
        l1.insertarUlt(5);

        l1.insertarLugarAsc(0);

        System.out.println(l1);
        System.out.println(l1.diferentes());
        // System.out.println(l1.mayorElem());
        System.out.println(l1.poker());
        System.out.println(l1.alternos());

    }
}
