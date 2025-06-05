package tema2.tarea3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArbolCadena {
  public NodoCadena raiz;

  public ArbolCadena() {
    raiz = null;
  }

  public void insertar(String x) {
    raiz = insertar(x, raiz);
  }

  /*
   * Ejercicio-2.
   * 
   * Implementar el Ejercicios-1, con elementos Strings. Es decir; los elementos
   * ya no son enteros, sino Cadenas de Caracteres, utilizar s1.compareTo(s2),
   * s1.equals(s2), para comparar dos cadenas de caracteres.
   * 
   * Para ejecutar con n-palabras, para n-grande. Leer los datos de un Archivo de
   * Texto y utilizar StringTokenizer() y utilizar todos los delimitadores
   * posibles de palabras, para encontrar cada palabra del Archivo de Texto, para
   * facilitar las consultas transformar todas las palabras del Texto a
   * minúsculas. Utilizar un archivo de texto cualquiera de al menos 5 páginas de
   * un documento.
   */

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

  public void leerCadena(String cadena) {
    String delimitadores = " \t\n\r\f,.:;?!¡¿\"'()[]{}<>/\\|-_=+*&^%$#@`~1234567890";
    StringTokenizer tokenizer = new StringTokenizer(cadena, delimitadores);
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
}
