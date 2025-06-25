package modelos.examen3;

public class Arbol {

  Nodo raiz;

  public Arbol() {
    this.raiz = null;
  }

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
   * ##################################
   * # Al menos 5 metodos de consulta #
   * ##################################
   */

  /**
   * 1. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
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
   * 2. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
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
   * 3. A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales
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
   * 4. A1.menor() : Método que devuelve el elemento menor del árbol A1.
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
   * 5. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
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
   * ##################################
   * # Al menos 5 metodos de eliminar #
   * ##################################
   */
  private Nodo eliminarNodo(Nodo p) {
    if (p.izq == null && p.der == null) {
      return null;
    }
    if (p.izq == null && p.der != null) {
      return p.der;
    }
    if (p.izq != null && p.der == null) {
      return p.izq;
    }
    Nodo q = p.der;
    while (q.izq != null) {
      q = q.izq;
    }
    p.der = eliminar(q.elem, p.der);
    p.elem = q.elem;
    return p;
  }

  /*
   * 1. A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
   */
  public void eliminar(int x) {
    raiz = eliminar(x, raiz);
  }

  private Nodo eliminar(int x, Nodo p) {
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

  /*
   * 2. eliminarMenor() : Método que eliminar el nodo menor del arbol
   */
  public void eliminarMenor() {
    raiz = eliminarMenor(raiz);
  }

  private Nodo eliminarMenor(Nodo p) {
    if (p == null)
      return null;
    if (p.izq == null) {
      return p.der;
    }
    p.izq = eliminarMenor(p.izq);
    return p;
  }

  /*
   * 3. eliminarMayor() : Método que eliminar el nodo mayor del arbol
   */
  public void eliminarMayor() {
    raiz = eliminarMayor(raiz);
  }

  private Nodo eliminarMayor(Nodo p) {
    if (p == null)
      return null;
    if (p.der == null) {
      return p.izq;
    }
    p.der = eliminarMayor(p.der);
    return p;
  }

  /*
   * 4. A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
   */
  public void eliminarPares() {
    raiz = eliminarPares(raiz);
  }

  private Nodo eliminarPares(Nodo p) {
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
   * 5. A1.eliminarImpares() : Método que elimina los elementos impares del árbol
   * A1.
   */
  public void eliminarImpares() {
    raiz = eliminarImpares(raiz);
  }

  private Nodo eliminarImpares(Nodo p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarImpares(p.izq);
    p.der = eliminarImpares(p.der);
    if (p.elem % 2 == 1) {
      return eliminarNodo(p);
    }
    return p;
  }
}