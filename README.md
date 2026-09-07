# Actividad: Recursividad y algoritmos

## 1. Fibonacci

`Recursivo.fibonacci` usa recursividad directa. Los casos base son `F(0) = 0` y `F(1) = 1`. Para cualquier otro índice aplica `F(n) = F(n - 1) + F(n - 2)`.

## 2. Suma de subconjuntos

`Recursivo.sumaSubconjunto` analiza cada elemento con dos posibilidades: incluirlo en el subconjunto o no incluirlo. El caso base es encontrar el objetivo (`objetivo == 0`) o terminar los elementos sin encontrarlo.

## 3. Sudoku

`BackTracking.resolverSudoku` busca una celda vacía, prueba números del 1 al 9 y verifica la fila, columna y bloque de 3x3. Si una elección no permite terminar el tablero, la deshace y prueba otra.

## Técnicas aplicadas

- Recursividad directa: `fibonacci` y `sumaSubconjunto` se llaman a sí mismos.
- Recursividad indirecta: `esPar` y `esImpar` se llaman entre sí.
- Divide y vencerás: `MergeSort` divide la lista en dos mitades, ordena cada una y las combina.
- Backtracking: Sudoku construye una solución paso a paso y retrocede ante una opción inválida.

## Reflexión

Estas técnicas permiten convertir un problema grande en subproblemas más pequeños. La recursividad expresa naturalmente problemas que se repiten; divide y vencerás reduce el tamaño del problema; y backtracking explora posibilidades sin conservar decisiones que conducen a un resultado inválido. Juntas ayudan a resolver problemas complejos de forma ordenada y comprensible.

## Ejecución

Desde esta carpeta:

```text
javac *.java
java Main
```

`Main` ejecuta todos los ejercicios y muestra el Sudoku resuelto.
