package modelos;

public class Lista {
    int[] elem;
    int MAX = 100;
    int cantElem;

    public Lista() {
        this.elem = new int[MAX];
        this.cantElem = 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.cantElem; i++) {
            s = s + this.elem[i];
            if (i < this.cantElem - 1)
                s = s + ", ";
        }
        return s + "]";
    }

    // metodos auxiliares
    public void insertarIesimo(int x, int i) {
        for (int k = this.cantElem - 1; k >= i; k--) {
            this.elem[k + 1] = this.elem[k];
        }
        this.elem[i] = x;
        this.cantElem++;
    }

    public void insertarPrim(int x) {
        this.insertarIesimo(x, 0);
    }

    public void insertarUlt(int x) {
        this.insertarIesimo(x, this.cantElem);
    }

    // iterativo
    public int suma() {
        int suma = 0;
        for (int i = 0; i < this.cantElem; i++) {
            suma = suma + this.elem[i];
        }
        return suma;
    }

    // recursivo
    public int suma1() {
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

    // iterativo
    public int sumaPares() {
        int suma = 0;
        for (int i = 0; i < this.cantElem; i++) {
            if (this.elem[i] % 2 == 0) {
                suma = suma + this.elem[i];
            }
        }
        return suma;
    }

    // recursivo
    public int sumaPares1() {
        return this.sumaParesR(0, this.cantElem - 1);
    }

    private int sumaParesR(int a, int b) {
        int n = b - a + 1;
        if (n == 0) {
            return 0;
        } else {
            int suma = sumaParesR(a + 1, b);
            if (this.elem[a] % 2 == 0) {
                return suma + this.elem[a];
            }
            return suma;
        }
    }

    // iterativo
    public int menor() {
        int menor = this.elem[0];
        for (int i = 1; i < this.cantElem; i++) {
            if (menor > this.elem[i]) {
                menor = this.elem[i];
            }
        }
        return menor;
    }

    // recursivo
    public int menor1() {
        return menorR(this.elem[0], 1, this.cantElem);
    }

    public int menorR(int menor, int a, int n) {
        if (a >= n)
            return menor;
        else {
            if (menor > this.elem[a]) {
                menor = this.elem[a];
            }
            return menorR(menor, a + 1, n);
        }
    }

    // iterativo
    public void pasarDigitos(int n) {
        if (n == 0) {
            this.insertarPrim(0);
            return;
        }
        while (n > 0) {
            this.insertarPrim(n % 10);
            n = n / 10;
        }
    }

    // recursivo
    public void pasarDigitos1(int n) {
        this.pasarDigitosR(n);
    }

    private void pasarDigitosR(int n) {
        if (n < 10) {
            this.insertarPrim(n);
        } else {
            this.insertarPrim(n % 10);
            pasarDigitosR(n / 10);
        }
    }

    // iterativo
    public boolean iguales() {
        int primero = this.elem[0];
        for (int i = 1; i < this.cantElem; i++) {
            if (this.elem[i] != primero)
                return false;
        }
        return true;
    }

    // recursivo
    public boolean iguales1() {
        if (this.cantElem == 0)
            return true;
        return igualesR(this.elem[0], 1, this.cantElem);
    }

    private boolean igualesR(int primero, int a, int n) {
        if (a < n) {
            if (this.elem[a] != primero)
                return false;
            return igualesR(primero, a + 1, n);
        }
        return true;
    }

    // 1. L1.suma(): Método que devuelve la sumatoria de los elementos de la lista
    // L1
    // 2. L1.sumaPares(): Método que devuelve la sumatoria de los elementos pares de
    // la lista L1.
    // 3. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
    // 4. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
    // Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7,
    // 8, 1]
    // 5. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
    // la lista L1, son iguales.
}
