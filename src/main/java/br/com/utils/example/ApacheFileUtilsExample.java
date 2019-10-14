package br.com.utils.example;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class ApacheFileUtilsExample {

    public static void main(final String[] args) {
        File file = new File("C:/tmp");
        Collection<File> files = FileUtils.listFiles(file, null, true);
        for (File file2 : files) {
            System.out.println(file2.getName());
        }
    }

}
