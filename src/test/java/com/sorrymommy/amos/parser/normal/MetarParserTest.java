package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.MetarItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetarParserTest {

    @Test
    void parse_OK_returnItemValues() {
        MetarParser parser = new MetarParser();
        List<MetarItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(items.get(0).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(0).getIcaoCode(), "RKSI");
        Assertions.assertEquals(items.get(0).getMetarMsg(), "METAR RKSI 082000Z 29010KT 7000 NSC 05/M01 Q1018 NOSIG=");
    }

    @Test
    void parse_throwException_runtimeException(){
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "<header>\n" +
                "<resultCode>E01</resultCode>\n" +
                "<resultMsg>Error</resultMsg>\n" +
                "</header>\n" +
                "</response>";
        MetarParser parser = new MetarParser();

        assertThrows(RuntimeException.class, () -> parser.parse(content));
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
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<metarMsg><![CDATA[METAR RKSI 082000Z 29010KT 7000 NSC 05/M01 Q1018 NOSIG=]]></metarMsg></item>\n" +
            "</items>\n" +
            "</body>\n" +
            "</response>";
}