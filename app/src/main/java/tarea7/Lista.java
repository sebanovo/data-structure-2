package tarea7;

public class Lista {
  public Nodo prim;
  public int cantElem;
  public Nodo ult;

  public Lista() {
    prim = ult = null;
    cantElem = 0;
  }

  /**
   * 1. L1.toString() : Método que devuelve una cadena, que representa la
   * secuencia de elementos de la lista L1.
   */
  // iterativo
  @Override
  public String toString() {
    String s = "[";
    Nodo p = prim;

    while (p != null) {
      s = s + p.elem;
      if (p.prox != null)
        s = s + ", ";
      p = p.prox;
    }
    return s + "]";
  }

  // recursivo
  public String toString1() {
    String s = "[";
    return s + toStringR(this.prim) + "]";
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

  public boolean vacia() {
    return this.cantElem == 0;
  }

  /*
   * 2. L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la
   * lista L1.
   */
  public void insertarPrim(int x) {
    if (vacia()) {
      prim = ult = new Nodo(x, null);
    } else {
      prim = new Nodo(x, prim);
    }
    cantElem++;
  }

  /**
   * 3. L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la
   * lista L1.
   */
  public void insertarUlt(int x) {
    if (vacia()) {
      prim = ult = new Nodo(x, null);
    } else {
      ult = ult.prox = new Nodo(x, null);
    }
    cantElem++;
  }

  /**
   * 1. L1.InsertarIesimo(x, i) : Método que inserta el elemento x, en la la
   * iésima posición de la Lista L1.
   */
  public void insertarNodo(Nodo ap, Nodo p, int x) {
    if (ap == null) {
      insertarPrim(x);
    } else if (p == null) {
      insertarUlt(x);
    } else {
      ap.prox = new Nodo(x, p);
      cantElem++;
    }
  }

  // iterativo
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

  // recursivo
  public void insertarIesimo1(int x, int i) {
    insertarIesimoR(x, i, 0, prim, null);
  }

  private void insertarIesimoR(int x, int i, int k, Nodo p, Nodo ap) {
    if (k >= i || p == null) {
      this.insertarNodo(ap, p, x);
    } else {
      insertarIesimoR(x, i, k + 1, p.prox, p);
    }
  }

  /**
   * 4. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de
   * la lista L1 son iguales.
   */
  // iterativo
  public boolean iguales() {
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) == this.cantElem)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean iguales1() {
    return igualesR(prim);
  }

