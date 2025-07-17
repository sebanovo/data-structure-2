package modelos.examen3;

public class ArbolF {

  public NodoF raiz;

  public ArbolF() {
    raiz = null;
  }

  public void inOrden() {
    inOrden(raiz);
    System.out.print('\n');
  }

  private void inOrden(NodoF p) {
    if (p == null) {
      return;
    }
    inOrden(p.izq);
    System.out.print(p.elem + " - " + p.frec + '\n');
    inOrden(p.der);
  }

  public void insertar(int x) {
    raiz = insertar(x, raiz);
  }

  private NodoF insertar(int x, NodoF p) {
    if (p == null) {
      return new NodoF(x);
    }
    if (x < p.elem) {
      p.izq = insertar(x, p.izq);
    } else if (x > p.elem) {
      p.der = insertar(x, p.der);
    } else {
      p.frec++;
    }
    return p;
  }

  /*
   * #######################################
   * # Al menos 5 metodos sobre frecuencia #
   * #######################################
   */
  /*
   * 1. A1.totalFrecuencia()
   * Suma total de todas las frecuencias del árbol. Representa la cantidad total
   * de inserciones, contando repeticiones.
   */
  public int totalFrecuencia() {
    return totalFrecuencia(raiz);
  }

  private int totalFrecuencia(NodoF p) {
    if (p == null)
      return 0;
    return p.frec + totalFrecuencia(p.izq) + totalFrecuencia(p.der);
  }

  /*
   * 2. A1.contarFrecuenciaUnica()
   * Cuenta cuántos valores aparecen solo una vez (frecuencia = 1).
   */
  public int contarFrecuenciaUnica() {
    return contarFrecuenciaUnica(raiz);
  }

  private int contarFrecuenciaUnica(NodoF p) {
    if (p == null)
      return 0;
    int frecuencia = contarFrecuenciaUnica(p.izq) + contarFrecuenciaUnica(p.der);
    if (p.frec == 1) {
      return frecuencia + 1;
    }
    return frecuencia;
  }

  /*
   * 3. A1.hayFrecuencia(f)
   * Verifica si existe algún nodo con una frecuencia igual a f.
   */
  public boolean hayFrecuencia(int f) {
    return hayFrecuencia(raiz, f);
  }

  private boolean hayFrecuencia(NodoF p, int f) {
    if (p == null)
      return false;
    if (p.frec == f)
      return true;
    return hayFrecuencia(p.izq, f) || hayFrecuencia(p.der, f);
  }

  /*
   * 4. A1.frecuenciaMaxima() Obtiene la frecuencia más alta de todos los nodos.
   */
  public int frecuenciaMaxima() {
    return frecuenciaMaxima(raiz);
  }

  private int frecuenciaMaxima(NodoF p) {
    if (p == null)
      return 0;
    int izqMax = frecuenciaMaxima(p.izq);
    int derMax = frecuenciaMaxima(p.der);
    return Math.max(p.frec, Math.max(izqMax, derMax));
  }

  /*
   * 5. A1.frecuenciaMinima() Obtiene la frecuencia minima de todos los nodos.
   */
  public int frecuenciaMinima() {
    return frecuenciaMinima(raiz);
  }

  private int frecuenciaMinima(NodoF p) {
    if (p == null)
      return Integer.MAX_VALUE;
    int izqMax = frecuenciaMinima(p.izq);
    int derMax = frecuenciaMinima(p.der);
    return Math.min(p.frec, Math.min(izqMax, derMax));
  }
}
