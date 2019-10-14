package br.com.utils.teste;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestaImagemToBytes {
    public static void main(final String[] args) throws IOException {
        byte bytes[] = FileUtils.readFileToByteArray(new File("imagem.png"));
        System.out.println(bytes.length);
    }
}
