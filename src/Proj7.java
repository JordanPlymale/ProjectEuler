import java.math.BigInteger;

public class Proj7 {
    public static void main(String[] args) {
        int counter = 6;
        for(int i = 13; counter < 10002; i+=2){
            if(isPrime(new BigInteger(i+""))){
                counter++;
                System.out.println(i);
            }
        }


    }

    public static boolean isPrime(BigInteger num) {
        for(BigInteger i = BigInteger.TWO; i.compareTo(num.sqrt()) < 1; i = i.add(BigInteger.ONE)){
            if(num.mod(i).equals(BigInteger.ZERO)){
                return false;
            }

        }
        return true;
    }
}
