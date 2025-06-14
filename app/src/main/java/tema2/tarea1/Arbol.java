package tema2.tarea1;

public class Arbol {
  Nodo raiz;

  public Arbol() {
    this.raiz = null;
  }

  /*
   * 1. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su
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
    } else {
      p.der = insertar(x, p.der);
    }
    return p;
  }

  /*
   * 2. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
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

  /*
   * 3. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
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

  /*
   * 4. A1.postOrden() : Método que muestra los elementos del árbol A1 en
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

  public boolean seEncuentra(int x) {
    return seEncuentra(x, raiz);
  }

  /*
   * 5. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se
   * encuentra en el árbol A1.
   */
  public boolean seEncuentra(int x, Nodo p) {
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

  /*
   * 6. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
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

  /*
   * 7. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
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

  /*
   * 8. A1.menor() : Método que devuelve el elemento menor del árbol A1.
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

  /*
   * 9. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
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

  /*
   * 10. A1.cantidadTerm() : Método que devuelve la cantidad de nodos terminales
   * del árbol A1.
   */
  public int cantidadTerm() {
    return cantidadTerm(raiz);
  }

  private int cantidadTerm(Nodo p) {
    if (p == null) {
      return 0;
    }

    if (esHoja(p)) {
      return 1;
    }

    int cantIzq = cantidadTerm(p.izq);
    int cantDer = cantidadTerm(p.der);
    return cantIzq + cantDer;
  }

  private boolean esHoja(Nodo p) {
    return p.izq == null && p.der == null;
  }

  /*
   * 11. A1.sumaPares() : Método que devuelve la suma de los elementos pares del
   * árbol A1.
   */
  public int sumaPares() {
    return sumaPares(raiz);
  }

  private int sumaPares(Nodo p) {
    if (p == null) {
      return 0;
    }
    if (p.elem % 2 == 0) {
      return sumaPares(p.izq) + sumaPares(p.der) + p.elem;
    }
    return sumaPares(p.izq) + sumaPares(p.der);
  }

  /*
   * 12. Al menos 5 métodos adicionales cualesquiera, interesantes.
   */
  /*
   * 1. A1.Altura() : Método que devuelva la altura del arbol
   */
  public int altura() {
    return altura(raiz);
  }

  private int altura(Nodo p) {
    if (p == null) {
      return 0;
    }
    int altIzq = altura(p.izq);
    int altDer = altura(p.der);
    return Math.max(altIzq, altDer) + 1;
  }

  /*
   * 2. A1.contarPares() : Método que cuenta los pares del arbol
   */
  public int contarPares() {
    return contarPares(raiz);
  }

  private int contarPares(Nodo p) {
    if (p == null) {
      return 0;
    }
    int suma = contarPares(p.izq) + contarPares(p.der);
    if (p.elem % 2 == 0) {
      suma++;
    }
    return suma;
  }

  /*
   * 3. A1.contarImpares() : Método que cuenta los impares del arbol
   */
  public int contarImpares() {
    return contarImpares(raiz);
  }

  private int contarImpares(Nodo p) {
    if (p == null) {
      return 0;
    }
    int suma = contarImpares(p.izq) + contarImpares(p.der);
    if (p.elem % 2 != 0) {
      suma++;
    }
    return suma;
  }

  /*
   * 4. A1.soloHijosIzquierdos() : Método que verifica que el arbol solo tenga
   * hijos izquierdos
   */
  public void soloHijosIzquierdos() {
    soloHijosIzquierdos(raiz);
    System.out.println();
  }

  private void soloHijosIzquierdos(Nodo p) {
    if (p == null) {
      return;
    }

    if (p.izq != null && p.der == null) {
      System.out.print(p.elem + ", ");
    }

    soloHijosIzquierdos(p.izq);
    soloHijosIzquierdos(p.der);
  }

  /*
   * 4. A1.soloHijosDerechos() : Método que verifica que el arbol solo tenga hijos
   * derechos
   */
  public void soloHijosDerechos() {
    soloHijosDerechos(raiz);
    System.out.println();
  }

  private void soloHijosDerechos(Nodo p) {
    if (p == null) {
      return;
    }

    if (p.der != null && p.izq == null) {
      System.out.print(p.elem + ", ");
    }

    soloHijosDerechos(p.izq);
    soloHijosDerechos(p.der);
  }
}