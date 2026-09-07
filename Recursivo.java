
public class Recursivo {

    // Recursividad directa: el método se llama a sí mismo.
    public int fibonacci(int num){
        if(num < 0){
            throw new IllegalArgumentException("El indice no puede ser negativo");
        }
        if(num == 0 || num == 1){
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public boolean sumaSubconjunto(int[] conjunto, int indice, int objetivo){
        if(objetivo == 0){
            return true;
        }
        if(indice == conjunto.length){
            return false;
        }

        return sumaSubconjunto(conjunto, indice + 1, objetivo - conjunto[indice])
                || sumaSubconjunto(conjunto, indice + 1, objetivo);
    }

    public boolean sumaSubconjunto(int[] conjunto, int objetivo){
        return sumaSubconjunto(conjunto, 0, objetivo);
    }

    // Recursividad indirecta: estos métodos se llaman entre sí.
    public boolean esPar(int num){
        if(num == 0){
            return true;
        }
        return esImpar(Math.abs(num) - 1);
    }

    public boolean esImpar(int num){
        if(num == 0){
            return false;
        }
        return esPar(Math.abs(num) - 1);
    }
}
