package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReaderDemo1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Something.dep10");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();

        fis.close();

        String someText = new String(bytes);
        System.out.println(someText);


    }
}
