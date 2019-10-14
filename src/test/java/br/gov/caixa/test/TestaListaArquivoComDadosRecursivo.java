package br.gov.caixa.test;

import java.io.File;
import java.util.List;

import br.com.utils.service.DirectoryHelper;
/** Pesquisa a existencia de um determinado nome de arquivo, em subpastas, e se seu tamanho ew maior que zero*/
public class TestaListaArquivoComDadosRecursivo {

	public static void main(String[] args) {
		String nomeArquivo = "VALIDA_CARTAO.LOG";
		String diretorioInicial = "\\\\sp7266et077\\E\\APPL.BAR.TRACEWAS";
		File diretorioPesquisa = new File(diretorioInicial);
		DirectoryHelper helper = new DirectoryHelper();
		System.out.println("--- Arquivo Procurado: " + nomeArquivo);
		System.out.println("--- Diretorio de Pesquisa Inicial: " + diretorioInicial);
		List<File> folders = helper.getFolders(diretorioPesquisa);
		for (File folder : folders) {
			System.out.println("--- Folder: " + folder.getAbsolutePath());
			List<File> files = helper.getFiles(folder);
			for (File file : files) {
				//System.out.println(file.getName());
				// System.out.println(file.length());
				if (file.getName().equals(nomeArquivo)) {
					System.out.println(file.getAbsolutePath() + " - size: " + file.length());
					if (file.length() > 0) {
						System.out.println("--- Found ---");
						System.out.println(file.getAbsolutePath() + " - size: " + file.length());
					}
				}
			}
		}
	}

}
