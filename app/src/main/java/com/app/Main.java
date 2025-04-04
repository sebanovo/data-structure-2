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
        Lista l2 = new Lista();
        l2.pasarDigitos(12);
        System.out.println(l2);
        System.out.println(l2.suma());
    }
}
