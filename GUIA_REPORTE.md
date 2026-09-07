# Guía para elaborar el reporte de la actividad

> Este archivo sirve como fuente de información para redactar el documento final de explicación y ejecución. El reporte debe describir el código real del proyecto y no agregar funciones que no existen.

## 1. Datos del proyecto

- Lenguaje: Java.
- Punto de entrada: `Main.java`, método `main`.
- Clases principales: `Recursivo`, `MergeSort` y `BackTracking`.
- Ejecución desde la carpeta del proyecto:

```text
javac *.java
java Main
```

El comando `javac *.java` compila todos los archivos Java. El comando `java Main` ejecuta todos los ejemplos desde un único programa principal.

## 2. Objetivo

El proyecto aplica recursividad directa, recursividad indirecta, divide y vencerás y backtracking. Los problemas principales son Fibonacci, suma de subconjuntos y resolución de Sudoku. Además, `MergeSort` demuestra de forma independiente la técnica de divide y vencerás.

## 3. Organización del código

### `Main.java`

- Líneas 1-2: importación de `ArrayList` y `Arrays` para la prueba de MergeSort.
- Líneas 4-6: declaración de la clase y del método `main`.
- Líneas 8-11: creación del objeto `Recursivo` y ejecución de Fibonacci con el índice 7.
- Líneas 13-19: creación del conjunto `{3, 34, 4, 12, 5, 2}` y pruebas de Subset Sum con objetivos 9 y 30.
- Líneas 21-24: pruebas de recursividad indirecta con `esPar(8)` y `esImpar(7)`.
- Líneas 26-29: creación de la lista `[4, 1, 3, 2]` y ejecución de MergeSort.
- Líneas 31-41: definición del tablero de Sudoku. El valor `0` representa una celda vacía.
- Líneas 43-49: creación del objeto `BackTracking`, resolución del tablero e impresión del resultado.

`Main` no contiene la lógica de los algoritmos. Su responsabilidad es preparar los datos, llamar a los métodos y mostrar resultados.

## 4. Primer problema: Fibonacci recursivo

Archivo: `Recursivo.java`, líneas 4-13.

### Diseño

La sucesión se define de esta manera:

- `F(0) = 0`.
- `F(1) = 1`.
- `F(n) = F(n - 1) + F(n - 2)` para `n > 1`.

### Implementación

El método `fibonacci(int num)` usa recursividad directa porque se llama a sí mismo. Primero rechaza índices negativos. Después verifica los casos base `0` y `1`. Si el índice es mayor, realiza dos llamadas recursivas y suma sus resultados.

### Funcionamiento con el ejemplo

Para `fibonacci(7)`, el método descompone el problema hasta llegar a `fibonacci(0)` y `fibonacci(1)`. Después combina los resultados y obtiene:

```text
Fibonacci(7) = 13
```

### Complejidad

La versión implementada tiene complejidad temporal exponencial aproximada `O(2^n)` porque recalcula varios valores. Es una implementación adecuada para demostrar recursividad directa y para valores pequeños.

## 5. Segundo problema: Suma de subconjuntos

Archivo: `Recursivo.java`, líneas 15-31.

### Diseño

El algoritmo debe decidir si algún subconjunto de un arreglo suma exactamente el objetivo. Para cada elemento existen dos decisiones:

1. Incluir el elemento actual.
2. No incluir el elemento actual.

El método explora ambas posibilidades mediante llamadas recursivas.

### Casos base

- Si `objetivo == 0`, se encontró una combinación válida y retorna `true`.
- Si se revisaron todos los elementos sin llegar a cero, retorna `false`.

### Implementación

El método recursivo principal recibe el arreglo, el índice actual y el objetivo restante. Cuando incluye un elemento, resta su valor al objetivo. Cuando lo excluye, conserva el objetivo y avanza al siguiente índice. La expresión `||` permite detener la búsqueda cuando una de las dos alternativas encuentra solución.

El método sobrecargado de las líneas 27-29 inicia la búsqueda desde el índice cero y facilita el uso desde `Main`.

### Funcionamiento con el ejemplo

Para el conjunto `{3, 34, 4, 12, 5, 2}`:

- Objetivo `9`: retorna `true`, porque existe el subconjunto `{4, 5}` o `{3, 4, 2}`.
- Objetivo `30`: retorna `false` para las combinaciones exploradas por el algoritmo.

### Complejidad

En el peor caso se exploran dos decisiones por cada elemento, por lo que la complejidad temporal es `O(2^n)` y el uso de memoria por la profundidad recursiva es `O(n)`.

## 6. Recursividad indirecta

Archivo: `Recursivo.java`, líneas 33-47.

`esPar` y `esImpar` se llaman entre sí. Esto es recursividad indirecta: el método A llama al método B y el método B vuelve a llamar al método A.

- `esPar(0)` retorna `true`.
- `esImpar(0)` retorna `false`.
- Para otros valores, cada método reduce el número y delega la decisión al otro.

En `Main` se comprueba que `8` es par y `7` es impar. Esta sección demuestra explícitamente el requisito de recursividad indirecta.

## 7. Divide y vencerás: MergeSort

