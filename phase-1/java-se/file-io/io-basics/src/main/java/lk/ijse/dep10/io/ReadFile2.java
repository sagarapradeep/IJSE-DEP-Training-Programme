package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/sagara/Desktop/movie.mp4");
        if (!file.exists()) {
            System.out.println("No such file");
            return;
        }
        FileInputStream fis = new FileInputStream(file);

        while (true) {
            byte[] buffer = new byte[1024*1024*10];
            int read = fis.read(buffer);
            System.out.println(Arrays.toString(buffer));

            if(read==-1)break;
            System.out.println(read);

        }



        fis.close();



    }
}
