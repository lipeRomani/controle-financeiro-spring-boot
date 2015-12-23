package br.com.romani.formatters;

import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;


public class BrasilRealFormatter implements Formatter<BigDecimal> {

    @Override
    public BigDecimal parse(String s, Locale locale) throws ParseException {

        String resultado = s.replace(".","").replace(",",".");
        return new BigDecimal(resultado);
    }

    @Override
    public String print(BigDecimal bigDecimal, Locale locale) {

        DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.00");
        return decimalFormat.format(bigDecimal);
        //return bigDecimal.toString().replace(".",",");
    }
}
