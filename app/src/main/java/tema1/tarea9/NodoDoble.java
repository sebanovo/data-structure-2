package tema1.tarea9;

public class NodoDoble {
  public NodoDoble ant;
  public int elem;
  public NodoDoble prox;

  public NodoDoble(NodoDoble ant, int elem, NodoDoble prox) {
    this.ant = ant;
    this.elem = elem;
    this.prox = prox;
  }
}
