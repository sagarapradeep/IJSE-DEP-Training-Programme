import java.util.Arrays;

public class Debug
{
    public static void main(String[] args) {

        var numbs = new int[]{10, 20, -45, 66, -44};

        var max = numbs[numbs.length-1];
        var maxIndex=numbs.length-1;

        var i=0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        for (int j = 0; j < numbs.length; j++) {
            System.out.println(j);
            j++;
        }


        System.out.println(Arrays.toString(numbs));

    }
}
