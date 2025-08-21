package tema2.tarea4;

import java.util.Random;

public class Lista {
  public Arbol[] elem;
  public int cantElem;
  public int MAX = 10;

  public Lista() {
    this.elem = new Arbol[MAX];
    for (int i = 0; i < MAX; i++) {
      this.elem[i] = new Arbol();
    }
    this.cantElem = 0;
  }

  public void insertar(int x) {
    int digitoFinal = Math.abs(x % 10);
    elem[digitoFinal].insertar(x);
    cantElem++;
  }

  public void generarElemRandom(int n, int a, int b) {
    for (int i = 0; i < n; i++) {
      Random random = new Random();
      int numeroAleatorio = a + random.nextInt(b - a + 1);
      insertar(numeroAleatorio);
    }
  }

  public void mostrarMenorMayor() {
    for (int i = 0; i < MAX; i++) {
      if (elem[i] == null)
        continue;

      elem[i].mostrarMenorMayor();
    }
  }

  public void mostrarMayorMenor() {
    for (int i = 0; i < MAX; i++) {
      elem[i].mostrarMayorMenor();
    }
  }
}
