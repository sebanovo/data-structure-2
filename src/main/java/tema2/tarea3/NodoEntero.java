package tema2.tarea3;

public class NodoEntero {
  NodoEntero izq, der;
  int elem;
  int frec;

  public NodoEntero(int x) {
    this.elem = x;
    this.frec = 1;
    this.izq = this.der = null;
  }
}
