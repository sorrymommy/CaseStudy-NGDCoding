package com.sorrymommy.main;

import com.sorrymommy.amos.parser.MetarParser;
import com.sorrymommy.amos.parser.SigmetParser;
import com.sorrymommy.amos.parser.TafParser;
import com.sorrymommy.htmlcontent.HtmlContentLoader;
import com.sorrymommy.url.util.UrlBuilder;
import com.sorrymommy.url.util.UrlParameterBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.URL;
import java.util.Map;

public class Main {

    private static String[] airPortCodes = {    "RKSI", /* 인천공항 */
                                                "RKSS", /* 김포공항 */
                                                "RKPC", /* 제주공항 */
                                                "RKPK", /* 김해공항 */
                                                "RKNY", /* 양양공항 */
                                                "RKNW", /* 원주공항 */
                                                "RKTU", /* 청주공항 */
                                                "RKTN", /* 대구공항 */
                                                "RKTH", /* 포항공항 */
                                                "RKJJ", /* 광주공항 */
                                                "RKJB", /* 무안공항 */
                                                "RKJY", /* 여수공항 */
                                                "RKPU", /* 울산공항 */
                                                "RKPS", /* 사천공항 */
                                                "RKJK"  /* 군산공항 */ };
    private static HtmlContentLoader htmlContentLoader = new HtmlContentLoader();
    private static UrlBuilder urlBuilder   = new UrlBuilder();
    private static TafParser tafParser = new TafParser();
    private static MetarParser metarParser = new MetarParser();
    private static SigmetParser sigmetParser = new SigmetParser();
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        workMetar();
        workTaf();
        workSigmet();
    }

    private static void workSigmet() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        //1. URL 및 Parameter 설정
        URL url = urlBuilder.build("http://amoapi.kma.go.kr/amoApi/sigmet");

        //2. API 호출
        String xmlContent = htmlContentLoader.getAPIContent(url);

        //3. 결과값 파싱
        Map<String,Object> map = sigmetParser.parse(xmlContent);

        //4. 후처리
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private static void workTaf() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        for(String airportCode : airPortCodes){
            //1. URL 및 Parameter 설정
            URL url = urlBuilder.build("http://amoapi.kma.go.kr/amoApi/taf", UrlParameterBuilder.simpleBuild("icao", airportCode));

            //2. API 호출
            String xmlContent = htmlContentLoader.getAPIContent(url);

            //3. 결과값 파싱
            Map<String,Object> map = tafParser.parse(xmlContent);

            //4. 후처리
            for(String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
        }
    }

    private static void workMetar() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
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
