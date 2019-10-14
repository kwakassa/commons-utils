package br.com.utils.helper;

import java.util.Calendar;

public class CurrentDateTime {
    public String getCurrentDateTime() {
        return new AbsConvTempo().converteMillisegundos(Calendar.getInstance()
                        .getTimeInMillis());
    }

    public String getCurrentDateTime(final String formato) {
        return new AbsConvTempo(formato).converteMillisegundos(Calendar
                        .getInstance().getTimeInMillis());
    }
}
