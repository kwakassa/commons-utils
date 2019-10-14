package br.com.utils.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContaNumLinhasArquivo {
    private File file;

    public ContaNumLinhasArquivo(final File file) {
        if (file == null) {
            throw new NullPointerException("Ponteiro nulo em : " + this
                            .getClass().getName());
        } else {
            this.file = file;
        }
    }

    public Long numLinhas() {
        long num = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            while (br.readLine() != null) {
                num++;
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
        return num;
    }
}
