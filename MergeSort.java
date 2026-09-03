

import java.util.ArrayList;

public class MergeSort {
    
    //Métodos
    public ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
        if(arr.size() == 1){
            return arr;
        }

        //Dividir
        int mid = arr.size() / 2;
        ArrayList<Integer> arr_izq = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> arr_der = new ArrayList<>(arr.subList(mid, arr.size()));

        //Conquistar Recursivamente
        ArrayList<Integer> izq_ordenado = mergeSort(arr_izq);
        ArrayList<Integer> der_ordenado = mergeSort(arr_der);

        //Combinar
        return Merge(izq_ordenado, der_ordenado);
    }

    private ArrayList<Integer> Merge(ArrayList<Integer> arr_izq, ArrayList<Integer> arr_der){
        ArrayList<Integer> arr_res = new ArrayList<>();
        while(!arr_izq.isEmpty() && !arr_der.isEmpty()){

            int selNum;
            if(arr_izq.get(0) > arr_der.get(0)){
                selNum = arr_der.remove(0);
            }
            else{
                selNum = arr_izq.remove(0);
            }
            arr_res.add(selNum);
        }

        while(!arr_izq.isEmpty()){
            int num_izq = arr_izq.remove(0);
            arr_res.add(num_izq);
        }

        while(!arr_der.isEmpty()){
            int num_der = arr_der.remove(0);
            arr_res.add(num_der);
        }

        return arr_res;
    }
    
}
