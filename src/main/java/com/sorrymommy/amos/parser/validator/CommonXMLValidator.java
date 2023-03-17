package com.sorrymommy.amos.parser.validator;

import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class CommonXMLValidator {
    public static boolean validate(Document document) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String resultCode = xPath.evaluate("//response/header/resultCode", document);

        if (resultCode == null)
            throw new RuntimeException("resultCode is null");

        String resultMsg  = xPath.evaluate("//response/header/resultMsg", document);

        if (resultMsg == null)
            throw new RuntimeException("resultMsg is null");

        if (!resultCode.equals("0000"))
            throw new RuntimeException(resultMsg);

        return true;
    }
}
