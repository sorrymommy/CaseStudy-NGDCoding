package com.sorrymommy.amos.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocumentUtil {
    private Document document;
    public DocumentUtil(Document document){
        this.document = document;
    }
    public String getTagContent(String tagName) {
        return DocumentUtil.getTagContent(this.document, tagName);
    }

    public static int getTagContentAsInt(Document document, String tagName){
        String value = getTagContent(document, tagName);

        if (value.isEmpty())
            return 0;

        return Integer.parseInt(value);
    }

    public static float getTagContentAsFloat(Document document, String tagName){
        String value = getTagContent(document, tagName);

        if (value.isEmpty())
            return 0;

        return Float.parseFloat(value);
    }
    public static String getTagContent(Document document, String tagName){
        NodeList nodes = document.getElementsByTagName(tagName);

        for(int i= 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() != Node.ELEMENT_NODE)
                continue;

            return nodes.item(i).getTextContent();
        }

        return "";
    }

    public static String getAttribute(Document document, String tagName, String attributeName){
        NodeList nodes = document.getElementsByTagName(tagName);

        for(int i= 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() != Node.ELEMENT_NODE)
                continue;

            Node node =nodes.item(i).getAttributes().getNamedItem(attributeName);

            if (node != null)
                return node.getTextContent();
        }

        return "";
    }
}
