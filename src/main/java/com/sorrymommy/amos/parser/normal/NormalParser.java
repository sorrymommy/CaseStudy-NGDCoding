package com.sorrymommy.amos.parser.normal;

import com.sorrymommy.amos.parser.util.DocumentLoader;
import com.sorrymommy.amos.parser.validator.CommonXMLValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalParser<T> {
    private Class<T> clazz;
    public NormalParser(Class<T> clazz){
        this.clazz = clazz;
    }
    public List<T> parse(String content, String parentNodeName, String[] tags){
        try {
            return doParsing(content, parentNodeName, tags);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<T> doParsing(String content, String parentNodeName, String[] tags) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Document document = DocumentLoader.load(content);

        if (CommonXMLValidator.validate(document) == false)
            return null;

        NodeList itemsNodes = document.getElementsByTagName(parentNodeName);

        if (itemsNodes == null)
            throw new RuntimeException(String.format("this document has no %s tags", parentNodeName));

        List<T> returnItems = new ArrayList<T>();

        for(int i= 0; i < itemsNodes.getLength(); i++) {
            Node node = itemsNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;

            T item = clazz.newInstance();
            returnItems.add(item);
            for(int j=0; j < node.getChildNodes().getLength(); j++){
                Node childNode = node.getChildNodes().item(j);

                if (childNode.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                for(String tag : tags){
                    if ( tag.equals(childNode.getNodeName()) )
                        setMethodValue(item, childNode);
                }
            }
        }

        return returnItems;
    }

    private void setMethodValue(T item, Node node) throws ClassNotFoundException {
        String tagName = node.getNodeName();
        String tagValue = node.getTextContent();
        String methodName = String.format("set%s%s", Character.toUpperCase(tagName.charAt(0)), tagName.substring(1, tagName.length()));

        Arrays.stream(Class.forName(item.getClass().getTypeName()).getMethods()).forEach(m -> {
            if (m.getName().equals(methodName)) {
                try {
                    m.invoke(item, tagValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
