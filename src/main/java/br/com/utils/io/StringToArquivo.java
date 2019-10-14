package br.com.utils.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import br.com.utils.ui.io.SelecionaArquivoUI;

/**
 * Classe Static que recebe a url do arquivo e devolve em string o conteudo do
 * arquivo fazer o import e usar o Metodo direto da classe, sem instanciar
 * objeto:
 * ArquivoToString.getString(urlArquivo)
 */
public class StringToArquivo {
    static String string = "";
    static String stringTudo = "";
    static String encoding = "ISO-8859-1";// Exemplo de outra opcao "UTF-8";

    public static void setEncoding(final String encoding) {
        StringToArquivo.encoding = encoding;
    }

    public static void createFileWithStringUI(final String texto) {
        try {
            SelecionaArquivoUI selecionaArquivoUI =
                            new SelecionaArquivoUI().mudaTitulo(
                                            "Selecione Arquivo de Saida")
                                            .mudaParaDiretorioRoot();
            File file = selecionaArquivoUI.abreArquivo();
            System.out.println(file.getAbsolutePath());
            PrintWriter pw =
                            new PrintWriter(new OutputStreamWriter(
                                            new FileOutputStream(file),
                                            StringToArquivo.encoding));
            pw.write(texto);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createFileWithStringUI(final String texto, final String pathFile) throws IOException {
        try {
            PrintWriter pw =
                            new PrintWriter(new OutputStreamWriter(
                                            new FileOutputStream(pathFile),
                                            StringToArquivo.encoding));
            pw.write(texto);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(final String[] args)
                    throws IllegalArgumentException, IllegalAccessException,
                    SecurityException, NoSuchFieldException {

        System.setProperty("file.encoding", "UTF-8");
        Field charset = Charset.class.getDeclaredField("defaultCharset");
        charset.setAccessible(true);
        charset.set(null, null);

        String texto =
                        "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
                                        + "n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
                                        + "mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
                                        + "on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
                                        + "expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000\u001dcom.sun.msv.grammar."
                                        + "ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.grammar.Attribut"
                                        + "eExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/gramma"
                                        + "r/NameClass;xq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp"
                                        + "\u0000psr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/rel"
                                        + "axng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/"
                                        + "util/StringPair;xq\u0000~\u0000\u0003ppsr\u0000#com.sun.msv.datatype.xsd.StringT"
                                        + "ype\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.B"
                                        + "uiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.Conc"
                                        + "reteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeIm"
                                        + "pl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeName"
                                        + "q\u0000~\u0000\u0017L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpacePro"
                                        + "cessor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006stringsr\u00005com"
                                        + ".sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
                                        + "\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000"
                                        + "xp\u0001sr\u00000com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000"
                                        + "\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tl"
                                        + "ocalNameq\u0000~\u0000\u0017L\u0000\fnamespaceURIq\u0000~\u0000\u0017xpq\u0000~\u0000\u001bq\u0000~\u0000\u001asr\u0000#com.sun.msv"
                                        + ".grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0017L\u0000\fnames"
                                        + "paceURIq\u0000~\u0000\u0017xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000"
                                        + "\u0007destinot\u0000\u0000sr\u00000com.sun.msv.grammar.Expression$EpsilonExpress"
                                        + "ion\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000\r\u0001psq\u0000~\u0000\bppsq\u0000~\u0000\nq\u0000~\u0000\u000epq\u0000~\u0000\u0012sq\u0000~\u0000#t"
                                        + "\u0000\u0004hashq\u0000~\u0000\'q\u0000~\u0000)sq\u0000~\u0000\bppsq\u0000~\u0000\nq\u0000~\u0000\u000epq\u0000~\u0000\u0012sq\u0000~\u0000#t\u0000\u0004nomeq\u0000~\u0000\'q"
                                        + "\u0000~\u0000)sq\u0000~\u0000\bppsq\u0000~\u0000\nq\u0000~\u0000\u000epq\u0000~\u0000\u0012sq\u0000~\u0000#t\u0000\u0007tamanhoq\u0000~\u0000\'q\u0000~\u0000)sr\u0000\"c"
                                        + "om.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lc"
                                        + "om/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.m"
                                        + "sv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rst"
                                        + "reamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPool;x"
                                        + "p\u0000\u0000\u0000\u0007\u0001pq\u0000~\u00003q\u0000~\u0000/q\u0000~\u0000\u0007q\u0000~\u0000\tq\u0000~\u0000\u0006q\u0000~\u0000\u0005q\u0000~\u0000+x";
        StringToArquivo.setEncoding("UTF-8");
        StringToArquivo.createFileWithStringUI(texto);
    }

}
