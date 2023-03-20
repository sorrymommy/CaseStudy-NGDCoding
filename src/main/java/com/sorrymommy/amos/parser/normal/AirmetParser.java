package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.AirmetItem;
import com.sorrymommy.amos.model.normal.SigmetItem;
import com.sorrymommy.amos.parser.util.DocumentLoader;
import com.sorrymommy.amos.parser.validator.CommonXMLValidator;
import com.sorrymommy.amos.parser.validator.TagValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirmetParser {
    public List<AirmetItem> parse(String xmlContent){
        try {
            return doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<AirmetItem> doParsing(String xmlContent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        Document document = DocumentLoader.load(xmlContent);

        if (CommonXMLValidator.validate(document) == false)
            return null;

        NodeList itemsNodes = document.getElementsByTagName("item");

        if (itemsNodes == null)
            throw new RuntimeException("this document has no item tags");

        List<AirmetItem> airmetItems = new ArrayList<AirmetItem>();
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            Node node = itemsNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;

            AirmetItem item = new AirmetItem();
            airmetItems.add(item);
            for(int j=0; j < node.getChildNodes().getLength(); j++){
                Node childNode = node.getChildNodes().item(j);

                if (childNode.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                if ("tmDate".equals(childNode.getNodeName()))
                    item.setTmDate(childNode.getTextContent());

                if ("icaoCode".equals(childNode.getNodeName()))
                    item.setIcaoCode(childNode.getTextContent());

                if ("airportName".equals(childNode.getNodeName()))
                    item.setAirportName(childNode.getTextContent());

                if ("stTm".equals(childNode.getNodeName()))
                    item.setStTm(childNode.getTextContent());

                if ("edTm".equals(childNode.getNodeName()))
                    item.setEdTm(childNode.getTextContent());

                if ("airmetMsg".equals(childNode.getNodeName()))
                    item.setAirmetMsg(childNode.getTextContent());

            }
        }
        return airmetItems;
    }
}
