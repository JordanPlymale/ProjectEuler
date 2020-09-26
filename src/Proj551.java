//20000000000
//sum: 1045315151345

//20100000000
//sum: 1050414332576

//151400000000
//sum: 8518841356457

//378000000000
//sum: 21685582737923

//700000000000
//sum: 41018235111359

//700000000000 UPDATED
//sum: 41018235111403

//1041000000000
//sum: 62083915062089

//1520000000000
//sum: 93010082789347

//1622500000000
//sum: 99975388793536

//2245400000000
//sum: 136904510092804

//10^8, 4047602471, 1369 ms


public class Proj551 {
    private static long sumOfFirstDigits;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(a((long)Math.pow(10,15)));
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    private static long a(long n) {

        long sum = 128981976824060L;

        long temp = 0;
        boolean mightWrap = false;

        if(checkFifthDigit(sum) < 8){
            temp = 122;
        }

        for(long i = 2114100000000L; i < n; i++) {

            if(temp > 0){
                sum += digitAdder(sum, false);
                sum += sumOfFirstDigits;
                temp--;
            }else {
                sum += digitAdder(sum, true);
                long fifthDigit = checkFifthDigit(sum);
                if (mightWrap && fifthDigit == 0) {
                    digitAdder(sum, true);
                    mightWrap = false;
                }
                if(fifthDigit < 8){
                    temp = 12;
                } else {
                    mightWrap = true;
                }
            }
            if (i % 100000000 == 0) {
                System.out.println(i);
                System.out.println("sum: " + sum);
            }
        }
        return sum;
    }


    private static long digitAdder(long num, boolean wholeNum) {

        long finalNum = 0;
        long temp = 0;
        long firstFive = 0;

        if(wholeNum) {
            //RUNNING THROUGH WHOLE NUMBER
            while (num != 0) {
                finalNum += num % 10;

                if (temp < 5) {
                    temp++;
                    firstFive = finalNum;
                }

                num /= 10;
            }
            sumOfFirstDigits = finalNum - firstFive;
        }else{
            while (temp < 5) {
                finalNum += num % 10;
                num /= 10;
                temp++;
            }
        }
        return finalNum;
    }

    private static long checkFifthDigit(long num) {
        return num % 100000 / 10000;
    }



}

//10,8  4047602471
//4038 ms
/*
public class Proj551 {
    //private static final BigInteger HUNDRED_THOUSAND = new BigInteger("1000000");
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(a((long)Math.pow(10,8)));
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    public static long a(long n) {

        long sum = 1L;

        for(long i = 1L; i < n; i++) {
            //if (i % 1000000000 == 0) {
              //  System.out.println(i);
              //  System.out.println("sum: " + sum);
            //}
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


 */