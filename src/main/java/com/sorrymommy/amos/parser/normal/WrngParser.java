package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.WrngItem;

import java.util.List;

public class WrngParser {
    public List<WrngItem> parse(String content) {
        try {
            return doParsing(content);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private List<WrngItem> doParsing(String content) {
        NormalParser<WrngItem> parser = new NormalParser<>(WrngItem.class);

        String[] tags = {"tm", "icaoCode", "airportName", "wrngType", "validTm1", "validTm2", "wrngMsg"};

        return parser.parse(content, "item", tags);
    }
}
