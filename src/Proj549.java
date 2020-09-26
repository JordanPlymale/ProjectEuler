import java.math.BigInteger;

public class Proj549 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BigInteger[] factorials = factorialGenerator(3001);
        long sum = 0;
        for(BigInteger i = new BigInteger("2"); i.compareTo(BigInteger.valueOf((long)Math.pow(10,8))) < 1; i = i.add(BigInteger.ONE)) {
            int temp = 2;

            if((!isPrime(i) || (i.mod(BigInteger.TWO)).equals(BigInteger.ZERO)) && !isPrime(i.divide(BigInteger.TWO))) {
                while (!factorials[temp].mod(i).equals(BigInteger.ZERO)) {
                    temp++;
                }
            }else{
                temp = i.intValue();
            }
            System.out.println("number: " + i + " Factorial: " + temp);


            sum += temp;
            temp = 2;
        }

        System.out.println("sum: " + sum);
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    //creates an array of one higher than input to account for zero so if you need
    //the 25th factorial you can just do [25]
    private static BigInteger[] factorialGenerator(int numberOfFactorials) {
        BigInteger temp = BigInteger.ONE;
        BigInteger[] retArray = new BigInteger[numberOfFactorials + 1];
        retArray[0] = BigInteger.ONE;

        for(int j = 1; j <= numberOfFactorials; j++) {

            for(int k = 1; k <= j; k++) {
                temp = temp.multiply(BigInteger.valueOf(k));
            }
            retArray[j] = temp;
            temp = BigInteger.ONE;
        }

        return retArray;
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
