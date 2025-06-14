package tema2.tarea6;

import java.util.*;

public class ArbolCadena {

  public NodoCadena raiz;

  public ArbolCadena() {
    raiz = null;
  }

  public void insertar(String x) {
    raiz = insertar(x, raiz);
  }

  private NodoCadena insertar(String x, NodoCadena p) {
    if (p == null) {
      return new NodoCadena(x);
    }
    if (x.compareTo(p.elem) < 0) {
      p.izq = insertar(x, p.izq);
    } else if (x.compareTo(p.elem) > 0) {
      p.der = insertar(x, p.der);
    } else {
      p.frec++;
    }
    return p;
  }

  public void mostrarMenorMayor() {
    mostrarMenorMayor(raiz);
    System.out.print('\n');
  }

  private void mostrarMenorMayor(NodoCadena p) {
    if (p == null) {
      return;
    }
    mostrarMenorMayor(p.izq);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMenorMayor(p.der);
  }

  public void mostrarMayorMenor() {
    mostrarMayorMenor(raiz);
    System.out.print('\n');
  }

  private void mostrarMayorMenor(NodoCadena p) {
    if (p == null) {
      return;
    }
    mostrarMayorMenor(p.der);
    System.out.print(p.elem + " " + p.frec + "\n");
    mostrarMayorMenor(p.izq);
  }

  /*
   * 0. A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
   */
  public void eliminar(String x) {
    raiz = eliminar(x, raiz);
  }

  private NodoCadena eliminar(String x, NodoCadena p) {
    if (p == null) {
      return null;
    }
    if (x.equals(p.elem)) {
      return eliminarNodo(p);
    }
    if (x.compareTo(p.elem) < 0) {
      p.izq = eliminar(x, p.izq);
    } else {
      p.der = eliminar(x, p.der);
    }
    return p;
  }

  private NodoCadena eliminarNodo(NodoCadena p) {
    if (p.izq == null && p.der == null) {
      return null;
    }
    if (p.izq == null && p.der != null) {
      return p.der;
    }
    if (p.izq != null && p.der == null) {
      return p.izq;
    }

    NodoCadena q = p.der;
    while (q.izq != null) {
      q = q.izq;
    }
    p.der = eliminar(q.elem, p.der);
    p.elem = q.elem;
    return p;
  }

  /*
   * 1. A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se
   * encuentran en el árbol A1.
   */
  public void eliminar(ArrayList<String> L1) {
    raiz = eliminar(L1, raiz);
  }

  private NodoCadena eliminar(ArrayList<String> L1, NodoCadena p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminar(L1, p.izq);
    p.der = eliminar(L1, p.der);
    for (int i = 0; i < L1.size(); i++) {
      if (L1.get(i).equals(p.elem)) {
        return eliminarNodo(p);
      }
    }
    return p;
  }

  /*
   * 2. A1.eliminarRaices() : Método que elimina los nodos raíces del árbol A1.
   */
  public void eliminarRaices() {
    raiz = eliminarRaices(raiz);
  }

