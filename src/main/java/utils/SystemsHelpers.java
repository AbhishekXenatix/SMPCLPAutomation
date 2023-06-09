package utils;


import java.io.File;

public class SystemsHelpers {

    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

}
