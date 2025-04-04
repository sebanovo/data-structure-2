package tarea5;

public class Tabla {
  /**
   * 1. tabla( n ) : Procedimiento que muestra la tabla de multiplicación de 1 a
   * n.
   */
  // iterativo
  public static void tabla(int n) {
    int i = 1;
    while (i <= n) {
      int j = 1;
      while (j <= n) {
        System.out.println(i + " * " + j + " = " + i * j);
        j++;
      }
      i++;
      System.out.println("\n");
    }
  }

  // recursivo
  public static void tabla1(int n) {
    tablaRI(n, 1);
  }

  private static void tablaRI(int n, int i) {
    if (i > n)
      return;
    tablaRJ(n, i, 1);
    System.out.println("\n");
    tablaRI(n, i + 1);
  }

  private static void tablaRJ(int n, int i, int j) {
    if (j > n)
      return;
    System.out.println(i + " * " + j + " = " + i * j);
    tablaRJ(n, i, j + 1);
  }

  /**
   * 2. tabla( n, k ) : Procedimiento que muestra la tabla de multiplicación de 1
   * a n, muestra solamente cuando la multiplicación es igual a k.
   */
  // iterativo
  public static void tabla2(int n, int k) {
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i * j == k) {
          System.out.println(i + "x" + j + "=" + (i * j) + "\n");
        }
      }
    }
  }

  // recursivo
  public static void tabla3(int n, int k) {
    cicloa(n, k, 1);
  }

  private static void cicloa(int n, int k, int i) {
    if (i > n)
      return;
    ciclob(n, k, i, 1);
    cicloa(n, k, i + 1);
  }

  private static void ciclob(int n, int k, int i, int j) {
    if (j > n)
      return;
    if ((i * j) == k) {
      System.out.println(i + "x" + j + "=" + (i * j));
    }
    ciclob(n, k, i, j + 1);
  }

  /**
   * 3. tablaAscDesc( n ): Procedimiento que muestra la tabla de multiplicar de n
   * con el primer factor ascendente y el segundo descendente.
   */
  // iterativo
  public static void tablaAscDesc(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = n; j >= 1; j--) {
        System.out.println(i + " * " + j + " = " + i * j);
      }
      System.out.println("\n");
    }
  }

  // recursivo
  public static void tablaAscDesc1(int n) {
    tablaAscDescRI(n, 1);
  }

  private static void tablaAscDescRI(int n, int i) {
    if (i > n)
      return;
    tablaAscDescRJ(n, i, n);
    System.out.println("\n");
    tablaAscDescRI(n, i + 1);
  }

  private static void tablaAscDescRJ(int n, int i, int j) {
    if (j < 1)
      return;
    System.out.println(i + " * " + j + " = " + i * j);
    tablaAscDescRJ(n, i, j - 1);
  }

  /**
   * 4. tablaDescAsc( n ): Procedimiento que muestra la tabla de multiplicar de n
   * con el primer factor Descendente y el segundo ascendente.
   */
  // iterativo
  public static void tablaDesAsc(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= n; j++) {
        System.out.println(i + " * " + j + " = " + i * j);
      }
      System.out.println("\n");
    }
  }

  // recursivo
  public static void tablaDescAsc1(int n) {
    tablaDescAscRI(n, n);
  }

  private static void tablaDescAscRI(int n, int i) {
    if (i < 1)
      return;
    tablaDescAscRJ(n, i, 1);
    System.out.println("\n");
    tablaDescAscRI(n, i - 1);
  }

  private static void tablaDescAscRJ(int n, int i, int j) {
    if (j > n)
      return;
    System.out.println(i + " * " + j + " = " + i * j);
    tablaDescAscRJ(n, i, j + 1);
  }

  /**
   * 5. tablaPares( n ): Procedimiento que muestra la tabla de multiplicar de n,
   * con factores pares. (incrementar de 2 en 2)
   */
  // iterativo
  public static void tablaPares(int n) {
    int i = 2;
    while (i <= n) {
      int j = 2;
      while (j <= n) {
        System.out.println(i + "*" + j + "=" + i * j);
        j = j + 2;
      }
      System.out.println("");
      i = i + 2;
    }
  }

  // recursivo
  public static void tablaPares2(int n) {
    cicloIPares(n, 2);
  }

  private static void cicloIPares(int n, int i) {
    if (i > n)
      return;
    cicloJPares(n, i, 2);
    System.out.println("");
    cicloIPares(n, i + 2);
  }

  private static void cicloJPares(int n, int i, int j) {
    if (j > n)
      return;
    System.out.println(i + "*" + j + "=" + i * j);
    cicloJPares(n, i, j + 2);
  }

  /**
   * 6. tablaParImpar( n ): Procedimiento que muestra la tabla de multiplicar de n
   * con factores par, impar o impar, par.
   */
  public static void tablaParImpar(int n) {
    int i = 1;
    while (i <= n) {
      int j = 1;
      while (j <= n) {
        if (((i % 2 == 0) && (j % 2 != 0)) || ((i % 2 != 0) && (j % 2 == 0))) {
          System.out.println(i + "*" + j + "=" + i * j);
        }
        j = j + 1;
      }
      System.out.println("");
      i = i + 1;
    }
  }

  // recursivo
  public static void tablaParImpar2(int n) {
    cicloIParImpar(n, 1);
  }

  private static void cicloIParImpar(int n, int i) {
    if (i > n)
      return;
    cicloJParImpar(n, i, 1);
    System.out.println("");
    cicloIParImpar(n, i + 1);
  }

  private static void cicloJParImpar(int n, int i, int j) {
    if (j > n)
      return;
    if (((i % 2 == 0) && (j % 2 != 0)) || ((i % 2 != 0) && (j % 2 == 0))) {
      System.out.println(i + "*" + j + "=" + i * j);
    }
    cicloJParImpar(n, i, j + 1);
  }

  /**
   * 7. tablaIguales( n ) : Procedimiento que muestra la tabla de multiplicar de n
   * con factores iguales. Implementar 2 algoritmos con T( n ) = n2 y T(n ) = n.
   */
  // iterativo T(n) = ^2
  public static void tablaIgualesIterativaTn2(int n) {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.println(i + " x " + j + " = " + (i * j));
      }
    }
  }

  // recursivo T(n) = n^2
  public static void tablaIgualesRecursivaTn2(int n) {

    imprimirTablaRecursivaTn2(n, 1);
  }

  private static void imprimirTablaRecursivaTn2(int n, int i) {

    if (i > n) {
      return;
    }

    imprimirFilaRecursivaTn2(n, i, 1);

    imprimirTablaRecursivaTn2(n, i + 1);
  }

  private static void imprimirFilaRecursivaTn2(int n, int i, int j) {

    if (j > n) {
      return;
    }

    System.out.println(i + " x " + j + " = " + (i * j));

    imprimirFilaRecursivaTn2(n, i, j + 1);
  }

  // iterativo T(N) = n
  public static void tablaIgualesIterativaTn(int n) {
    for (int i = 1; i <= n; i++) {
      System.out.println(n + " x " + i + " = " + (n * i));
    }
  }

  // recursivo T(n) = n
  public static void tablaIgualesRecursivaTn(int n) {
    // Llamamos a la función recursiva para imprimir la tabla
    imprimirTablaRecursivaTn(n, 1);
  }

  private static void imprimirTablaRecursivaTn(int n, int i) {

    if (i > n) {
      return;
    }

    System.out.println(n + " x " + i + " = " + (n * i));

    imprimirTablaRecursivaTn(n, i + 1);
  }

  /**
   * 8. tablaSinRepetición( n ) : Procedimiento que muestra la tabla de
   * multiplicar de n, tales que no se repitan la permutación o conmutatividad de
   * factores.
   */
  // iterativo
  public static void tablaSinRepeticionIterativa(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        System.out.println(i + " x " + j + " = " + (i * j));
      }
    }
  }

  // recursivo
  public static void tablaSinRepeticionRecursiva(int n) {
    imprimirTablaRecursivaSinRepeticion(n, 1, 1);
  }

  private static void imprimirTablaRecursivaSinRepeticion(int n, int i, int j) {

    if (i > n) {
      return;
    }
    if (j >= i) {
      System.out.println(i + " x " + j + " = " + (i * j));
    }

    if (j < n) {
      imprimirTablaRecursivaSinRepeticion(n, i, j + 1);
    } else {
      imprimirTablaRecursivaSinRepeticion(n, i + 1, i);
    }
  }
}
