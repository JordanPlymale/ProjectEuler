public class Proj4 {
    public static void main(String[] args) {
        long pal = 0;
        for(int i = 999; i > 0; i--) {
            for(int j = 999; j > 0; j--) {
                if(isPalindrome(i * j)){
                    if(i * j > pal)
                        pal = i * j;
                    System.out.println("i: "+ i);
                    System.out.println("j: "+ j);

                }
            }
        }
        System.out.println("palindrome: " + pal);
    }
    public static boolean isPalindrome(long num){
        String number = num + "";
        char[] numberSplit = number.toCharArray();

        for(int i = 0; i < numberSplit.length; i++){
            if(numberSplit[i] != (numberSplit[numberSplit.length - 1 - i])){
                return false;
            }
        }
        return true;
    }
}
