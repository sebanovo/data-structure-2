package tema2.tarea2;

import java.util.*;

public class Arbol {

  Nodo raiz;

  public Arbol() {
    this.raiz = null;
  }

  /**
   * 1. A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros
   * diferentes entre a y b inclusive.
   */
  public void generarElem(int n, int a, int b) {
    for (int i = 0; i < n; i++) {
      Random random = new Random();
      int numeroRandom = a + random.nextInt((b + 1) - a);
      insertar(numeroRandom);
    }
  }

  /**
   * 2. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su
   * lugar correspondiente.
   */
  public void insertar(int x) {
    this.raiz = insertar(x, raiz);
  }

  private Nodo insertar(int x, Nodo p) {
    if (p == null) {
      return new Nodo(x);
    }
    if (x < p.elem) {
      p.izq = insertar(x, p.izq);
    } else if (x > p.elem) {
      p.der = insertar(x, p.der);
    } else {
      p.elem = x;
    }
    return p;
  }

  /**
   * 3. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
   */
  public void preOrden() {
    preOrden(raiz);
    System.out.print('\n');
  }

  private void preOrden(Nodo p) {
    if (p == null) {
      return;
    }
    System.out.print(p.elem + ", ");
    preOrden(p.izq);
    preOrden(p.der);
  }

  /**
   * 4. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
   */
  public void inOrden() {
    inOrden(raiz);
    System.out.print('\n');
  }

  private void inOrden(Nodo p) {
    if (p == null) {
      return;
    }
    inOrden(p.izq);
    System.out.print(p.elem + ", ");
    inOrden(p.der);
  }

  /**
   * 5. A1.postOrden() : Método que muestra los elementos del árbol A1 en
   * postOrden.
   */
  public void postOrden() {
    postOrden(raiz);
    System.out.print('\n');
  }

  private void postOrden(Nodo p) {
    if (p == null) {
      return;
    }
    postOrden(p.izq);
    postOrden(p.der);
    System.out.print(p.elem + ", ");
  }

  /**
   * 6. A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.
   */
  public void niveles() {
    LinkedList<Nodo> L1 = new LinkedList<Nodo>();
    if (raiz != null) {
      L1.add(raiz);

    }
    while (!L1.isEmpty()) {
      Nodo p = L1.removeFirst();
      if (p.izq != null) {
        L1.add(p.izq);
      }
      if (p.der != null) {
        L1.add(p.der);
      }
      System.out.print(p.elem + ", ");
    }
  }

  /**
   * 7. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
   */
  public void desc() {
    ArrayList<Integer> L1 = new ArrayList<Integer>();
    inOrden(L1, raiz);
    for (int i = L1.size() - 1; i >= 0; i--) {
      System.out.print(L1.get(i) + ", ");
    }
  }

  /**
   * 8. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se
   * encuentra en el árbol A1.
   */
  public boolean seEncuentra(int x) {
    return seEncuentra(x, raiz);
  }

  private boolean seEncuentra(int x, Nodo p) {
    if (p == null) {
      return false;
    }
    if (x < p.elem) {
      return seEncuentra(x, p.izq);
    } else if (x > p.elem) {
      return seEncuentra(x, p.der);
    } else {
      return true;
    }
  }

  /**
   * 9. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
   */
  public int cantidad() {
    return cantidad(raiz);
  }

  private int cantidad(Nodo p) {
    if (p == null) {
      return 0;
    }
    return cantidad(p.izq) + cantidad(p.der) + 1;
  }

  /**
   * 10. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
   */
  public int suma() {
    return suma(raiz);
  }

  private int suma(Nodo p) {
    if (p == null) {
      return 0;
    }
    return suma(p.izq) + suma(p.der) + p.elem;
  }

  /**
   * 11. A1.menor() : Método que devuelve el elemento menor del árbol A1.
   */
  public int menor() {
    return menor(raiz);
  }

  private int menor(Nodo p) {
    Nodo ap = null;
    while (p != null) {
      ap = p;
      p = p.izq;
    }
    return ap.elem;
  }

  /**
   * 12. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
   */
  public int mayor() {
    return mayor(raiz);
  }

  private int mayor(Nodo p) {
    Nodo ap = null;
    while (p != null) {
      ap = p;
      p = p.der;
    }
    return ap.elem;
  }

  /**
   * 13. A1.preoOrden(L1) : Método que encuentra en la lista L1, el recorrido de
   * preOrden de los elementos del árbol A1.
   */
  public void preOrden(ArrayList<Integer> L1) {
    preOrden(L1, raiz);
  }

  private void preOrden(ArrayList<Integer> L1, Nodo p) {
    if (p == null) {
      return;
    }
    L1.add(p.elem);
    preOrden(L1, p.izq);
    preOrden(L1, p.der);
  }

  /**
   * 14. A1.inOrden(L1) : Método que encuentra en la lista L1, el
   * recorrido de
   * inOrden de los elementos del árbol A1.
   * 
   */
  public void inOrden(ArrayList<Integer> L1) {
    inOrden(L1, raiz);
  }

  private void inOrden(ArrayList<Integer> L1, Nodo p) {
    if (p == null) {
      return;
    }
    inOrden(L1, p.izq);
    L1.add(p.elem);
    inOrden(L1, p.der);
  }

  /**
   * 15. A1.postOrden(L1) : Método que encuentra en la lista L1, el
   * recorrido
   * de postOrden de los elementos del árbol A1.
   */
  public void postOrden(ArrayList<Integer> L1) {
    postOrden(L1, raiz);
  }

  private void postOrden(ArrayList<Integer> L1, Nodo p) {
    if (p == null) {
      return;
    }
    postOrden(L1, p.izq);
    postOrden(L1, p.der);
    L1.add(p.elem);
  }

