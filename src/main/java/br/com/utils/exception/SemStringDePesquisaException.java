package br.com.utils.exception;

public class SemStringDePesquisaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SemStringDePesquisaException() {
        super("Trecho de pesquisa String nao informado!");
    }
}
