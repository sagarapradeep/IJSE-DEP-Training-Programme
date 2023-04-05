package lk.ijse.dep10.io;

import java.io.File;

public class Delete {
    public static void main(String[] args) {
        File fileWanttoDelete = new File("/home/sagara/Desktop/test_Source/Untitled Document 1");
        fileWanttoDelete.delete();
    }
}
