package modelos.examen3;

public class NodoF {
  int elem, frec;
  NodoF izq, der;

  public NodoF(int x) {
    this.elem = x;
    this.frec = 1;
    this.izq = this.der = null;
  }
}
