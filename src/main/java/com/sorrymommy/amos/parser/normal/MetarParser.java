package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.MetarItem;
import com.sorrymommy.amos.parser.util.DocumentLoader;
import com.sorrymommy.amos.parser.validator.CommonXMLValidator;
import com.sorrymommy.amos.parser.validator.TagValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
        Document document = DocumentLoader.load(xmlContent);

        if (CommonXMLValidator.validate(document) == false)
            return null;

        if (TagValidator.validate(document, "items") == false)
            return null;

        NodeList itemsNodes = document.getElementsByTagName("items");

        MetarItem item = new MetarItem();
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            for(Node node = itemsNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {

                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                NodeList itemNode = node.getChildNodes();

                for(int j= 0; j < itemNode.getLength(); j++) {
                    Node childNode = itemNode.item(j);

                    if (childNode.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    if ("icaoCode".equals(childNode.getNodeName()))
                        item.setIcaoCode(childNode.getTextContent());

                    if ("airportName".equals(childNode.getNodeName()))
                        item.setAirportName(childNode.getTextContent());

                    if ("metarMsg".equals(childNode.getNodeName()))
                        item.setMetarMsg(childNode.getTextContent());
                }
            }
        }

        return item;
    }
}