  private boolean igualesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (this.frecuencia(p.elem) == this.cantElem)
        return true;
      return igualesR(p.prox);
    }
  }

  /**
   * 5. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 son diferentes.
   */
  public boolean diferentes() {
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) > 1)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean diferentes1() {
    return diferentesR(prim);
  }

  private boolean diferentesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (this.frecuencia(p.elem) > 1)
        return false;
      return diferentesR(p.prox);
    }
  }

  /**
   * 6. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
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

  private int mayorElemR(Nodo p, int mayor) {
    if (p == null) {
      return mayor;
    } else {
      if (mayor < p.elem) {
        mayor = p.elem;
      }
      return mayorElemR(p.prox, mayor);
    }
  }

  /**
   * 7. L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
   */
  // iterativo
  public int menorElem() {
    Nodo p = prim;
    int menor = p.elem;
    while (p != null) {
      if (menor > p.elem) {
        menor = p.elem;
      }
      p = p.prox;
    }
    return menor;
  }

  // recursivo
  public int menorElem1() {
    return menorElemR(prim, prim.elem);
  }

  private int menorElemR(Nodo p, int menor) {
    if (p == null) {
      return menor;
    } else {
      if (menor < p.elem) {
        menor = p.elem;
      }
      return mayorElemR(p.prox, menor);
    }
  }

  /**
   * 8. L1.ordenado() : Método Lógico que devuelve True, si todos los elementos de
   * la lista L1 están ordenados en forma ascendente o descendente.
   */
  // iterativo
  public boolean ordenado() {
    return ordenadoAsc() || ordenadoDesc();
  }

  private boolean ordenadoAsc() {
    Nodo p = prim;
    while (p != null) {
      if (p.prox != null) {
        if (p.elem > p.prox.elem)
          return false;
      }
      p = p.prox;
    }
    return true;
  }

  private boolean ordenadoDesc() {
    Nodo p = prim;
    while (p != null) {
      if (p.prox != null) {
        if (p.elem < p.prox.elem)
          return false;
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

  /**
   * 9. L1.pares() : Método lógico que devuelve True, si todos los elementos de la
   * lista L1 son pares.
   */
  // iterativo
  public boolean pares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 0)
        return false;

      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean pares1() {
    return paresR(prim);
  }

  private boolean paresR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 0) {
        return false;
      }
      return paresR(p.prox);
    }
  }

  /*
   * 10. L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene
   * al menos un elemento par e impar.
   */
  // iterativo
  public boolean parImpar() {
    Nodo p = prim;
    boolean hayPar = false;
    boolean hayImpar = false;
    while (p != null) {
      if (p.elem % 2 == 0) {
        hayPar = true;
      } else {
        hayImpar = true;
      }
      p = p.prox;
    }
    return hayPar && hayImpar;
  }

  // recursivo
  public boolean parImpar1() {
    return parImparR(prim, false, false);
  }

  private boolean parImparR(Nodo p, boolean hayPar, boolean hayImpar) {
    if (p == null) {
      return hayPar && hayImpar;
    } else {
      if (p.elem % 2 == 0) {
        hayPar = true;
      } else {
        hayImpar = true;
      }
      return parImparR(p.prox, hayPar, hayImpar);
    }
  }

  /*
   * 11. L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del
   * elemento x por el elemento y en la lista L1.
   */
  // iterativo
  public void reemplazar(int x, int y) {
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x) {
        p.elem = y;
      }
      p = p.prox;
    }
  }

  // recursivo
  public void reemplazar1(int x, int y) {
    reemplazarR(prim, x, y);
  }

  private void reemplazarR(Nodo p, int x, int y) {
    if (p == null) {
      return;
    }
    if (p.elem == x) {
      p.elem = y;
    }
    reemplazarR(p.prox, x, y);
  }

  /**
   * 12. L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se
   * encuentra en la lista L1.
   */
  // iterativo
  public boolean seEncuentra(int x) {
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean seEncuentra1(int x) {
    return seEncuentraR(prim, x);
  }

  private boolean seEncuentraR(Nodo p, int x) {
    if (p == null) {
      return false;
    } else {
      if (p.elem == x)
        return true;
      return seEncuentraR(p.prox, x);
    }
  }

  /*
   * 13. L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece
   * el elemento x en la lista L1.
   */
  // iterativo
  public int frecuencia(int x) {
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

  // recursivo
  public int frecuencia1(int x) {
    return frecuenciaR(prim, x);
  }

  private int frecuenciaR(Nodo p, int x) {
    if (p == null) {
      return 0;
    } else {
      int frecuencia = frecuenciaR(p.prox, x);
      if (p.elem == x) {
        frecuencia++;
      }
      return frecuencia;
    }
  }

  /*
   * 14. L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún
   * elemento que se repite exactamente k-veces en la lista L1.
   */
  // iterativo
  public boolean existeFrec(int k) {
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) == k)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean existeFrec1(int k) {
    return existeFrecR(prim, k);
  }

  private boolean existeFrecR(Nodo p, int k) {
    if (p == null) {
      return false;
    } else {
      if (this.frecuencia(p.elem) == k) {
        return true;
      }
      return existeFrecR(p.prox, k);
    }
  }

  /*
   * 15. L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 tienen la misma frecuencia.
   */
  // iterativo
  public boolean mismasFrec() {
    Nodo p = prim;
    int frecPrimero = this.frecuencia(p.elem);
    while (p != null) {
      if (this.frecuencia(p.elem) != frecPrimero)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean mismasFrec1() {
    return mismasFrecR(prim, this.frecuencia(prim.elem));
  }

  private boolean mismasFrecR(Nodo p, int frecPrimero) {
    if (p == null) {
      return true;
    } else {
      if (this.frecuencia(p.elem) != frecPrimero)
        return false;
      return mismasFrecR(p.prox, frecPrimero);
    }
  }

  /*
   * 16. L1.poker() : Método Lógico que devuelve True, si los elementos de la
   * lista L1 forman poker. (Todos los elementos son iguales excepto uno)
   */
  // iterativo
  public boolean poker() {
    if (prim == null || prim.prox == null) {
      return false;
    }
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) == cantElem - 1) {
        return true;
      }
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean poker1() {
    if (prim == null || prim.prox == null) {
      return false;
    }
    return pokerR(prim);
  }

  private boolean pokerR(Nodo p) {
    if (p == null) {
      return false;
    } else {
      if (this.frecuencia(p.elem) == cantElem - 1) {
        return true;
      }
      return pokerR(p.prox);
    }
  }

  /*
   * 17. L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene
   * al menos un elemento par.
   */
  // iterativo
  public boolean existePar() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 == 0)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean existePar1() {
    return existeParR(prim);
  }

  private boolean existeParR(Nodo p) {
    if (p == null) {
      return false;
    } else {
      if (p.elem % 2 == 0)
        return true;
      return existeParR(p.prox);
    }
  }

  /*
   * 18. L1.existeImpar() : Método lógico que devuelve True, si la lista L1
   * contiene al menos un elemento impar.
   */
  // iterativo
  public boolean existeImpar() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 == 1)
        return true;
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean existeImpar1() {
    return existeImparR(prim);
  }

  private boolean existeImparR(Nodo p) {
    if (p == null) {
      return false;
    } else {
      if (p.elem % 2 == 1)
        return true;
      return existeImparR(p.prox);
    }
  }

  /*
   * 19. L1.todoPares() : Método lógico que devuelve True, si todos los elementos
   * de la lista L1 son pares.
   */
  // iterativo
  public boolean todoPares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 0)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean todoPares1() {
    return todoParesR(prim);
  }

  private boolean todoParesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 0)
        return false;
      return todoParesR(p.prox);
    }
  }

  /*
   * 20. L1.todoImpares() : Método lógico que devuelve True, si todos los
   * elementos de la lista L1 son impares.
   */
  // iteativo
  public boolean todoImpares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 1)
        return false;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean todoImpares1() {
    return todoImparesR(prim);
  }

  private boolean todoImparesR(Nodo p) {
    if (p == null) {
      return true;
    } else {
      if (p.elem % 2 != 1)
        return false;
      return todoImparesR(p.prox);
    }
  }

  /*
   * 21. L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1
   * al menos existe un elemento par y un elemento impar.
   */
  // itertativo
  public boolean existeParImpar() {
    return this.existePar() && this.existeImpar();
  }

  // recursivo
  public boolean existeParImpar1() {
    return this.existePar1() && this.existeImpar1();
  }

  /*
   * 22. L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene
   * elementos en la siguiente secuencia: par, impar, par, impar, . . . or impar,
   * par, impar, par, . . . .
   */
  // iterativo
  public boolean alternos() {
    if (prim == null)
      return false;
    Nodo p = prim;
    boolean esPar = p.elem % 2 == 0;
    p = p.prox;
    while (p != null) {
      if ((p.elem % 2 == 0) == esPar) {
        return false;
      }
      esPar = !esPar;
      p = p.prox;
    }
    return true;
  }

  // recursivo
  public boolean alternos1() {
    if (prim == null) {
      return false;
    }
    return alternosR(prim.prox, prim.elem % 2 == 0);
  }

  private boolean alternosR(Nodo p, boolean esPar) {
    if (p == null) {
      return true;
    } else {
      if ((p.elem % 2 == 0) == esPar) {
        return false;
      }
      return alternosR(p.prox, !esPar);
    }
  }

  /*
   * 23. L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al
   * final de la Lista L1.
   */
  // iterativo
  public void insertarUlt(Lista L2) {
    Nodo p = L2.prim;
    while (p != null) {
      this.insertarUlt(p.elem);
      p = p.prox;
    }
  }

  // recursivo
  public void insertarUlt1(Lista L2) {
    insertarUltR(L2.prim);
  }

  private void insertarUltR(Nodo p) {
    if (p == null) {
      return;
    }
    this.insertarUlt(p.elem);
    insertarUltR(p.prox);
  }

  /*
   * 24. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de menor a mayor.
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
      insertarNodo(ap, p, x);
    } else {
      insertarLugarAscR(p.prox, p, x);
    }
  }

  /*
   * 25. L1.insertarLugarDesc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de mayor a menor.
   */
  // iterativo
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
      insertarNodo(ap, p, x);
    } else {
      insertarLugarDescR(p.prox, p, x);
    }
  }

  /*
   * 26. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas
   * L2 con L3 en L1.
   */
  // iterativo
  public void intercalar(Lista L2, Lista L3) {
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
  public void intercalar1(Lista L2, Lista L3) {
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
   * 27. Adicionar al menos 5 métodos cualesquiera de consultas interesantes que
   * sean coherentes con los ejercicios de arriba.
   */
  /*
   * 1. L1.contieneDuplicados() : Método lógico que devuelve true si la lista
   * contiene al menos un elemento duplicado.
   */
  // iterativo
  public boolean contieneDuplicados() {
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) > 1) {
        return true;
      }
      p = p.prox;
    }
    return false;
  }

  // recursivo
  public boolean contieneDuplicados1() {
    return contieneDuplicadosR(prim);
  }

  private boolean contieneDuplicadosR(Nodo p) {
    if (p == null) {
      return false;
    } else {
      if (this.frecuencia(p.elem) > 1) {
        return true;
      }
      return contieneDuplicadosR(p.prox);
    }
  }

  /*
   * 2. L1.eliminarRepetidos() : Método que elimina todos los elementos repetidos,
   * dejando solo una ocurrencia de cada elemento en la lista.
   */
  // iterativo
  public void eliminarRepetidos() {
    Nodo p = prim;
    while (p != null) {
      Nodo q = p.prox;
      Nodo ap = p;
      while (q != null) {
        if (q.elem == p.elem) {
          ap.prox = q.prox;
        } else {
          ap = q;
        }
        q = q.prox;
      }
      p = p.prox;
    }
  }

  // recursivo
  public void eliminarRepetidos1() {
    eliminarRepetidosR1(prim);
  }

  private void eliminarRepetidosR1(Nodo p) {
    if (p == null) {
      return;
    }
    Nodo q = p.prox;
    Nodo ap = p;
    eliminarRepetidosR2(q, p, ap);
    eliminarRepetidosR1(p.prox);
  }

  private void eliminarRepetidosR2(Nodo q, Nodo p, Nodo ap) {
    if (q == null) {
      return;
    }
    if (q.elem == p.elem) {
      ap.prox = q.prox;
    } else {
      ap = q;
    }
    eliminarRepetidosR2(q.prox, p, ap);
  }

  /*
   * 3. L1.invertir() : Método que invierte el orden de los elementos de la lista.
   */
  // iterativo
  public void invertir() {
    Nodo ap = null;
    Nodo p = prim;
    while (p != null) {
      Nodo sig = p.prox;
      p.prox = ap;
      ap = p;
      p = sig;
    }
    prim = ap;
  }

  // recursivo
  public void invertir1() {
    invertirR(prim, null);
  }

  private void invertirR(Nodo p, Nodo ap) {
    if (p == null) {
      prim = ap;
    } else {
      Nodo sig = p.prox;
      p.prox = ap;
      ap = p;
      p = sig;
    }
  }

  /*
   * 4. L1.sumaElementos() : Método que devuelve la suma de todos los elementos de
   * la lista.
   */
  // iterativo
  public int sumaElementos() {
    Nodo p = prim;
    int suma = 0;
    while (p != null) {
      suma += p.elem;
      p = p.prox;
    }
    return suma;
  }

  // recursivo
  public int sumaElementos1() {
    return sumaElementosR(prim);
  }

  private int sumaElementosR(Nodo p) {
    if (p == null) {
      return 0;
    } else {
      return p.elem + sumaElementosR(p.prox);
    }
  }

  /*
   * 5. L1.ordenar() : Método que ordena los elementos de la lista de menor a
   * mayor
   */
  // iterativo
  public void ordenar() {
    Nodo p = this.prim;
    while (p != null) {
      Nodo q = p.prox;
      while (q != null) {
        if (p.elem > q.elem) {
          int temporal = p.elem;
          p.elem = q.elem;
          q.elem = temporal;
        }
        q = q.prox;
      }
      p = p.prox;
    }
  }

  // recursivo
  public void ordenar1() {
    ordenarR1(prim);
  }

  private void ordenarR1(Nodo p) {
    if (p == null) {
      return;
    }
    ordenarR2(p, p.prox);
    ordenarR1(p.prox);
  }

  private void ordenarR2(Nodo p, Nodo q) {
    if (q == null) {
      return;
    }
    if (p.elem > q.elem) {
      int temporal = p.elem;
      p.elem = q.elem;
      q.elem = temporal;
    }
    ordenarR2(p, q.prox);
  }
}
