package tema2.tarea5;

public class Arbol {

  public Nodo raiz;

  public Arbol() {
    raiz = null;
  }

  public void insertar(String x) {
    raiz = insertar(x, raiz);
  }

  private Nodo insertar(String x, Nodo p) {
    if (p == null) {
      return new Nodo(x);
    }
    if (x.compareTo(p.elem) < 0) {
      p.izq = insertar(x, p.izq);
    } else if (x.compareTo(p.elem) > 0) {
      p.der = insertar(x, p.der);
    } else {
      p.frec++;
    }
    return p;
  }

  public void mostrarMenorMayor() {
    mostrarMenorMayor(raiz);
    System.out.print('\n');
  }

  private void mostrarMenorMayor(Nodo p) {
    if (p == null) {
      return;
    }
    mostrarMenorMayor(p.izq);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMenorMayor(p.der);
  }

  public void mostrarMayorMenor() {
    mostrarMayorMenor(raiz);
    System.out.print('\n');
  }

  private void mostrarMayorMenor(Nodo p) {
    if (p == null) {
      return;
    }
    mostrarMayorMenor(p.der);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMayorMenor(p.izq);
  }

}