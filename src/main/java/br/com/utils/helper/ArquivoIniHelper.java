package br.com.utils.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;

public class ArquivoIniHelper {
	
	private static Logger logger = Logger.getLogger(ArquivoIniHelper.class);
	private static File file;
	private static Ini arquivoIni;
	public static final int SETUP_OK = -1;
	public static final int ARQUIVO_JA_EXISTE = 0;
	public static final int ARQUIVO_NAO_EXISTE_NAO_CRIADO = 1;
	public static final int ERRO_DE_INICIALIZACAO = 2;
	public static final int ARQUIVO_CRIADO_COM_SUCESSO = 3;
	public static final int ERRO_AO_CRIAR_ARQUIVO = 4;
	
	public static Ini getArquivoIni() {
		if(verificaSeAtributosNaoNulo()){
			return arquivoIni;
		}else{
			logger.error("Execute Metodo setupArquivoIni()");
			return null;
		}
	}
	public static int setArquivoIni(Ini arquivoIni) {
		int situacao = SETUP_OK;
		if(arquivoIni!=null){
			ArquivoIniHelper.arquivoIni = arquivoIni;
			situacao = SETUP_OK;
		}else{
			situacao = ARQUIVO_NAO_EXISTE_NAO_CRIADO;
		}
		return situacao;
	}
	
	public static void resetDefaultValuesOnSectionName(String sectionName, HashMap<String,String> listaParametrosHashMap){
		if(file != null && arquivoIni != null){
			arquivoIni.remove(sectionName);
			List<String> listKeys = new ArrayList<String>(listaParametrosHashMap.keySet());
			Collections.sort(listKeys);
			for(String key : listKeys){
				arquivoIni.put(sectionName, key, listaParametrosHashMap.get(key));
			}
			try {
				arquivoIni.store();
			} catch (IOException e) {
				logger.error("Erro ao realizar o store() do arquivo INI no \"resetDefaultValuesOnSectionName\"");
			}
		}else{
			logger.error("Inicialize o ArquivoIniHelper com \"setupArquivoIni\"");
		}
	}
	//new JFileChooser().getFileSystemView().getDefaultDirectory().getCanonicalPath()+"/selenium.ini"
	public static int setupArquivoIni(String pathArquivoIni){
		int situacao = SETUP_OK;
		try {
			file = new File(pathArquivoIni);
			if(file.exists()){
				arquivoIni = new Ini(file);
				situacao = SETUP_OK;
			}else{
				situacao = ARQUIVO_NAO_EXISTE_NAO_CRIADO;
			}
			return situacao;
		} catch (IOException e) {
			logger.error("Error de Inicialização do Arquivo " + pathArquivoIni,e);
			return ERRO_DE_INICIALIZACAO;
		}catch (Exception e) {
			logger.error("Erro nao previsto",e);
			return ERRO_DE_INICIALIZACAO;
		}
	}
	
	public static int criaArquivoSeNaoExistir(File file){
		try {
		    file.createNewFile();
		    return ARQUIVO_CRIADO_COM_SUCESSO;
		} catch (IOException e) {
			return ERRO_AO_CRIAR_ARQUIVO;
		}
	}
	
	public static String getProperty(Object sectionName, Object optionName){
		if(verificaSeAtributosNaoNulo()){
			return arquivoIni.get(sectionName, optionName);
		}else{
			logger.error("Execute Metodo setupArquivoIni()");
			return "";
		}		
	}
	
	public static void setProperty(String sectionName, String optionName, Object value){
		if(verificaSeAtributosNaoNulo()){
			try {
				arquivoIni.put(sectionName, optionName, value);
				arquivoIni.store();
			} catch (IOException e) {
				logger.error("Erro ao realizar \"setProperty\" no arquivo INI",e);
			}
		}else{
			logger.error("Execute Metodo setupArquivoIni()");
		}
	}
	
	public static void removeProperty(String sectionName, String optionName){
		try {
			arquivoIni.remove(sectionName, optionName);
			arquivoIni.store();
		} catch (IOException e) {
			logger.error("Erro ao realizar \"removeProperty\" no arquivo INI",e);
		}
	}
	
	public static File getFile(){
		if(verificaSeAtributosNaoNulo()){
			return file;
		}else{
			logger.error("Execute Metodo setupArquivoIni()");
			return null;
		}
	}
	
	private static boolean verificaSeAtributosNaoNulo(){
		if(file==null || arquivoIni==null){
			return false;
		}else{
			return true;
		}
	}
	
	public static List<String> getSetionNames(){
		List<String> sectionNames = new ArrayList<String>();
		if(verificaSeAtributosNaoNulo()){
			Set<Entry<String, Section>> entrySet = arquivoIni.entrySet(); /* !!! */
			for (Entry<String, Section> entry : entrySet) {
				sectionNames.add(entry.getKey());
			}
			return sectionNames;
		}else{
			logger.error("Execute Metodo setupArquivoIni()");
			return null;
		}
	}
	
	private static void teste1(){
		try {
			logger.info("Inicio");
			String pathToDefaultIni = "/c096489/default.ini";
			Ini ini = new Ini(new File(pathToDefaultIni));
			Set<Entry<String, Section>> entrySet = ini.entrySet(); /* !!! */
			for (Entry<String, Section> entry : entrySet) {
				logger.info("SECTION: " + entry.getKey());
				Set<String> keySet = entry.getValue().keySet();
				for (String string : keySet) {
					logger.info(string);
				}
			}
			logger.info("Fim");
		} catch (InvalidFileFormatException e) {
			logger.error("",e);
		} catch (IOException e) {
			logger.error("",e);
		}
	}
	
	public static void main(String[] args) {
		teste1();
	}
}
