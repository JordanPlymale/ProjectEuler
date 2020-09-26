import java.math.BigDecimal;

public class Proj206 {
    public static void main(String[] args) {
        System.out.println(create(123456789));
    }

    public static BigDecimal create(int number){

        BigDecimal finalNum = new BigDecimal("102030405060708090.0");
        String numString = number + "";

        for(int i = 17; i > 0; i-=2) {
            finalNum = finalNum.add(BigDecimal.valueOf(numString.charAt(i/2) * Math.pow(10,i)));
            System.out.println(number%Math.pow(10,i));
        }
        return finalNum;
    }
}
