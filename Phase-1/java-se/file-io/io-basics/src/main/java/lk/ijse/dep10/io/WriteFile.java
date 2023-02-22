package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {

        File file = new File("/home/sagara/Desktop/doc1.ijse");

        if(file.exists()){
            System.out.println("File already exists");
            return;
        }
        FileOutputStream fos = new FileOutputStream(file);

        String something = "Hello this is a new file";
        byte[] bytes = something.getBytes();

        fos.write(bytes);


        fos.close();
    }
}
