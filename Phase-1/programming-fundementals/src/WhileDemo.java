import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class WhileDemo
{
    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        int i=0;
        int[] nums2 = new int[nums.length];

        while (i < nums.length) {
            nums2[i] = nums[nums.length - i-1];

            i++;
        }
        nums = nums2;


        System.out.println(Arrays.toString(nums));
    }
}
