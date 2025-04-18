import math


class Lista:
    def __init__(self):
        self.MAX = 1000
        self.elem = [None] * self.MAX
        self.cantElem = 0

    # iterativo
    def toString(self):
        s = "["
        for i in range(0, self.cantElem):
            s = s + str(self.elem[i])
            if i < self.cantElem - 1:
                s = s + ", "
        return s + "]"

    # recursivo
    def toStringR(self):
        s = "["
        s = s + self.toStringRA(0, self.cantElem - 1)
        return s + "]"

    def toStringRA(self, a, b):
        s = ""
        if a <= b:
            s = s + self.elem[a]
        if a < b:
            s = s + ", "
        s = s + self.toStringRA(a + 1, b)
        return s

    # 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
    # i, de la lista L1.
    # iterativo
    def insertarIesimo1(self, x, i):
        for i in range(self.cantElem, i - 1, -1):
            self.elem[i] = self.elem[i - 1]

        self.elem[i] = x
        self.cantElem += 1

    # recursivo
    def insertarIesimo1R(self, x, i):
        self.insertarIesimo1RA(x, i)

    def insertarIesimo1RA(self, x, i, n):
        if n < i:
            self.elem[i] = x
            self.cantElem += 1
        else:
            self.elem[n + 1] = self.elem[n]
            self.insertarIesimo1RA(x, i, n - 1)

    # 2. L1.insertarPrim1(x) : Método que insertar el elemento x, al inicio de la
    # lista L1.
    # iterativo
    def insertarPrim1(self, x):
        self.insertarIesimo1(x, 0)

    # recursivo
    def insertarPrim1R(self, x):
        self.insertarIesimo1R(x, 0)

    # 3. L1.insertarUlt1(x) : Método que inserta el elemento x, al final de la lista
    # L1.
    # iterativo
    def insertarUlt1(self, x):
        self.insertarIesimo1(x, self.cantElem)

    # recursivo
    def insertarUlt1R(self, x):
        self.insertarIesimo1R(x, self.cantElem)

    # 4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
    # iterativo
    def eliminarIesimo1(self, i):
        for k in range(i, self.cantElem - 1):
            self.elem[k] = self.elem[k + 1]
        self.cantElem -= 1

    # recursivo
    def eliminarIesimo1R(self, i):
        self.eliminarIesimo1RA(i, self.cantElem)
        self.cantElem -= 1

    def eliminarIesimo1RA(self, i, n):
        if i > n:
            self.cantElem -= 1
        else:
            self.elem[i] = self.elem[i + 1]
            self.eliminarIesimo1RA(i + 1, n)

    # 5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
    # iterativo
    def eliminarPrim(self):
        self.eliminarIesimo1(0)

    # recurusivo
    def eliminarPrim1(self):
        self.eliminarIesimo1R(0)

    # 6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    # iterativo
    def eliminarUlt(self):
        self.eliminarIesimo1(self.cantElem - 1)

    # recursivo
    def eliminarUltR(self):
        self.eliminarIesimo1R(self.cantElem - 1)

    # 7. L1.insertarLugasAsc(x) : Método que inserta el elemento x, en su lugar
    #  correspondiente en la Lista L1, ordenada de menor a mayor.
    # iterativo
    def insertarLugarAsc(self, x):
        k = self.cantElem - 1
        while k >= 0 and x < self.elem[k]:
            self.elem[k + 1] = self.elem[k]
            k -= 1
        self.elem[k + 1] = x
        self.cantElem += 1

    # recursivo
    def insertarLugarAscR(self, x):
        self.insertarLugarAscRA(0, self.cantElem - 1, x)

    def insertarLugarAscRA(self, a, b, x):
        if b < 0 or self.elem[b] <= x:
            self.elem[b + 1] = x
            self.cantElem += 1
        else:
            self.elem[b + 1] = self.elem[b]
            self.insertarLugarAscRA(a, b - 1, x)

    # 8. L1.insertarLugarDesc(x) : Método que inserta el elemento x, en su lugar
    # correspondiente en la Lista L1, ordenada de mayor a menor
    # iterativo
    def insertarLugarDesc(self, x):
        k = self.cantElem - 1
        while k >= 0 and x > self.elem[k]:
            self.elem[k + 1] = self.elem[k]
            k -= 1
        self.elem[k + 1] = x
        self.cantElem += 1

    # recursivo
    def insertarLugarDescR(self, x):
        self.insertarLugarDescRA(0, self.cantElem - 1, x)

    def insertarLugarDescRA(self, a, b, x):
        if b < 0 or self.elem[b] >= x:
            self.elem[b + 1] = x
            self.cantElem += 1
        else:
            self.elem[b + 1] = self.elem[b]
            self.insertarLugarDescRA(a, b - 1, x)

    # 9. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
    # Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7,
    # 8, 1]
    # iterativo
    def pasarDigitos(self, n):
        if n == 0:
            self.insertarPrim1(0)
            return
        while n > 0:
            d = n % 10
            self.insertarPrim1(d)
            n = math.floor(n / 10)

    # recursivo
    def pasarDigitosR(self, n):
        self.pasarDigitosRA(n)

    def pasarDigitosRA(self, n):
        if n < 10:
            self.insertarPrim(n)
        else:
            d = n % 10
            self.insertarPrim(d)
            self.pasarDigitosRA(math.floor(n / 10))

    # 10. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
    # la lista L1, son iguales.
    # iterativo
    def iguales(self):
        for i in range(0, self.cantElem - 1):
            if self.elem[i] != self.elem[i + 1]:
                return False
        return True

    # recusivo
    def igualesR(self):
        return self.igualesRA(0, self.cantElem - 1)

    def igualesRA(self, a, b):
        bol = True
        n = b - a + 1
        if n > 1 and a < b - 1:
            if self.elem[a] != self.elem[b]:
                bol = False
            self.igualesRA(a + 1, b)
        return bol

    # 11. L1.ordenado() : Método lógico que devuelve True, si los elementos de la lista L1,
    # están ordenados en forma ascendente o descendente.
    # iterativo
    def ordenado(self):
        estaOrdenadoAsc = True
        estaOrdenadoDesc = True
        for i in range(0, self.cantElem - 1):
            if self.elem[i] > self.elem[i + 1]:
                estaOrdenadoAsc = False
            if self.elem[i] < self.elem[i + 1]:
                estaOrdenadoDesc = False
        return estaOrdenadoAsc or estaOrdenadoDesc

    # recursivo
    def ordenadoR(self):
        return self.estaOrdenadoAsc(0, self.cantElem - 1) or self.estaOrdenadoDesc(
            0, self.cantElem - 1
        )

    def estaOrdenadoAsc(self, a, b):
        if a >= b:
            return True
        else:
            if self.elem[a] > self.elem[a + 1]:
                return False
        return self.estaOrdenadoAsc(a + 1, b)

    def estaOrdenadoDesc(self, a, b):
        if a >= b:
            return True
        else:
            if self.elem[a] < self.elem[a + 1]:
                return False
        return self.estaOrdenadoDesc(a + 1, b)

    # 12. L1.frecuencia(x): Método que devuelve la cantidad de veces que aparece el
    # elemento x, en la lista L1
    # iterativo
    def frecuencia(self, x):
        frecuencia = 0
        for i in range(0, self.cantElem):
            if self.elem[i] == x:
                frecuencia += 1
        return frecuencia

    # recursivo
    def frecuenciaR(self, x):
        return self.frecuenciaRA(0, self.cantElem - 1, x)

    def frecuenciaRA(self, a, b, x):
        n = b - a + 1
        if n == 0:
            return 0
        else:
            frec = self.frecuenciaR(a + 1, b, x)
            if self.elem[a] == x:
                frec += 1
        return frec

    # 13. L1.suma(): Método que devuelve la sumatoria de los elementos de la lista L1
    # iterativo
    def suma(self):
        suma = 0
        for i in range(0, self.cantElem):
            suma += self.elem[i]
        return suma

    # recursivo
    def sumaR(self):
        return self.sumaRA(0, self.cantElem - 1)

    def sumaRA(self, a, b):
        n = b - a + 1
        if n == 0:
            return 0
        else:
            suma = self.sumaRA(a + 1, b)
            return suma + self.elem[a]

    # 14. L1.sumaPares(): Método que devuelve la sumatoria de los elementos pares
    # de la lista L1.
    def sumaPares(self):
        suma = 0
        for i in range(0, self.cantElem):
            if self.elem[i] % 2 == 0:
                suma += self.elem[i]
        return suma

    # recursivo
    def sumaParesR(self):
        return self.sumaParesRA(0, self.cantElem - 1)

    def sumaParesRA(self, a, b):
        n = b - a + 1
        if n == 0:
            return 0
        else:
            suma = self.sumaParesRA(a + 1, b)
            if self.elem[a] % 2 == 0:
                return suma + self.elem[a]
            return suma

    # 15. L1.diferentes() : Método lógico que devuelve True, si todos los
    # elementos de la lista L1, son diferentes.
    # iterativo
    def diferentes(self):
        for i in range(0, self.cantElem):
            for j in range(0, self.cantElem):
                if self.elem[i] == self.elem[j] and i != j:
                    return False
        return True

    # recursivo
    def diferentesR(self):
        return self.diferentesRA(0, self.cantElem - 1)

    def diferentesRA(self, a1, b1):
        n1 = b1 - a1 + 1
        if n1 == 0:
            return True
        else:
            return self.diferentesRB(a1, 0, self.cantElem - 1) and self.diferentesRA(
                a1 + 1, b1
            )

    def diferentesRB(self, a1, a2, b2):
        n2 = b2 - a2 + 1
        if n2 == 0:
            return True
        elif n2 == 1:
            return True
        else:
            diferentes = self.diferentesRB(a1, a2 + 1, b2)
            if self.elem[a1] == self.elem[a2] and a1 != a2:
                diferentes = False
            return diferentes

    # 16. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
    # iterativo
    # iterativo
    def menor(self):
        menor = self.elem[0]
        for i in range(1, self.cantElem):
            if self.elem[i] < menor:
                menor = self.elem[i]
        return menor

    # recusivo
    def menorR(self):
        return self.menorRA(1, self.cantElem, self.elem[0])

    def menorRA(self, a, n, menor):
        if a >= n:
            return menor
        else:
            if self.elem[a] < menor:
                menor = self.elem[a]
            return self.menorRA(a + 1, n, menor)

    # 17. L1.mismaFrec() : Método lógico que devuelve True, si todos
    # los elementos tienen la misma frecuencia de aparición en la Lista L1.
    def mismaFrec(self):
        for i in range(0, self.cantElem - 1):
            if self.frecuencia(self.elem[i]) != self.frecuencia(self.elem[i + 1]):
                return False
        return True

    def mismaFrecR(self):
        return self.mismaFrecRA(0, self.cantElem - 1)

    def mismaFrecRA(self, a, b):
        n = b - a + 1
        if n == 0:
            return True
        elif n == 1:
            return True
        else:
            frec = self.mismaFrecRA(a + 1, b)
            if self.frecuencia(self.elem[a]) != self.frecuencia(self.elem[a + 1]):
                frec = False
            return frec

    # 18. L1.palindrome() : Método lógico que devuelve True, si los elementos de la
    # Lista L1, forma un palíndrome.
    def palindrome(self):
        n = self.cantElem
        for i in range(0, math.floor(n / 2)):
            izquierda = self.elem[i]
            derecha = self.elem[n - i - 1]

            if izquierda != derecha:
                return False
        return True

    # recursivo
    def palindromeR(self):
        return self.palindromeRA(0, self.cantElem / 2)

    def palindromeRA(self, a, n2):
        if a < n2:
            if self.elem[a] != self.elem[self.cantElem - 1 - a]:
                return False
            return self.palindromeRA(a + 1, n2)
        return True

    # 19. L1.intercalar(L2, L3) : Método que encuentra en L1, los
    # elementos intercalados de las Listas L2 y L3.
    # iterativo
    def intercalar(self, L2, L3):
        i = 0
        j = 0
        while i < L2.cantElem and L3.cantElem:
            self.insertarUlt1(L2.elem[i])
            self.insertarUlt1(L3.elem[j])
            i += 1
            j += 1
        while i < L2.cantElem:
            self.insertarUlt1(L2.elem[i])
            i += 1

        while j < L3.cantElem:
            self.insertarUlt1(L3.elem[j])
            j += 1

    def intercalarR(self, L2, L3):
        self.intercalarRA(L2, L3, 0, 0, L2.cantElem, L3.cantElem)

    def intercalarRA(self, L2, L3, i, j, n2, n3):
        if i < n2 and j < n3:
            self.insertarUlt(L2.elem[i])
            self.insertarUlt(L3.elem[j])
            i += 1
            j += 1
            self.intercalarRA(L2, L3, i, j, n2, n3)
        elif i < n2:
            self.insertarUlt(L2.elem[i])
            i += 1
            self.intercalarRA(L2, L3, i, j, n2, n3)
        elif j < n3:
            self.insertarUlt(L3.elem[j])
            j += 1
            self.intercalarRA(L2, L3, i, j, n2, n3)

    # 20. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista
    # L1 y L2 tienen los mismos elementos.
    # iterativo
    def mismosElem(self, L2):
        for i in range(self.cantElem):
            if not L2.tieneElemento(self.elem[i]):
                return False
        for j in range(L2.cantElem):
            if not self.tieneElemento(L2.elem[j]):
                return False
        return True

    def tieneElemento(self, x):
        for i in range(self.cantElem):
            if self.elem[i] == x:
                return True
        return False

    # recursivo
    def mismosElemR(self, L2):
        return self.tieneElementosR(L2) and L2.tieneElementosR(self)

    def tieneElementoR(self, x):
        return self.tieneElementoR(0, self.cantElem - 1, x)

    def tieneElementoR(self, a, b, x):
        n = b - a + 1
        if n == 0:
            return False
        elif n == 1:
            return self.elem[a] == x
        else:
            tiene = self.tieneElementoR(a + 1, b, x)
            if self.elem[a] == x:
                tiene = True
            return tiene

    def tieneElementosR(self, L2):
        return self.tieneElementosRA(L2, 0, self.cantElem - 1)

    def tieneElementosRA(self, L2, a, b):
        n = b - a + 1
        if n == 0:
            return True
        elif n == 1:
            return L2.tieneElementoR(self.elem[a])
        else:
            if not L2.tieneElementoR(self.elem[a]):
                return False
        return self.tieneElementosRA(L2, a + 1, b)

    # 21. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
    # lista L1.
    # iterativo
    def eliminarTodo(self, x):
        for i in range(self.cantElem - 1, -1, -1):
            if self.cantElem[i] == x:
                self.eliminarIesimo1(i)

    # recursivo
    def eliminarTodoR(self, x):
        self.eliminarTodoRA(x, 0, self.cantElem)

    def eliminarTodoRA(self, x, a, n):
        if n <= a:
            return
        else:
            if self.cantElem[n - 1] == x:
                self.eliminarIesimo1(n - 1)
