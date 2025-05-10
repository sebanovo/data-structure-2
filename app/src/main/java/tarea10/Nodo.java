package tarea10;

public class Nodo {
  Nodo prox;
  String elem;
  Nodo ant;

  public Nodo(Nodo ant, String elem, Nodo prox) {
    this.ant = ant;
    this.elem = elem;
    this.prox = prox;
  }
}
