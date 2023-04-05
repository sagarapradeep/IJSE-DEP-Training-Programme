package lk.ijse.dep10.ds.util;

import java.util.Arrays;

public class DynamicArray {
    private int[] numbers = new int[0];
    private int[] clearNumberArray = new int[0];
    private int i=0;

    public void add(String value) {
        int[] numbersUpdate = new int[numbers.length + 1];
        for (int j = 0; j < numbers.length; j++) {
            numbersUpdate[j] = numbers[j];
        }
        numbersUpdate[i++] = Integer.parseInt(value);
        numbers=numbersUpdate;
//        System.out.println(Arrays.toString(numbers));


    }

    public void clear() {
        numbers=clearNumberArray;
    }

    public boolean contains(String input) {
        for (int j = 0; j < numbers.length; j++) {
            if (Integer.parseInt(input) == numbers[j]) {
                return true;

            }
        }
        return false;
    }

    public String get(int index) {
        for (int j = 0; j < numbers.length; j++) {
            if (j == index) {
                return (numbers[j] + "");
            }
        }
        return "Not in the list";
    }

    public void remove(String input) {
        if(numbers.length==0)return;
        boolean condition =false;
        for (int j = 0; j < numbers.length; j++) {
            if (Integer.parseInt(input) == numbers[j]) {
                condition =true;
                break;
            }
        }
//        System.out.println(condition);
        if (condition) {
            int[] afterNumRemove = new int[numbers.length - 1];
            int k=0;
            boolean condition2=true;
            while (k < numbers.length-1) {
                if(Integer.parseInt(input)==numbers[k]&&condition2){
                    condition2=false;
                    continue;
                }
                if (condition2) {
                    afterNumRemove[k] = numbers[k];
                    ++k;

                }
                if (!condition2) {
                    afterNumRemove[k] = numbers[k+1];
                    ++k;
                }


            }

            numbers=afterNumRemove;
//            System.out.println(Arrays.toString(numbers));
        }

    }

    public int size() {
        return numbers.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
