package tema2.tarea4;

public class Arbol {

  Nodo raiz;

  public Arbol() {
    this.raiz = null;
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

  public void mostrarMenorMayor() {
    mostrarMenorMayor(raiz);
  }

  private void mostrarMenorMayor(Nodo p) {
    if (p == null) {
      return;
    }
    mostrarMenorMayor(p.izq);
    System.out.print(p.elem + "\n");
    mostrarMenorMayor(p.der);
  }

  public void mostrarMayorMenor() {
    mostrarMayorMenor(raiz);
  }

  private void mostrarMayorMenor(Nodo p) {
    if (p == null) {
      return;
    }
    mostrarMayorMenor(p.der);
    System.out.print(p.elem + "\n");
    mostrarMayorMenor(p.izq);
  }
}