public class Proj6 {
    public static void main(String[] args) {
        long sumSquared = 0;
        long sumOfSquared = 0;
        long sum = 0;

        for(int i = 0; i <= 100; i++){
            sum += i;
        }
        sumSquared = (long) Math.pow(sum,2);

        for(int i = 0; i <=100; i++){
            sumOfSquared += (long)Math.pow(i,2);
        }
        System.out.println(sumSquared - sumOfSquared);

    }
}
