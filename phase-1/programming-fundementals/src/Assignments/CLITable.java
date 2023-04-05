package practice;

public class CLITable {
    public static void main(String[] args) {
        String[] columnNames = {"ID", "Name", "Age","City"};
        String[][] data = {
                {"S001", "Kasun", "25","Colombo"},
                {"S00200", "Nuwan Ramindu Sampath", "35","Gampaha"},
                {"S003", "Ruwan Dissanayaka Hettige", "45","Kalutara"},
                {"S004", "Supun", "40","Kandy"},
                {"S004", "Supun", "30","Matara"},
                {"S004", "Supun", "25","Kurunegala"},
                {"S005", "Nimal", "15","Jaffna"},
                {"S006", "Kamal", "26", "Minuwangoda"}
        };
        printTable(columnNames, data);
    }

    public static void printTable(String[] columnNames, String[][] data) {
        int[] maxWidths = widthCalculation(columnNames, data);
        printLine(maxWidths);
        printColumnNames(columnNames, maxWidths);
        printLine(maxWidths);
        printData(data, maxWidths);
        printLine(maxWidths);
    }

    private static int[] widthCalculation(String[] columnNames, String[][] data) {
        int[] maxWidths = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            int maxLength = columnNames[i].length()+1;
            for (int j = 0; j < data.length; j++) {
                if (maxLength < data[j][i].length()+1) {
                    maxLength = data[j][i].length()+1;
                }
            }
            maxWidths[i] = maxLength;
        }
        return maxWidths;
    }

    private static void printLine(int[] maxWidths) {
        System.out.print("+");
        for (int i = 0; i < maxWidths.length; i++) {
            for (int j = 0; j < maxWidths[i]; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.print("\n");
    }

    private static void printColumnNames(String[] columnNames, int[] maxWidths) {
        System.out.print("|");
        for (int i = 0; i < columnNames.length; i++) {
            String str = "%-" + maxWidths[i] + "s";
            str = String.format(str,columnNames[i]);
            System.out.printf(str);
            System.out.printf("|");
        }
        System.out.print("\n");
    }

    private static void printData(String[][] data, int[] maxWidths) {
        for (int i = 0; i < data.length; i++) {
            System.out.print("|");
            for (int j = 0; j < data[i].length; j++) {
                String str = "%-" + maxWidths[j] + "s";
                str = String.format(str, data[i][j]);
                System.out.printf(str);
                System.out.printf("|");
            }
            System.out.print("\n");
        }
    }
}
