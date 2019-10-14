package br.com.utils.service;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.com.utils.exception.SemStringDePesquisaException;

public class PesquisaTextoEmArquivo {

    private File file;
    private String stringDeBusca;

    private boolean verificaSeTrechoNulo() {
        if (this.stringDeBusca == null) {
            return true;
        } else {
            return false;
        }
    }

    public PesquisaTextoEmArquivo(final File file, final String trechoPesquisa) {
        this.file = file;
        this.stringDeBusca = trechoPesquisa;
    }

    public String buscaLinhasQueTenhaTexto() {
        if (this.verificaSeTrechoNulo()) {
            throw new SemStringDePesquisaException();
        }
        long numLinhasArquivo =
                        new ContaNumLinhasArquivo(this.file).numLinhas();
        String texto = "";
        try {
            String linha = "";
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            int numLinha = 1;
            int ctrlLinha = 0;
            int ctrlLinha2 = 10;
            System.out.println("Inicio");
            while ((linha = br.readLine()) != null) {
                if (linha.contains(this.stringDeBusca)) {
                    texto += "Linha " + numLinha + ": " + linha + "\n";
                }
                numLinha++;
                ctrlLinha++;
                if (ctrlLinha > (numLinhasArquivo / 50)) {
                    ctrlLinha = 0;
                    System.out.print(".");
                }
                if ((((double) numLinha / (double) numLinhasArquivo) * 100) >= ctrlLinha2) {
                    System.out.print(ctrlLinha2 + "%");
                    ctrlLinha2 += 10;
                }
            }
            br.close();
            System.out.println("\nFim\n");
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return texto;
    }
}
