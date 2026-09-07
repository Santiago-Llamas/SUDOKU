
public class BackTracking {
    static boolean esValidoSudoku(int[][] tablero, int fila, int columna, int numero){
        for(int i = 0; i < 9; i++){
            if(tablero[fila][i] == numero || tablero[i][columna] == numero){
                return false;
            }
        }

        int inicioFila = fila - fila % 3;
        int inicioColumna = columna - columna % 3;
        for(int i = inicioFila; i < inicioFila + 3; i++){
            for(int j = inicioColumna; j < inicioColumna + 3; j++){
                if(tablero[i][j] == numero){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean resolverSudoku(int[][] tablero){
        // Prueba un número y lo deshace cuando lleva a un camino inválido.
        for(int fila = 0; fila < 9; fila++){
            for(int columna = 0; columna < 9; columna++){
                if(tablero[fila][columna] == 0){
                    for(int numero = 1; numero <= 9; numero++){
                        if(esValidoSudoku(tablero, fila, columna, numero)){
                            tablero[fila][columna] = numero;

                            if(resolverSudoku(tablero)){
                                return true;
                            }

                            tablero[fila][columna] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirSudoku(int[][] tablero){
        for(int[] fila : tablero){
            for(int numero : fila){
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }
}
