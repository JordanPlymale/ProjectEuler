import java.math.BigInteger;

public class Proj684 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        var sum = BigInteger.ZERO;

        //System.out.println(s(20));

        for(int i = 1; i <= 90; i++){
            /*sum = sum.add(s(fib(i)));
            System.out.println(sum);*/
            System.out.println(fib(i));
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-startTime + " ms");
    }

    private static BigInteger s(long n){
        BigInteger num = new BigInteger("0");
        BigInteger sum = new BigInteger(n + "");
        BigInteger nine = new BigInteger("9");
        BigInteger numOfNines = sum.divide(nine);
        int exp = 0;

        for(int i = 0; i < numOfNines.intValue(); i++){
            num = num.add(BigInteger.TEN.pow(i).multiply(nine));
            exp++;
        }
        return num = num.add((sum.subtract(numOfNines.multiply(nine))).multiply(BigInteger.TEN.pow(exp)));

    }

    private static long fib(int i) {
        long firstTerm = 0, secondTerm = 1;
        for (int x = 0; x < i; x++) {
            long temp = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = temp;
        }
        return secondTerm;
    }
}
