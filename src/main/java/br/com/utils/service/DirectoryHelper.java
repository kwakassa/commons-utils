package br.com.utils.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.com.utils.classes.FileNameFilterImpl;

public class DirectoryHelper {

    private String extension;

    public List<File> getAllFilesAndFolders(final File file) {
        return Arrays.asList(file.listFiles());
    }

    public List<File> getFiles(final File file) {
        List<File> files = new ArrayList<File>();
        for (File arquivo : file.listFiles()) {
            if (arquivo.isFile()) {
                files.add(arquivo);
            }
        }
        return files;
    }

    public List<File> getFolders(final File file) {
        List<File> files = new ArrayList<File>();
        for (File arquivo : file.listFiles()) {
            if (arquivo.isDirectory()) {
                files.add(arquivo);
            }
        }
        return files;
    }

    public List<File> getFoldersRecursive(File file) {

        if (file == null) {
            return null;
        }

        List<File> files = new ArrayList<File>();

        Queue<File> listaPastasASeremVerificadas = new LinkedList<File>();

        files.add(file);
        listaPastasASeremVerificadas.add(file);

        while (listaPastasASeremVerificadas.size() > 0) {
            file = listaPastasASeremVerificadas.poll();
            for (File arquivo : file.listFiles()) {
                if (arquivo.isDirectory()) {
                    files.add(arquivo);
                    listaPastasASeremVerificadas.add(arquivo);
                }
            }
        }
        return files;
    }

    public List<File> getFilesByExtension(final File folder, final String extension) {
        this.extension = extension;
        List<File> files = new LinkedList<File>();
        if (!folder.isDirectory()) {
            return files;
        } else {
            FilenameFilter filter = new FileNameFilterImpl(this.extension);
            for (File file : folder.listFiles(filter)) {
                files.add(file);
            }
            return files;
        }
    }

    public List<File> getFilesByExtensionRecursive(final File folderIni,
                    final String extension) {
        List<File> files = new LinkedList<File>();
        if (!folderIni.isDirectory()) {
            return files;
        } else {
            List<File> folders = getFoldersRecursive(folderIni);
            for (File folder : folders) {
                List<File> arquivos =
                                getFilesByExtension(folder,
                                                extension);
                if (arquivos.size() > 0) {
                    files.addAll(arquivos);
                }
            }
            return files;
        }
    }

    public void printListFilesOrFolder(
                    final List<File> listaFilesAndFolders) {
        for (File file : listaFilesAndFolders) {
            System.out.println(file.getAbsolutePath());
        }
    }

    /** --- Metodos de Teste --- */
    public void testaFolderRecursive() {
        printListFilesOrFolder(getFoldersRecursive(new File("/tmp/")));
    }

    /** --- Metodo Main para Teste --- */
    public static void main(final String[] args) {
        new DirectoryHelper().testaFolderRecursive();
    }

}
