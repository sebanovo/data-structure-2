package tema2.tarea6;

public class NodoEntero {
  NodoEntero izq, der;
  int elem;

  public NodoEntero(int x) {
    this.elem = x;
    this.izq = this.der = null;
  }
}