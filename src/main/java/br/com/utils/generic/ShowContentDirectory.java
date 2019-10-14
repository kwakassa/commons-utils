package br.com.utils.generic;

import java.io.File;
import java.io.FileFilter;

public class ShowContentDirectory {
    private static String path1 =
                    "C:/c096489/SITMO/Versoes/02_00_11_48/20150515/CAB";
    private static String path2 = "/c096489/SITMO/CER/Nova pasta";
    private static String path = ShowContentDirectory.path2;

    public static class ImageFileFilter implements FileFilter {
        private final String[] okFileExtensions = new String[] {"jpg", "png",
                        "gif", "cer"};

        @Override
        public boolean accept(final File file) {
            for (String extension : this.okFileExtensions) {
                if (file.getName().toLowerCase().endsWith(extension)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void executaComFiltro() {
        File file = new File(ShowContentDirectory.path);
        File[] listFiles = file.listFiles(new ImageFileFilter());
        for (File arqOrDir : listFiles) {
            System.out.println(arqOrDir.getName());
        }
    }

    public static void executaSemFiltro() {
        File file = new File(ShowContentDirectory.path);
        File[] listFiles = file.listFiles();
        for (File arqOrDir : listFiles) {
            System.out.println(arqOrDir.getName());
        }
    }

    public static void executaSemFiltroFor() {
        File file = new File(ShowContentDirectory.path);
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            System.out.println(listFiles[i].getName());
        }
    }

    public static void main(final String[] args) {
        ShowContentDirectory.executaComFiltro();
    }

}
