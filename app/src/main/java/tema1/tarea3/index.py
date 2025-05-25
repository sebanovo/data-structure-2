import math
import random

class Lista:
    def __init__(self):
        self.MAX = 1000
        self.elem = [None] * self.MAX
        self.cantElem = 0

    def toString(self):
        s = "["
        for i in range(0, self.cantElem):
            s = s + str(self.elem[i])
            if i < self.cantElem - 1:
                s = s + ", "
        return s + "]"

    def insertarIesimo1(self, x, i):
        """
        1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición
        i, de la lista L1.
        """
        for i in range(self.cantElem, i - 1, -1):
            self.elem[i] = self.elem[i - 1]

        self.elem[i] = x
        self.cantElem += 1

    def insertarPrim1(self, x):
        """
        2. L1.insertarPrim1(x) : Método que insertar el elemento x, al inicio de la
        lista L1.
        """
        self.insertarIesimo1(x, 0)

    def insertarUlt1(self, x):
        """
        3. L1.insertarUlt1(x) : Método que inserta el elemento x, al final de la lista
        L1.
        """
        self.insertarIesimo1(x, self.cantElem)

    def eliminarIesimo1(self, i):
        """
        4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
        """
        for k in range(i, self.cantElem - 1):
            self.elem[k] = self.elem[k + 1]
        self.cantElem -= 1

    def eliminarPrim(self):
        """
        5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
        """
        self.eliminarIesimo1(0)

    def eliminarUlt(self):
        """
        6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
        """
        self.eliminarIesimo1(self.cantElem - 1)

    def eliminarTodo(self, x):
        """
        7. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la
        lista L1.
        """
        for i in range(self.cantElem - 1, -1, -1):
            if self.cantElem[i] == x:
                self.eliminarIesimo1(i)

    def eliminarPares(self):
        """
        8. L1.eliminarPares() : Método que elimina los elementos pares de la lista
        L1. Verificar en listas dónde todos los elementos sean pares.
        """
        for i in range(self.cantElem - 1, -1, -1):
            if self.elem[i] % 2 == 0:
                self.eliminarIesimo1(i)

    def eliminarUnicos(self):
        """
        9. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo
        una vez en la lista L1.
        """
        self.eliminarVeces()

    def encontrarIndice(self, elem):
        for i in range(0, self.cantElem):
            if self.elem[i] == elem:
                return i
        return -1

    def eliminarTodo(self, L2):
        """
        10. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista
        L1, que aparecen en la lista L2.
        """
        for i in range(0, L2.cantElem):
            indice = self.encontrarIndice(L2.elem[i])
            while indice != -1:
                self.eliminarIesimo1(indice)
                indice = self.encontrarIndice(L2.elem[i])

    def pasarDigitos(self, n):
        """
        11. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la
        Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7,
        8, 1]
        """
        if n == 0:
            self.insertarPrim1(0)
            return
        while n > 0:
            d = n % 10
            self.insertarPrim1(d)
            n = math.floor(n / 10)

    def rotarIzqDer(self, n):
        """
        12. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1
        n-veces de derecha a izquierda.
        """
        for i in range(0, n):
            ultimo = self.elem[self.cantElem - 1]
            self.eliminarUlt()
            self.insertarPrim1(ultimo)

    def rotarDerIzq(self, n):
        """
        13. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1
        n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar
        y eliminar por los extremos de la Lista.
        """
        for i in range(0, n):
            primer = self.elem[0]
            self.eliminarPrim()
            self.insertarUlt1(primer)

    def eliminarPrim(self, n):
        """
        14. L1.eliminarPrim( n ) : Método que elimina los primeros n-elementos de la
        Lista L1.
        """
        self.eliminarIesimo2(0, n)

    def eliminarUlt(self, n):
        """
        15. L1.eliminarUlt( n ) : Método que elimina los últimos n-elementos de la
        Lista L1.
        """
        for i in range(0, n):
            self.eliminarIesimo1(self.cantElem - 1)

    def insertarIesimo2(self, L2, i):
        """
        16. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista
        L2 en la lista L1, desde la posición i.
        """
        for k in range(0, L2.cantElem):
            self.insertarIesimo1(L2.elem[k], i)

    def insertarPrim2(self, L2):
        """
        17. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al
        principio de la lista L1.
        """
        self.insertarIesimo2(L2, 0)

    def insertarUlt2(self, L2):
        """
        18. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al
        final de la lista L1.
        """
        self.insertarIesimo2(L2, self.cantElem - 1)

    def eliminarIesimo2(self, i, n):
        """
        19. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista
        L1, desde la posición i.
        """
        for k in range(0, n):
            self.eliminarIesimo1(i)

    def eliminarExtremos(self, n):
        """
        20. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los
        extremos de la lista L1.
        """
        self.eliminarPrim2(n)
        self.eliminarUlt2(n)

    def eliminarVeces(self, k):
        # pending
        return

    def eliminarAlternos(self):
        for i in range(0, self.cantElem):
            self.eliminarIesimo1(i)

    """
    EJERCICIOS DE tema1.tarea-2
    """

    def insertarLugarAsc(self, x):
        """
        1. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
        correspondiente en la Lista L1, ordenada de menor a mayor.
        """
        i = 0
        while i < self.cantElem and self.elem[i] < x:
            i += 1
        self.insertarIesimo1(x, i)

    def insertarLugarDesc(self, x):
        """
        2. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar
        correspondiente en la Lista L1, ordenada de mayor a menor.
        """
        i = 0
        while i < self.cantElem and self.elem[i] > x:
            i += 1
        self.insertarIesimo1(x, i)

    def tieneElemento(self, x):
        for i in range(0, self.cantElem):
            if self.elem[i] == x:
                return True
        return False

    def comunes(self, L2, L3):
        """
        3. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en
        las Listas L2, L3.
        """
        for i in range(0, L2.cantElem):
            elemento = L2.elem[i]
            if not self.tieneElemento(elemento) and L3.tieneElemento(elemento):
                self.insertarUlt1(elemento)

    def intercalar(self, L2, L3):
        """
        4. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos
        intercalados de las Listas L2 y L3.
        """
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

    def ordenado(self):
        """
        5. L1.ordenado() : Método lógico que devuelve True, si los elementos de la
        lista L1, están ordenados en forma ascendente o descendente.
        """
        estaOrdenadoAsc = True
        estaOrdenadoDesc = True
        for i in range(0, self.cantElem - 1):
            if self.elem[i] > self.elem[i + 1]:
                estaOrdenadoAsc = False
            if self.elem[i] < self.elem[i + 1]:
                estaOrdenadoDesc = False
        return estaOrdenadoAsc or estaOrdenadoDesc

    def iguales(self):
        """
        6. L1.iguales() : Método lógico que devuelve True, si todos los elementos de
        la lista L1, son iguales.
        """
        for i in range(0, self.cantElem - 1):
            if self.elem[i] != self.elem[i + 1]:
                return False
        return True

    def diferentes(self):
        """
        7. L1.diferentes() : Método lógico que devuelve True, si todos los elementos
        de la lista L1, son diferentes.
        """
        for i in range(0, self.cantElem):
            for j in range(0, self.cantElem):
                if self.elem[i] == self.elem[j] and i != j:
                    return False
        return True

    def menor(self):
        """
        8. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
        """
        menor = self.elem[0]
        for i in range(1, self.cantElem):
            if self.elem[i] < menor:
                menor = self.elem[i]
        return menor

    def parImpar(self):
        """
        9. L1.parImpar() : Método lógico que devuelve True, en la Lista L1, existe
        al menos un elemento par y al menos un elemento impar.
        """
        existePar = False
        existeImpar = False
        for i in range(0, self.cantElem):
            if self.elem[i] % 2 == 0:
                existePar = True
            if self.elem[i] % 2 == 1:
                existeImpar = True
        return existePar and existeImpar

    def frecuencia(self, x):
        frecuencia = 0
        for i in range(0, self.cantElem):
            if self.elem[i] == x:
                frecuencia += 1
        return frecuencia

    def mismaFrec(self):
        """
        10. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos
        tienen la misma frecuencia de aparición en la Lista L1.
        """
        for i in range(0, self.cantElem - 1):
            if self.frecuencia(self.elem[i]) != self.frecuencia(self.elem[i + 1]):
                return False
        return True

    def palindrome(self):
        """
        11. L1.palindrome() : Método lógico que devuelve True, si los elementos de la
        Lista L1, forma un palíndrome.
        """
        n = self.cantElem
        for i in range(0, math.floor(n / 2)):
            izquierda = self.elem[i]
            derecha = self.elem[n - i - 1]

            if izquierda != derecha:
                return False
        return True

    def mismoElem(self, L2):
        """
        10. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos
        tienen la misma frecuencia de aparición en la Lista L1.
        """
        for i in range(0, self.cantElem):
            if not L2.tieneElemento(self.elem[i]):
                return False

        for i in range(0, L2.cantElem):
            if not self.tieneElemento(L2.elem[i]):
                return False
        return True

    """
    13. Incluir al menos 10 métodos : Con el objetivo de consultar Bibliografía
    sobre el tema, enunciar e implementar al menos 10 métodos adicionales a
    implementar. Citar fuente. (Importante).
    """

    def invertir(self):
        """
        1. L1.invertir() : Método que invertierte el orden de los elementos
        """
        a = 0
        b = self.cantElem - 1
        while a < b:
            temp = self.elem[a]
            self.elem[a] = self.elem[b]
            self.elem[b] = temp
            a += 1
            b -= 1

    def ordenamientoBurbuja(self):
        """
        2. L1.ordenamientoBurbuja() : Método que ordena los elementos de la lista
        (menor a mayor)
        """
        for i in range(0, self.cantElem):
            for j in range(0, self.cantElem):
                if self.elem[i] < self.elem[j]:
                    temp = self.elem[i]
                    self.elem[i] = self.elem[j]
                    self.elem[j] = temp

    def busquedaBinaria(self, k):
        """
        3. L1.busquedaBinaria(k) : Método que busca si existe el elemento en la lista
        """
        izquierda = 0
        derecha = self.cantElem - 1

        while izquierda <= derecha:
            medio = izquierda + math.floor((derecha - izquierda) / 2)
            if self.elem[medio] > k:
                derecha = medio - 1
            elif self.elem[medio] < k:
                izquierda = medio + 1
            else:
                return True
        return True

    def repetirKVeces(self, k):
        """
        4. L1.repetirKVeces(k): Meotod que repite los elementos de la Lista
        Ejemplos: v = [1,2,3] | k = 3 => v[1,1,1,2,2,2,3,3,3]
        """
        longitud = self.cantElem * k
        lista = [None] * self.MAX

        indice = 0
        for i in range(0, self.cantElem):
            for j in range(0, k):
                lista[indice] = self.elem[i]
                indice += 1

        self.elem = lista
        self.cantElem = longitud

    def generarSerirRegresiva(self, n):
        """
        5. L1.generarSerieRegresiva(n): Metodo que genera esta seríe
        [1, 21, 321, 4321, 54321]
        """
        self.cantElem = n
        for i in range(0, n):
            numero = i + 1
            resultado = 0
            while numero > 0:
                resultado = resultado * 10 + numero
                numero -= 1
            self.elem[i] = resultado

    def segmentarParImpar(self):
        """
        6. L1.segmentarParImpar(): Segmenta el vector separando los números pares de
        los
        impares.
        ejemplo:
        [2,2,4,6,3,3,5,5,5,9]
        """
        for p in range(0, self.cantElem - 1):
            for d in range(p + 1, self.cantElem):
                n1 = self.elem[d]
                n2 = self.elem[p]
                if (
                    (n1 % 2 == 0 and n2 % 2 != 0)
                    or (n1 % 2 == 0 and n2 % 2 == 0 and self.elem[d] < self.elem[p])
                    or (n1 % 2 != 0 and n2 % 2 != 0 and self.elem[d] < self.elem[p])
                ):
                    temp = self.elem[d]
                    self.elem[d] = self.elem[p]
                    self.elem[p] = temp

    def intercalarParImpar(self):
        """
        7. L1.intercalarParImpar(): Intercala los números pares e impares de la lista
        ejemplo:
        [2,3,2,5,4,7,6]
        """
        b = True
        for p in range(0, self.cantElem - 1):
            if b:
                for d in range(p + 1, self.cantElem):
                    n1 = self.elem[d]
                    n2 = self.elem[p]
                    if (
                        (n1 % 2 == 0 and n2 % 2 != 0)
                        or (n1 % 2 == 0 and n2 % 2 == 0 and self.elem[d] < self.elem[p])
                        or (n1 % 2 != 0 and n2 % 2 != 0 and self.elem[d] < self.elem[p])
                    ):
                        temp = self.elem[d]
                        self.elem[d] = self.elem[p]
                        self.elem[p] = temp
            else:
                for d in range(p + 1, self.cantElem):
                    n1 = self.elem[d]
                    n2 = self.elem[p]
                    if (
                        (n1 % 2 != 0 and n2 % 2 == 0)
                        or (n1 % 2 != 0 and n2 % 2 != 0 and self.elem[d] < self.elem[p])
                        or (n1 % 2 == 0 and n2 % 2 == 0 and self.elem[d] < self.elem[p])
                    ):
                        temp = self.elem[d]
                        self.elem[d] = self.elem[p]
                        self.elem[p] = temp
            b = not b

    def generarSerieFibonacci(self, longitud):
        """
        8. L1.generarSerieFibonacci(longitud): Carga la lista con una serie de
        Fibonacci.
        """
        if longitud <= 0:
            return
        if longitud > 0:
            self.insertarPrim1(0)
        if longitud > 1:
            self.insertarUlt1(1)

        for i in range(2, longitud):
            elem = self.elem[i - 1] + self.elem[i - 2]
            self.insertarUlt1(elem)

    def concatenar(self, L1):
        """
        9. L1.concatenar(L2): concatena una lista al final de la lista L1.
        """
        for i in range(0, L1.cantElem):
            self.insertarUlt1(L1.elem[i])

    def desordenar(self):
        """
        10. L1.desordenar(): Desordena todos los elementos de la lista L1 de forma
        aleatoria.
        """
        for i in range(0, self.cantElem):
            indiceRandom = random.randint(0, self.cantElem - 1)
            temp = self.elem[i]
            self.elem[i] = self.elem[indiceRandom]
            self.elem[indiceRandom] = temp

    """
    Bibliografia: https://utilities-library.vercel.app/classes/Vector.html
    """