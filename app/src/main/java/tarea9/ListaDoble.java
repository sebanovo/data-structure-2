package tarea9;

public class ListaDoble {
  public NodoDoble prim;
  public int cantElem;
  public NodoDoble ult;

  public ListaDoble() {
    prim = ult = null;
    cantElem = 0;
  }

  @Override
  public String toString() {
    String s = "[";
    NodoDoble p = prim;
    while (p != null) {
      s = s + p.elem;
      if (p.prox != null) {
        s = s + ", ";
      }
      p = p.prox;
    }
    return s + "]";
  }

  public boolean vacia() {
    return this.cantElem == 0;
  }

  // 1. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
  // iterativo y recursivo
  public void eliminarPrim() {
    if (vacia()) {
      return;
    }
    if (prim == ult) {
      prim = ult = null;
    } else {
      prim.prox.ant = null;
      prim = prim.prox;
    }
    cantElem--;
  }

  // 2. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
  // iterativo y recursivo
  public void eliminarUlt() {
    if (vacia()) {
      return;
    }
    if (prim == ult) {
      prim = ult = null;
    } else {
      ult.ant.prox = null;
      ult = ult.ant;
    }
    cantElem--;
  }

  // 3. L1.eliminarNodo(ap, p) : Método que elimina el nodo p, y devuelve el nodo
  // siguiente a ap. El nodo p, puede estar al principio, final o al centro de la
  // lista.
  // iterativo y recursivo
  public NodoDoble eliminarNodoDoble(NodoDoble ap, NodoDoble p) {
    if (ap == null) {
      eliminarPrim();
      return prim;
    }
    if (p.prox == null) {
      eliminarUlt();
      return null;
    } else {
      ap.prox = p.prox;
      p.prox.ant = ap;
      cantElem--;
      return ap.prox;
    }
  }

  // 4. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
  // lista L1.
  // iterativo
  public void eliminarTodo(int x) {
    NodoDoble p = prim;
    NodoDoble ap = null;
    while (p != null) {
      if (p.elem == x) {
        p = eliminarNodoDoble(ap, p);
      } else {
        ap = p;
        p = p.prox;
      }
    }
  }

  // recursivo
  public void eliminarTodo1(int x) {
    eliminarTodoR(null, prim, x);
  }

  public void eliminarTodoR(NodoDoble ap, NodoDoble p, int x) {
    if (p == null) {
      return;
    }

    if (p.elem == x) {
      p = eliminarNodoDoble(ap, p);
    } else {
      ap = p;
      p = p.prox;
    }
    eliminarTodoR(ap, p, x);
  }

  // 5. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la
  // lista L1.
  // iterativo
  public void eliminarPrim(int n) {
    for (int i = 0; i < n; i++) {
      eliminarPrim();
    }
  }

  // recursivo
  public void eliminarPrim1(int n) {
    eliminarPrimR(0, n);
  }

  public void eliminarPrimR(int i, int n) {
    if (i >= n) {
      return;
    }
    eliminarPrim();
    eliminarPrimR(i + 1, n);
  }

  // 6. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la
  // lista L1.
  // iterativo
  public void eliminarUlt(int n) {
    for (int i = 0; i < n; i++) {
      eliminarUlt();
    }
  }

  public void eliminarUlt1(int n) {
    eliminarUltR(0, n);
  }

  // recursivo
  public void eliminarUltR(int i, int n) {
    if (i >= n) {
      return;
    }
    eliminarUlt();
    eliminarUltR(i + 1, n);
  }

  // 7. L1.eliminarIesimo(i) : Método que elimina el i-ésimo elemento de la lista
  // L1.
  // iterativo
  public void eliminarIesimo(int i) {
    int k = 0;
    NodoDoble p = prim;
    NodoDoble ap = null;
    while (k < i) {
      k = k + 1;
      ap = p;
      p = p.prox;
    }
    eliminarNodoDoble(ap, p);
  }

  // recursivo
  public void eliminarIesimo1(int i) {
    eliminarIesimoR(0, i, null, prim);
  }

  public void eliminarIesimoR(int k, int i, NodoDoble ap, NodoDoble p) {
    if (k >= i) {
      eliminarNodoDoble(ap, p);
    } else {
      eliminarIesimoR(k + 1, i, p, p.prox);
    }
  }

  // 8. L1.eliminarUnicos() : Método que elimina los elementos que no se repiten
  // en la Lista L1.
  // iterativo
  public void eliminarUnicos() {
    NodoDoble p = prim;
    NodoDoble ap = null;
    while (p != null) {
      if (frecuencia(p.elem) == 1) {
        p = eliminarNodoDoble(ap, p);
      } else {
        ap = p;
        p = p.prox;
      }
    }
  }

  public int frecuencia(int x) {
    int frecuencia = 0;
    NodoDoble p = prim;
    while (p != null) {
      if (p.elem == x) {
        frecuencia = frecuencia + 1;
      }
      p = p.prox;
    }
    return frecuencia;
  }

  // recursivo
  public void eliminarUnicos1() {
    eliminarUnicosR(null, prim);
  }

  public void eliminarUnicosR(NodoDoble ap, NodoDoble p) {
    if (p == null) {
      return;
    }
    if (frecuencia1(p.elem) == 1) {
      p = eliminarNodoDoble(ap, ap);
    } else {
      ap = p;
      p = p.prox;
    }
    eliminarUnicosR(ap, p);
  }

  public int frecuencia1(int x) {
    return frecuencia1(prim, x);
  }

  public int frecuencia1(NodoDoble p, int x) {
    if (p == null) {
      return 0;
    } else {
      int frecuencia = frecuencia1(p.prox, x);
      if (p.elem == x) {
        frecuencia += 1;
      }
      return frecuencia;
    }
  }

  // 9. L1.eliminarDup() : Método que elimina los elementos que se repiten en la
  // Lista L1.
  // iterativo
  public void eliminarDup() {
    NodoDoble p = prim;
    while (p != null) {
      if (frecuencia(p.elem) > 1) {
        eliminarTodo(p.elem);
        p = prim;
      } else {
        p = p.prox;
      }

    }
  }

  // recursivo
  public void eliminarDup1() {
    eliminarDupR(prim);
  }

  public void eliminarDupR(NodoDoble p) {
    if (p == null) {
      return;
    }
    if (frecuencia1(p.elem) > 1) {
      eliminarTodo1(p.elem);
      p = prim;
    } else {
      p = p.prox;
    }
    eliminarDupR(p);
  }

  // 10- L1.eliminar(L2) : Método que elimina los elementos de la Lista L1, que se
  // encuentran en L2.
  // iterativo
  public void eliminar(ListaDoble L2) {
    NodoDoble p = L2.prim;
    while (p != null) {
      eliminarTodo(p.elem);
      p = p.prox;
    }
  }

  // recursivo
  public void eliminar1(ListaDoble L2) {
    eliminarR(L2.prim);
  }

  public void eliminarR(NodoDoble p) {
    if (p == null) {
      return;
    }
    eliminarTodo(p.elem);
    eliminarR(p.prox);
  }
}
