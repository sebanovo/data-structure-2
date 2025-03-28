package tarea1;

import java.util.*;

public class Lista {
  public int[] elem;
  public int cantElem;
  public int MAX = 10000;

  public Lista() {
    this.elem = new int[MAX];
    this.cantElem = 0;
  }

  @Override
  public String toString() {
    String s = "[";
    for (int i = 0; i < this.cantElem; i++) {
      s = s + this.elem[i];
      if (i < this.cantElem - 1)
        s = s + ", ";
    }
    return s + "]";
  }

  /**
   * 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
   */
  public void insertarIesimo(int x, int i) {
    for (int k = this.cantElem - 1; k >= i; k--) {
      this.elem[k + 1] = this.elem[k];
    }
    this.elem[i] = x;
    this.cantElem++;
  }

  /**
   * 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la
   */
  public void insertarPrim(int x) {
    insertarIesimo(x, 0);
  }

  /**
   * 3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista
   * L1.
   */
  public void insertarUlt(int x) {
    this.insertarIesimo(x, this.cantElem);
  }

  /**
   * 4. L1.generarSecuencia(n, k) : Método que genera n-elementos de la Lista L1,
   * comenzando desde k y saltando de k en k. Ejemplo, Si n = 5, k = 2. L1 = [2,
   * 4, 6, 8, 10]
   */
  public void generarSecuencia(int n, int k) {
    int a = k;
    for (int i = 0; i < n; i++) {
      this.insertarUlt(a);
      a = a + k;
    }
  }

  /**
   * 5. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
   * Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7,
   * 8, 1]
   */
  public void pasarDigitos(int n) {
    if (n == 0) {
      this.insertarPrim(0);
      return;
    }
    while (n > 0) {
      int d = n % 10;
      this.insertarPrim(d);
      n /= 10;
    }
  }

  /**
   * 6. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
   */
  public void eliminarIesimo(int i) {
    for (int k = i; k < this.cantElem - 1; k++) {
      this.elem[k] = this.elem[k + 1];
    }
    this.cantElem--;
  }

  /**
   * 7. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
   */
  public void eliminarPrim() {
    this.eliminarIesimo(0);
  }

  /**
   * 8. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
   */
  public void eliminarUlt() {
    this.eliminarIesimo(this.cantElem - 1);
  }

  /**
   * 9. L1.eliminarPrim( n ) : Método que elimina los primeros n-elementos de la
   * Lista L1.
   */
  public void eliminarPrim(int n) {
    this.eliminarIesimo(n, 0);
  }

  /**
   * 10. L1.eliminarUlt( n ) : Método que elimina los últimos n-elementos de la
   * Lista L1.
   */
  public void eliminarUlt(int n) {
    for (int i = 0; i < n; i++) {
      this.eliminarIesimo(this.cantElem - 1);
    }
  }

  /**
   * 11. L1.eliminarIesimo( n, i ) : Método que elimina n-elementos sucesivos a
   * partir de la posición i, de la Lista L1.
   */
  public void eliminarIesimo(int n, int i) {
    for (int k = 0; k < n; k++) {
      this.eliminarIesimo(i);
    }
  }

  /**
   * 12. L1.eliminarPares() : Método que elimina los elementos pares de la lista
   * L1. Verificar en listas dónde todos los elementos sean pares.
   */
  public void eliminarPares() {
    for (int i = this.cantElem - 1; i >= 0; i--) {
      if (this.elem[i] % 2 == 0) {
        this.eliminarIesimo(i);
      }
    }
  }

  /**
   * 13. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo
   * una vez en la lista L1.
   */
  public void eliminarUnicos() {
    this.eliminarVeces(1);
  }

