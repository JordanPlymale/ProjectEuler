

import java.math.BigInteger;

public class Proj714 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(d(new BigInteger("3170")));


       /* BigInteger k = new BigInteger("50000").add(BigInteger.ONE);
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger x = new BigInteger("3100"); !x.equals(k); x = x.add(BigInteger.ONE)) {
            System.out.println(x);
            sum = sum.add(d(x));
        }
        System.out.println(sum);*/
        System.out.println(System.currentTimeMillis()-startTime + " ms");
    }

    private static BigInteger d(BigInteger n) {
        BigInteger multiple = new BigInteger("1");
        while (true) {
            if (isDuoDigit(n.multiply(multiple))){
                System.out.println(multiple);
                return n.multiply(multiple);
            }
            int numDigitsReturn = 0, numDigitsMult = 0;
            int length = length(multiple);
            //finds the number of digits in the multiple

            //the general formulas for the number of digits to check for both return (the product) and mult (multiple)
            //follow that the number of digits
            if(length > 5){
                numDigitsMult = length - 1;
                numDigitsReturn = numDigitsMult - 2;
            }

            //only the first five digits of the multiplier have influence over the first three digits of the return number
            if(numDigitsMult!=0&&numDigitsReturn!=0){
                //System.out.println("first three digits: "+ ((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length())-3)))));
                for(int i = 5; i <= numDigitsMult;i++) {

                    //takes the return n.multiply(multiple), divides it by 10^(# digits - 3) (finding the first 3) and runs it through isDuoDigit
                    if (!isDuoDigit(((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length()) - (i-2))))))) {
                        //if the first three are NOT a duo digit, we are adding 1 to the fifth digit on multiple
                        //since if the first 3 of return are NOT a duo digit, non of the rest of the digit will be a duo digit
                        //if only the first 5 digits of multiple affect the first three of return, then you can increment the fifth digit of multiple by 1, skipping multiple tests
                        int factor = multiple.toString().length() - i;
                        multiple = multiple.divide(BigInteger.TEN.pow(factor));
                        multiple = multiple.add(BigInteger.ONE);
                        multiple = multiple.multiply(BigInteger.TEN.pow(factor));
                    } else {
                        //if the first three ARE duodigits, then we increment by 1 as to not pass the answer
                        multiple = multiple.add(BigInteger.ONE);
                    }
                }
            }else{
                //if mult is less than 6 digits we just add one until it is over 5 digits
                multiple = multiple.add(BigInteger.ONE);
            }
            //System.out.println(multiple.intValue());

        }
    }

    private static boolean isDuoDigit(BigInteger n) {
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



//working, only checks 3, 5
/*
//only the first five digits of the multiplier have influence over the first three digits of the return number
            if(multiple.toString().length() > 5){
                //System.out.println("first three digits: "+ ((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length())-3)))));

                //takes the return n.multiply(multiple), divides it by 10^(# digits - 3) (finding the first 3) and runs it through isDuoDigit
                if(!isDuoDigit(((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length())-3)))))){
                    //if the first three are NOT a duo digit, we are adding 1 to the fifth digit on multiple
                    //since if the first 3 of return are NOT a duo digit, non of the rest of the digit will be a duo digit
                    //if only the first 5 digits of multiple affect the first three of return, then you can increment the fifth digit of multiple by 1, skipping multiple tests
                    int factor = multiple.toString().length() - 5;
                    multiple = multiple.divide(BigInteger.TEN.pow(factor));
                    multiple = multiple.add(BigInteger.ONE);
                    multiple = multiple.multiply(BigInteger.TEN.pow(factor));
                }else{
                    //if the first three ARE duodigits, then we increment by 1 as to not pass the answer
                    multiple = multiple.add(BigInteger.ONE);
                }

            }else{
                //if mult is less than 5 digits we just add one until it is over 5 digits
                multiple = multiple.add(BigInteger.ONE);
            }
 */



/* working 1:39
//only the first five digits of the multiplier have influence over the first three digits of the return number
            if(numDigitsMult!=0&&numDigitsReturn!=0){
                //System.out.println("first three digits: "+ ((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length())-3)))));

                //takes the return n.multiply(multiple), divides it by 10^(# digits - 3) (finding the first 3) and runs it through isDuoDigit
                if(!isDuoDigit(((n.multiply(multiple)).divide((BigInteger.TEN.pow((n.multiply(multiple).toString().length())-numDigitsReturn)))))){
                    //if the first three are NOT a duo digit, we are adding 1 to the fifth digit on multiple
                    //since if the first 3 of return are NOT a duo digit, non of the rest of the digit will be a duo digit
                    //if only the first 5 digits of multiple affect the first three of return, then you can increment the fifth digit of multiple by 1, skipping multiple tests
                    int factor = multiple.toString().length() - numDigitsMult;
                    multiple = multiple.divide(BigInteger.TEN.pow(factor));
                    multiple = multiple.add(BigInteger.ONE);
                    multiple = multiple.multiply(BigInteger.TEN.pow(factor));
                }else{
                    //if the first three ARE duodigits, then we increment by 1 as to not pass the answer
                    multiple = multiple.add(BigInteger.ONE);
                }

            }else{
                //if mult is less than 6 digits we just add one until it is over 5 digits
                multiple = multiple.add(BigInteger.ONE);
            }

 */