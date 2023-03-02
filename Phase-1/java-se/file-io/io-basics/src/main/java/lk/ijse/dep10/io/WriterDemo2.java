package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriterDemo2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Something2.dep10");
        String someText = "I want to write this string";

        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < someText.length(); i++) {
            char c = someText.charAt(i);
            byte byteChar = (byte) c;
            fos.write(byteChar);

        }
        fos.close();
    }
}
