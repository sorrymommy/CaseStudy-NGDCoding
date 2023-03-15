package com.sorrymommy.main;

import com.sorrymommy.amos.HtmlContentLoader;
import com.sorrymommy.amos.MetarParser;
import com.sorrymommy.amos.UrlBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        HtmlContentLoader htmlContentLoader = new HtmlContentLoader();
        UrlBuilder urlBuilder = new UrlBuilder();
        MetarParser metarParser = new MetarParser();
        String apiType = "metar";
        String airPort = "RKSI";

        //1. URL 및 Parameter 설정
        URL url = urlBuilder.getUrl(apiType, airPort );

        //2. API 호출
        String xmlContent = htmlContentLoader.getAPIContent(url);

        //3. 결과값 파싱
        Map<String,Object> map = null;
        switch (apiType) {
            case "metar":
                map = metarParser.parse(xmlContent);
                break;
                //TODO API별로 파싱이 모두 다를 것이다.
        }

        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
