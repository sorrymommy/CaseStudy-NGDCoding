package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.SigmetItem;

import java.util.List;

public class SigmetParser {
    public List<SigmetItem> parse(String xmlContent){
        try {
            return doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public  List<SigmetItem> doParsing(String content){
        NormalParser<SigmetItem> parser = new NormalParser<>(SigmetItem.class);

        String[] tags = {"tmDate", "icaoCode", "airportName", "stTm", "edTm", "sigmetMsg"};

        return parser.parse(content, "item", tags);
    }
}