Archivo: `MergeSort.java`, líneas 5-21.

### Diseño

MergeSort divide una lista grande en dos mitades, ordena recursivamente cada mitad y combina las dos listas ordenadas. Sus etapas son:

1. Dividir la lista en `izquierda` y `derecha`.
2. Ordenar cada mitad con llamadas recursivas.
3. Combinar ambas mitades mediante `combinar`.

### Caso base

En las líneas 7-9, una lista con cero o un elemento ya está ordenada y se retorna sin dividirla.

### Combinación

El método `combinar`, líneas 23-42, compara el primer elemento de cada lista, agrega el menor al resultado y continúa hasta vaciar ambas listas.

### Funcionamiento con el ejemplo

La lista inicial `[4, 1, 3, 2]` se divide, se ordena y se muestra como:

```text
Lista ordenada: [1, 2, 3, 4]
```

La implementación demuestra la idea de divide y vencerás. En una implementación de MergeSort optimizada, la complejidad esperada es `O(n log n)`. Este código utiliza `ArrayList.remove(0)`, que puede hacer más costosa la combinación debido al desplazamiento de elementos; aun así, su lógica es clara para fines académicos.

## 8. Tercer problema: Sudoku con backtracking

Archivo: `BackTracking.java`.

### Representación de datos

El Sudoku se representa con una matriz `int[9][9]`. Los números del 1 al 9 son valores ocupados y el valor `0` representa una celda vacía.

### Validación de movimientos

El método `esValidoSudoku`, líneas 2-20, comprueba que un número:

- No se repita en la fila.
- No se repita en la columna.
- No se repita en el bloque de 3 por 3 correspondiente.

### Algoritmo de backtracking

El método `resolverSudoku`, líneas 22-44, realiza estos pasos:

1. Busca la primera celda vacía.
2. Prueba números del 1 al 9.
3. Coloca un número si es válido.
4. Se llama recursivamente para continuar con el tablero.
5. Si el camino no lleva a una solución, restaura la celda a `0` y prueba otro número.
6. Si no quedan celdas vacías, retorna `true`.

La restauración de la celda es el retroceso o backtracking. Permite explorar alternativas sin dejar cambios incorrectos en el tablero.

### Impresión del resultado

El método `imprimirSudoku`, líneas 46-53, recorre la matriz y muestra cada fila. `Main` imprime el tablero resuelto después de llamar a `resolverSudoku`.

## 9. Reporte de ejecución

El reporte debe incluir una captura del código o del resultado de ejecución para cada sección. Las capturas deben realizarse después de ejecutar el programa en VS Code.

### Captura recomendada 1: compilación y ejecución

Ejecutar en la terminal:

```text
javac *.java
java Main
```

La captura debe mostrar que no hay errores de compilación y que aparecen los encabezados de los ejercicios.

### Captura recomendada 2: Fibonacci y Subset Sum

Debe mostrar una salida equivalente a:

```text
=== Fibonacci ===
Fibonacci(7) = 13

=== Suma de subconjuntos ===
¿Existe una suma igual a 9? true
¿Existe una suma igual a 30? false
```

### Captura recomendada 3: recursividad indirecta y MergeSort

Debe mostrar una salida equivalente a:

```text
=== Recursividad indirecta ===
¿8 es par? true
¿7 es impar? true

=== MergeSort: divide y vencerás ===
Lista ordenada: [1, 2, 3, 4]
```

### Captura recomendada 4: Sudoku

Debe mostrar el tablero completo sin ceros:

```text
=== Sudoku: backtracking ===
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
```

En el documento final, las salidas anteriores deben compararse con la captura real. No se deben presentar capturas como si fueran reales si no fueron tomadas durante la ejecución.

## 10. Reflexión final sugerida

La recursividad permite expresar una solución usando versiones más pequeñas del mismo problema. Para que sea correcta, debe tener casos base que detengan las llamadas y un caso recursivo que reduzca el problema. En Fibonacci y Subset Sum, esta técnica hace visible la estructura del problema y facilita su comprensión.

La recursividad indirecta muestra que la descomposición también puede distribuirse entre varios métodos que colaboran entre sí. Por otra parte, divide y vencerás reduce un problema grande a subproblemas independientes, como ocurre al separar una lista en MergeSort. El backtracking agrega la posibilidad de probar decisiones, detectar caminos inválidos y deshacerlos, como sucede al llenar un Sudoku.

Estas técnicas son importantes para resolver problemas complejos porque permiten organizar la solución en pasos pequeños, identificar casos base y controlar la exploración de alternativas. También muestran que una solución clara debe considerar sus costos: algunas soluciones recursivas son sencillas pero pueden requerir mucho tiempo, por lo que en aplicaciones reales podrían optimizarse con memoria, programación dinámica o estructuras de datos más eficientes.

## 11. Conclusión sugerida

El proyecto cumple con la implementación de Fibonacci recursivo, Subset Sum recursivo y Sudoku mediante backtracking. También demuestra recursividad indirecta con `esPar` y `esImpar`, y divide y vencerás con MergeSort. El uso de `Main` permite ejecutar todas las pruebas desde un solo lugar y verificar los resultados de forma reproducible.
