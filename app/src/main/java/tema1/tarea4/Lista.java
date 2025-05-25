package tema1.tarea4;

// Lista con algoritmos recursivos
public class Lista {
  int[] elem;
  int cantElem;
  int MAX = 10000;

  public Lista() {
    this.elem = new int[MAX];
    this.cantElem = 0;
  }

  @Override
  public String toString() {
    String s = "[";
    s = s + this.toStringR(0, this.cantElem - 1);
    return s + "]";
  }

  private String toStringR(int a, int b) {
    String s = "";
    if (a <= b) {
      s = s + this.elem[a];
      if (a < b)
        s = s + ", ";
      s = s + toStringR(a + 1, b);
    }
    return s;
  }

  /**
   * 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
   * i, de la lista L1.
   */
  public void insertarIesimo(int x, int i) {
    this.insertarIesimoR(x, i, this.cantElem);
  }

  private void insertarIesimoR(int x, int i, int n) {
    if (n < i) {
      this.elem[i] = x;
      this.cantElem++;
    } else {
      this.elem[n + 1] = this.elem[n];
      insertarIesimoR(x, i, n - 1);
    }
  }

  /**
   * 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la
   * lista L1
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
    this.eliminarIesimoR(i, this.cantElem);
    this.cantElem--;
  }

  private void eliminarIesimoR(int i, int n) {
    if (i > n) {
      this.cantElem--;
    } else {
      this.elem[i] = this.elem[i + 1];
      this.eliminarIesimoR(i + 1, n);
    }
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
   * 7. L1.insertarLugasAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de menor a mayor.
   */
  public void insertarLugarAsc(int x) {
    this.insertarLugarAscR(0, this.cantElem - 1, x);
  }

  private void insertarLugarAscR(int a, int b, int x) {
    if (b < 0 || this.elem[b] <= x) {
      this.elem[b + 1] = x;
      this.cantElem++;
    } else {
      this.elem[b + 1] = this.elem[b];
      insertarLugarAscR(a, b - 1, x);
    }
  }

  /**
   * 8. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de mayor a menor
   */
  public void insertarLugarDesc(int x) {
    this.insertarLugarDescR(0, this.cantElem - 1, x);
  }

  private void insertarLugarDescR(int a, int b, int x) {
    if (b < 0 || this.elem[b] >= x) {
      this.elem[b + 1] = x;
      this.cantElem++;
    } else {
      this.elem[b + 1] = this.elem[b];
      insertarLugarDescR(a, b - 1, x);
    }
  }

  /**
   * 9. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
   * Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7,
   * 8, 1]
   */
  public void pasarDigitos(int n) {
    this.pasarDigitosR(n);
  }

  private void pasarDigitosR(int n) {
    if (n < 10) {
      this.insertarPrim(n);
    } else {
      int d = n % 10;
      this.insertarPrim(d);
      pasarDigitosR(n / 10);
    }
  }

  /**
   * 10. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
   * la lista L1, son iguales..
   */
  public boolean iguales() {
    return this.igualesR(0, this.cantElem - 1);
  }

  private boolean igualesR(int a, int b) {
    boolean bol = true;
    int n = b - a + 1;
    if (n > 1 && a < b - 1) {
      if (this.elem[a] != this.elem[b]) {
        bol = false;
      }
      igualesR(a + 1, b);
    }
    return bol;
  }

  /**
   * 11. L1.ordenado() : Método lógico que devuelve True, si los elementos de la
   * lista L1, están ordenados en forma ascendente o descendente.
   */
  public boolean ordenado() {
    return estaOrdenadoAsc(0, this.cantElem - 1) || estaOrdenadoDesc(0, this.cantElem - 1);
  }

  private boolean estaOrdenadoAsc(int a, int b) {
    if (a >= b) {
      return true;
    } else {
      if (this.elem[a] > this.elem[a + 1]) {
        return false;
      }
    }
    return estaOrdenadoAsc(a + 1, b);
  }

  private boolean estaOrdenadoDesc(int a, int b) {
    if (a >= b) {
      return true;
    } else {
      if (this.elem[a] < this.elem[a + 1]) {
        return false;
      }
    }
    return estaOrdenadoDesc(a + 1, b);
  }

  /**
   * 12. L1.frecuencia(x): Método que devuelve la cantidad de veces que aparece el
   * elemento x, en la lista L1
   */
  public int frecuencia(int x) {
    return frecuenciaR(0, this.cantElem - 1, x);
  }

  private int frecuenciaR(int a, int b, int x) {
    int n = b - a + 1;
    if (n == 0) {
      return 0;
    } else {
      int frec = this.frecuenciaR(a + 1, b, x);
      if (this.elem[a] == x) {
        frec++;
      }
      return frec;
    }
  }

  /**
   * 13. L1.suma(): Método que devuelve la sumatoria de los elementos de la lista
   * L1
   */
  public int suma() {
    return this.sumaR(0, this.cantElem - 1);
  }

  private int sumaR(int a, int b) {
    int n = b - a + 1;
    if (n == 0) {
      return 0;
    } else {
      return this.sumaR(a + 1, b) + this.elem[a];
    }
  }

  /**
   * 14. L1.sumaPares(): Método que devuelve la sumatoria de los elementos pares
   * de la lista L1.
   */
  public int sumaPares() {
    return this.sumaParesR(0, this.cantElem - 1);
  }

