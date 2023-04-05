package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/sagara/Desktop/cv.psd");     //specify path
        if(!file.exists())
        {
            System.out.println("Invalid File Path!");
            return;
        }

        FileInputStream fis = new FileInputStream(file);        //connect socket to file

        byte[] bytes = fis.readAllBytes();

        fis.close();

        System.out.println(new String(bytes));


    }
}
