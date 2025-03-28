package com.app;

// import tarea1.Lista;
// import tarea2.Lista;
// import tarea3.Lista;
import tarea4.Lista;

public class Main {
    public static void nose(String s) {
        s = "Hola mundo";
    }

    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        // l2.pasarDigitos(1245213);
        l1.pasarDigitos(1213411);
        // System.out.println(l1.mismosElem(l2));
        System.out.println(l1);
        l1.eliminarTodo(1);
        System.out.println(l1);
    }
}
