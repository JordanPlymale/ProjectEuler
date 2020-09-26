import java.math.BigInteger;

public class Proj3 {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("600851475143");

        for(BigInteger i = number.sqrt().add(BigInteger.ONE); i.compareTo(BigInteger.ZERO) > -1 ; i = i.subtract(BigInteger.TWO)){
            if(number.mod(i).equals(BigInteger.ZERO)){
                if(isPrime(i)){
                    System.out.println("Prime factor: " + i);
                    break;
                }
                System.out.println("Factor: " + i);
            }
            System.out.println(i);
        }
        System.out.println("done");
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
