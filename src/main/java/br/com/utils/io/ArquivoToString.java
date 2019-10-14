package br.com.utils.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Scanner;

import br.com.utils.ui.io.SelecionaArquivoUI;

/**
 * Classe Static que recebe a url do arquivo e devolve em string o conteudo do
 * arquivo fazer o import e usar o Metodo direto da classe, sem instanciar
 * objeto:
 * ArquivoToString.getString(urlArquivo)
 */
public class ArquivoToString {
    static String string = "";
    static String stringTudo = "";

    public static String getString(final File arquivo) {
        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(
                            new FileInputStream(arquivo)));

            ArquivoToString.string = file.readLine();
            // System.out.println(string);
            ArquivoToString.stringTudo = "";
            while (ArquivoToString.string != null) {
                ArquivoToString.stringTudo += ArquivoToString.string;
                ArquivoToString.string = file.readLine();
            }
            file.close();
            return ArquivoToString.stringTudo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getString(final String urlArquivo) throws IOException {

        BufferedReader file = new BufferedReader(new InputStreamReader(
                        new FileInputStream(urlArquivo)));

        ArquivoToString.string = file.readLine();
        // System.out.println(string);
        ArquivoToString.stringTudo = "";
        while (ArquivoToString.string != null) {
            ArquivoToString.stringTudo += ArquivoToString.string;
            ArquivoToString.string = file.readLine();
        }
        file.close();
        return ArquivoToString.stringTudo;
    }

    public static void main(final String[] args) throws FileNotFoundException {
        System.out.println(ArquivoToString.getStringSemAcento(new SelecionaArquivoUI().abreArquivo()));
        
    }
    
    public static String getStringSemAcento(File file) throws FileNotFoundException{
    	Scanner leitor = new Scanner(file);
    	String conteudoSemAcento = "";
    	while(leitor.hasNext()){
    		String linha = leitor.nextLine() + "\n";
    		conteudoSemAcento += Normalizer.normalize(linha, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    	}
    	leitor.close();
    	return conteudoSemAcento; 
    }
    
    

}
