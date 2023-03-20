package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.MetarItem;

import java.util.List;

public class MetarParser {
    public List<MetarItem> parse(String xmlContent) {
        try {
            return doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private List<MetarItem> doParsing(String content) {
        NormalParser<MetarItem> parser = new NormalParser<>(MetarItem.class);

        String[] tags = {"icaoCode", "airportName", "metarMsg"};

        return parser.parse(content, "item", tags);
    }
}
