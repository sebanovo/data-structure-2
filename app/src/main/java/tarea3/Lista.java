package tarea3;

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
   * EJERCICIOS DE TAREA-1
   */

  /**
   * 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
   * i, de la lista L1.
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
   * lista L1.
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
   * 4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
   */
  public void eliminarIesimo(int i) {
    for (int k = i; k < this.cantElem - 1; k++) {
      this.elem[k] = this.elem[k + 1];
    }
    this.cantElem--;
  }

  /**
   * 5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
   */
  public void eliminarPrim() {
    this.eliminarIesimo(0);
  }

  /**
   * 6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
   */
  public void eliminarUlt() {
    this.eliminarIesimo(this.cantElem - 1);
  }

  /**
   * 7. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
   * lista L1.
   */
  public void eliminarTodo(int x) {
    for (int i = this.cantElem - 1; i >= 0; i--) {
      if (this.elem[i] == x) {
        this.eliminarIesimo(i);
      }
    }
  }

  /**
   * 8. L1.eliminarPares() : Método que elimina los elementos pares de la lista
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
   * 9. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo
   * una vez en la lista L1.
   */
  public void eliminarUnicos() {
    this.eliminarVeces(1);
  }

  /**
   * 10. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista
   * L1, que aparecen en la lista L2.
   */
  private int encontrarIndice(int elem) {
    for (int i = 0; i < this.cantElem; i++) {
      if (this.elem[i] == elem) {
        return i;
      }
    }
    return -1;
  }

  public void eliminarTodo(Lista L2) {
    for (int i = 0; i < L2.cantElem; i++) {
      int indice = this.encontrarIndice(L2.elem[i]);
      while (indice != -1) {
        this.eliminarIesimo(indice);
        indice = this.encontrarIndice(L2.elem[i]);
      }
    }
  }

  /**
   * 11. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
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
   * 12. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1
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
   * 13. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1
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
   * 14. L1.eliminarPrim( n ) : Método que elimina los primeros n-elementos de la
   * Lista L1.
   */
  public void eliminarPrim(int n) {
    this.eliminarIesimo(0, n);
  }

  /**
   * 15. L1.eliminarUlt( n ) : Método que elimina los últimos n-elementos de la
   * Lista L1.
   */
  public void eliminarUlt(int n) {
    for (int i = 0; i < n; i++) {
      this.eliminarIesimo(this.cantElem - 1);
    }
  }

  /**
   * 16. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista
   * L2 en la lista L1, desde la posición i.
   */
  public void insertarIesimo(Lista L2, int i) {
    for (int k = 0; k < L2.cantElem; k++) {
      this.insertarIesimo(L2.elem[k], i);
    }
  }

  /**
   * 17. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al
   * principio de la lista L1.
   */
  public void insertarPrim(Lista L2) {
    this.insertarIesimo(L2, 0);
  }

  /**
   * 18. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al
   * final de la lista L1.
   */
  public void insertarUlt(Lista L2) {
    this.insertarIesimo(L2, this.cantElem - 1);
  }

  /**
   * 19. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista
   * L1, desde la posición i.
   */
  public void eliminarIesimo(int i, int n) {
    for (int k = 0; k < n; k++) {
      this.eliminarIesimo(i);
    }
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
   * 22. L1.eliminarAlternos() : Método que elimina los elementos de las
   * posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)
   */
  public void eliminarAlternos() {
    for (int i = 1; i < this.cantElem; i++) {
      this.eliminarIesimo(i);
    }
  }

  /**
   * EJERCICIOS DE TAREA-2
   */

  /**
   * 1. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de menor a mayor.
   */
  public void insertarLugarAsc(int x) {
    int k = this.cantElem - 1;
    while (k >= 0 && x < this.elem[k]) {
      this.elem[k + 1] = this.elem[k];
      k--;
    }
    this.elem[k + 1] = x;
    this.cantElem++;
  }

  /**
   * 2. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de mayor a menor.
   */
  public void insertarLugarDesc(int x) {
    int k = this.cantElem - 1;
    while (k >= 0 && x < this.elem[k]) {
      this.elem[k + 1] = this.elem[k];
      k--;
    }
    this.elem[k + 1] = x;
    this.cantElem++;
  }

  /**
   * 3. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en
   * las Listas L2, L3.
   */
  private boolean tieneElemento(int x) { // metodo auxiliar
    for (int i = 0; i < this.cantElem; i++) {
      if (this.elem[i] == x) {
        return true;
      }
    }
    return false;
  }

  public void comunes(Lista L2, Lista L3) {
    for (int i = 0; i < L2.cantElem; i++) {
      int elemento = L2.elem[i];
      if (!this.tieneElemento(elemento) &&
          L3.tieneElemento(elemento)) {
        this.insertarUlt(elemento);
      }
    }
  }

  /**
   * 4. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos
   * intercalados de las Listas L2 y L3.
   */
  public void intercalar(Lista L2, Lista L3) {
    int i = 0;
    int j = 0;
    while (i < L2.cantElem && j < L3.cantElem) {
      this.insertarUlt(L2.elem[i]);
      this.insertarUlt(L3.elem[j]);
      i++;
      j++;
    }
    while (i < L2.cantElem) {
      this.insertarUlt(L2.elem[i]);
      i++;
    }
    while (j < L3.cantElem) {
      this.insertarUlt(L3.elem[j]);
      j++;
    }
  }

  /**
   * 5. L1.ordenado() : Método lógico que devuelve True, si los elementos de la
   * lista L1, están ordenados en forma ascendente o descendente.
   */
  public boolean ordenado() {
    boolean estaOrdenadoAsc = true;
    boolean estaOrdenadoDesc = true;
    for (int i = 0; i < this.cantElem - 1; i++) {
      if (this.elem[i] > this.elem[i + 1]) {
        estaOrdenadoAsc = false;
      }
      if (this.elem[i] < this.elem[i + 1]) {
        estaOrdenadoDesc = false;
      }
    }
    return estaOrdenadoAsc || estaOrdenadoDesc;
  }

  /**
   * 6. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
   * la lista L1, son iguales.
   */
  public boolean iguales() {
    for (int i = 0; i < this.cantElem - 1; i++) {
      if (this.elem[i] != this.elem[i + 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * 7. L1.diferentes() : Método lógico que devuelve True, si todos los elementos
   * de la lista L1, son diferentes.
   */
  public boolean diferentes() {
    for (int i = 0; i < this.cantElem; i++) {
      for (int j = 0; j < this.cantElem; j++) {
        if (this.elem[i] == this.elem[j] && i != j)
          return false;
      }
    }
    return true;
  }

  /**
   * 8. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
   */
  public int menor() {
    int menor = this.elem[0];
    for (int i = 1; i < this.cantElem; i++) {
      if (this.elem[i] < menor)
        menor = this.elem[i];
    }
    return menor;
  }

  /**
   * 9. L1.parImpar() : Método lógico que devuelve True, en la Lista L1, existe
   * al menos un elemento par y al menos un elemento impar.
   */
  public boolean parImpar() {
    boolean existePar = false;
    boolean existeImpar = false;
    for (int i = 0; i < this.cantElem; i++) {
      if (this.elem[i] % 2 == 0)
        existePar = true;
      if (this.elem[i] % 2 == 1)
        existeImpar = true;
    }
    return existePar && existeImpar;
  }

  /**
   * 10. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos
   * tienen la misma frecuencia de aparición en la Lista L1.
   */
  public int frecuencia(int x) {
    int frecuencia = 0;
    for (int i = 0; i < this.cantElem; i++) {
      if (this.elem[i] == x)
        frecuencia++;
    }
    return frecuencia;
  }

  public boolean mismaFrec() {
    for (int i = 0; i < this.cantElem - 1; i++) {
      if (frecuencia(this.elem[i]) != frecuencia(this.elem[i + 1]))
        return false;
    }
    return true;
  }

  /**
   * 11. L1.palindrome() : Método lógico que devuelve True, si los elementos de la
   * Lista L1, forma un palíndrome.
   */
  public boolean palindrome() {
    int n = cantElem;
    for (int i = 0; i < n / 2; i++) {
      int izquierda = this.elem[i];
      int derecha = this.elem[n - 1 - i];

      if (izquierda != derecha) {
        return false;
      }
    }
    return true;
  }

  /**
   * 12. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista L1 y L2
   * tienen los mismos elementos.
   */
  public boolean mismosElem(Lista L2) {
    for (int i = 0; i < this.cantElem; i++) {
      if (!L2.tieneElemento(this.elem[i]))
        return false;
    }

    for (int i = 0; i < L2.cantElem; i++) {
      if (!this.tieneElemento(L2.elem[i]))
        return false;
    }
    return true;
  }

  /*
   * 13. Incluir al menos 10 métodos : Con el objetivo de consultar Bibliografía
   * sobre el tema, enunciar e implementar al menos 10 métodos adicionales a
   * implementar. Citar fuente. (Importante).
   */
  /**
   * Bibliografia: https://utilities-library.vercel.app/classes/Vector.html
   */
  /**
   * 1. L1.invertir() : Método que invertierte el orden de los elementos
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
   * 2. L1.ordenamientoBurbuja() : Método que ordena los elementos de la lista
   * (menor
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
   * 3. L1.busquedaBinaria(k) : Método que busca si existe el elemento en la lista
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
   * 4. L1.repetirKVeces(k): Meotod que repite los elementos de la Lista
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
   * 5. L1.generarSerieRegresiva(n): Metodo que genera esta seríe
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

  /**
   * 6. L1.segmentarParImpar(): Segmenta el vector separando los números pares de
   * los
   * impares.
   * ejemplo:
   * [2,2,4,6,3,3,5,5,5,9]
   */
  public void segmentarParImpar() {
    for (int p = 0; p < this.cantElem - 1; p++) {
      for (int d = p + 1; d < this.cantElem; d++) {
        int n1 = this.elem[d];
        int n2 = this.elem[p];
        if ((n1 % 2 == 0 && n2 % 2 != 0) ||
            (n1 % 2 == 0 && n2 % 2 == 0 && this.elem[d] < this.elem[p]) ||
            (n1 % 2 != 0 && n2 % 2 != 0 && this.elem[d] < this.elem[p])) {
          int temp = this.elem[d];
          this.elem[d] = this.elem[p];
          this.elem[p] = temp;
        }
      }
    }
  }

  /**
   * 7. L1.intercalarParImpar(): Intercala los números pares e impares de la lista
   * ejemplo:
   * [2,3,2,5,4,7,6]
   */
  public void intercalarParImpar() {
    boolean bool = true;

    for (int p = 0; p < this.cantElem - 1; p++) {
      if (bool) {
        for (int d = p + 1; d < this.cantElem; d++) {
          int n1 = this.elem[d];
          int n2 = this.elem[p];
          if ((n1 % 2 == 0 && n2 % 2 != 0) ||
              (n1 % 2 == 0 && n2 % 2 == 0 && this.elem[d] < this.elem[p]) ||
              (n1 % 2 != 0 && n2 % 2 != 0 && this.elem[d] < this.elem[p])) {
            int temp = this.elem[d];
            this.elem[d] = this.elem[p];
            this.elem[p] = temp;
          }
        }
      } else {
        for (int d = p + 1; d < this.cantElem; d++) {
          int n1 = this.elem[d];
          int n2 = this.elem[p];

          if ((n1 % 2 != 0 && n2 % 2 == 0) ||
              (n1 % 2 != 0 && n2 % 2 != 0 && this.elem[d] < this.elem[p]) ||
              (n1 % 2 == 0 && n2 % 2 == 0 && this.elem[d] < this.elem[p])) {
            int temp = this.elem[d];
            this.elem[d] = this.elem[p];
            this.elem[p] = temp;
          }
        }
      }
      bool = !bool;
    }
  }

  /**
   * 8. L1.generarSerieFibonacci(longitud): Carga la lista con una serie de
   * Fibonacci.
   */
  public void generarSerieFibonacci(int longitud) {
    if (longitud <= 0)
      return;
    if (longitud > 0) {
      this.insertarPrim(0);
    }
    if (longitud > 1) {
      this.insertarUlt(1);
    }

    for (int i = 2; i < longitud; i++) {
      int elem = this.elem[i - 1] + this.elem[i - 2];
      this.insertarUlt(elem);
    }
  }

  /**
   * 9. L1.concatenar(L2): concatena una lista al final de la lista L1.
   */
  public void concatenar(Lista L1) {
    for (int i = 0; i < L1.cantElem; i++) {
      this.insertarUlt(L1.elem[i]);
    }
  }

  /**
   * 10. L1.desordenar(): Desordena todos los elementos de la lista L1 de forma
   * aleatoria.
   */
  public void desordenar() {
    for (int i = 0; i < this.cantElem; i++) {
      int indiceRandom = (int) Math.random() * (this.cantElem - 1);
      int temp = this.elem[i];
      this.elem[i] = this.elem[indiceRandom];
      this.elem[indiceRandom] = temp;
    }
  }
  /**
   * Bibliografia: https://utilities-library.vercel.app/classes/Vector.html
   */
}
