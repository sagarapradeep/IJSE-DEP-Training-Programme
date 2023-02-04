package practice;

public class ReverseStringRecursive {
    public static void main(String[] args) {
        String str = "abcD";
        printReverse(str);
    }

    public static void printReverse(String str) {
        str = reverseString(str);
        System.out.println(str);
    }

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        if (array.length == 0) return "String is empty";
        recursiveReverse(array, 0);
        str = recursiveAdd(array,0,"");
        return str;
    }

    private static void recursiveReverse(char[] array, int index) {
        if (index == array.length/2) return;
        char temp;
        temp = array[index];
        array[index] = array[array.length - 1 - index];
        array[array.length-1-index] = temp;
        recursiveReverse(array, index+1);
    }

    private static String recursiveAdd(char[] array, int index,String str) {
        if (index == array.length) return "";
        str = Character.toString(array[index]);
        str += recursiveAdd(array,index + 1,str);
        return str;
    }

}
