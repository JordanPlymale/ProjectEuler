public class Proj5 {
    public static void main(String[] args) {
        long i = 2;
        while(!isDivisible(i)){
            i += 2;
        }
        System.out.println("final: " + i);
    }
    public static boolean isDivisible(long number){
        for(int i = 1; i <= 20; i++){
            if(number%i != 0){
                return false;
            }

        }
        return true;

    }
}
