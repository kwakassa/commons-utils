package br.com.utils.ui.io;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;

public class SelecionaArquivoUI {
	
    private static JFileChooser fc;
    private File selFile;
    private static String currentDir = "/";
    private static Logger logger = Logger.getLogger(SelecionaArquivoUI.class);

    public SelecionaArquivoUI(final String title) {
    	fc = new JFileChooser(currentDir);
        this.fc.setDialogTitle(title);
    }

    public SelecionaArquivoUI() {
    	fc = new JFileChooser(currentDir);
    }
    private void setCurrentDir(){
    	try {
			currentDir = selFile.getParentFile().getAbsolutePath();
			fc.setCurrentDirectory(new File(currentDir));
		} catch (NullPointerException e) {
			logger.warn("Selecao de arquivo cancelada.");
		}
    }
    private File executaJFileChooser() {
        this.fc.showOpenDialog(this.fc);
        this.selFile = this.fc.getSelectedFile();
        setCurrentDir();
        return this.selFile;
    }

    public File abreArquivo() {
    	this.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.executaJFileChooser();
        return this.selFile;
    }

    public File abreArquivo(final String... extensao) {
    	this.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String extensoes = "";
        int cont = 0;
        for (String ex : extensao) {
            extensoes += ex;
            cont++;
            if (cont < extensao.length) {
                extensoes += ",";
            }
        }
        FileNameExtensionFilter filter =
                        new FileNameExtensionFilter("Arquivos " + extensoes,
                                        extensao);
        this.fc.setFileFilter(filter);
        this.executaJFileChooser();
        this.fc = new JFileChooser();
        return this.selFile;
    }

    public File abrePasta() {
        this.fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.executaJFileChooser();
        return this.selFile;
    }

    public SelecionaArquivoUI mudaParaDiretorioRoot() {
        this.fc = new JFileChooser("/");
        return this;
    }

    public SelecionaArquivoUI mudaParaDiretorioHome() {
        this.fc.changeToParentDirectory();
        return this;
    }

    public SelecionaArquivoUI mudaTitulo(final String titulo) {
        this.fc.setDialogTitle(titulo);
        return this;
    }

    public static void main(final String[] args) {
        SelecionaArquivoUI selecionaArquivoUI = new SelecionaArquivoUI();
        File file;
        try {
        	file = selecionaArquivoUI.abreArquivo();
            System.out.println("CanonicalPath: " + file.getCanonicalPath());
            System.out.println("AbsolutePath: " + file.getAbsolutePath());
            System.out.println("Path: " + file.getPath());
            System.out.println("ParentFile: " + file.getParentFile().getAbsolutePath());
        } catch (IOException e) {
            System.out.println("IOException");
        }catch (NullPointerException e) {
        	System.out.println("Objeto file null");
		}
    }
}
