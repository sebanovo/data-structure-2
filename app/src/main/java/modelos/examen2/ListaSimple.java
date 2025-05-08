package modelos.examen2;

public class ListaSimple {
  public NodoSimple prim;
  public int cantElem;
  public NodoSimple ult;

  public ListaSimple() {
    prim = ult = null;
    cantElem = 0;
  }

  // iterativo
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

  // recursivo
  public String toString1() {
    return "[" + toStringR(this.prim) + "]";
  }

  private String toStringR(NodoSimple p) {
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

  public void insertarUlt(int x) {
    if (vacia()) {
      prim = ult = new NodoSimple(x, null);
    } else {
      ult = ult.prox = new NodoSimple(x, null);
    }
    cantElem++;
  }

  // 1
  // iterativo
  public int frecuencia(int x) {
    NodoSimple p = prim;
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

  private int frecuenciaR(NodoSimple p, int x) {
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
    NodoSimple p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) == this.cantElem)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean iguales1() {
    return igualesR(prim);
  }

  private boolean igualesR(NodoSimple p) {
    if (p == null) {
      return true;
    } else {
      if (this.frecuencia(p.elem) == this.cantElem)
        return true;
      return igualesR(p.prox);
    }
  }

  // 3
  // iterativo
  public boolean diferentes() {
    NodoSimple p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) > 1)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean diferentes1() {
    return diferentesR(prim);
  }

  private boolean diferentesR(NodoSimple p) {
    if (p == null) {
      return true;
    } else {
      if (this.frecuencia(p.elem) > 1)
        return false;
      return diferentesR(p.prox);
    }
  }

  // 4
  // iterativo
  public int mayorElem() {
    NodoSimple p = prim;
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

  private int mayorElemR(NodoSimple p, int mayor) {
    if (p == null) {
      return mayor;
    } else {
      if (mayor < p.elem) {
        mayor = p.elem;
      }
      return mayorElemR(p.prox, mayor);
    }
  }

  // 5
  // iterativo
  public boolean pares() {
    NodoSimple p = prim;
    while (p != null) {
      if (p.elem % 2 != 0)
        return false;

      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean pares1() {
    return paresR(prim);
  }

  private boolean paresR(NodoSimple p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 0) {
        return false;
      }
      return paresR(p.prox);
    }
  }
}
