package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.WrngItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WrngParserTest {
    @Test
    void parse_two_returnItems() {
        WrngParser parser = new WrngParser();

        List<WrngItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(2, items.size());
    }

    @Test
    void parse_ok_returnItemsValues(){
        WrngParser parser = new WrngParser();

        List<WrngItem> items = parser.parse(xmlContent);

        WrngItem item = items.get(0);
        Assertions.assertEquals("201511080852", item.getTm());
        Assertions.assertEquals("RKSI", item.getIcaoCode());
        Assertions.assertEquals("인천공항", item.getAirportName());
        Assertions.assertEquals("윈드시어", item.getWrngType());
        Assertions.assertEquals("201511070358", item.getValidTm1());
        Assertions.assertEquals("201511082359", item.getValidTm2());
        Assertions.assertEquals("RKSI WS CLIMB-OUT WRNG 1\n140400 VALID 140400/140800\nWS RWY ALL=", item.getWrngMsg());

        item = items.get(1);
        Assertions.assertEquals("201511080852", item.getTm());
        Assertions.assertEquals("RKSI", item.getIcaoCode());
        Assertions.assertEquals("인천공항", item.getAirportName());
        Assertions.assertEquals("윈드시어", item.getWrngType());
        Assertions.assertEquals("201511070358", item.getValidTm1());
        Assertions.assertEquals("201511082359", item.getValidTm2());
        Assertions.assertEquals("RKSI WS CLIMB-OUT WRNG 1\n140400 VALID 140400/140800\nWS RWY ALL=", item.getWrngMsg());
    }

    private static final String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<response>\n" +
            "<header>\n" +
            "<resultCode>0000</resultCode>\n" +
            "<resultMsg>OK</resultMsg>\n" +
            "</header>\n" +
            "<body>\n" +
            "<items>\n" +
            "<item>\n" +
            "<tm>201511080852</tm>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<wrngType>윈드시어</wrngType>\n" +
            "<validTm1>201511070358</validTm1>\n" +
            "<validTm2>201511082359</validTm2>\n" +
            "<wrngMsg><![CDATA[RKSI WS CLIMB-OUT WRNG 1\n" +
            "140400 VALID 140400/140800\n" +
            "WS RWY ALL=]]></wrngMsg>\n" +
            "</item>\n" +
            "<item>\n" +
            "<tm>201511080852</tm>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<wrngType>윈드시어</wrngType>\n" +
            "<validTm1>201511070358</validTm1>\n" +
            "<validTm2>201511082359</validTm2>\n" +
            "<wrngMsg><![CDATA[RKSI WS CLIMB-OUT WRNG 1\n" +
            "140400 VALID 140400/140800\n" +
            "WS RWY ALL=]]></wrngMsg>\n" +
            "</item>\n" +
            "</items>\n" +
            "</body>\n" +
            "</response>";
}