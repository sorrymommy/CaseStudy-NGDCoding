package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.TafItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TafParserTest {

    @Test
    void parse_OK_returnItemValues() {
        TafParser parser = new TafParser();
        List<TafItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(items.get(0).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(0).getIcaoCode(), "RKSI");
        Assertions.assertEquals(items.get(0).getTafMsg(), "TAF RKSI 090500Z 0906/1012 33020G35KT\nCAVOK\n TNM06/0920Z TX01/1005Z\n BECMG 1003/1004 32015G25KT=");
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
            "<tafMsg><![CDATA[TAF RKSI 090500Z 0906/1012 33020G35KT\n" +
            "CAVOK\n" +
            " TNM06/0920Z TX01/1005Z\n" +
            " BECMG 1003/1004 32015G25KT=]]></tafMsg>\n" +
            "</item>\n" +
            "</items>\n" +
            "</body>\n" +
            "</response>";
}