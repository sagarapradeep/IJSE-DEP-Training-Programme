package lk.ijse.dep10.io;

import java.io.File;
import java.util.Properties;

public class EnvDemo2 {
    public static void main(String[] args) {
//        String tmpDir = System.getProperty("os.arch");
//        System.out.println(tmpDir);

        Properties properties = System.getProperties();


        for (Object key : properties.keySet()) {
            System.out.printf("%s = %s\n", key, properties.get(key.toString()));
        }

        File file = new File(new File(System.getProperty("user.home")), "ABC");
        file.mkdir();
    }
}
