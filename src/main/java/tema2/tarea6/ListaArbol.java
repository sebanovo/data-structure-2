package tema2.tarea6;

import java.io.*;
import java.util.*;

public class ListaArbol {
  int cantElem;
  ArrayList<ArbolCadena> lista;
  int MAX = 100000;

  public ListaArbol() {
    lista = new ArrayList<ArbolCadena>(MAX);
    cantElem = 0;

    for (int i = 0; i < MAX; i++) {
      lista.add(new ArbolCadena());
      cantElem++;
    }
  }

  public void insertar(String cadena) {
    int longitud = cadena.length();
    ArbolCadena ArbolCadena = lista.get(longitud);
    ArbolCadena.insertar(cadena);
  }

  public void mostrarMenorMayor() {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      System.out.println("####### LONGITUD " + i + " #######");
      lista.get(i).mostrarMenorMayor();
    }
  }

  public void leerCadena(String cadena) {
    String cadenaSinAcentosNiÑ = cadena
        .replace("á", "a")
        .replace("é", "e")
        .replace("í", "i")
        .replace("ó", "o")
        .replace("ú", "u")
        .replace("Á", "A")
        .replace("É", "E")
        .replace("Í", "I")
        .replace("Ó", "O")
        .replace("Ú", "U")

        .replace("ñ", "n")
        .replace("Ñ", "N");

    String delimitadores = " \t\n\r\f,.:;?!¡¿\"'()[]{}<>/\\|_=+*&^%$#@`~1234567890";

    StringTokenizer tokenizer = new StringTokenizer(cadenaSinAcentosNiÑ, delimitadores);

    while (tokenizer.hasMoreTokens()) {
      String palabra = tokenizer.nextToken();
      insertar(palabra);
    }
  }

  public void cargarArchivo(String rutaArchivo) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
    String linea;
    while ((linea = reader.readLine()) != null) {
      this.leerCadena(linea.toLowerCase());
    }
    reader.close();
  }

  /*
   * #####################################################
   * # B. Sobre una Lista de ABB de Strings de misma #####
   * # longitud. (Después de haber realizado la lectura ##
   * # de las palabras de un archivo de texto). ##########
   * #####################################################
   */
  /*
   * 1. L1.eliminar(L2): Método que elimina las palabras que aparecen en la Lista
   * de palabras L2, de los árboles de Lista de árboles L1. L2, puede contener por
   * ejemplo artículos or preposiciones or conectivos, etc.
   */
  public void eliminar(ArrayList<String> L2) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminar(L2);
    }
  }

  /*
   * 2. L1.eliminarNodosRaices() : Método que elimina los nodos raíces principales
   * de cada Arbol.
   */
  public void eliminarNodosRaices(ArrayList<String> L2) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarRaices();
    }
  }

  /*
   * 3. L1.eliminarNodosTerm() : Método que elimina los nodos terminales de cada
   * Arbol de L1.
   */
  public void eliminarNodosTerm(ArrayList<String> L2) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarHojas();
    }
  }

  /*
   * 4. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En
   * lo posible citar fuente.
   */
  /*
   * 1. L1.eliminarPalabrasConPrefijo(prefijo) : Eliminar de todos los
   * árboles las palabras que comienzan con el prefijo dado.
   */
  public void eliminarPalabrasConPrefijo(String prefijo) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarSiEmpiezaCon(prefijo);
    }
  }

  /*
   * 2. L1.eliminarPalabrasConCaracter(c) : Eliminar las palabras que contienen un
   * caracter específico.
   */
  public void eliminarPalabrasConCaracter(char c) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarSiContiene(c);
    }
  }

  /*
   * 3. L1.eliminarPalabrasPalindromas() : Eliminar las palabras que son
   * palíndromos.
   */
  public void eliminarPalabrasPalindromas() {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarPalindromos();
    }
  }

  /*
   * 4. L1.eliminarPalabrasConLetraRepetida() : Elimina las palabras que tienen
   * letras repetidas.
   */
  public void eliminarPalabrasConLetraRepetida() {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarConLetraRepetida();
    }
  }

  /*
   * 5. L1.eliminarPalabrasConVocalesRepetidas() : Elimina palabras con vocales
   * repetidas.
   */
  public void eliminarPalabrasConVocalesRepetidas() {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      lista.get(i).eliminarVocalesRepetidas();
    }
  }

  /*
   * #############
   * # CONSULTAS #
   * #############
   */
  /*
   * 1. L1.arbolPequeño() : Método que devuelve el Árbol de menos cantidad de
   * elementos.
   */
  public ArbolCadena arbolPequeño() {
    ArbolCadena arbolMenor = null;
    int cantidadMenor = Integer.MAX_VALUE;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      ArbolCadena arbolActual = lista.get(i);
      int cantidadActual = arbolActual.cantidad();
      if (cantidadMenor > cantidadActual) {
        cantidadMenor = cantidadActual;
        arbolMenor = arbolActual;
      }
    }
    return arbolMenor;
  }

  /*
   * 2. L1.arbolGrande() : Método que devuelve el Árbol de mayor cantidad de
   * elementos.
   */
  public ArbolCadena arbolGrande() {
    ArbolCadena arbolGrande = null;
    int cantidadMayor = 0;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      ArbolCadena arbolActual = lista.get(i);
      int cantidadActual = arbolActual.cantidad();
      if (cantidadMayor > cantidadActual) {
        cantidadMayor = cantidadActual;
        arbolGrande = arbolActual;
      }
    }
    return arbolGrande;
  }

  /*
   * 3. L1.igualTamaño() : Método lógico que devuelve True, si todos los Arboles
   * tiene la misma cantidad de elementos.
   */
  public boolean igualTamaño() {
    ArbolCadena primero = null;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      primero = lista.get(i);
      break;
    }

    int cantidadPrimero = primero.cantidad();
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      ArbolCadena arbolActual = lista.get(i);
      if (cantidadPrimero != arbolActual.cantidad()) {
        return false;
      }
    }
    return true;
  }

  /*
   * 4. L1.arbolMayorAltura() : Método que devuelve el arbol de mayor altura.
   */
  public ArbolCadena arbolMayorAltura() {
    ArbolCadena arbolMayorAltura = null;
    int alturaMayor = 0;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      ArbolCadena arbolActual = lista.get(i);
      int cantidadActual = arbolActual.altura();
      if (alturaMayor > cantidadActual) {
        alturaMayor = cantidadActual;
        arbolMayorAltura = arbolActual;
      }
    }
    return arbolMayorAltura;
  }

  /*
   * 5. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En
   * lo posible citar fuente.
   */
  /*
   * 5. L1.arbolMenorAltura() : Método que devuelve el árbol con menor altura.
   */
  public ArbolCadena arbolMenorAltura() {
    ArbolCadena arbolMenorAltura = null;
    int alturaMenor = Integer.MAX_VALUE;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      ArbolCadena arbolActual = lista.get(i);
      int alturaActual = arbolActual.altura();
      if (alturaActual < alturaMenor) {
        alturaMenor = alturaActual;
        arbolMenorAltura = arbolActual;
      }
    }
    return arbolMenorAltura;
  }

  /*
   * 6. L1.todasVacias() : Método lógico que devuelve true si todos los árboles
   * están vacíos.
   */
  public boolean todasVacias() {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz != null) {
        return false;
      }
    }
    return true;
  }

  /*
   * 7. L1.contarPalabrasConLetra(char) : Cuenta cuántas palabras en toda la
   * lista contienen la letra dada.
   */
  public int contarPalabrasConLetra(char letra) {
    int total = 0;
    letra = Character.toLowerCase(letra);
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      total += lista.get(i).contarPalabrasConLetra(letra);
    }
    return total;
  }

  /*
   * 8. L1.existePalabra(String palabra) : Devuelve true si la palabra está en
   * algún árbol de la lista.
   */
  public boolean existePalabra(String palabra) {
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      if (lista.get(i).buscar(palabra)) {
        return true;
      }
    }
    return false;
  }

  /*
   * 9. L1.contarPalabras() : Devuelve el total de palabras almacenadas en toda la
   * lista de árboles.
   */
  public int contarPalabras() {
    int total = 0;
    for (int i = 1; i < MAX; i++) {
      if (lista.get(i).raiz == null)
        continue;
      total += lista.get(i).cantidad();
    }
    return total;
  }
  /**
   * Bibliografia:
   * https://utilities-library.vercel.app/classes/BinarySearchTree.html
   * https://github.com/sebanovo/utilities-library/blob/master/src/class/binarysearchtree/binarysearch.tree.ts#L11
   * https://chatgpt.com/
   */
}