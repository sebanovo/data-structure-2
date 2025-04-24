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

  public void insertarLugar(int x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null && x > p.elem) {
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  /**
   * 4. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de
   * la lista L1 son iguales.
   */
  public boolean iguales() {
    Nodo p = prim;
    int primerElemento = p.elem;
    while (p != null) {
      if (p.elem != primerElemento)
        return false;
      p = p.prox;
    }
    return true;
  }

  /**
   * 5. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 son diferentes.
   */
  public boolean diferentes() {
    Nodo p1 = prim;
    while (p1 != null) {
      Nodo p2 = prim;
      while (p2 != null) {
        if (p1 != p2 && p1.elem == p2.elem)
          return false;
        p2 = p2.prox;
      }
      p1 = p1.prox;
    }
    return true;
  }

  /**
   * 6. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
   */
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

  /**
   * 7. L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
   */
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

  /**
   * 8. L1.ordenado() : Método Lógico que devuelve True, si todos los elementos de
   * la lista L1 están ordenados en forma ascendente o descendente.
   */
  public boolean ordenadoAsc() {
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

  public boolean ordenadoDesc() {
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

  public boolean ordenado() {
    return ordenadoAsc() || ordenadoDesc();
  }

  /**
   * 9. L1.pares() : Método lógico que devuelve True, si todos los elementos de la
   * lista L1 son pares.
   */
  public boolean pares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 0)
        return false;

      p = p.prox;
    }
    return true;
  }

  /*
   * 10. L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene
   * al menos un elemento par e impar.
   */
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

  /*
   * 11. L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del
   * elemento x por el elemento y en la lista L1.
   */
  public void reemplazar(int x, int y) {
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x) {
        p.elem = y;
      }
      p = p.prox;
    }
  }

  /**
   * 12. L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se
   * encuentra en la lista L1.
   */
  public boolean seEncuentra(int x) {
    Nodo p = prim;
    while (p != null) {
      if (p.elem == x)
        return true;
      p = p.prox;
    }
    return false;
  }

  /*
   * 13. L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece
   * el elemento x en la lista L1.
   */
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

  /*
   * 14. L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún
   * elemento que se repite exactamente k-veces en la lista L1.
   */
  public boolean existeFrec(int k) {
    Nodo p = prim;
    while (p != null) {
      if (this.frecuencia(p.elem) == k)
        return true;
      p = p.prox;
    }
    return false;
  }

  /*
   * 15. L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos
   * de la lista L1 tienen la misma frecuencia.
   */
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

  /*
   * 16. L1.poker() : Método Lógico que devuelve True, si los elementos de la
   * lista L1 forman poker. (Todos los elementos son iguales excepto uno)
   */
  public boolean poker() {
    if (prim == null || prim.prox == null) {
      return false;
    }

    Nodo p = prim;
    int elementoComun = p.elem;
    int elementoDiferente = elementoComun;
    int cantDiferente = 0;

    while (p != null) {
      if (p.elem != elementoComun) {
        elementoDiferente = p.elem;
        cantDiferente++;
      }
      p = p.prox;
    }
    if (cantDiferente > 1) {
      return false;
    }

    if (cantDiferente == 1 && this.frecuencia(elementoDiferente) == 1) {
      int frecComun = this.frecuencia(elementoComun);
      return frecComun == this.cantElem - 1;
    }
    return false;
  }

  /*
   * 17. L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene
   * al menos un elemento par.
   */
  public boolean existePar() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 == 0)
        return true;
      p = p.prox;
    }
    return false;
  }

  /*
   * 18. L1.existeImpar() : Método lógico que devuelve True, si la lista L1
   * contiene al menos un elemento impar.
   */
  public boolean existeImpar() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 == 1)
        return true;
      p = p.prox;
    }
    return false;
  }

  /*
   * 19. L1.todoPares() : Método lógico que devuelve True, si todos los elementos
   * de la lista L1 son pares.
   */
  public boolean todoPares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 0)
        return false;
      p = p.prox;
    }
    return true;
  }

  /*
   * 20. L1.todoImpares() : Método lógico que devuelve True, si todos los
   * elementos de la lista L1 son impares.
   */
  public boolean todoImpares() {
    Nodo p = prim;
    while (p != null) {
      if (p.elem % 2 != 1)
        return false;
      p = p.prox;
    }
    return true;
  }

  /*
   * 21. L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1
   * al menos existe un elemento par y un elemento impar.
   */
  public boolean existeParImpar() {
    return this.existePar() && this.existeImpar();
  }

  /*
   * 22. L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene
   * elementos en la siguiente secuencia: par, impar, par, impar, . . . or impar,
   * par, impar, par, . . . .
   */
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

  /*
   * 23. L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al
   * final de la Lista L1.
   */
  public void insertarUlt(Lista L2) {
    Nodo p = L2.prim;
    while (p != null) {
      this.insertarUlt(p.elem);
      p = p.prox;
    }
  }

  /*
   * 24. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de menor a mayor.
   */
  public void insertarLugarAsc(int x) {
    Nodo p = prim;
    Nodo ap = null;
    while (p != null && x > p.elem) {
      ap = p;
      p = p.prox;
    }
    insertarNodo(ap, p, x);
  }

  /*
   * 25. L1.insertarLugarDesc(x) : Método que inserta el elemento x, en su lugar
   * correspondiente en la Lista L1, ordenada de mayor a menor.
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

  /*
   * 26. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas
   * L2 con L3 en L1.
   */
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

  /*
   * 27. Adicionar al menos 5 métodos cualesquiera de consultas interesantes que
   * sean coherentes con los ejercicios de arriba.
   */
  /*
   * 1. L1.contieneDuplicados() : Método lógico que devuelve true si la lista
   * contiene al menos un elemento duplicado.
   */
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

  /*
   * 2. L1.eliminarRepetidos() : Método que elimina todos los elementos repetidos,
   * dejando solo una ocurrencia de cada elemento en la lista.
   */
  public void eliminarRepetidos() {
    Nodo p = prim;
    while (p != null) {
      Nodo q = p.prox;
      Nodo prev = p;
      while (q != null) {
        if (q.elem == p.elem) {
          prev.prox = q.prox;
        } else {
          prev = q;
        }
        q = q.prox;
      }
      p = p.prox;
    }
  }

  /*
   * 3. L1.invertir() : Método que invierte el orden de los elementos de la lista.
   */
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

  /*
   * 4. L1.sumaElementos() : Método que devuelve la suma de todos los elementos de
   * la lista.
   */
  public int sumaElementos() {
    Nodo p = prim;
    int suma = 0;
    while (p != null) {
      suma += p.elem;
      p = p.prox;
    }
    return suma;
  }

  /*
   * 5. L1.ordenar() : Método que ordena los elementos de la lista de menor a
   * mayor
   */
  public void ordenar() {
    Nodo p = this.prim;
    Nodo q = null;
    while (p != null) {
      q = p.prox;
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
}
