package lk.ijse.dep10.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReaderDemo {
    public static void main(String[] args) throws Exception {
        readBuffer();

//        readStream();

    }

    public static void readBuffer() throws Exception {
        File file = new File("Something3.dep10");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
//        String something = "";
        StringBuilder something = new StringBuilder();

        while ((line = br.readLine()) != null) {
            something.append(line);
        }
        br.close();
        System.out.println("completed");
        System.out.println(something);

    }

    public static void readStream() throws Exception {
        File file = new File("Something3.dep10");
        FileReader fr = new FileReader(file);

        String line;
        String something=new String();

        while (true) {
            char[] chars = new char[20];
            int read=fr.read(chars);
            if(read==-1)break;

            something += new String(chars, 0, read);
        }

        System.out.println(something+"from stream");

    }
}
