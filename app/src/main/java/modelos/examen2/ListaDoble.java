package modelos.examen2;

public class ListaDoble {
  public Nodo prim;
  public int cantElem;
  public Nodo ult;

  public ListaDoble() {
    prim = ult = null;
    cantElem = 0;
  }

  // iterativo
  public String toString() {
    String s = "[";
    Nodo p = prim;
    while (p != null) {
      s = s + p.elem;
      if (p.prox != null) {
        s = s + ", ";
      }
      p = p.prox;
    }
    return s + "]";
  }

  // recursivo
  public String toString1() {
    return "[" + toStringR(this.prim) + "]";
  }

  private String toStringR(Nodo p) {
    String s = "";
    if (p == null) {
      return s;
    } else {
      s = s + p.elem;
      if (p.prox != null) {
        s = s + ", ";
      }
      return s + toStringR(p.prox);
    }
  }

  public boolean vacia() {
    return this.cantElem == 0;
  }

  // metodos de insertar
  public void insertarPrim(int x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      prim = prim.ant = new Nodo(null, x, prim);
    }
    this.cantElem++;
  }

  public void insertarUlt(int x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      ult = ult.prox = new Nodo(ult, x, null);
    }
    this.cantElem++;
  }

  private void insertarNodo(Nodo ap, Nodo p, int x) {
    if (ap == null) {
      insertarPrim(x);
    } else if (p == null) {
      insertarUlt(x);
    } else {
      ap.prox = p.ant = new Nodo(ap, x, p);
      cantElem++;
    }
  }

  public void insertarIesimo(int x, int i) {
    int k = 0;
    Nodo p = prim;
    Nodo ap = null;
    while (k < i && p != null) {
      k = k + 1;
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  // 5 metodos de consulta

  // 1
  // iterativo
  public int frecuencia(int x) {
    Nodo p = prim;
    int frecuencia = 0;
    while (p != null) {
      if (p.elem == x) {
        frecuencia++;
      }
      p = p.prox;
    }
    return frecuencia;
  }

  // recursivo
  public int frecuencia1(int x) {
    return frecuenciaR(prim, x);
  }

  private int frecuenciaR(Nodo p, int x) {
    if (p == null) {
      return 0;
    } else {
      int frecuencia = frecuenciaR(p.prox, x);
      if (p.elem == x) {
        frecuencia++;
      }
      return frecuencia;
    }
  }

  // 2
  // iterativo
  public boolean iguales() {
    Nodo p = prim;
    while (p != null) {
      if (frecuencia(p.elem) != this.cantElem)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean iguales1() {
    return igualesR(prim);
  }

  private boolean igualesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (frecuencia1(p.elem) != this.cantElem)
        return false;
      return igualesR(p.prox);
    }
  }

  // 3
  // iterativo
  public boolean diferentes() {
    Nodo p = prim;
    while (p != null) {
      if (frecuencia1(p.elem) > 1)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean diferentes1() {
    return diferentesR(prim);
  }

  private boolean diferentesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (frecuencia1(p.elem) > 1)
        return false;
      return diferentesR(p.prox);
    }
  }

  // 4
  // iterativo
  public int mayorElem() {
    Nodo p = prim;
    int mayor = p.elem;
    while (p != null) {
      if (mayor < p.elem) {
        mayor = p.elem;
      }
      p = p.prox;
    }
    return mayor;
  }

  // recursivo
  public int mayorElem1() {
    return mayorElemR(prim, prim.elem);
  }

  private int mayorElemR(Nodo p, int mayor) {
    if (p == null) {
      return mayor;
    } else {
      if (mayor < p.elem) {
        mayor = p.elem;
      }
      return mayorElemR(p.prox, mayor);
    }
  }

  // 4
  // iterativo
  public int menorElem() {
    Nodo p = prim;
    int menor = p.elem;
    while (p != null) {
      if (menor > p.elem) {
        menor = p.elem;
      }
      p = p.prox;
    }
    return menor;
  }

  // recursivo
  public int menorElem1() {
    return menorElemR(prim, prim.elem);
  }

  private int menorElemR(Nodo p, int menor) {
    if (p == null) {
      return menor;
    } else {
      if (menor > p.elem) {
        menor = p.elem;
      }
      return menorElemR(p.prox, menor);
    }
  }

  // metodos de eliminacion
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

  public Nodo eliminarNodo(Nodo ap, Nodo p) {
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

  public void eliminarIesimo(int i) {
    int k = 0;
    Nodo p = prim;
    Nodo ap = null;
    while (k < i) {
      k = k + 1;
      ap = p;
      p = p.prox;
    }
    eliminarNodo(ap, p);
  }

  // 5 metodos de eliminacion

  // 1
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

  // 2
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

  // 3
  // iterativo
  public void eliminarTodo(int x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null) {
      if (p.elem == x) {
        p = eliminarNodo(ap, p);
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

  public void eliminarTodoR(Nodo ap, Nodo p, int x) {
    if (p == null) {
      return;
    }

    if (p.elem == x) {
      p = eliminarNodo(ap, p);
    } else {
      ap = p;
      p = p.prox;
    }
    eliminarTodoR(ap, p, x);
  }

  // 4
  // iterativo
  public void eliminarUnicos() {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null) {
      if (frecuencia(p.elem) == 1) {
        p = eliminarNodo(ap, p);
      } else {
        ap = p;
        p = p.prox;
      }
    }
  }

  // recursivo
  public void eliminarUnicos1() {
    eliminarUnicosR(null, prim);
  }

  public void eliminarUnicosR(Nodo ap, Nodo p) {
    if (p == null) {
      return;
    }
    if (frecuencia1(p.elem) == 1) {
      p = eliminarNodo(ap, ap);
    } else {
      ap = p;
      p = p.prox;
    }
    eliminarUnicosR(ap, p);
  }

  // 5
  // iterativo
  public void eliminarDup() {
    Nodo p = prim;
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

  public void eliminarDupR(Nodo p) {
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
}
