package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderDemo3 {
    public static void main(String[] args) throws Exception {
        File file = new File("Something3.dep10");

        FileReader fr = new FileReader(file);
        char[] buffer = new char[(int) file.length()];

        int read = fr.read(buffer);

        fr.close();
        String someText = new String(buffer, 0, read);

        System.out.println(someText);
    }
}
