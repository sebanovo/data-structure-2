package tema2.tarea2;

public class Nodo {
  int elem;
  Nodo izq, der;

  public Nodo(int x) {
    this.elem = x;
    this.izq = this.der = null;
  }
}
