package tema2.tarea5;

import java.io.*;
import java.util.*;

public class Lista {
  int cantElem;
  ArrayList<Arbol> lista;
  int MAX = 100000;

  public Lista() {
    lista = new ArrayList<Arbol>(MAX);
    cantElem = 0;

    for (int i = 0; i < MAX; i++) {
      lista.add(new Arbol());
      cantElem++;
    }
  }

  public void insertar(String cadena) {
    int longitud = cadena.length();
    Arbol arbol = lista.get(longitud);
    arbol.insertar(cadena);
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
}