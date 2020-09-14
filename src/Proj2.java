public class Proj2 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; fib(i) < 4000000; i ++){
            if(fib(i)%2 == 0){
                sum += fib(i);
            }

        }
        System.out.println(sum);

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
