package tema2.tarea6;

import java.util.*;

public class ArbolEntero {

  public NodoEntero raiz;

  public ArbolEntero() {
    raiz = null;
  }

  public void insertar(int x) {
    raiz = insertar(x, raiz);
  }

  private NodoEntero insertar(int x, NodoEntero p) {
    if (p == null) {
      return new NodoEntero(x);
    }
    if (x < p.elem) {
      p.izq = insertar(x, p.izq);
    } else {
      p.der = insertar(x, p.der);
    }
    return p;
  }

  public void inOrden() {
    inOrden(raiz);
    System.out.print('\n');
  }

  private void inOrden(NodoEntero p) {
    if (p == null) {
      return;
    }

    inOrden(p.izq);
    System.out.print(p.elem + ", ");
    inOrden(p.der);
  }

  /*
   * ##########################################################
   * # A. Eliminar elementos de un Árbol Binario de Búsqueda. #
   * ##########################################################
   */
  /*
   * 1. A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
   */
  public void eliminar(int x) {
    raiz = eliminar(x, raiz);
  }

  private NodoEntero eliminar(int x, NodoEntero p) {
    if (p == null) {
      return null;
    }
    if (x == p.elem) {
      return eliminarNodo(p);
    }
    if (x < p.elem) {
      p.izq = eliminar(x, p.izq);
    } else {
      p.der = eliminar(x, p.der);
    }
    return p;
  }

  private NodoEntero eliminarNodo(NodoEntero p) {
    if (p.izq == null && p.der == null) {
      return null;
    }
    if (p.izq == null && p.der != null) {
      return p.der;
    }
    if (p.izq != null && p.der == null) {
      return p.izq;
    }
    NodoEntero q = p.der;
    while (q.izq != null) {
      q = q.izq;
    }
    p.der = eliminar(q.elem, p.der);
    p.elem = q.elem;
    return p;
  }

  /*
   * 2. A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.
   */
  public void eliminarHojas() {
    raiz = eliminarHojas(raiz);
  }

  private NodoEntero eliminarHojas(NodoEntero p) {
    if (p == null) {
      return null;
    }
    if (p.izq == null && p.der == null) {
      return eliminarNodo(p);
    }
    p.izq = eliminarHojas(p.izq);
    p.der = eliminarHojas(p.der);
    return p;
  }

  /*
   * 3. A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
   */
  public void eliminarPares() {
    raiz = eliminarPares(raiz);
  }

  private NodoEntero eliminarPares(NodoEntero p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarPares(p.izq);
    p.der = eliminarPares(p.der);
    if (p.elem % 2 == 0) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 4. A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se
   * encuentran en el árbol A1.
   */
  public void eliminar(ArrayList<Integer> L1) {
    raiz = eliminar(L1, raiz);
  }

  private NodoEntero eliminar(ArrayList<Integer> L1, NodoEntero p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminar(L1, p.izq);
    p.der = eliminar(L1, p.der);
    for (int i = 0; i < L1.size(); i++) {
      if (L1.get(i) == p.elem) {
        return eliminarNodo(p);
      }
    }
    return p;
  }

  /*
   * 5. A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.
   */
  public void eliminarMenor() {
    NodoEntero p = raiz;
    NodoEntero ap = null;
    while (p != null) {
      ap = p;
      p = p.izq;
    }

    eliminar(ap.elem);
  }

  /*
   * 6. A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
   */
  public void eliminarMayor() {
    NodoEntero p = raiz;
    NodoEntero ap = null;
    while (p != null) {
      ap = p;
      p = p.der;
    }
    eliminar(ap.elem);
  }

  /*
   * 7. A1.eliminarNivel( n ) : Método que elimina los nodos del árbol A1 del
   * nivel n.
   */
  public void eliminarNivel(int n) {
    raiz = eliminarNivel(raiz, n, 1);
  }

  private NodoEntero eliminarNivel(NodoEntero p, int n, int i) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarNivel(p.izq, n, i + 1);
    p.der = eliminarNivel(p.der, n, i + 1);
    if (i == n) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 8. A1.eliminarRaices() : Método que elimina los nodos raíces del árbol A1.
   */
  public void eliminarRaices() {
    raiz = eliminarRaices(raiz);
  }

  public NodoEntero eliminarRaices(NodoEntero p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarRaices(p.izq);
    p.der = eliminarRaices(p.der);
    if (p.izq != null && p.der != null) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 9. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En
   * lo posible citar fuente.
   */
  /*
   * 1. A1.eliminarMultiplosDe(n) : Elimina todos los nodos cuyo valor sea
   * múltiplo de n.
   */
  public void eliminarMultiplosDe(int n) {
    raiz = eliminarMultiplosDe(raiz, n);
  }

  private NodoEntero eliminarMultiplosDe(NodoEntero p, int n) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarMultiplosDe(p.izq, n);
    p.der = eliminarMultiplosDe(p.der, n);
    if (p.elem % n == 0) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 2. A1.eliminarFueraDeRango(a, b) : Elimina todos los nodos cuyo valor esté
   * fuera del intervalo [a, b].
   */
  public void eliminarFueraDeRango(int a, int b) {
    raiz = eliminarFueraDeRango(raiz, a, b);
  }

  private NodoEntero eliminarFueraDeRango(NodoEntero p, int a, int b) {
    if (p == null) {
      return null;
    }

    p.izq = eliminarFueraDeRango(p.izq, a, b);
    p.der = eliminarFueraDeRango(p.der, a, b);

    if (p.elem < a || p.elem > b) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 3. A1.eliminarSiAlturaMenorQue(h) : Elimina todos los nodos cuya altura de
   * subárbol sea menor que h.
   */
  public void eliminarSiAlturaMenorQue(int h) {
    raiz = eliminarSiAlturaMenorQue(raiz, h);
  }

  private NodoEntero eliminarSiAlturaMenorQue(NodoEntero p, int h) {
    if (p == null) {
      return null;
    }

    p.izq = eliminarSiAlturaMenorQue(p.izq, h);
    p.der = eliminarSiAlturaMenorQue(p.der, h);

    if (altura(p) < h) {
      return eliminarNodo(p);
    }

    return p;
  }

  private int altura(NodoEntero p) {
    if (p == null) {
      return 0;
    }
    int altIzq = altura(p.izq);
    int altDer = altura(p.der);
    return Math.max(altIzq, altDer) + 1;
  }

  /*
   * 4. A1.eliminarConHijoIzquierdoUnico() : Elimina los nodos que tienen solo
   * hijo izquierdo.
   */
  public void eliminarConHijoIzquierdoUnico() {
    raiz = eliminarConHijoIzquierdoUnico(raiz);
  }

  private NodoEntero eliminarConHijoIzquierdoUnico(NodoEntero p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarConHijoIzquierdoUnico(p.izq);
    p.der = eliminarConHijoIzquierdoUnico(p.der);

    if (p.izq != null && p.der == null) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 5. A1.eliminarConHijoDerechoUnico() : Elimina los nodos que tienen solo hijo
   * derecho.
   */
  public void eliminarConHijoDerechoUnico() {
    raiz = eliminarConHijoDerechoUnico(raiz);
  }

  private NodoEntero eliminarConHijoDerechoUnico(NodoEntero p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarConHijoDerechoUnico(p.izq);
    p.der = eliminarConHijoDerechoUnico(p.der);

    if (p.izq == null && p.der != null) {
      return eliminarNodo(p);
    }

    return p;
  }

}