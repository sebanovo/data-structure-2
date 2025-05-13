package tarea8;

public class ListaDoble {

  public Nodo prim;
  public Nodo ult;
  public int cantElem;

  public ListaDoble() {
    prim = ult = null;
    cantElem = 0;
  }

  // iterativo
  @Override
  public String toString() {
    String s = "[";
    Nodo p = prim;
    while (p != null) {
      s = s + p.elem;
      if (p.prox != null) {
        s = s + ", ";
      }
      p = p.prox;
    }
    return s + "]";
  }

  // recursivo
  public String toString1() {
    return "[" + toStringR(this.prim) + "]";
  }

  private String toStringR(Nodo p) {
    String s = "";
    if (p == null) {
      return s;
    } else {
      s = s + p.elem;
      if (p.prox != null) {
        s = s + ", ";
      }
      return s + toStringR(p.prox);
    }
  }

  // metodos auxiliares
  private boolean vacia() {
    return this.cantElem == 0;
  }

  private void insertarNodo(Nodo ap, Nodo p, int x) {
    if (ap == null) {
      insertarPrim(x);
    } else if (p == null) {
      insertarUlt(x);
    } else {
      ap.prox = p.ant = new Nodo(ap, x, p);
      cantElem++;
    }
  }

  /*
   * 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
   * i, de la lista L1.
   */
  public void insertarIesimo(int x, int i) {
    int k = 0;
    Nodo p = prim;
    Nodo ap = null;
    while (k < i && p != null) {
      k = k + 1;
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  public void insertarIesimo1(int x, int i) {
    insertarIesimoR(0, prim, null, x, i);
  }

  private void insertarIesimoR(int k, Nodo p, Nodo ap, int x, int i) {
    if (k >= i || p == null) {
      insertarNodo(ap, p, x);
    } else {
      insertarIesimoR(k + 1, p.prox, ap, x, i);
    }
  }

  /*
   * 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la
   * lista L1.
   */
  public void insertarPrim(int x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      prim = prim.ant = new Nodo(null, x, prim);
    }
    this.cantElem++;
  }

  /*
   * 3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista
   * L1.
   */
  public void insertarUlt(int x) {
    if (vacia()) {
      prim = ult = new Nodo(null, x, null);
    } else {
      ult = ult.prox = new Nodo(ult, x, null);
    }
    this.cantElem++;
  }

  /*
   * 4. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista ordenadas de menor a mayor.
   */
  // iterativo
  public void insertarLugarAsc(int x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null && x > p.elem) {
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  // recursivo
  public void insertarLugarAsc1(int x) {
    insertarLugarAscR(prim, null, x);
  }

  private void insertarLugarAscR(Nodo p, Nodo ap, int x) {
    if (p == null || x <= p.elem) {
      insertarNodo(ap, ap, x);
      return;
    } else {
      insertarLugarAscR(p.prox, p, x);
    }
  }

  /*
   * 5. L1.insertarLugarDes(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista ordenadas de mayor a menor.
   */
  public void insertarLugarDesc(int x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null && x < p.elem) {
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  // recursivo
  public void insertarLugarDesc1(int x) {
    insertarLugarDescR(prim, null, x);
  }

  private void insertarLugarDescR(Nodo p, Nodo ap, int x) {
    if (p == null || x >= p.elem) {
      insertarNodo(ap, ap, x);
      return;
    } else {
      insertarLugarDescR(p.prox, p, x);
    }
  }

  /*
   * 6. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista
   * L2 en la lista L1, desde la posición i.
   */
  // iterativo
  public void insertarIesimo(ListaDoble L2, int i) {
    Nodo p = L2.prim;
    int k = i;
    while (p != null) {
      insertarIesimo(p.elem, k);
      p = p.prox;
      k++;
    }
  }

  // recursivo
  public void insertarIesimo1(ListaDoble L2, int i) {
    insertarIesimoR(L2.prim, i);
  }

  private void insertarIesimoR(Nodo p, int k) {
    if (p == null) {
      return;
    }
    insertarIesimo1(p.elem, k);
    insertarIesimoR(p.prox, k + 1);
  }

  /*
   * 7. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al
   * principio de la lista L1.
   */
  public void insertarPrim(ListaDoble L2) {
    insertarIesimo(L2, 0);
  }

  /*
   * 8. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al
   * final de la lista L1.
   */
  public void insertarUlt(ListaDoble L2) {
    insertarIesimo(L2, cantElem);
  }

  /*
   * 9. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de
   * la lista L1 son iguales.
   */
  private int frecuencia(int x) {
    Nodo p = prim;
    int frecuencia = 0;
    while (p != null) {
      if (p.elem == x) {
        frecuencia++;
      }
      p = p.prox;
    }
    return frecuencia;
  }

  // iterativo
  public boolean iguales() {
    Nodo p = prim;
    while (p != null) {
      if (frecuencia(p.elem) != this.cantElem) {
        return false;
      }
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean iguales1() {
    return igualesR(prim);
  }

  private boolean igualesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (frecuencia(p.elem) != this.cantElem) {
        return false;
      }
      return igualesR(p.prox);
    }
  }

  /*
   * 10. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 son diferentes.
   */
  // iterativo
  public boolean diferentes() {
    Nodo p = prim;
    while (p != null) {
      if (frecuencia(p.elem) > 1) {
        return false;
      }
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean diferentes1() {
    return diferentesR(prim);
  }

  public boolean diferentesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (frecuencia(p.elem) > 1) {
        return false;
      }
      return diferentesR(p.prox);
    }
  }

  /*
   * 11. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
   */
  // iterativo
  public int mayorElem() {
    Nodo p = prim;
    int mayor = p.elem;
    while (p != null) {
      if (mayor < p.elem) {
        mayor = p.elem;
      }
      p = p.prox;
    }
    return mayor;
  }

  // recursivo
  public int mayorElem1() {
    return mayorElemR(prim, prim.elem);
  }

  public int mayorElemR(Nodo p, int mayor) {
    if (p == null) {
      return mayor;
    } else {
      if (mayor < p.elem) {
        return mayorElemR(p.prox, p.elem);
      }
      return mayorElemR(p.prox, mayor);
    }
  }

  /*
   * SELECT NIT, CLIENTE.NOMBRE
   * FROM CLIENTE, BOLETO, PELICULA, GENERO
   * WHERE NIT=CLIENTE AND CODPELICULA= CODIGO
   * -- Mostrar la cantidad de peliculas del genero infantil que no han sido
   * vistas
   * 
   * SELECT COUNT(CODIGO)
   * FROM PELICULA
   * WHERE IDGENERO IN (SELECT ID
   * FROM GENERO
   * WHERE DESCRIPCION = 'INFANTIL'
   * )
   * AND CODIGO NOT IN (SELECT CODPELICULA
   * FROM BOLETO)
   */
  /*
   * 12. L1.ordenado() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 están ordenados en forma ascendente o descendente.
   */
  // iterativo
  public boolean ordenado() {
    return ordenadoAsc() || ordenadoDesc();
  }

  private boolean ordenadoAsc() {
    Nodo p = prim;
    while (p != null) {
      if (p.prox != null) {
        if (p.elem < p.prox.elem) {
          return false;
        }
      }
      p = p.prox;
    }
    return true;
  }

  private boolean ordenadoDesc() {
    Nodo p = prim;
    while (p != null) {
      if (p.prox != null) {
        if (p.elem > p.prox.elem) {
          return false;
        }
      }
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean ordenado1() {
    return ordenadoAsc1() || ordenadoDesc1();
  }

  private boolean ordenadoAsc1() {
    return ordenadoAscR(prim);
  }

  private boolean ordenadoDesc1() {
    return ordenadoDescR(prim);
  }

  private boolean ordenadoAscR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.prox != null) {
        if (p.elem > p.prox.elem)
          return false;
      }
      return ordenadoAscR(p.prox);
    }
  }

  private boolean ordenadoDescR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.prox != null) {
        if (p.elem < p.prox.elem)
          return false;
      }
      return ordenadoDescR(p.prox);
    }
  }

  /*
   * 13. L1.indexOf(x) : Método que devuelve la posición (lugar) de la primera
   * ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método
   * devuelve –
   */
  // iterativo
  public int indexOf(int x) {
    int i = 0;
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x) {
        return i;
      }
      i++;
      p = p.prox;
    }
    return -1;
  }

  // recursivo
  public int indexOf1(int x) {
    return indexOfR(prim, 0, x);
  }

  public int indexOfR(Nodo p, int i, int x) {
    if (p == null) {
      return -1;
    } else {
      if (p.elem == x) {
        return i;
      }
      return indexOfR(p.prox, i + 1, x);
    }
  }

  /*
   * 14. L1.lastIndexOf(x) : Método que devuelve la posición (lugar) de la última
   * ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método
   * devuelve –
   */
  // recursivo
  public int lastIndexOf(int x) {
    int i = cantElem - 1;
    Nodo p = ult;
    while (p != null) {
      if (p.elem == x) {
        return i;
      }
      i--;
      p = p.ant;
    }
    return -1;
  }

  // iterativo
  public int lastIndexOf1(int x) {
    return lastIndexOfR(ult, cantElem - 1, x);
  }

  public int lastIndexOfR(Nodo p, int i, int x) {
    if (p == null) {
      return -1;
    } else {
      if (p.elem == x) {
        return i;
      }
      return lastIndexOfR(p.ant, i - 1, x);
    }
  }

  /*
   * 15. L1.palindrome() : Método lógico que devuelve True, si la lista L1
   * contiene elementos que forma un palíndrome.
   */
  // iterativo
  public boolean palindrome() {
    Nodo primero = prim;
    Nodo ultimo = ult;

    while (primero != null && ultimo != null) {
      if (primero.elem != ultimo.elem) {
        return false;
      }
      primero = primero.prox;
      ultimo = ultimo.ant;
    }
    return true;
  }

  // recursivo
  public boolean palindrome1() {
    return palindromeR(prim, ult);
  }

  private boolean palindromeR(Nodo primero, Nodo ultimo) {
    if (primero == null || ultimo == null) {
      return true;
    } else {
      if (primero.elem != ultimo.elem) {
        return false;
      }
      return palindromeR(primero.prox, ultimo.ant);
    }
  }

  /*
   * 16. Incluir al menos 10 ejercicios cualesquiera, interesantes. (No utilizar
   * métodos de eliminar . . . ). Consultar propuestas de ejercicios en chatGPT
   * (la calidad de los ejercicios propuestos depende de la calidad de
   * entrenamiento al chatGPT) coherentes con los anteriores (ejercicios para
   * exponer).
   */
  /*
   * 1. L1.suma() Devuelve la suma de todos los elementos de la lista.
   */
  // iterativo
  public int suma() {
    int suma = 0;
    Nodo p = prim;
    while (p != null) {
      suma += p.elem;
      p = p.prox;
    }
    return suma;
  }

  // recursivo
  public int suma1() {
    return sumaR(prim);
  }

  private int sumaR(Nodo p) {
    if (p == null) {
      return 0;
    }
    return p.elem + sumaR(p.prox);
  }

  /*
   * 2. L1.frecuenciaMax() Devuelve el elemento que más se repite en la lista.
   */
  // iterativo
  public int frecuenciaMax() {
    Nodo p = prim;
    int frecuenciaMax = frecuencia(p.elem);
    while (p != null) {
      if (frecuenciaMax < frecuencia(p.elem)) {
        frecuenciaMax = frecuencia(p.elem);
      }
      p = p.prox;
    }
    return frecuenciaMax;
  }

  // recursivo
  public int frecuenciaMax1() {
    return frecuenciaMaxR(prim, this.frecuencia(prim.elem));
  }

  private int frecuenciaMaxR(Nodo p, int frecuenciaMax) {
    if (p == null) {
      return frecuenciaMax;
    } else {
      if (frecuenciaMax < frecuencia(p.elem)) {
        return frecuenciaMaxR(p.prox, frecuencia(p.elem));
      }
      return frecuenciaMaxR(p.prox, frecuenciaMax);
    }
  }

  /*
   * 3. L1.invertir() Invierte el orden de los punteros de la lista
   */
  public void invertir() {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null) {
      ap = p.ant;
      p.ant = p.prox;
      p.prox = ap;
      p = p.ant;
    }

    if (ap != null) {
      this.prim = ap.ant;
      ult = prim;
      while (ult != null && ult.prox != null) {
        ult = ult.prox;
      }
    }
  }

  /*
   * 4. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas
   * L2 con L3 en L1.
   */
  // iterativo
  public void intercalar(ListaDoble L2, ListaDoble L3) {
    Nodo i = L2.prim;
    Nodo j = L3.prim;
    while (i != null && j != null) {
      this.insertarUlt(i.elem);
      this.insertarUlt(j.elem);
      i = i.prox;
      j = j.prox;
    }
    while (i != null) {
      this.insertarUlt(i.elem);
      i = i.prox;
    }
    while (j != null) {
      this.insertarUlt(j.elem);
      j = j.prox;
    }
  }

  // recursivo
  public void intercalar1(ListaDoble L2, ListaDoble L3) {
    intercalarR(L2.prim, L3.prim);
  }

  private void intercalarR(Nodo i, Nodo j) {
    if (i != null && j != null) {
      this.insertarUlt(i.elem);
      this.insertarUlt(j.elem);
      intercalarR(i.prox, j.prox);
    } else if (i != null) {
      this.insertarUlt(i.elem);
      intercalarR(i.prox, j);
    } else if (j != null) {
      this.insertarUlt(j.elem);
      intercalarR(i, j.prox);
    }
  }

  /*
   * 5. L1.soloPares() Devuelve true si todos los elementos son pares.
   */
  // iterativo
  public boolean soloPares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 0) {
        return false;
      }
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean soloPares1() {
    return soloParesR(prim);
  }

  private boolean soloParesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 0) {
        return false;
      }
      return soloParesR(p.prox);
    }
  }

  /*
   * 6. L1.soloImpares() Devuelve true si todos los elementos son impares.
   */
  public boolean soloImpares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 1) {
        return false;
      }
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean soloImpares1() {
    return soloImparesR(prim);
  }

  private boolean soloImparesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 1) {
        return false;
      }
      return soloImparesR(p.prox);
    }
  }

  /*
   * 7. L1.sumaPosicionesPares() Suma los elementos que están en posiciones pares
   * (0, 2, 4...)
   */
  // iterativo
  public int sumaPosicionesPares() {
    int i = 0;
    int sumaPosicionesPares = 0;
    Nodo p = prim;
    while (p != null) {
      if (i % 2 == 0) {
        sumaPosicionesPares += p.elem;
      }
      i++;
      p = p.prox;
    }
    return sumaPosicionesPares;
  }

  // recursivo
  public int sumaPosicionesPares1() {
    return sumaPosicionesParesR(prim, 0);
  }

  private int sumaPosicionesParesR(Nodo p, int i) {
    if (p == null) {
      return 0;
    } else {
      if (i % 2 == 0) {
        return p.elem + sumaPosicionesParesR(p.prox, i + 1);
      }
      return sumaPosicionesParesR(p.prox, i + 1);
    }
  }

  /*
   * 8. L1.tieneElemento(x) Devuelve True si el elemento se encuentra en la lista
   * y False si no
   */
  // iterativo
  private boolean tieneElemento(int x) {
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  private boolean tieneElemento1(int x) {
    return tieneElementoR(prim, x);
  }

  private boolean tieneElementoR(Nodo p, int x) {
    if (p == null) {
      return false;
    } else {
      if (p.elem == x)
        return true;
      return tieneElementoR(p.prox, x);
    }
  }

  /*
   * 9. L1.comunes(L2, L3) Inserta en L1 los elementos comunes entre L2
   * y L3 (sin repetir).
   */
  // iterativo
  public void comunes(ListaDoble L2, ListaDoble L3) {
    Nodo p = L2.prim;
    while (p != null) {
      int elemento = p.elem;
      if (!this.tieneElemento(elemento) &&
          L3.tieneElemento(elemento)) {
        this.insertarUlt(elemento);
      }
      p = p.prox;
    }
  }

  // recursivo
  public void comunes1(ListaDoble L2, ListaDoble L3) {
    comunesR(L2.prim, L3);
  }

  private void comunesR(Nodo p, ListaDoble L3) {
    if (p != null) {
      int elemento = p.elem;
      if (!this.tieneElemento1(elemento) &&
          L3.tieneElemento(elemento)) {
        this.insertarUlt(elemento);
      }
    }
  }

  /*
   * 10. L1.intercalarParImpar() Metodo que intercala los elementos y los ordena
   * [Par, Impar, Par, Impar, etc]
   */
  // iterativo
  public void intercalarParImpar() {
    boolean bool = true;
    Nodo x = prim;
    Nodo y = null;
    while (x != null) {
      y = x.prox;
      if (bool) {
        while (y != null) {
          int n1 = y.elem;
          int n2 = x.elem;
          if ((n1 % 2 == 0 && n2 % 2 != 0) ||
              (n1 % 2 == 0 && n2 % 2 == 0 && y.elem < x.elem) ||
              (n1 % 2 != 0 && n2 % 2 != 0 && y.elem < x.elem)) {
            int temporal = x.elem;
            x.elem = y.elem;
            y.elem = temporal;
          }
          y = y.prox;
        }
      } else {
        while (y != null) {
          int n1 = y.elem;
          int n2 = x.elem;
          if ((n1 % 2 != 0 && n2 % 2 == 0) ||
              (n1 % 2 != 0 && n2 % 2 != 0 && y.elem < x.elem) ||
              (n1 % 2 == 0 && n2 % 2 == 0 && y.elem < x.elem)) {
            int temporal = x.elem;
            x.elem = y.elem;
            y.elem = temporal;
          }
          y = y.prox;
        }
      }
      bool = !bool;
      x = x.prox;
    }
  }

  // recursivo
  public void intercalarParImpar1() {
    intercalarParImparR1(prim, null, true);
  }

  public void intercalarParImparR1(Nodo x, Nodo y, boolean bool) {
    if (x == null) {
      return;
    }
    if (bool) {
      intercalarParImparR2(x, x.prox);
    } else {
      intercalarParImparR3(x, x.prox);
    }

    intercalarParImparR1(x.prox, y, !bool);
  }

  public void intercalarParImparR2(Nodo x, Nodo y) {
    if (y == null) {
      return;
    }
    int n1 = y.elem;
    int n2 = x.elem;
    if ((n1 % 2 == 0 && n2 % 2 != 0) ||
        (n1 % 2 == 0 && n2 % 2 == 0 && y.elem < x.elem) ||
        (n1 % 2 != 0 && n2 % 2 != 0 && y.elem < x.elem)) {
      int temporal = x.elem;
      x.elem = y.elem;
      y.elem = temporal;
    }
    intercalarParImparR2(x, y.prox);
  }

  public void intercalarParImparR3(Nodo x, Nodo y) {
    if (y == null) {
      return;
    }
    int n1 = y.elem;
    int n2 = x.elem;
    if ((n1 % 2 != 0 && n2 % 2 == 0) ||
        (n1 % 2 != 0 && n2 % 2 != 0 && y.elem < x.elem) ||
        (n1 % 2 == 0 && n2 % 2 == 0 && y.elem < x.elem)) {
      int temporal = x.elem;
      x.elem = y.elem;
      y.elem = temporal;
    }
    intercalarParImparR3(x, y.prox);
  }

}