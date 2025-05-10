package tarea10;

public class ListaDoble {
  public Nodo prim;
  public int cantElem;
  public Nodo ult;

  public ListaDoble() {
    prim = ult = null;
    cantElem = 0;
  }

  public String mostrarMenorAMayor() {
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

  public String mostrarMayorAMenor() {
    String s = "[";
    Nodo p = ult;
    while (p != null) {
      s = s + p.elem;
      if (p.ant != null) {
        s = s + ", ";
      }
      p = p.ant;
    }
    return s + "]";
  }

  public boolean vacia() {
    return this.cantElem == 0;
  }

  public void insertarPrim(String x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      prim = prim.ant = new Nodo(null, x, prim);
    }
    this.cantElem++;
  }

  public void insertarUlt(String x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      ult = ult.prox = new Nodo(ult, x, null);
    }
    this.cantElem++;
  }

  private void insertarNodo(Nodo ap, Nodo p, String x) {
    if (ap == null) {
      insertarPrim(x);
    } else if (p == null) {
      insertarUlt(x);
    } else {
      ap.prox = p.ant = new Nodo(ap, x, p);
      cantElem++;
    }
  }

  public void insertarLugarAsc(String x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null && x.compareTo(p.elem) > 0) {
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }
}
