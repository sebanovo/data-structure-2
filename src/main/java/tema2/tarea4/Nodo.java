package tema2.tarea4;

public class Nodo {
  int elem;
  Nodo izq, der;

  public Nodo(int x) {
    this.elem = x;
    this.izq = this.der = null;
  }
}
