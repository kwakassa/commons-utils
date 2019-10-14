package br.com.utils.teste;

import java.io.File;

import br.com.utils.service.DirectoryHelper;

public class TestaRecursividadeDePastas {

    public void testaConteudoPastaSimples() {
        File fileIni = new File("/tmp");
        for (File file : fileIni.listFiles()) {
            System.out.println("[absolutePath: " + file.getAbsolutePath());
            System.out.print(" , getName: " + file.getName());
            System.out.println(" , IsDirectory: " + file.isDirectory());
            System.out.println(" , IsFile: " + file.isDirectory());
            System.out.println("]");
        }
    }

    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        DirectoryHelper helper = new DirectoryHelper();
        File fileIni = new File("/tmp");
        System.out.println("--------- Arquivos e Pastas  ---------");
        for (File file : helper.getAllFilesAndFolders(fileIni)) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------- Arquivos ---------");
        for (File file : helper.getFiles(fileIni)) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------- Pastas ---------");
        for (File file : helper.getFolders(fileIni)) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------- Pastas e Subpastas ---------");
        for (File file : helper.getFoldersRecursive(fileIni)) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------- Arquivos com Extensao Log---------");
        for (File file : helper.getFilesByExtension(fileIni, ".log")) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------- Arquivos com Extensao Log Recursivo---------");
        for (File file : helper.getFilesByExtensionRecursive(fileIni,
                        ".log")) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
