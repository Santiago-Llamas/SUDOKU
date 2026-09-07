

import java.util.ArrayList;

public class MergeSort {

    // Divide el arreglo, ordena cada mitad y después las combina.
    public ArrayList<Integer> mergeSort(ArrayList<Integer> lista){
        if(lista.size() <= 1){
            return lista;
        }

        int mitad = lista.size() / 2;
        ArrayList<Integer> izquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Integer> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        ArrayList<Integer> izquierdaOrdenada = mergeSort(izquierda);
        ArrayList<Integer> derechaOrdenada = mergeSort(derecha);

        return combinar(izquierdaOrdenada, derechaOrdenada);
    }

    private ArrayList<Integer> combinar(ArrayList<Integer> izquierda,
            ArrayList<Integer> derecha){
        ArrayList<Integer> resultado = new ArrayList<>();
        while(!izquierda.isEmpty() && !derecha.isEmpty()){

            if(izquierda.get(0) <= derecha.get(0)){
                resultado.add(izquierda.remove(0));
            }
            else{
                resultado.add(derecha.remove(0));
            }
        }

        while(!izquierda.isEmpty()){
            resultado.add(izquierda.remove(0));
        }

        while(!derecha.isEmpty()){
            resultado.add(derecha.remove(0));
        }

        return resultado;
    }
}
