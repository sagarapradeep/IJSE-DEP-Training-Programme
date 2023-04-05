package lk.ijse.dep10.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HashDemo3 {
    public static void main(String[] args) {
        String text = "Hello, are their any duplicates in this text, show what they are";

        List<String> textArray = Arrays.asList(text.split("\\b\\s+"));
//        List<String> textArray = Arrays.asList(text.split(" "));

        System.out.println(textArray);;

        HashSet<String> textHashList = new HashSet<>(textArray);

        System.out.println((textHashList.size() < textArray.size()) ? "Has Duplicates" : "No duplicates");
    }
}
