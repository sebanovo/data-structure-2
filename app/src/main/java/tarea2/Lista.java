package tarea2;

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
   * 4. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de menor a mayor.
   */
  public void insertarLugarAsc(int x) {
    int i = 0;
    while (i < this.cantElem && this.elem[i] < x) {
      i++;
    }
    this.insertarIesimo(x, i);
  }

  /**
   * 5. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de mayor a menor.
   */
  public void insertarLugarDesc(int x) {
    int i = 0;
    while (i < this.cantElem && this.elem[i] > x) {
      i++;
    }
    this.insertarIesimo(x, i);
  }

  /**
   * 6. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en
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
   * 7. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos
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
   * 8. L1.ordenado() : Método lógico que devuelve True, si los elementos de la
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
   * 9. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
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
   * 10. L1.diferentes() : Método lógico que devuelve True, si todos los elementos
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
   * 11. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
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
   * 12. L1.parImpar() : Método lógico que devuelve True, en la Lista L1, existe
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
   * 13. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos
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
   * 14. L1.palindrome() : Método lógico que devuelve True, si los elementos de la
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
   * 15. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista L1 y L2
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
   * 16. Incluir al menos 10 métodos : Con el objetivo de consultar Bibliografía
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
      // intercambiar
      int temp = this.elem[i];
      this.elem[i] = this.elem[indiceRandom];
      this.elem[indiceRandom] = temp;
    }
  }
  /**
   * Bibliografia: https://utilities-library.vercel.app/classes/Vector.html
   */
}
