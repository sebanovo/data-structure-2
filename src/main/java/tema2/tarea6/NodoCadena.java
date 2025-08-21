package tema2.tarea6;

public class NodoCadena {
  NodoCadena izq, der;
  String elem;
  int frec;

  public NodoCadena(String x) {
    this.elem = x;
    this.frec = 1;
    this.izq = this.der = null;
  }
}