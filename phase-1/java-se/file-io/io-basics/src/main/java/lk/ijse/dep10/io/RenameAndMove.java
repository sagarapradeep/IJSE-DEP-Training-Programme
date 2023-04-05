package lk.ijse.dep10.io;

import java.io.File;

public class RenameAndMove {
    public static void main(String[] args) {
        /*rename*/
//        File oldFile = new File("/home/sagara/Desktop/doc1.ijse");
//        File newFile = new File(oldFile.getParentFile(), "abc.txt");
//        oldFile.renameTo(newFile);

        /*Move*/
        File src = new File("/home/sagara/Documents/paint-app.zip");

        File desktopFolder = src.getParentFile();
        File test = new File(desktopFolder, "test/gayashan/old");
        test.mkdirs();

        File target = new File("/home/sagara/Documents/test/gayashan/old", src.getName());
        src.renameTo(target);



    }
}
