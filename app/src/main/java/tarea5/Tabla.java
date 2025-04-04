package tarea5;

public class Tabla {
  /**
   * I. TABLA DE MULTIPLICAR CON DOS FACTORES A x B = C (dos ciclos anidados)
   */
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

  /**
   * 9. Incluir al menos 5 ejercicios adicionales cualesquiera sobre la tabla de
   * multiplicar de dos factores.
   */
  /**
   * 1. tablaResultadoPar(int n)
   */
  // iterativo
  public static void tablaResultadoPar(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if ((a * b) % 2 == 0) {
          System.out.println(a + " x " + b + " = " + (a * b));
        }
      }
    }
  }

  // recursivo
  public static void tablaResultadoPar1(int n) {
    tablaResultadoPar1(n, 1, 1);
  }

  private static void tablaResultadoPar1(int n, int a, int b) {
    if (a > n)
      return;
    if (b > n) {
      tablaResultadoPar1(n, a + 1, 1);
      return;
    }
    if ((a * b) % 2 == 0) {
      System.out.println(a + " x " + b + " = " + (a * b));
    }
    tablaResultadoPar1(n, a, b + 1);
  }

  /**
   * 2. tablaSumaFactoresPar(int n)
   */
  // iterativo
  public static void tablaSumaFactoresPar2(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if ((a + b) % 2 == 0) {
          System.out.println(a + " x " + b + " = " + (a * b));
        }
      }
    }
  }

  // recursivo
  public static void tablaSumaFactoresPar21(int n) {
    tablaSumaFactoresPar21(n, 1, 1);
  }

  private static void tablaSumaFactoresPar21(int n, int a, int b) {
    if (a > n)
      return;
    if (b > n) {
      tablaSumaFactoresPar21(n, a + 1, 1);
      return;
    }
    if ((a + b) % 2 == 0) {
      System.out.println(a + " x " + b + " = " + (a * b));
    }
    tablaSumaFactoresPar21(n, a, b + 1);
  }

  /*
   * 3. tablaSoloUnFactorPar(int n)
   */
  // iterativo
  public static void tablaSoloUnFactorPar(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        boolean aPar = a % 2 == 0;
        boolean bPar = b % 2 == 0;
        if (aPar ^ bPar) { // solo uno es par
          System.out.println(a + " x " + b + " = " + (a * b));
        }
      }
    }
  }

  // recursivo
  public static void tablaSoloUnFactorPar1(int n) {
    tablaSoloUnFactorPar1(n, 1, 1);
  }

  private static void tablaSoloUnFactorPar1(int n, int a, int b) {
    if (a > n)
      return;
    if (b > n) {
      tablaSoloUnFactorPar1(n, a + 1, 1);
      return;
    }
    boolean aPar = a % 2 == 0;
    boolean bPar = b % 2 == 0;
    if (aPar ^ bPar) {
      System.out.println(a + " x " + b + " = " + (a * b));
    }
    tablaSoloUnFactorPar1(n, a, b + 1);
  }

  /**
   * 4. tablaUnoEsMultiploDeOtro(int n)
   */
  // iterativo
  public static void tablaUnoEsMultiploDeOtro(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if (a % b == 0 || b % a == 0) {
          System.out.println(a + " x " + b + " = " + (a * b));
        }
      }
    }
  }

  // recursivo
  public static void tablaUnoEsMultiploDeOtro1(int n) {
    tablaUnoEsMultiploDeOtro1(n, 1, 1);
  }

  private static void tablaUnoEsMultiploDeOtro1(int n, int a, int b) {
    if (a > n)
      return;
    if (b > n) {
      tablaUnoEsMultiploDeOtro1(n, a + 1, 1);
      return;
    }
    if (a % b == 0 || b % a == 0) {
      System.out.println(a + " x " + b + " = " + (a * b));
    }
    tablaUnoEsMultiploDeOtro1(n, a, b + 1);
  }

  /**
   * 5. tablaSumaIgualProducto(int n)
   */
  // iterativo
  public static void tablaSumaIgualProducto(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if (a + b == a * b) {
          System.out.println(a + " x " + b + " = " + (a * b));
        }
      }
    }
  }

  // recursivo
  public static void tablaSumaIgualProducto1(int n) {
    tablaSumaIgualProducto1(n, 1, 1);
  }

  private static void tablaSumaIgualProducto1(int n, int a, int b) {
    if (a > n)
      return;
    if (b > n) {
      tablaSumaIgualProducto1(n, a + 1, 1);
      return;
    }
    if (a + b == a * b) {
      System.out.println(a + " x " + b + " = " + (a * b));
    }
    tablaSumaIgualProducto1(n, a, b + 1);
  }

  /**
   * II. TABLA DE MULTIPLICAR CON TRES FACTORES A x B x C = D (tres ciclos
   * anidados)
   */

  /**
   * 12. Incluir al menos 5 ejercicios adicionales cualesquiera, sobre una tabla
   * de multiplicar de 3 factores.
   */
  /**
   * 1. tablaSumaFactoresPar(int n)
   */
  // iterativo
  public static void tablaSumaFactoresPar(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          if ((a + b + c) % 2 == 0) {
            System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
          }
        }
      }
    }
  }

  // recursivo
  public static void tablaSumaFactoresPar1(int n) {
    tablaSumaFactoresPar1(n, 1, 1, 1);
  }

  private static void tablaSumaFactoresPar1(int n, int a, int b, int c) {
    if (a > n)
      return;

    if ((a + b + c) % 2 == 0) {
      System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
    }

    if (c < n) {
      tablaSumaFactoresPar1(n, a, b, c + 1);
    } else if (b < n) {
      tablaSumaFactoresPar1(n, a, b + 1, 1);
    } else {
      tablaSumaFactoresPar1(n, a + 1, 1, 1);
    }
  }

  /**
   * 2. tablaPrimos(int n)
   */
  // iterativo
  public static void tablaPrimos(int n) {
    for (int a = 1; a <= n; a++) {
      if (!esPrimo(a))
        continue;
      for (int b = 1; b <= n; b++) {
        if (!esPrimo(b))
          continue;
        for (int c = 1; c <= n; c++) {
          if (esPrimo(c)) {
            System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
          }
        }
      }
    }
  }

  private static boolean esPrimo(int num) {
    if (num < 2)
      return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }

  // recursivo
  public static void tablaPrimos1(int n) {
    tablaPrimos1(n, 1, 1, 1);
  }

  private static void tablaPrimos1(int n, int a, int b, int c) {
    if (a > n)
      return;

    if (esPrimo(a) && esPrimo(b) && esPrimo(c)) {
      System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
    }

    if (c < n) {
      tablaPrimos1(n, a, b, c + 1);
    } else if (b < n) {
      tablaPrimos1(n, a, b + 1, 1);
    } else {
      tablaPrimos1(n, a + 1, 1, 1);
    }
  }

  /**
   * 3. tablaFactoresConsecutivos(int n)
   */
  // iterativo
  public static void tablaFactoresConsecutivos(int n) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          if ((Math.abs(a - b) == 1 && Math.abs(b - c) == 1 && Math.abs(a - c) == 2)) {
            System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
          }
        }
      }
    }
  }

  // recursivo
  public static void tablaFactoresConsecutivos1(int n) {
    tablaFactoresConsecutivos1(n, 1, 1, 1);
  }

  private static void tablaFactoresConsecutivos1(int n, int a, int b, int c) {
    if (a > n)
      return;

    if (Math.abs(a - b) == 1 && Math.abs(b - c) == 1 && Math.abs(a - c) == 2) {
      System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
    }

    if (c < n) {
      tablaFactoresConsecutivos1(n, a, b, c + 1);
    } else if (b < n) {
      tablaFactoresConsecutivos1(n, a, b + 1, 1);
    } else {
      tablaFactoresConsecutivos1(n, a + 1, 1, 1);
    }
  }

  /**
   * 4. tablaMultiploComun(int n, int m)
   */
  // iterativo
  public static void tablaMultiploComun(int n, int m) {
    for (int a = 1; a <= n; a++) {
      if (a % m != 0)
        continue;
      for (int b = 1; b <= n; b++) {
        if (b % m != 0)
          continue;
        for (int c = 1; c <= n; c++) {
          if (c % m == 0) {
            System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
          }
        }
      }
    }
  }

  // recursivo
  public static void tablaMultiploComun1(int n, int m) {
    tablaMultiploComun1(n, m, 1, 1, 1);
  }

  private static void tablaMultiploComun1(int n, int m, int a, int b, int c) {
    if (a > n)
      return;

    if (a % m == 0 && b % m == 0 && c % m == 0) {
      System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
    }

    if (c < n) {
      tablaMultiploComun1(n, m, a, b, c + 1);
    } else if (b < n) {
      tablaMultiploComun1(n, m, a, b + 1, 1);
    } else {
      tablaMultiploComun1(n, m, a + 1, 1, 1);
    }
  }

  /**
   * 5. tablaFactorMayorIgualQue(int n, int x)
   */
  // iterativo
  public static void tablaFactorMayorIgualQue(int n, int x) {
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          if (a >= x || b >= x || c >= x) {
            System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
          }
        }
      }
    }
  }

  // recursivo
  public static void tablaFactorMayorIgualQue1(int n, int x) {
    tablaFactorMayorIgualQue1(n, x, 1, 1, 1);
  }

  private static void tablaFactorMayorIgualQue1(int n, int x, int a, int b, int c) {
    if (a > n)
      return;

    if (a >= x || b >= x || c >= x) {
      System.out.println(a + " x " + b + " x " + c + " = " + (a * b * c));
    }

    if (c < n) {
      tablaFactorMayorIgualQue1(n, x, a, b, c + 1);
    } else if (b < n) {
      tablaFactorMayorIgualQue1(n, x, a, b + 1, 1);
    } else {
      tablaFactorMayorIgualQue1(n, x, a + 1, 1, 1);
    }
  }

}
