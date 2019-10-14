package br.com.utils.teste;

import java.io.File;

import br.com.utils.service.ContaNumLinhasArquivo;
import br.com.utils.ui.io.SelecionaArquivoUI;

public class TestaNumLinhasArquivo {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        File file = new SelecionaArquivoUI().abreArquivo();
        System.out.println("Num linhas Arquivo: " + new ContaNumLinhasArquivo(
                        file).numLinhas());
    }

}
