package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.AirmetItem;

import java.util.List;

public class AirmetParser {
    public List<AirmetItem> parse(String xmlContent){
        try {
            return this.doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<AirmetItem> doParsing(String content) {
        NormalParser<AirmetItem> parser = new NormalParser<>(AirmetItem.class);

        String[] tags = {"tmDate", "icaoCode", "airportName", "stTm", "edTm", "airmetMsg"};

        return parser.parse(content, "item", tags);
    }
}
