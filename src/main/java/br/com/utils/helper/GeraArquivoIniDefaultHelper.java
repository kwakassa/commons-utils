package br.com.utils.helper;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class GeraArquivoIniDefaultHelper {
	
	private static Logger logger = Logger.getLogger(GeraArquivoIniDefaultHelper.class);
	
	/** 
	 * Exemplo: 
	 *   pathToArqIni = "./";
	 *   ou
	 *   pathToArqIni = new JFileChooser().getFileSystemView().getDefaultDirectory().getCanonicalPath()+"/arquivo.ini";
	 *   pathToDefaultIni = "/default.ini";
	 *   
	 * */
	public void geraArquivoIniDefault(String pathToArqIni, String pathToDefaultIni){
		File fileIni = new File(pathToArqIni);
		try {
			FileUtils.copyInputStreamToFile(getClass().getResourceAsStream(pathToDefaultIni), fileIni);
			logger.debug("Arquivo Ini gerado com sucesso a partir de default.ini");
		} catch (IOException e) {
			logger.error("Nao foi Possivel criar arquivo ini apartir de default.ini");
			LoggerPrintExceptionHelper.printExceptionOnLogger(logger, e);
		}
	}
}
