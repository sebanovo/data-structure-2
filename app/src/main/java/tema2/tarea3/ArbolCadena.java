package tema2.tarea3;

import java.util.*;

public class ArbolCadena {
  public NodoCadena raiz;

  public ArbolCadena() {
    raiz = null;
  }

  public void insertar(String x) {
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

  private NodoCadena insertar(String x, NodoCadena p) {
    if (p == null) {
      return new NodoCadena(x);
    }
    if (x.compareTo(p.elem) < 0) {
      p.izq = insertar(x, p.izq);
    } else if (x.compareTo(p.elem) > 0) {
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

  public void mostrarMenorMayor(NodoCadena p) {
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

  public void mostrarMayorMenor(NodoCadena p) {
    if (p == null) {
      return;
    }
    mostrarMayorMenor(p.der);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMayorMenor(p.izq);
  }

  public void leerCadena(String cadena) {
    StringTokenizer tokenizer = new StringTokenizer(cadena);
    while (tokenizer.hasMoreTokens()) {
      String palabra = tokenizer.nextToken();
      insertar(palabra);
    }
  }
}
