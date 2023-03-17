package com.sorrymommy.amos.parser.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class DocumentLoader {
    public static Document load(String content) throws ParserConfigurationException, IOException, SAXException {
        InputSource is = new InputSource(new StringReader(content));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

        return document;
    }
}
