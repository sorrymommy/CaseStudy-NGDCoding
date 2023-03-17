package com.sorrymommy.main;

import com.sorrymommy.amos.AMOSApiType;
import com.sorrymommy.amos.AMOSApiVersion;
import com.sorrymommy.amos.UrlSelector;
import com.sorrymommy.amos.parser.*;
import com.sorrymommy.htmlcontent.HtmlContentLoader;
import com.sorrymommy.url.util.UrlBuilder;
import com.sorrymommy.url.util.UrlParameterBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Main {

    private static HtmlContentLoader htmlContentLoader = new HtmlContentLoader();
    private static UrlBuilder urlBuilder   = new UrlBuilder();
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String[] airPortCodes = {    "RKSI", /* 인천공항 */
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

        workWithAirportCodes( UrlSelector.getUrl(AMOSApiType.Metar, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Metar),
                airPortCodes);
        workWithAirportCodes( UrlSelector.getUrl(AMOSApiType.Taf, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Taf),
                airPortCodes);

        workWithoutAirportCodes(UrlSelector.getUrl(AMOSApiType.Sigmet, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Sigmet) );
    }

    private static void work(String url, String parameter, BaseParser parser) throws IOException {
        URL Url = urlBuilder.build(url, parameter);

        //2. API 호출
        String xmlContent = htmlContentLoader.getAPIContent(Url);

        //3. 결과값 파싱
        Map<String,Object> map = parser.parse(xmlContent);

        //4. 후처리
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private static void workWithAirportCodes(String url, BaseParser baseParser, String[] airPortCodes) {
        try{
            for (String airportCode : airPortCodes) {
                work(url, UrlParameterBuilder.simpleBuild("icao", airportCode), baseParser);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void workWithoutAirportCodes(String url, BaseParser baseParser){
        try{
            work(url, null, baseParser);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
