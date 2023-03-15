package com.sorrymommy.main;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        //1. URL 및 Parameter 설정
        StringBuilder urlBuilder = new StringBuilder("http://amoapi.kma.go.kr/amoApi/metar");
        urlBuilder.append("?" + URLEncoder.encode("icao","UTF-8") + "=" + URLEncoder.encode("RKSI", "UTF-8"));
        URL url = new URL(urlBuilder.toString());

        //2. API 호출
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        //3. 결과값 파싱
        String xmlContent = sb.toString();
        InputSource is = new InputSource(new StringReader(xmlContent));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String resultCode = xPath.evaluate("//response/header/resultCode", document);
        String resultMsg = xPath.evaluate("//response/header/resultMsg", document);

        System.out.println("resultCode: " + resultCode);
        System.out.println("resultMsg: " + resultMsg);
        NodeList itemsNodes = document.getElementsByTagName("itemsNodes");
        for(int i= 0; i < itemsNodes.getLength(); i++) {
            for(Node node = itemsNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {

                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                NodeList itemNode = node.getChildNodes();

                for(int j= 0; j < itemNode.getLength(); j++) {
                    Node childNode = itemNode.item(j);

                    if (childNode.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    System.out.println(childNode.getNodeName() + ": " + childNode.getTextContent());
                }
            }
        }
    }
}
