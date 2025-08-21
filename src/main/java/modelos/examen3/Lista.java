package modelos.examen3;

public class Lista {
  public ArbolF[] elem;
  public int cantElem;
  public int MAX = 10;

  public Lista() {
    this.elem = new ArbolF[MAX];
    for (int i = 0; i < MAX; i++) {
      this.elem[i] = new ArbolF();
    }
    this.cantElem = 0;
  }

  public void inOrden() {
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      elem[i].inOrden();
    }
  }

  public void insertar(int x) {
    int digitoFinal = Math.abs(x % 10);
    elem[digitoFinal].insertar(x);
    cantElem++;
  }

  /*
   * ######################################################
   * # Al menos 5 metodos de consulta sobre una Lista ABB #
   * ######################################################
   */

  /*
   * 1. L1.totalFrecuencias() : Suma todas las frecuencias de todos los arboles de
   * frecuencia
   */
  public int totalFrecuencias() {
    int total = 0;
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      total += elem[i].totalFrecuencia();
    }
    return total;
  }

  /*
   * 2. L1.totalFrecuenciasPares() : Suma todas las frecuencias pares de todos los
   * arboles de
   * frecuencia
   */
  public int totalFrecuenciasPares() {
    int total = 0;
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      int frec = elem[i].totalFrecuencia();
      if (frec % 2 == 0) {
        total += frec;
      }
    }
    return total;
  }

  /*
   * 3. L1.totalFrecuenciasImpares() : Suma todas las frecuencias impares de todos
   * los arboles de
   * frecuencia
   */
  public int totalFrecuenciasImpares() {
    int total = 0;
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      int frec = elem[i].totalFrecuencia();
      if (frec % 2 == 1) {
        total += frec;
      }
    }
    return total;
  }

  /*
   * 4. L1.frecuenciaMayor() : Devuelve la frecuencia mayor de todos los arboles
   */
  public int frecuenciaMayor() {
    int frecM = 0;
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      int frec = elem[i].totalFrecuencia();
      if (frecM < frec) {
        frecM = frec;
      }
    }
    return frecM;
  }

  /*
   * 5. L1.frecuenciaMenor() : Devuelve la frecuencia menor de todos los arboles
   */
  public int frecuenciaMenor() {
    int frecM = Integer.MAX_VALUE;
    for (int i = 0; i < MAX; i++) {
      if (elem[i].raiz == null)
        continue;
      int frec = elem[i].totalFrecuencia();
      if (frecM > frec) {
        frecM = frec;
      }
    }
    return frecM;
  }
}