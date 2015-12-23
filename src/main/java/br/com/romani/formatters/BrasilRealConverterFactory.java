package br.com.romani.formatters;


import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BrasilRealConverterFactory implements AnnotationFormatterFactory<CurrencyBrConverter> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> setTypes = new HashSet<Class<?>>();
        setTypes.add(BigDecimal.class);
        return setTypes;
    }

    @Override
    public Printer<?> getPrinter(CurrencyBrConverter currencyBrConverter, Class<?> aClass) {
        return new BrasilRealFormatter();
    }

    @Override
    public Parser<?> getParser(CurrencyBrConverter currencyBrConverter, Class<?> aClass) {
        return new BrasilRealFormatter();
    }
}
