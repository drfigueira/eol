package com.eol.web;

import com.eol.model.Plano;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlanoConverter implements Converter<String, Plano> {

    @Override
    public Plano convert(String source) {
        switch (source){
            case "Monofasico":
                return Plano.MONO;
            case "Bifasico":
                return Plano.BI;
            case "Trifasico":
                return Plano.TRI;
            default:
                return null;
        }
    }
}
