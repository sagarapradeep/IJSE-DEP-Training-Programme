import java.util.Arrays;

public class WhileDemo2
{
    public static void main(String[] args) {
        var nums = new int[]{10, 34, 54, 33, 599, 56, -96, 5};
        var sortedNumbs=new int[nums.length];
        int i=0;

        int smallestNum = 0;


        while (i<nums.length) {
            smallestNum = nums[i];
            var minIndex=i;
            int j=i+1;
            while (j < nums.length) {

                if (smallestNum > nums[j]) {
                    smallestNum = nums[j];
                    minIndex=j;

                }
                j++;

            }
            var temp = nums[i];
            nums[i]=smallestNum;
            nums[minIndex]=temp;
            i++;
        }


        System.out.println(Arrays.toString(nums));;

    }
}
