package string;

public class TableDemo {
    public static void main(String[] args) {
        String []columnNames = {"ID", "Names"};
        String [][]data = {
                {"S001","Kasun"},
                {"S002","Nimal"},
                {"S003","Nuwan"},
                {"S004","Amal"},
                {"S005","Amara"}
        };
        printTable(columnNames,data);

    }
    public static void printTable(String[] columns, String[][] data) {
        int rawLength = data.length;
        int columnLength = data[0].length;
        int[] maxLengthArray = new int[columnLength];
        for (int i = 0; i < columns.length; i++) {
            String[] temporaryNames = new String[rawLength];
            for (int j = 0; j < rawLength; j++) {
                temporaryNames[j] = data[j][i];
            }
            maxLengthArray[i] = findTheLongest(temporaryNames);
        }

        for (int i = 0; i < (rawLength+1); i++) {
            if (i==0||i==1||i==rawLength+1) {
                for (int j = 0; j < columnLength; j++) {
                    System.out.print("+".concat("-".repeat(maxLengthArray[j])));

                }
                System.out.print("+");
            }
            System.out.println();
            for (int k = 0; k < columnLength; k++) {
                if (i == 0) {

                    System.out.printf("|%-".concat(Integer.toString(maxLengthArray[k]) + "s"), columns[k].toUpperCase());
                } else {
                    System.out.printf("|%-".concat(Integer.toString(maxLengthArray[k]) + "s"), data[i-1][k]);
                }

            }
            System.out.print("|");
            System.out.println();


            }

        for (int j = 0; j < columnLength; j++) {
            System.out.print("+".concat("-".repeat(maxLengthArray[j])));
        }
        System.out.print("+");

    }


    public static int findTheLongest(String[] data) {
        int maxIndex=0;
        int maxLength=data[0].length();

        char[]charArray=data[0].toCharArray();
        for (int i = 1; i < data.length; i++) {
            if (maxLength < data[i].length()) {
                maxIndex = i;
                maxLength = data[i].length();
            }

        }

        return maxLength;

    }
}
