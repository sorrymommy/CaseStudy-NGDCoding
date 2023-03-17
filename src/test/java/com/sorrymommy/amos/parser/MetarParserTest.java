package com.sorrymommy.amos.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MetarParserTest {

    @Test
    void testParse() {
        String xmlContent = "<response>\n" +
                "<header>\n" +
                "<resultCode>0000</resultCode>\n" +
                "<resultMsg>OK</resultMsg>\n" +
                "</header>\n" +
                "<body>\n" +
                "<items>\n" +
                "<item>\n" +
                "<icaoCode>RKSI</icaoCode>\n" +
                "<airportName>인천공항</airportName>\n" +
                "<metarMsg>\n" +
                "<![CDATA[ METAR RKSI 170030Z 04007KT 360V060 CAVOK 04/M07 Q1027 NOSIG= ]]>\n" +
                "</metarMsg>\n" +
                "</item>\n" +
                "</items>\n" +
                "</body>\n" +
                "</response>";

        MetarParser metarParser = new MetarParser();
        Map<String, Object> map = metarParser.parse(xmlContent);

        Assertions.assertTrue(map.containsKey("resultCode"));
        Assertions.assertTrue(map.containsKey("icaoCode"));
    }
}