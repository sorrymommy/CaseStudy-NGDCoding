package com.sorrymommy.amos.parser;

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
import java.util.HashMap;
import java.util.Map;

public class TafParser implements Parser{
    @Override
    public Map<String,Object> parse(String xmlContent){
        Map<String, Object> map = new HashMap<>();
        try{
            map = doParsing(xmlContent);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    public  Map<String,Object> doParsing(String xmlContent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        Map<String, Object> resultMap = new HashMap<>();
        InputSource is = new InputSource(new StringReader(xmlContent));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String resultCode = xPath.evaluate("//response/header/resultCode", document);
        String resultMsg = xPath.evaluate("//response/header/resultMsg", document);

        resultMap.put("resultCode", resultCode);
        resultMap.put("resultMsg", resultMsg);

        NodeList itemsNodes = document.getElementsByTagName("items");
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            for(Node node = itemsNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {

                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                NodeList itemNode = node.getChildNodes();

                for(int j= 0; j < itemNode.getLength(); j++) {
                    Node childNode = itemNode.item(j);

                    if (childNode.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    resultMap.put(childNode.getNodeName(), childNode.getTextContent());
                }
            }
        }

        return resultMap;
    }
}
