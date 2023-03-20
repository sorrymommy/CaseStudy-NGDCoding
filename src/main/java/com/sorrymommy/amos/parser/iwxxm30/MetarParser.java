package com.sorrymommy.amos.parser.iwxxm30;

import com.sorrymommy.amos.model.iwxxm20.MetarItem;
import com.sorrymommy.amos.parser.DocumentUtil;
import com.sorrymommy.amos.parser.util.DocumentLoader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class MetarParser {
    public MetarItem parse(String xmlContent) {
        try {
            return doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private MetarItem doParsing(String xmlContent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        String tempXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlContent;

        Document document = DocumentLoader.load(tempXml);

        MetarItem item = new MetarItem();

        item.setMsgText(DocumentUtil.getTagContent(document,"msgText") );
        item.setPhenomenonTime(DocumentUtil.getTagContent(document,"gml:timePosition") );

        return item;
    }
}
