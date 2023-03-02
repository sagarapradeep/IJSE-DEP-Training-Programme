package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileOutputStream;

public class WriterDemo1 {
    public static void main(String[] args) {
        String someText = "I want to write this in to a file";
        byte[] bytes = someText.getBytes();

        File file = new File("Something.dep10");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
