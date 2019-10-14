package br.com.utils.main;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import javax.swing.JOptionPane;

import br.com.utils.service.PesquisaTextoEmArquivo;
import br.com.utils.ui.io.SelecionaArquivoUI;

public class MainPesquisaTextoEmArquivo {

	public static void main(final String[] args) {
		File file = new SelecionaArquivoUI().abreArquivo("txt");
		String stringDeBusca = JOptionPane.showInputDialog("Digite a string de pesquisa");
		System.out.println("String de Busca: " + stringDeBusca);
		String texto = new PesquisaTextoEmArquivo(file, stringDeBusca).buscaLinhasQueTenhaTexto();
		System.out.println(texto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(texto), null);
		System.out.println("\nTexto Armazenado na Area de Transferencia.");
	}
}
