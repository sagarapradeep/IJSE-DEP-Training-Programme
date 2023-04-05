public class NullObject {
    public static void main(String[] args) {
        System.out.println(find("IJSE", 0, 1));
        System.out.println(find("IJSE", -1, 34));
        System.out.println(find("Here is some text", 5, 6));
        System.out.println(find("Here is some text", 4, 1));

    }

    public static String find(String input,int start, int end) {

        if(start<0||end>input.length())return null;
        String extractedText = input.substring(start, end);
        return extractedText;

    }
}
