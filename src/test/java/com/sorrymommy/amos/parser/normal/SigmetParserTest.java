package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.SigmetItem;
import com.sorrymommy.amos.model.normal.WrngItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SigmetParserTest {

    @Test
    void parse_three_returnItems() {
        SigmetParser parser = new SigmetParser();

        List<SigmetItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(3, items.size());
    }

    @Test
    void parse_OK_returnItemValues() {
        SigmetParser parser = new SigmetParser();
        List<SigmetItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(items.get(0).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(0).getIcaoCode()   , "RKSI");
        Assertions.assertEquals(items.get(0).getTmDate()     , "20050323");
        Assertions.assertEquals(items.get(0).getStTm()       , "232050");
        Assertions.assertEquals(items.get(0).getEdTm()       , "240050");
        Assertions.assertEquals(items.get(0).getSigmetMsg()  , "INCHEON FIR ISOL TS FCST\nTOP FL200 IN AREA BOUNDED\nBY 36N126E 36N128E\n35N128E 35N126E\nAND 36N126E\nMOV E 07KT NC");

        Assertions.assertEquals(items.get(1).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(1).getIcaoCode()   , "RKSI");
        Assertions.assertEquals(items.get(1).getTmDate()     , "20050323");
        Assertions.assertEquals(items.get(1).getStTm()       , "231800");
        Assertions.assertEquals(items.get(1).getEdTm()       , "232200");
        Assertions.assertEquals(items.get(1).getSigmetMsg()  , "INCHEON FIR ISOL TS FCST\nTOP FL200IN AREA BOUNDED\nBY 34N125E 34N128E\n32N128E 32N125E\nAND 34N125E\nMOV SE 07KT NC");

        Assertions.assertEquals(items.get(2).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(2).getIcaoCode()   , "RKSI");
        Assertions.assertEquals(items.get(2).getTmDate()     , "20050323");
        Assertions.assertEquals(items.get(2).getStTm()       , "231000");
        Assertions.assertEquals(items.get(2).getEdTm()       , "231400");
        Assertions.assertEquals(items.get(2).getSigmetMsg()  , "INCHEON FIR FRQ TS FCST TOP FL260 IN\nAREA BOUNDED BY\n38N 128E 38N 129E 35N 129E 35N 128E AND 38N 128E\nMOV E 07KT INTSF");
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
            "<tmDate>20050323</tmDate>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<stTm>232050</stTm>\n" +
            "<edTm>240050</edTm>\n" +
            "<sigmetMsg><![CDATA[INCHEON FIR ISOL TS FCST\n" +
            "TOP FL200 IN AREA BOUNDED\n" +
            "BY 36N126E 36N128E\n" +
            "35N128E 35N126E\n" +
            "AND 36N126E\n" +
            "MOV E 07KT NC]]></sigmetMsg>\n" +
            "</item>\n" +
            "<item>\n" +
            "<tmDate>20050323</tmDate>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<stTm>231800</stTm>\n" +
            "<edTm>232200</edTm>\n" +
            "<sigmetMsg><![CDATA[INCHEON FIR ISOL TS FCST\n" +
            "TOP FL200IN AREA BOUNDED\n" +
            "BY 34N125E 34N128E\n" +
            "32N128E 32N125E\n" +
            "AND 34N125E\n" +
            "MOV SE 07KT NC]]></sigmetMsg>\n" +
            "</item>\n" +
            "<item>\n" +
            "<tmDate>20050323</tmDate>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<stTm>231000</stTm>\n" +
            "<edTm>231400</edTm>\n" +
            "<sigmetMsg><![CDATA[INCHEON FIR FRQ TS FCST TOP FL260 IN\n" +
            "AREA BOUNDED BY\n" +
            "38N 128E 38N 129E 35N 129E 35N 128E AND 38N 128E\n" +
            "MOV E 07KT INTSF]]></sigmetMsg>\n" +
            "</item>\n" +
            "</items>\n" +
            "</body>\n" +
            "</response>";
}