  private int encontrarIndice(int elem) {
    for (int i = 0; i < this.cantElem; i++) {
      if (this.elem[i] == elem) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 14. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista
   * L1, que aparecen en la lista L2.
   */
  public void eliminarTodo(Lista L2) {
    for (int i = 0; i < L2.cantElem; i++) {
      // [1,2,1,2,1,1,1]
      int indice = this.encontrarIndice(L2.elem[i]);
      while (indice != -1) {
        this.eliminarIesimo(indice);
        indice = this.encontrarIndice(L2.elem[i]);
      }
    }
  }

  /**
   * 15. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1
   * n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar
   * y eliminar por los extremos de la Lista.
   */
  public void rotarDerIzq(int n) {
    for (int i = 0; i < n; i++) {
      int primer = this.elem[0];
      this.eliminarPrim();
      this.insertarUlt(primer);
    }
  }

  /**
   * 16. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1
   * n-veces de derecha a izquierda.
   */
  public void rotarIzqDer(int n) {
    for (int i = 0; i < n; i++) {
      int ultimo = this.elem[this.cantElem - 1];
      this.eliminarUlt();
      this.insertarPrim(ultimo);
    }
  }

  /**
   * 17. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista
   * L2 en la lista L1, desde la posición i.
   */
  public void insertarIesimo(Lista L2, int i) {
    for (int k = 0; k < L2.cantElem; k++) {
      this.insertarIesimo(L2.elem[k], i);
    }
  }

  /**
   * 18. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al
   * principio de la lista L1.
   */
  public void insertarPrim(Lista L2) {
    this.insertarIesimo(L2, 0);
  }

  /**
   * 19. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al
   * final de la lista L1.
   */
  public void insertarUlt(Lista L2) {
    this.insertarIesimo(L2, this.cantElem - 1);
  }

  /**
   * 20. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los
   * extremos de la lista L1.
   */
  public void eliminarExtremos(int n) {
    this.eliminarPrim(n);
    this.eliminarUlt(n);
  }

  /**
   * 21. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten
   * k-veces en la lista L1.
   */
  public void eliminarVeces(int k) {
    Map<Integer, Integer> diccionario = new HashMap<>();
    for (int i = 0; i < this.cantElem; i++) {
      diccionario.put(this.elem[i], diccionario.getOrDefault(this.elem[i], 0) + 1);
    }

    int nuevaLongitud = 0;
    for (int i = 0; i < this.cantElem; i++) {
      if (diccionario.get(this.elem[i]) != k) {
        this.elem[nuevaLongitud] = this.elem[i];
        nuevaLongitud++;
      }
    }

    this.cantElem = nuevaLongitud;
  }

  /**
   * Adicionar al menos 5 ejercicios adicionales cualesquiera, interesantes.
   */

  /**
   * 1. invertir() : Método que invertierte el orden de los elementos
   */
  public void invertir() {
    int a = 0;
    int b = this.cantElem - 1;
    while (a < b) {
      int temp = this.elem[a];
      this.elem[a] = this.elem[b];
      this.elem[b] = temp;
      a++;
      b--;
    }
  }

  /**
   * 2. ordenamientoBurbuja() : Método que ordena los elementos de la lista (menor
   * a mayor)
   */
  public void ordenamientoBurbuja() {
    for (int i = 1; i < this.cantElem; i++) {
      for (int j = 0; j < this.cantElem - 1; j++) {
        if (this.elem[j] > this.elem[j + 1]) {
          int temp = this.elem[j];
          this.elem[j] = this.elem[j + 1];
          this.elem[j + 1] = temp;
        }
      }
    }
  }

  /**
   * 3. busquedaBinaria(k) : Método que busca si existe el elemento en la lista
   */
  public Boolean busquedaBinaria(int k) {
    int izquierda = 0;
    int derecha = this.cantElem - 1;

    while (izquierda <= derecha) {
      int medio = izquierda + (derecha - izquierda) / 2;

      if (this.elem[medio] == k) {
        return true;
      }
      if (this.elem[medio] > k) {
        derecha = medio - 1;
      } else {
        izquierda = medio + 1;
      }
    }
    return false;
  }

  /**
   * 4. repetirKVeces(k): Meotod que repite los elementos de la Lista
   * Ejemplos: v = [1,2,3] | k = 3 => v[1,1,1,2,2,2,3,3,3]
   */
  public void repetirKVeces(int k) {
    int longitud = this.cantElem * k;
    int[] lista = new int[MAX];

    int indice = 0;
    for (int i = 0; i < this.cantElem; i++) {
      for (int j = 0; j < k; j++) {
        lista[indice] = this.elem[i];
        indice++;
      }
    }

    this.elem = lista;
    this.cantElem = longitud;
  }

  /**
   * 5. generarSerieRegresiva(n): Metodo que genera esta seríe
   * [1, 21, 321, 4321, 54321]
   */
  public void generarSerieRegresiva(int n) {
    this.cantElem = n;
    for (int i = 0; i < n; i++) {
      int numero = i + 1;
      int resultado = 0;
      while (numero > 0) {
        resultado = resultado * 10 + numero;
        numero = numero - 1;
      }
      this.elem[i] = resultado;
    }
  }
}
