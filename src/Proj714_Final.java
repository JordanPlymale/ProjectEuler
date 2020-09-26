

// WIP (got 245697130621188677682 in 2 hours, wrong)

// difficult cases:
// d(8910) = 9999999999999999990 (multiple = 1122334455667789)
// d(17820) = 22222222222222220220 (multiple = 1247038284075321)

import java.math.BigInteger;


public class Proj714_Final {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(d(new BigInteger("8910")));
        System.out.println(startTime - System.currentTimeMillis() + " ms");
        /*BigInteger k = new BigInteger("50000").add(BigInteger.ONE);
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger x = new BigInteger("1"); !x.equals(k); x = x.add(BigInteger.ONE)) {
            BigInteger d = d(x);
            sum = sum.add(d);
            System.out.println("x: " + x + "\t\tproduct: " + d + "\t\tsum: " + sum);
        }
        System.out.println(sum);*/
    }

    private static BigInteger d(BigInteger n) {
        BigInteger product;
        BigInteger multiple = new BigInteger("1");
        //int progress = 0;
        while (true) {
            // Progress updates
            /*
            if (progress == 10000) {
                System.out.println(multiple);
                progress = 0;
            }
             */

            product = n.multiply(multiple);

            int multipleLength = length(multiple);

            int ddResult = isDuoDigit(product);
            if (ddResult == 0)
                return product;
            else if (multipleLength > 5 && ddResult + 2 < multipleLength)
                multiple = firstNDigits(multiple, ddResult + 2, multipleLength).add(BigInteger.ONE).multiply(BigInteger.TEN.pow(multipleLength - ddResult - 2));
            else
                multiple = multiple.add(BigInteger.ONE);

            //progress++;
        }
    }

    private static int isDuoDigit(BigInteger n) {
        char[] chars = n.toString().toCharArray();
        char digit1 = chars[0], digit2 = ' ';
        for (int x = 1; x < chars.length; x++) {
            char nextDigit = chars[x];
            if (nextDigit != digit1)
                if (digit2 == ' ')
                    digit2 = nextDigit;
                else if (nextDigit != digit2)
                    return x + 1;
        }
        return 0;
    }

    private static BigInteger firstNDigits(BigInteger i, int n, int length) {
        return i.divide(BigInteger.TEN.pow(length - n));
    }

    private static BigInteger lastNDigits(BigInteger i, int n) {
        return i.mod(BigInteger.TEN.pow(n));
    }

    // https://stackoverflow.com/questions/18828377/biginteger-count-the-number-of-decimal-digits-in-a-scalable-method
    private static int length(BigInteger i) {
        double factor = Math.log10(2);
        int digitCount = (int) (factor * i.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(i) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }
}