  /**
   * 16. A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por
   * niveles de los elementos del árbol A1.
   */
  public void niveles(ArrayList<Integer> L1) {
    LinkedList<Nodo> cola = new LinkedList<Nodo>();
    if (raiz != null) {
      cola.add(raiz);

    }
    while (!L1.isEmpty()) {
      Nodo p = cola.removeFirst();
      if (p.izq != null) {
        cola.add(p.izq);
      }
      if (p.der != null) {
        cola.add(p.der);
      }
      L1.add(p.elem);
    }
  }

  /**
   * 17. A1.mostrarNivel(): Método que muestra los elementos del árbol
   * y el nivel en el que se encuentran. (Recorrer el árbol en cualquier orden)
   */
  public void mostrarNivel() {
    mostrarNivel(raiz, 0);
  }

  private void mostrarNivel(Nodo p, int nivel) {
    if (p == null) {
      return;
    }
    mostrarNivel(p.izq, nivel + 1);
    System.out.println(p.elem + " " + nivel);
    mostrarNivel(p.der, nivel + 1);
  }

  /**
   * 18. A1.sumarNivel(L1) : Método que encuentra en la Lista de acumuladores por
   * nivel L1, la suma de los elementos de cada nivel.
   */
  public void sumarNivel(ArrayList<Integer> L1) {
    sumarNivel(raiz, 0, L1);
  }

  private void sumarNivel(Nodo p, int nivel, ArrayList<Integer> L1) {
    if (p == null) {
      return;
    }
    if (nivel >= L1.size()) {
      L1.add(p.elem);
    } else {
      L1.set(nivel, L1.get(nivel) + p.elem);
    }
    sumarNivel(p.izq, nivel + 1, L1);
    sumarNivel(p.der, nivel + 1, L1);
  }

  /**
   * 19. A1.alturaMayor(): Método que devuelve la altura del árbol A1.(Altura es
   * la máxima longitud de la raíz a un nodo hoja en el árbol)
   */
  public int alturaMayor() {
    return alturaMayor(raiz);
  }

  private int alturaMayor(Nodo p) {
    if (p == null) {
      return -1;
    }
    int izq = alturaMayor(p.izq);
    int der = alturaMayor(p.der);
    return 1 + Math.max(izq, der);
  }

  /**
   * 20. A1.alturaMenor(): Método que devuelve la menor altura del árbol A1.
   */
  public int alturaMenor() {
    return alturaMenor(raiz);
  }

  private int alturaMenor(Nodo p) {
    if (p == null) {
      return -1;
    }
    if (p.izq == null && p.der == null) {
      return 0;
    }
    int izq = (p.izq != null) ? alturaMenor(p.izq) : Integer.MAX_VALUE;
    int der = (p.der != null) ? alturaMenor(p.der) : Integer.MAX_VALUE;
    return 1 + Math.min(izq, der);
  }

  /**
   * 21. A1.mostrarTerm(): Método que muestra los elementos de los nodos
   * terminales del árbol A1. Mostrar los elementos de menor a mayor.
   */
  public void mostrarTerm() {
    ArrayList<Integer> lista = new ArrayList<>();
    recolectarTerminales(raiz, lista);
    Collections.sort(lista);
    for (int x : lista) {
      System.out.println(x);
    }
  }

  private void recolectarTerminales(Nodo p, ArrayList<Integer> lista) {
    if (p == null) {
      return;
    }
    if (p.izq == null && p.der == null) {
      lista.add(p.elem);
    }
    recolectarTerminales(p.izq, lista);
    recolectarTerminales(p.der, lista);
  }

  /**
   * 22. A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales
   * del árbol A1.
   */
  public int cantidadTerm() {
    return cantidadTerm(raiz);
  }

  private int cantidadTerm(Nodo p) {
    if (p == null) {
      return 0;
    }
    if (p.izq == null && p.der == null) {
      return 1;
    }
    return cantidadTerm(p.izq) + cantidadTerm(p.der);
  }

  /**
   * 23. A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol
   * degenerado o lIneal. (Se puede dar cuando se genera el árbol con una
   * secuencia ordenada de elementos)
   */
  public boolean lineal() {
    return lineal(raiz);
  }

  private boolean lineal(Nodo p) {
    if (p == null) {
      return true;
    }
    if (p.izq != null && p.der != null) {
      return false;
    }
    return lineal(p.izq) && lineal(p.der);
  }

  /**
   * 24. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a
   * x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
   */
  public int inmediatoSup(int x) {
    return inmediatoSup(raiz, x, Integer.MAX_VALUE);
  }

  private int inmediatoSup(Nodo p, int x, int sup) {
    if (p == null) {
      return sup == Integer.MAX_VALUE ? x : sup;
    }
    if (p.elem > x && p.elem < sup) {
      sup = p.elem;
    }
    if (x < p.elem) {
      return inmediatoSup(p.izq, x, sup);
    } else {
      return inmediatoSup(p.der, x, sup);
    }
  }

  /**
   * 25. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato
   * inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo
   * elemento.
   */
  public int inmediatoInf(int x) {
    return inmediatoInf(raiz, x, Integer.MIN_VALUE);
  }

  private int inmediatoInf(Nodo p, int x, int inf) {
    if (p == null) {
      return inf == Integer.MIN_VALUE ? x : inf;
    }
    if (p.elem < x && p.elem > inf) {
      inf = p.elem;
    }
    if (x > p.elem) {
      return inmediatoInf(p.der, x, inf);
    } else {
      return inmediatoInf(p.izq, x, inf);
    }
  }
}