  public NodoCadena eliminarRaices(NodoCadena p) {
    if (p == null) {
      return null;
    }
    p.izq = eliminarRaices(p.izq);
    p.der = eliminarRaices(p.der);
    if (p.izq != null && p.der != null) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 3. A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.
   */
  public void eliminarHojas() {
    raiz = eliminarHojas(raiz);
  }

  private NodoCadena eliminarHojas(NodoCadena p) {
    if (p == null) {
      return null;
    }
    if (p.izq == null && p.der == null) {
      return eliminarNodo(p);
    }
    p.izq = eliminarHojas(p.izq);
    p.der = eliminarHojas(p.der);
    return p;
  }

  /*
   * 4. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En
   * lo posible citar fuente.
   */
  /*
   * 1. A1.eliminarSiEmpiezaCon(prefijo) : elimina las palabras que comienzan con
   * el prefijo dado.
   */
  public void eliminarSiEmpiezaCon(String prefijo) {
    raiz = eliminarSiEmpiezaCon(raiz, prefijo);
  }

  private NodoCadena eliminarSiEmpiezaCon(NodoCadena p, String prefijo) {
    if (p == null)
      return null;
    p.izq = eliminarSiEmpiezaCon(p.izq, prefijo);
    p.der = eliminarSiEmpiezaCon(p.der, prefijo);
    if (p.elem.startsWith(prefijo)) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 2. A1.eliminarPalabrasConCaracter(c) : elimina las palabras que tengan el
   * caracter c.
   */
  public void eliminarSiContiene(char c) {
    raiz = eliminarSiContiene(raiz, c);
  }

  private NodoCadena eliminarSiContiene(NodoCadena p, char c) {
    if (p == null)
      return null;
    p.izq = eliminarSiContiene(p.izq, c);
    p.der = eliminarSiContiene(p.der, c);
    if (p.elem.indexOf(c) >= 0) {
      return eliminarNodo(p);
    }
    return p;
  }

  /*
   * 3. A1.eliminarPalindromos() : Eliminar las palabras que son palíndromos.
   */
  public void eliminarPalindromos() {
    raiz = eliminarPalindromos(raiz);
  }

  private NodoCadena eliminarPalindromos(NodoCadena p) {
    if (p == null)
      return null;
    p.izq = eliminarPalindromos(p.izq);
    p.der = eliminarPalindromos(p.der);
    if (esPalindromo(p.elem)) {
      return eliminarNodo(p);
    }
    return p;
  }

  private boolean esPalindromo(String palabra) {
    int i = 0, j = palabra.length() - 1;
    while (i < j) {
      if (palabra.charAt(i++) != palabra.charAt(j--))
        return false;
    }
    return true;
  }

  /*
   * 4. A1.eliminarPalabrasConLetraRepetida() : Elimina las palabras que tienen
   * letras repetidas.
   */
  public void eliminarConLetraRepetida() {
    raiz = eliminarConLetraRepetida(raiz);
  }

  private NodoCadena eliminarConLetraRepetida(NodoCadena p) {
    if (p == null)
      return null;
    p.izq = eliminarConLetraRepetida(p.izq);
    p.der = eliminarConLetraRepetida(p.der);
    if (tieneLetraRepetida(p.elem)) {
      return eliminarNodo(p);
    }
    return p;
  }

  private boolean tieneLetraRepetida(String palabra) {
    palabra = palabra.toLowerCase();
    int[] contador = new int[26];
    for (char c : palabra.toCharArray()) {
      if (c < 'a' || c > 'z')
        continue;
      contador[c - 'a']++;
      if (contador[c - 'a'] > 1)
        return true;
    }
    return false;
  }

  /*
   * 5. A1.eliminarPalabrasConVocalesRepetidas() : Elimina palabras con vocales
   * repetidas.
   */
  public void eliminarVocalesRepetidas() {
    raiz = eliminarVocalesRepetidas(raiz);
  }

  private NodoCadena eliminarVocalesRepetidas(NodoCadena p) {
    if (p == null)
      return null;
    p.izq = eliminarVocalesRepetidas(p.izq);
    p.der = eliminarVocalesRepetidas(p.der);
    if (tieneVocalesRepetidas(p.elem)) {
      return eliminarNodo(p);
    }
    return p;
  }

  private boolean tieneVocalesRepetidas(String palabra) {
    palabra = palabra.toLowerCase();
    int a = 0, e = 0, i = 0, o = 0, u = 0;
    for (char c : palabra.toCharArray()) {
      if (c == 'a')
        a++;
      else if (c == 'e')
        e++;
      else if (c == 'i')
        i++;
      else if (c == 'o')
        o++;
      else if (c == 'u')
        u++;
    }
    return a > 1 || e > 1 || i > 1 || o > 1 || u > 1;
  }

  /*
   * #############
   * # CONSULTAS #
   * #############
   */
  /*
   * 1,2,3,9. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol
   * A1.
   */
  public int cantidad() {
    return cantidad(raiz);
  }

  private int cantidad(NodoCadena p) {
    if (p == null) {
      return 0;
    }
    return cantidad(p.izq) + cantidad(p.der) + 1;
  }

  /*
   * 4,5. A1.Altura() : Método que devuelva la altura del arbol.
   */
  public int altura() {
    return altura(raiz);
  }

  private int altura(NodoCadena p) {
    if (p == null) {
      return 0;
    }
    int altIzq = altura(p.izq);
    int altDer = altura(p.der);
    return Math.max(altIzq, altDer) + 1;
  }

  /*
   * 7. A1.contarPalabrasConLetra(letra) Cuenta recursivamente las palabras que
   * contienen la letra dada.
   */
  public int contarPalabrasConLetra(char letra) {
    letra = Character.toLowerCase(letra);
    return contarPalabrasConLetra(raiz, letra);
  }

  private int contarPalabrasConLetra(NodoCadena p, char letra) {
    if (p == null) {
      return 0;
    }

    int count = 0;
    String palabra = p.elem.toLowerCase();
    if (palabra.indexOf(letra) != -1) {
      count = 1;
    }
    count += contarPalabrasConLetra(p.izq, letra);
    count += contarPalabrasConLetra(p.der, letra);

    return count;
  }

  /*
   * 8. buscar(palabra) : Busca la palabra exacta en el árbol
   */
  public boolean buscar(String palabra) {
    return buscar(raiz, palabra.toLowerCase());
  }

  private boolean buscar(NodoCadena nodo, String palabra) {
    if (nodo == null) {
      return false;
    }

    String elem = nodo.elem.toLowerCase();
    int cmp = palabra.compareTo(elem);

    if (cmp == 0) {
      return true;
    } else if (cmp < 0) {
      return buscar(nodo.izq, palabra);
    } else {
      return buscar(nodo.der, palabra);
    }
  }
  /**
   * Bibliografia:
   * https://utilities-library.vercel.app/classes/BinarySearchTree.html
   * https://github.com/sebanovo/utilities-library/blob/master/src/class/binarysearchtree/binarysearch.tree.ts#L11
   * https://chatgpt.com/
   */
}