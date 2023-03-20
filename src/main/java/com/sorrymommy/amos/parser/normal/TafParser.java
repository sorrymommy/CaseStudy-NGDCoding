package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.TafItem;

import java.util.List;

public class TafParser {
    public List<TafItem> parse(String xmlContent){
        try{
            return doParsing(xmlContent);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<TafItem> doParsing(String content){
        NormalParser<TafItem> parser = new NormalParser<>(TafItem.class);

        String[] tags = {"icaoCode", "airportName", "tafMsg"};

        return parser.parse(content, "item", tags);
    }
}
