
public class Recursivo {
    
    public int factIFr(int num){
        if(num == 1){
            return 1;
        }
        else{
            return num * factIFr(num-1);
        }
    }

    public int factSWITCHr(int num){
        switch(num){
            case 1:
                return 1;
            //break;
            default:
                return num * factSWITCHr(num-1);
            //break;
        }
    }
    
    public int fibbonacci(int num){
        switch(num){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibbonacci(num-1)+fibbonacci(num-2);
        }
    }
    public String esPalindromo(String palindromo) {
    String invertido = new StringBuilder(palindromo).reverse().toString();

    if (palindromo.equals(invertido)) {
        return "La palabra " + palindromo + " si es Palindromo crack";
    } else {
        return "La palabra " + palindromo + " no es Palindromo crack";
    }
    }

}
