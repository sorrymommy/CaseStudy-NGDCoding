package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.TafItem;
import com.sorrymommy.amos.parser.util.DocumentLoader;
import com.sorrymommy.amos.parser.validator.CommonXMLValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TafParser {
    public List<TafItem> parse(String xmlContent){
        try{
            return doParsing(xmlContent);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<TafItem> doParsing(String xmlContent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        Document document = DocumentLoader.load(xmlContent);

        if (CommonXMLValidator.validate(document) == false)
            throw new RuntimeException("validate failed");

        NodeList itemsNodes = document.getElementsByTagName("item");

        if (itemsNodes == null)
            throw new RuntimeException("this document has no item tags");

        List<TafItem> tafItems = new ArrayList<>();
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            Node node = itemsNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;

            TafItem item = new TafItem();
            tafItems.add(item);
            for(int j=0; j < itemsNodes.item(i).getChildNodes().getLength(); j++){
                Node childNode = node.getChildNodes().item(j);

                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                if ("icaoCode".equals(childNode.getNodeName()))
                    item.setIcaoCode(childNode.getTextContent());

                if ("airportName".equals(childNode.getNodeName()))
                    item.setAirportName(childNode.getTextContent());

                if ("tafMsg".equals(childNode.getNodeName()))
                    item.setTafMsg(childNode.getTextContent());
            }
        }

        return tafItems;
    }
}
