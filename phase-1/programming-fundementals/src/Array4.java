public class Array4
{
    public static void main(String[] args) {

        int x=10;
        int[] num1;
        int[][] array2D;
        int [][] array2D2;

        num1=new int[]{10,20,30,40};
        array2D=new int[2][];
        array2D2=new int[3][];

        array2D[1]=num1;
        array2D[0]=new int[]{70,80,90};
        array2D2=new int[3][];
        array2D2[0]=new int[]{40,50,60};
        array2D2[2]=new int[]{40,50,60};

        array2D2[1]=array2D[1];

    }
}
