package algorithm;


import java.util.Arrays;

public class MyTableView
{
    public static void main(String[] args) {
        String[][]data={
                {"1","Kasun","23542"},
                {"1","Kasun","34535"},
                {"1","Kasun","345345"},
                {"2","Nuwan","345345"},
                {"3","Amara","457523412-2345"},
                {"4","Supun","345353566"},
                {"4","Supun","56745885"},
        };
        String[] topics = new String[]{"Names", "Number","Contact"};

        printTableCommand(topics, data);

    }

    public static void printTableCommand(String[] topics, String[][] data)
    {
        int maxColumnLengths[] = maxColumnLength(topics, data);


        printTable(topics, data, maxColumnLengths);

    }

    public static void printTable(String[] topics, String[][] data,int[] maxColumnLengths) {
        int numOfcolumns = topics.length;
        int numOfraws=data.length;
        int l=0;

        for (int i=0;i<numOfraws+3;i++) {
            if (i == 0 || i == 2 || i == numOfraws + 2) {
                for (int j = 0; j < numOfcolumns; j++) {
                    System.out.printf("%s%s", "+", ("-").repeat(maxColumnLengths[j]));
                }
                System.out.print("+");
                System.out.println();
            } else {
                if (i == 1) {
                    for (int j = 0; j < numOfcolumns; j++) {
                        System.out.printf("|%-".concat(Integer.toString(maxColumnLengths[j]) + "s"), topics[j]);
                    }
                    System.out.print("|");
                    System.out.println();
                } else {
                    for (int j = 0; j < numOfcolumns; j++) {
                        System.out.printf("|%-".concat(Integer.toString(maxColumnLengths[j])+"s"),data[l][j]);
                    }
                    System.out.print("|");
                    System.out.println();
                    ++l;

                }



            }

        }


    }

    public static int[] maxColumnLength(String[] topics, String[][] data) {
        int[] maxColumnLength = new int[topics.length];
        for (int i = 0; i < topics.length; i++) {
            maxColumnLength[i] = (topics[i].length()+1);
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < topics.length; j++) {
                if (maxColumnLength[j] < (data[i][j].length() + 1)) {
                    maxColumnLength[j] = (data[i][j].length() + 1);
                }
            }

        }
        return maxColumnLength;

    }

}
