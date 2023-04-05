package lk.ijse.dep10.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            viaBuffers(i);
            viaStream(i);
        }


    }

    private static void viaBuffers(int i) throws Exception {
        File file = new File("buffered-file.dep10");

        FileOutputStream fos = new FileOutputStream(file);
        long t1 = System.nanoTime();
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("I am Sagara Pradeep".getBytes());
        long t2=System.nanoTime();

        bos.close();

        System.out.printf("Via buffer: Attempt %s, time: %s", ++i, t2 - t1);
        System.out.println();

    }

    private static void viaStream(int i) throws Exception {
        File file = new File("buffered-file.dep10");
        long t1 = System.nanoTime();

        FileOutputStream fos = new FileOutputStream(file);


        fos.write("I am Sagara Pradeep".getBytes());
        long t2=System.nanoTime();

        System.out.printf("Via Stream: Attempt %s, time: %s", ++i, t2 - t1);
        System.out.println("\n");

        fos.close();

    }
}
