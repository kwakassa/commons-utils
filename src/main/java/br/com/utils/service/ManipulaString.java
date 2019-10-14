package br.com.utils.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.utils.helper.CurrentDateTime;
/**
 * 
 * Descricao Generica.
 * @author c096489
 * @version 1.0
 */
public class ManipulaString {

    Logger logger = Logger.getLogger(ManipulaString.class);

    public int numLetrasStringAg(final String texto) {// Verifica o se Contem
                                                      // "AG ", "AG." E "AG. "
                                                      // retorna a quantidade 3
                                                      // ou 4 dependendo do caso
        if (texto.contains("AG. ")) {
            return 4;
        } else if (texto.contains("AG.") || texto.contains("AG ")) {
            return 3;
        } else {
            return 0;
        }
    }

    public String preencheComEspacos(String texto,
                    final int tamanhoTotalComEspacos,
                    final boolean sentidoParaDireita) {
        int diferenca = 0;
        if (texto == null) {
            texto = "";
        }
        if (texto.length() < tamanhoTotalComEspacos) {
            diferenca = tamanhoTotalComEspacos - texto.length();
            if (sentidoParaDireita == true) {
                for (int i = 0; i < diferenca; i++) {
                    texto = texto + " ";
                }
            } else {
                for (int i = 0; i < diferenca; i++) {
                    texto = " " + texto;
                }
            }
        }
        return texto;
    }

    public String retiraStringAg(final String texto) {
        String trecho = "";
        String textoModificado = "";
        String textoComparacao1 = "AG ";
        String textoComparacao2 = "AG.";
        String textoComparacao3 = "AG. ";
        int indicePrimeiraLetra = 0;
        int i = 0;
        int j = 0;
        int qtdCharsParaArrancar = this.numLetrasStringAg(texto);
        if ((texto != null) && !texto.equals("")) {
            for (i = 0; i < texto.length(); i++) {
                if (!("" + texto.charAt(i)).equals(" ")) {
                    indicePrimeiraLetra = i;// Para verificar o indice da
                                            // primeira letra do texto que nao
                                            // seja " "(espaco);
                    break;
                }
            }
            for (j = indicePrimeiraLetra; j < qtdCharsParaArrancar; j++) {
                trecho += "" + texto.charAt(j);
            }
            if (textoComparacao1.contains(trecho) || textoComparacao2
                            .contains(trecho) || textoComparacao3
                            .contains(trecho)) {
                textoModificado =
                                texto.substring(indicePrimeiraLetra + qtdCharsParaArrancar,
                                                texto.length());
            } else {
                textoModificado = texto;
            }
        }
        // System.out.println(textoComparacao1);
        // System.out.println(textoComparacao2);
        return textoModificado;
    }

    public String retiraEspacosEsqDir(final String texto) {
        String texto1 = "";
        if ((texto != null) && !texto.equals("")) {
            texto1 = texto;
            int i = 0;
            int contVazio = 0;

            if ((texto1.length() > 0) && ("" + texto1.charAt(0)).equals(" ")) {
                i = 0;
                contVazio = 0;
                do {
                    if (("" + texto1.charAt(i)).equals(" ")) {
                        contVazio++;
                    }
                    i++;
                } while ((i < texto1.length()) && ("" + texto1.charAt(i))
                                .equals(" "));
                if (contVazio >= 1) {
                    texto1 = texto1.substring(contVazio, texto.length());
                }
            }

            if ((texto1.length() > 0) && ("" + texto1
                            .charAt(texto1.length() - 1)).equals(" ")) {
                i = texto1.length() - 1;
                contVazio = 0;
                do {
                    if (("" + texto1.charAt(i)).equals(" ")) {
                        contVazio++;
                    }
                    i--;
                } while ((i >= 0) && ("" + texto1.charAt(i)).equals(" "));
                if (contVazio >= 1) {
                    texto1 = texto1.substring(0, (texto1.length()) - contVazio);
                }
            }
        }
        return texto1;
    }

    // Compara quão igual o texto 1 é em relacao ao texto 2
    public double porcentagemIgual(final String texto1, final String texto2) {
        int numCharsIgual = 0;
        double porcentagem = 0;
        String texto1Modificado = "";
        String texto2Modificado = "";
        String trecho = "";
        String trechoEncontradoAtual = "";
        List<String> trechosEncontrados = new LinkedList<String>();

        texto1Modificado = this.retiraEspacosEsqDir(texto1);
        texto2Modificado = this.retiraEspacosEsqDir(texto2);

        texto1Modificado = texto1Modificado.toUpperCase();
        texto2Modificado = texto2Modificado.toUpperCase();

        String texto3Modificado = "";
        // Verificacao para colocar o texto de Maior tamanho como
        // texto2Modificado
        if (texto1Modificado.length() > texto2Modificado.length()) {
            texto3Modificado = texto2Modificado;
            texto2Modificado = texto1Modificado;
            texto1Modificado = texto3Modificado;
        }

        for (int i = 0; i < texto1Modificado.length(); i++) {
            trecho += ("" + texto1Modificado.charAt(i));
            if (texto2Modificado.contains(trecho)) {
                trechoEncontradoAtual = trecho;
            } else {
                if (!trechoEncontradoAtual.equals("")) {
                    trechosEncontrados.add(trechoEncontradoAtual);
                }
                trecho = "";
                trechoEncontradoAtual = "";
                // Para verificar se o character que quebrou o contains, tambem
                // consta individualmente na outra String
                trecho += ("" + texto1Modificado.charAt(i));
                if (texto2Modificado.contains(trecho)) {
                    trechoEncontradoAtual = trecho;
                }
            }
        }
        if (!trechoEncontradoAtual.equals("")) {
            trechosEncontrados.add(trechoEncontradoAtual);
        }
        for (int j = 0; j < trechosEncontrados.size(); j++) {
            // System.out.println(trechosEncontrados.get(j).length());
            numCharsIgual += trechosEncontrados.get(j).length();
        }
        porcentagem = (double) numCharsIgual / texto2Modificado.length();
        return porcentagem;
    }

    public String colocaDataEmNomeDeArquivo(final String urlArquivo) {
        String texto = urlArquivo;
        String textoSemExtensao = "";// Se tiver extensao ira receber a string
                                     // sem a mesma. Exemplo: "arquivo.txt" ->
                                     // "arquivo"
        String extensaoArquivo = "";
        if (texto.length() > 4) {
            extensaoArquivo =
                            texto.substring(texto.length() - 4, texto.length());
            if (extensaoArquivo.matches("\\....")) {
                textoSemExtensao = texto.substring(0, texto.length() - 4);
                texto =
                                textoSemExtensao + new CurrentDateTime()
                                                .getCurrentDateTime("yyyy-MM-dd") + extensaoArquivo;
            } else {// Se nao tiver extensao, so colocara a data no final
                texto =
                                texto + new CurrentDateTime()
                                                .getCurrentDateTime("yyyy-MM-dd") + extensaoArquivo;
            }
        }
        return texto;
    }

    public boolean verificaUrlArquivoSeXml(final String urlArquivo) {
        if (urlArquivo.length() > 4) {
            String extensao =
                            urlArquivo.substring(urlArquivo.length() - 4,
                                            urlArquivo.length());
            if (extensao.equals(".xml")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean verificaSeStringConverteEmNumero(final String numero) {
        try {
            Integer.getInteger(numero);
            return true;
        } catch (NumberFormatException e) {
            this.logger.debug("Parametro Redcebido para conversao: " + numero);
            this.logger.debug(e);
            return false;
        }
    }
}
