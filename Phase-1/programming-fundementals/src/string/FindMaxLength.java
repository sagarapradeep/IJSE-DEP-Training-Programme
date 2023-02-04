package string;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] data = {"kasun", "Amal","Pubudu", "Hansana"};
        findTheLongest(data);

    }

    public static void findTheLongest(String[] data) {
        int maxIndex=0;
        int maxLength=data[0].length();

            char[]charArray=data[0].toCharArray();
            for (int i = 1; i < data.length; i++) {
                if (maxLength < data[i].length()) {
                    maxIndex = i;
                    maxLength = data[i].length();
                }

            }

        System.out.println("Maximum Length name "+maxLength);
        System.out.println("Maximum Length index "+maxIndex);

    }





}
