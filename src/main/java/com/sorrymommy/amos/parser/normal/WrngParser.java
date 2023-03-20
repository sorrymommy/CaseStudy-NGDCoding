package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.model.normal.WrngItem;
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
import java.util.ArrayList;
import java.util.List;

public class WrngParser {
    public List<WrngItem> parse(String content) {

        try {
            return doParsing(content);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private List<WrngItem> doParsing(String content) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        Document document = DocumentLoader.load(content);

        if (CommonXMLValidator.validate(document) == false)
            return null;

        if (TagValidator.validate(document, "items") == false)
            return null;

        NodeList itemsNodes = document.getElementsByTagName("item");

        List<WrngItem> wrngItems = new ArrayList<WrngItem>();
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            Node node = itemsNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;

            WrngItem item = new WrngItem();
            wrngItems.add(item);
            for(int j=0; j < node.getChildNodes().getLength(); j++){
                Node childNode = node.getChildNodes().item(j);

                if (childNode.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                if ("tm".equals(childNode.getNodeName()))
                    item.setTm(childNode.getTextContent());

                if ("icaoCode".equals(childNode.getNodeName()))
                    item.setIcaoCode(childNode.getTextContent());

                if ("airportName".equals(childNode.getNodeName()))
                    item.setAirportName(childNode.getTextContent());

                if ("wrngType".equals(childNode.getNodeName()))
                    item.setWrngType(childNode.getTextContent());

                if ("validTm1".equals(childNode.getNodeName()))
                    item.setValidTm1(childNode.getTextContent());

                if ("validTm2".equals(childNode.getNodeName()))
                    item.setValidTm2(childNode.getTextContent());

                if ("wrngMsg".equals(childNode.getNodeName()))
                    item.setWrngMsg(childNode.getTextContent());

            }
        }

        return wrngItems;
    }
}
