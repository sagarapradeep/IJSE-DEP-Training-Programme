package lk.ijse.dep10.io;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File downloadDir = new File("/home/sagara/Downloads");
        System.out.println(downloadDir.isFile());
        System.out.println(downloadDir.isDirectory());
        System.out.println("------------------------");

        String[] fileList = downloadDir.list();     //files as string
        for (String s : fileList) {
            System.out.println(s);
        }

        File[] filesList = downloadDir.listFiles();         //files as File type
        for (File file : filesList) {
            System.out.println(file);
        }
    }
}
