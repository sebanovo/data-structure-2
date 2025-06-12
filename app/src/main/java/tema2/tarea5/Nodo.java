package tema2.tarea5;

public class Nodo {
  Nodo izq, der;
  String elem;
  int frec;

  public Nodo(String x) {
    this.elem = x;
    this.frec = 1;
    this.izq = this.der = null;
  }
}