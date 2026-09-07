import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Recursivo recursivo = new Recursivo();

        System.out.println("=== Fibonacci ===");
        System.out.println("Fibonacci(7) = " + recursivo.fibonacci(7));

        System.out.println("\n=== Suma de subconjuntos ===");
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        System.out.println("¿Existe una suma igual a 9? "
                + recursivo.sumaSubconjunto(conjunto, 9));
        System.out.println("¿Existe una suma igual a 30? "
                + recursivo.sumaSubconjunto(conjunto, 30));

        System.out.println("\n=== Recursividad indirecta ===");
        System.out.println("¿8 es par? " + recursivo.esPar(8));
        System.out.println("¿7 es impar? " + recursivo.esImpar(7));

        System.out.println("\n=== MergeSort: divide y vencerás ===");
        MergeSort mergeSort = new MergeSort();
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(4, 1, 3, 2));
        System.out.println("Lista ordenada: " + mergeSort.mergeSort(lista));

        System.out.println("\n=== Sudoku: backtracking ===");
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        BackTracking sudoku = new BackTracking();
        if (sudoku.resolverSudoku(tablero)) {
            sudoku.imprimirSudoku(tablero);
        } else {
            System.out.println("El Sudoku no tiene solución.");
        }
    }
}
