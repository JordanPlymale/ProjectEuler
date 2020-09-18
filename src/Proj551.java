//import java.math.BigInteger;

//20000000000
//sum: 1045315151345

//20100000000
//sum: 1050414332576

//151400000000
//sum: 8518841356457

//378000000000
//sum: 21685582737923

//685000000000
//sum: 40154741856665

//10^8, 4047602471, 4043 ms

public class Proj551 {
    //private static final BigInteger HUNDRED_THOUSAND = new BigInteger("1000000");
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(a((long)Math.pow(10,15)));
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    public static long a(long n) {

        long sum = 21685582737923L;

        for(long i = 378000000000L; i < n; i++) {
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

        while(num != 0){
            finalNum += num % 10;
            num /= 10;
        }

        return finalNum;
    }


}
