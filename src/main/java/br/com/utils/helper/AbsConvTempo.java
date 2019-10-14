package br.com.utils.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbsConvTempo {

    private SimpleDateFormat dataFormat;

    public AbsConvTempo() {
        this.dataFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public AbsConvTempo(final String formatoData) {
        // Ex: formatoData = "dd/MM/yyyy HH:mm:ss";
        this.dataFormat = new SimpleDateFormat(formatoData);
    }

    public String converteMillisegundos(final long tempo) {
        String resultado = "";
        Date data = new Date(tempo);
        resultado = this.dataFormat.format(data);
        return resultado;
    }

    public long converteDataHora(final String dataHora) throws ParseException {
        long resultado = 0;
        Date data = this.dataFormat.parse(dataHora);
        resultado = data.getTime();
        return resultado;
    }
}
