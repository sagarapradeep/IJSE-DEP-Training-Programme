package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("Something3.dep10");
        String someText = "I am sagara";

        FileWriter fw = new FileWriter(file);
        fw.write(someText);
        fw.close();

        System.out.println("Write process completed");

    }
}
