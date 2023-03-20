package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.AirmetItem;
import com.sorrymommy.amos.model.normal.SigmetItem;
import com.sorrymommy.amos.model.normal.WrngItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AirmetParserTest {

    @Test
    void parse_two_returnItems() {
        AirmetParser parser = new AirmetParser();

        List<AirmetItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(2, items.size());
    }

    @Test
    void parse_OK_returnItemValues() {
        AirmetParser parser = new AirmetParser();

        List<AirmetItem> items = parser.parse(xmlContent);

        Assertions.assertEquals(items.get(0).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(0).getIcaoCode()   , "RKSI");
        Assertions.assertEquals(items.get(0).getTmDate()     , "20071119");
        Assertions.assertEquals(items.get(0).getStTm()       , "191540");
        Assertions.assertEquals(items.get(0).getEdTm()       , "191940");
        Assertions.assertEquals(items.get(0).getAirmetMsg()  , "INCHEON FIR\nSFC VIS 5000M RA BR AND BKN CLD 1000FT OBS\nBOUNDED BY\nN3734E12617 N3757E12821\nN3539E12901 N3437E12552\nN3522E12549 N3553E12723\nAND N3734E12617\nMOV SE 05KT WKN=");

        Assertions.assertEquals(items.get(1).getAirportName(), "인천공항");
        Assertions.assertEquals(items.get(1).getIcaoCode()   , "RKSI");
        Assertions.assertEquals(items.get(1).getTmDate()     , "20071119");
        Assertions.assertEquals(items.get(1).getStTm()       , "191540");
        Assertions.assertEquals(items.get(1).getEdTm()       , "191940");
        Assertions.assertEquals(items.get(1).getAirmetMsg()  , "INCHEON FIR\nSFC VIS 5000M RA BR AND BKN CLD 1000FT OBS\nBOUNDED BY\nN3734E12617 N3757E12821\nN3539E12901 N3437E12552\nN3522E12549 N3553E12723\nAND N3734E12617\nMOV E 05KT NC=");

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
            "<tmDate>20071119</tmDate>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<stTm>191540</stTm>\n" +
            "<edTm>191940</edTm>\n" +
            "<airmetMsg><![CDATA[INCHEON FIR\n" +
            "SFC VIS 5000M RA BR AND BKN CLD 1000FT OBS\n" +
            "BOUNDED BY\n" +
            "N3734E12617 N3757E12821\n" +
            "N3539E12901 N3437E12552\n" +
            "N3522E12549 N3553E12723\n" +
            "AND N3734E12617\n" +
            "MOV SE 05KT WKN=]]></airmetMsg>\n" +
            "</item>\n" +
            "<item>\n" +
            "<tmDate>20071119</tmDate>\n" +
            "<icaoCode>RKSI</icaoCode>\n" +
            "<airportName>인천공항</airportName>\n" +
            "<stTm>191540</stTm>\n" +
            "<edTm>191940</edTm>\n" +
            "<airmetMsg><![CDATA[INCHEON FIR\n" +
            "SFC VIS 5000M RA BR AND BKN CLD 1000FT OBS\n" +
            "BOUNDED BY\n" +
            "N3734E12617 N3757E12821\n" +
            "N3539E12901 N3437E12552\n" +
            "N3522E12549 N3553E12723\n" +
            "AND N3734E12617\n" +
            "MOV E 05KT NC=]]></airmetMsg>\n" +
            "</item>\n" +
            "</items>\n" +
            "</body>\n" +
            "</response>";
}