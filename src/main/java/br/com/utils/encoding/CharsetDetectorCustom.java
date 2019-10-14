package br.com.utils.encoding;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import br.com.utils.ui.io.SelecionaArquivoUI;

public class CharsetDetectorCustom {

	private static Logger logger = Logger
			.getLogger(CharsetDetectorCustom.class);

	public Charset detectCharset(File f, List<String> charsets) {

		Charset charset = null;

		for (String charsetName : charsets) {
			charset = detectCharset(f, Charset.forName(charsetName));
			if (charset != null) {
				break;
			}
		}

		return charset;
	}

	private Charset detectCharset(File f, Charset charset) {
		try {
			BufferedInputStream input = new BufferedInputStream(
					new FileInputStream(f));

			CharsetDecoder decoder = charset.newDecoder();
			decoder.reset();

			byte[] buffer = new byte[512];
			boolean identified = false;
			while ((input.read(buffer) != -1) && (!identified)) {
				identified = identify(buffer, decoder);
			}

			input.close();

			if (identified) {
				return charset;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error("Exception", e);
			return null;
		}
	}

	private boolean identify(byte[] bytes, CharsetDecoder decoder) {
		try {
			decoder.decode(ByteBuffer.wrap(bytes));
		} catch (CharacterCodingException e) {
			return false;
		}
		return true;
	}

	public String getEncoding(File file) {
		String path = file.getAbsolutePath();
		InputStream is = IOUtils.toInputStream(path);
		InputStreamReader r = new InputStreamReader(is);
		return r.getEncoding();
	}

	public InputStream getInputStream(File file) {
		String path = file.getAbsolutePath();
		InputStream is = IOUtils.toInputStream(path);
		return is;
	}

	public static void main(String[] args) {
		try {
			SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();

			Set<String> keySet = availableCharsets.keySet();

			// File f = new
			// File("C:/c096489/SIMTX/XMLS/Consulta_Contratos_Renovacao_Canal_REQ3.xml");
			File f = new SelecionaArquivoUI().abreArquivo("txt", "xml");

			// String[] charsetsToBeTested = { "UTF-8", "windows-1253",
			// "ISO-8859-7" };
			List<String> listCharSet = new ArrayList<String>(keySet);
			listCharSet = Arrays.asList(new String[] { "windows-1253",
					"ISO-8859-7", "UTF-8" });
			CharsetDetector cd = new CharsetDetector();
			CharsetDetectorCustom cdc = new CharsetDetectorCustom();
			String encodingCustom = cdc.getEncoding(f);
			cd.setText(cdc.getInputStream(f));
			CharsetMatch detect = cd.detect();
			String encoding = detect.getName();
			logger.info("Encoding Custom: " + encodingCustom);
			logger.info("Encoding: " + encoding);
			Charset charset = cdc.detectCharset(f, listCharSet);
			logger.info("Charset: " + charset.displayName());
			if (charset != null) {

				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(f), charset);
				int c = 0;
				while ((c = reader.read()) != -1) {
					System.out.print((char) c);
				}
				reader.close();
			}
		} catch (FileNotFoundException fnfe) {
			logger.error("FileNotFoundException", fnfe);
		} catch (IOException ioe) {
			logger.error("IOException", ioe);
		}

	}
}