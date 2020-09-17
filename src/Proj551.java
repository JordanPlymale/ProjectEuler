//import java.math.BigInteger;

//20000000000
//sum: 1045315151345

//20100000000
//sum: 1050414332576

//151400000000
//sum: 8518841356457

//378000000000
//sum: 21685582737923

//10^8, 4047602471, 4043 ms

public class Proj551 {
    //private static final BigInteger HUNDRED_THOUSAND = new BigInteger("1000000");
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(a((long)Math.pow(10,15)));
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    public static long a(long n) {

        long sum = 21012650953103l;

        for(long i = 365600000000l; i < n; i++) {
            if (i % 1000000000 == 0) {
                System.out.println(i);
                System.out.println("sum: " + sum);
            }
            sum += digitAdder(sum);
        }
        return sum;
    }


    public static long digitAdder(long num) {

        long finalNum = 0;
        /*char[] temp = (num + "").toCharArray();

        for (char c : temp) {

            finalNum += (c - 48);
        }*/
        while(num != 0){
            finalNum += num % 10;
            num /= 10;
        }

        return finalNum;
    }


}

/*
public class Proj551 {
    private static final BigInteger HUNDRED_THOUSAND = new BigInteger("1000000");
    public static void main(String[] args) {
        System.out.println(a(new BigInteger((long)Math.pow(10,15)+"")));
    }

    public static BigInteger a(BigInteger n) {

        BigInteger sum = BigInteger.ONE;

        for(BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            if (i.mod(HUNDRED_THOUSAND).equals(BigInteger.ZERO)) {
                System.out.println(i);
                System.out.println("sum: " + sum);
            }
            sum = sum.add(digitAdder(sum));
        }
        return sum;
    }


    public static BigInteger digitAdder(BigInteger num) {
        char[] temp = num.toString().toCharArray();
        BigInteger finalNum = BigInteger.ZERO;

        for (char c : temp) {

            finalNum = finalNum.add(new BigInteger((c - 48) + ""));
        }
        return finalNum;
    }
 */

