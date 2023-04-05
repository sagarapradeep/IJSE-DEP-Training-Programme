public class EnhancedForLoop {
    public static void main(String[] args) {
        var nums = new int[]{10, 20, 30, 40, 50};
        int sum=0;

        for (int i : nums) {
            sum += i;

        }
        System.out.printf("Sum is %s",sum);
    }
}
