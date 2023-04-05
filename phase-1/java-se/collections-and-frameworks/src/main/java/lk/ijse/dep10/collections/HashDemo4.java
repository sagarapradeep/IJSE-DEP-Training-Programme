package lk.ijse.dep10.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HashDemo4 {
    public static void main(String[] args) {
        String something = "Find any duplicate characters exists in this text";

        char[] chars = something.toCharArray();

        ArrayList<String> letterList = new ArrayList<>();
        for (char s : chars) {

            if(!Character.isSpaceChar(s)){ letterList.add(Character.toString(s));}

        }

        HashSet<String> hLetterList = new HashSet<>(letterList);


        System.out.println((hLetterList.size() < letterList.size()) ? "Has Duplicates" : "No duplicates");
    }
}
