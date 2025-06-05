package tema2.tarea3;

import java.util.*;

public class ArbolEntero {
  public NodoEntero raiz;

  public ArbolEntero() {
    raiz = null;
  }

  public void insertar(int x) {
    raiz = insertar(x, raiz);
  }

  /*
   * Ejercicio-1.
   * 
   * Dado una secuencia de elementos, se desea encontrar la frecuencia de cada
   * elementos.
   * - Mostrar los elementos de menor a mayor con sus respectivas frecuencias de
   * ocurrencias.
   * - Mostrar los elementos de mayor a menor con sus respectivas frecuencias de
   * ocurrencias.
   */

  private NodoEntero insertar(int x, NodoEntero p) {
    if (p == null) {
      return new NodoEntero(x);
    }
    if (x < p.elem) {
      p.izq = insertar(x, p.izq);
    } else if (x > p.elem) {
      p.der = insertar(x, p.der);
    } else {
      p.frec++;
    }
    return p;
  }

  public void mostrarMenorMayor() {
    mostrarMenorMayor(raiz);
    System.out.print('\n');
  }

  public void mostrarMenorMayor(NodoEntero p) {
    if (p == null) {
      return;
    }
    mostrarMenorMayor(p.izq);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMenorMayor(p.der);
  }

  public void mostrarMayorMenor() {
    mostrarMayorMenor(raiz);
    System.out.print('\n');
  }

  public void mostrarMayorMenor(NodoEntero p) {
    if (p == null) {
      return;
    }
    mostrarMayorMenor(p.der);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMayorMenor(p.izq);
  }

  public void generarElemRandom(int n, int a, int b) {
    for (int i = 0; i < n; i++) {
      Random random = new Random();
      int numeroAleatorio = a + random.nextInt(b - a + 1);
      insertar(numeroAleatorio);
    }
  }
}