  private int sumaParesR(int a, int b) {
    int n = b - a + 1;
    if (n == 0) {
      return 0;
    } else {
      int suma = this.sumaParesR(a + 1, b);
      if (this.elem[a] % 2 == 0) {
        suma += this.elem[a];
      }
      return suma;
    }
  }

  /**
   * 15. L1.diferentes() : Método lógico que devuelve True, si todos los elementos
   * de la lista L1, son diferentes.
   */
  public boolean diferentes() {
    return this.diferentesR1(0, this.cantElem - 1);
  }

  private boolean diferentesR1(int a1, int b1) {
    int n1 = b1 - a1 + 1;
    if (n1 == 0) {
      return true;
    } else {
      return this.diferentesR2(a1, 0, this.cantElem - 1) && this.diferentesR1(a1 + 1, b1);
    }
  }

  private boolean diferentesR2(int a1, int a2, int b2) {
    int n2 = b2 - a2 + 1;
    if (n2 == 0) {
      return true;
    } else if (n2 == 1) {
      return true;
    } else {
      boolean diferentes = diferentesR2(a1, a2 + 1, b2);
      if (this.elem[a1] == this.elem[a2] && a1 != a2) {
        diferentes = false;
      }
      return diferentes;
    }
  }

  /**
   * 16. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
   */
  public int menor() {
    return menorR(1, this.cantElem, this.elem[0]);
  }

  private int menorR(int a, int n, int menor) {
    if (a >= n) {
      return menor;
    } else {
      if (this.elem[a] < menor) {
        menor = this.elem[a];
      }
      return menorR(a + 1, n, menor);
    }
  }

  /**
   * 17. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos
   * tienen la misma frecuencia de aparición en la Lista L1.
   */
  public boolean mismaFrec() {
    return mismaFrecR(0, this.cantElem - 1);
  }

  private boolean mismaFrecR(int a, int b) {
    int n = b - a + 1;
    if (n == 0) {
      return true;
    } else if (n == 1) {
      return true;
    } else {
      boolean frec = this.mismaFrecR(a + 1, b);
      if (frecuencia(this.elem[a]) != frecuencia(this.elem[a + 1])) {
        frec = false;
      }
      return frec;
    }
  }

  /**
   * 18. L1.palindrome() : Método lógico que devuelve True, si los elementos de la
   * Lista L1, forma un palíndrome.
   */
  public boolean palindrome() {
    return this.palindromeR(0, this.cantElem / 2);
  }

  private boolean palindromeR(int a, int n2) {
    if (a < n2) {
      if (this.elem[a] != this.elem[this.cantElem - 1 - a])
        return false;
      return palindromeR(a + 1, n2);
    }
    return true;
  }

  /**
   * 19. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos
   * intercalados de las Listas L2 y L3.
   */
  public void intercalar(Lista L2, Lista L3) {
    this.intercalarR(L2, L3, 0, 0, L2.cantElem, L3.cantElem);
  }

  private void intercalarR(Lista L2, Lista L3, int i, int j, int n2, int n3) {
    if (i < n2 && j < n3) {
      this.insertarUlt(L2.elem[i]);
      this.insertarUlt(L3.elem[j]);
      i++;
      j++;
      intercalarR(L2, L3, i, j, n2, n3);
    } else if (i < n2) {
      this.insertarUlt(L2.elem[i]);
      i++;
      intercalarR(L2, L3, i, j, n2, n3);
    } else if (j < n3) {
      this.insertarUlt(L3.elem[j]);
      j++;
      intercalarR(L2, L3, i, j, n2, n3);
    }
  }

  /**
   * 20. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista L1 y L2
   * tienen los mismos elementos.
   */
  public boolean mismosElem(Lista L2) {
    return this.tieneElementos(L2) && L2.tieneElementos(this);
  }

  private boolean tieneElemento(int x) {
    return this.tieneElementoR(0, this.cantElem - 1, x);
  }

  private boolean tieneElementoR(int a, int b, int x) {
    int n = b - a + 1;
    if (n == 0) {
      return false;
    } else if (n == 1) {
      return this.elem[a] == x;
    } else {
      boolean tiene = this.tieneElementoR(a + 1, b, x);
      if (this.elem[a] == x) {
        tiene = true;
      }
      return tiene;
    }
  }

  public boolean tieneElementos(Lista L2) {
    return this.tieneElementosR(L2, 0, this.cantElem - 1);
  }

  private boolean tieneElementosR(Lista L2, int a, int b) {
    int n = b - a + 1;
    if (n == 0) {
      return true;
    } else if (n == 1) {
      return L2.tieneElemento(this.elem[a]);
    } else {
      if (!L2.tieneElemento(this.elem[a])) {
        return false;
      }
      return tieneElementosR(L2, a + 1, b);
    }
  }

  /**
   * 21. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
   * lista L1
   */
  public void eliminarTodo(int x) {
    this.eliminarTodoR(0, this.cantElem - 1, x);
  }

  private void eliminarTodoR(int a, int b, int x) {
    if (a < b + 1) {
      if (this.elem[b] == x) {
        this.eliminarIesimo(b);
      }
      this.eliminarTodoR(a, b - 1, x);
    }
  }
}
