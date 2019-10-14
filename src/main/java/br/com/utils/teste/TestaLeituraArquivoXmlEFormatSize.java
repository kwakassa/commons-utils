package br.com.utils.teste;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.bcel.util.ClassLoader;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class TestaLeituraArquivoXmlEFormatSize {
	private static Logger logger = Logger.getLogger(TestaLeituraArquivoXmlEFormatSize.class);
	/** Overload for int type */
	public static String humanReadableByteCount(int bytes, boolean si) {
		return humanReadableByteCount((long)bytes,true);
	}
	/** From: http://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java*/
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	/** From: http://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java*/
	public static String formatSize(long v) {
	    if (v < 1024) return v + " B";
	    int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
	    return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
	}
	
	public static void testeLeituraDeArquivoXmlToString(){
		try {
			String pathXmlResource = "Consulta_Contratos_Renovacao_Canal.xml";
			File file = new File(ClassLoader.getSystemResource(pathXmlResource).toURI());
			logger.info("File " + pathXmlResource + " Exists: " + file.exists());
			String xmlContentWithoutBreaks = FileUtils.readFileToString(file).replaceAll(System.getProperty("line.separator"), "");
			//logger.info("Content XML: " + FileUtils.readFileToString(file).replaceAll("\\r|\\n", ""));
			logger.info("Content XML: " + FileUtils.readFileToString(file).replaceAll(System.getProperty("line.separator"), ""));
			logger.info("XML SIZE(FileUtils): " + FileUtils.byteCountToDisplaySize(xmlContentWithoutBreaks.getBytes().length));
			logger.info("XML SIZE(Customized): " + humanReadableByteCount(xmlContentWithoutBreaks.getBytes().length,true));
			logger.info("XML SIZE(formatSize): " + formatSize(xmlContentWithoutBreaks.getBytes().length));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			logger.error("URISyntaxException",e);
		} catch (IOException e) {
			logger.error("IOException",e);
		}
	}
	public static void main(String[] args) {
		testeLeituraDeArquivoXmlToString();
	}
}
