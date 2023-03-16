package com.sorrymommy.main;

import com.sorrymommy.amos.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        workMetar();
    }

    private static void workMetar() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        HtmlContentLoader htmlContentLoader = new HtmlContentLoader();
        UrlBuilder urlBuilder   = new UrlBuilder();
        MetarParser metarParser = new MetarParser();
        String[] airPortCodes   = new String[] {"RKSI"};

        for(String airportCode : airPortCodes){
            //1. URL 및 Parameter 설정
            URL url = urlBuilder.build("http://amoapi.kma.go.kr/amoApi/metar", UrlParameterBuilder.simpleBuild("icao", airportCode));

            //2. API 호출
            String xmlContent = htmlContentLoader.getAPIContent(url);

            //3. 결과값 파싱
            Map<String,Object> map = metarParser.parse(xmlContent);

            //4. 후처리
            for(String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
        }
    }
}
