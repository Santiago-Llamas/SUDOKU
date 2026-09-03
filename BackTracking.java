
public class BackTracking {
    
    //Función que revisa si es seguro
    //Poner una reina en el tablero[row][col]
    static boolean esSeguro(int[][] tablero, int row, int col){
        int n = tablero.length;
        int i, j;

        //Revisar la columna desde arriba
        for(i = 0; i < row; i++){
            if (tablero[i][col] == 1){
                return false;
            }
        }

        //Revisar la diagonal del lado izquierdo
        for(i=row-1, j = col-1; i >=0 && j >= 0; i--, j--){
            if(tablero[i][j] == 1){
                return false;
            }
        }

        //Revisar la diagonal del lado derecho
        for(i = row - 1, j = col + 1; j < n && i >=0; i--, j++){
            if(tablero[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    static boolean ponReinas(int row, int[][] tablero){
        int n = tablero.length;

        //caso base: si todas las reinas han
        //sido colocadas, regresa true
        if(row == n){
            return true;
        }

        //Considdera la fila e intenta poner
        //una reina en todas las columnas una por una
        for(int i = 0; i < n; i++){

            //Revisa si la reina puede ser colocada
            if(esSeguro(tablero, row, i)){
                tablero[row][i] = 1;
                if(ponReinas(row + 1, tablero)){
                    return true;
                }
                tablero[row][i] = 0;

            }
        }

        return false;
    }

    //Función para encontrar la solución
    //al problema de las 8 reinas
    public int[][] reinas(){
        int n = 8;

        //inicia el tablero
        int[][] tablero = new int[n][n];

        ponReinas(0, tablero);

        return tablero;
    }
}
