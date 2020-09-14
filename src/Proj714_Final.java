/*import java.math.BigInteger;

public class Proj714_Final {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(d(new BigInteger("3170")));


        /*BigInteger k = new BigInteger("50000").add(BigInteger.ONE);
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger x = new BigInteger("1"); !x.equals(k); x = x.add(BigInteger.ONE)) {
            System.out.println(x);
            sum = sum.add(d(x));
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-startTime + " ms");
    }

    private static BigInteger d(BigInteger n) {
        BigInteger multiplier = BigInteger.ONE;
        while(true) {
            BigInteger result = n.multiply(multiplier);
            if(isDuoDigit(result))




        }

    }

    private static int isDuoDigit(BigInteger n) {
        int digit1 = n.mod(BigInteger.TEN).intValue(), digit2 = -1;
        n = n.divide(BigInteger.TEN);
        while (!n.equals(BigInteger.ZERO)) {
            int nextDigit = n.mod(BigInteger.TEN).intValue();
            if (nextDigit != digit1)
                if (digit2 == -1)
                    digit2 = nextDigit;
                else if (nextDigit != digit2)
                    return false;
            n = n.divide(BigInteger.TEN);
        }
        return true;
    }

    public static int length(BigInteger i) {
        double factor = Math.log10(2);
        int digitCount = (int)(factor * i.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(i) > 0){
            return digitCount - 1;
        }
        return digitCount;
    }


}
*/