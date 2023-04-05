public class Array3
{
    public static void main(String[] args) {
        int[][] array2d=new int[3][];

        int nums[]={1,2,3};

        array2d[1]=new int[]{20,30,34};
        array2d[2]=new int[0];

        System.out.println(array2d[0]);
        System.out.println(array2d[1]);
        System.out.println(array2d[2]);

        array2d[0]=nums;
        array2d[0][1]=65;
        System.out.println(nums[1]);

    }
}
