package tarea9;

public class ListaSimple {
  public NodoSimple prim;
  public int cantElem;
  public NodoSimple ult;

  public ListaSimple() {
    prim = ult = null;
    cantElem = 0;
  }

  @Override
  public String toString() {
    String s = "[";
    NodoSimple p = prim;
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

  public void insertarUlt(int x) {
    if (vacia()) {
      prim = ult = new NodoSimple(x, null);
    } else {
      ult = ult.prox = new NodoSimple(x, null);
    }
    cantElem++;
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
      prim = prim.prox;
    }
    cantElem--;
  }

  // 2. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
  // iterativo
  public void eliminarUlt() {
    if (vacia()) {
      return;
    }
    if (prim == ult) {
      prim = ult = null;
    } else {
      NodoSimple ant = ant(ult);
      ant.prox = null;
      ult = ant;
    }
    cantElem--;
  }

  public NodoSimple ant(NodoSimple p_objetivo) {
    NodoSimple p = prim;
    NodoSimple ap = null;
    while (p != p_objetivo) {
      ap = p;
      p = p.prox;
    }
    return ap;
  }

  // recursivo
  public void eliminarUlt1() {
    if (vacia()) {
      return;
    }
    if (prim == ult) {
      prim = ult = null;
    } else {
      NodoSimple ant = ant1(ult);
      ant.prox = null;
      ult = ant;
    }
    cantElem--;
  }

  public NodoSimple ant1(NodoSimple p_actual) {
    return antR(null, prim, p_actual);
  }

  public NodoSimple antR(NodoSimple ap, NodoSimple p, NodoSimple p_objetivo) {
    if (p == p_objetivo) {
      return ap;
    } else {
      return antR(p, p.prox, p_objetivo);
    }
  }

  // 3. L1.eliminarNodo(ap, p) : Método que elimina el nodo p, y devuelve el nodo
  // siguiente a ap. El nodo p, puede estar al principio, final o al centro de la
  // lista.
  // iterativo y recursivo
  public NodoSimple eliminarNodoSimple(NodoSimple ap, NodoSimple p) {
    if (ap == null) {
      eliminarPrim();
      return prim;
    }
    if (p.prox == null) {
      eliminarUlt();
      return null;
    } else {
      ap.prox = p.prox;
      cantElem--;
      return ap.prox;
    }
  }

  // 4. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
  // lista L1.
  // iterativo
  public void eliminarTodo(int x) {
    NodoSimple p = prim;
    NodoSimple ap = null;
    while (p != null) {
      if (p.elem == x) {
        p = eliminarNodoSimple(ap, p);
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

  public void eliminarTodoR(NodoSimple ap, NodoSimple p, int x) {
    if (p == null) {
      return;
    }

    if (p.elem == x) {
      p = eliminarNodoSimple(ap, p);
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

  // recursivo
  public void eliminarUlt1(int n) {
    eliminarUltR(0, n);
  }

  public void eliminarUltR(int i, int n) {
    if (i >= n) {
      return;
    }
    eliminarUlt1();
    eliminarUltR(i + 1, n);
  }

  // 7. L1.eliminarIesimo(i) : Método que elimina el i-ésimo elemento de la lista
  // L1.
  // iterativo
  public void eliminarIesimo(int i) {
    int k = 0;
    NodoSimple p = prim;
    NodoSimple ap = null;
    while (k < i) {
      k = k + 1;
      ap = p;
      p = p.prox;
    }
    eliminarNodoSimple(ap, p);
  }

  // recursivo
  public void eliminarIesimo1(int i) {
    eliminarIesimoR(0, i, null, prim);
  }

  public void eliminarIesimoR(int k, int i, NodoSimple ap, NodoSimple p) {
    if (k >= i) {
      eliminarNodoSimple(ap, p);
    } else {
      eliminarIesimoR(k + 1, i, p, p.prox);
    }
  }

  // 8. L1.eliminarUnicos() : Método que elimina los elementos que no se repiten
  // en la Lista L1.
  // iterativo
  public void eliminarUnicos() {
    NodoSimple p = prim;
    NodoSimple ap = null;
    while (p != null) {
      if (frecuencia(p.elem) == 1) {
        p = eliminarNodoSimple(ap, p);
      } else {
        ap = p;
        p = p.prox;
      }
    }
  }

  public int frecuencia(int x) {
    int frecuencia = 0;
    NodoSimple p = prim;
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

  public void eliminarUnicosR(NodoSimple ap, NodoSimple p) {
    if (p == null) {
      return;
    }
    if (frecuencia1(p.elem) == 1) {
      p = eliminarNodoSimple(ap, ap);
    } else {
      ap = p;
      p = p.prox;
    }
    eliminarUnicosR(ap, p);
  }

  public int frecuencia1(int x) {
    return frecuencia1(prim, x);
  }

  public int frecuencia1(NodoSimple p, int x) {
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
    NodoSimple p = prim;
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

  public void eliminarDupR(NodoSimple p) {
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
  public void eliminar(ListaSimple L2) {
    NodoSimple p = L2.prim;
    while (p != null) {
      eliminarTodo(p.elem);
      p = p.prox;
    }
  }

  // recursivo
  public void eliminar1(ListaSimple L2) {
    eliminarR(L2.prim);
  }

  public void eliminarR(NodoSimple p) {
    if (p == null) {
      return;
    }
    eliminarTodo(p.elem);
    eliminarR(p.prox);
  }
}
