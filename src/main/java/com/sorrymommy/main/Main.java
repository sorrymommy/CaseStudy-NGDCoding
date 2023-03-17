package com.sorrymommy.main;

import com.sorrymommy.amos.*;
import com.sorrymommy.amos.parser.*;
import com.sorrymommy.htmlcontent.HtmlContentLoader;
import com.sorrymommy.url.util.UrlBuilder;
import com.sorrymommy.url.util.UrlParameterBuilder;

import java.io.*;
import java.net.URL;
import java.util.Map;

public class Main {
    private static HtmlContentLoader htmlContentLoader = new HtmlContentLoader();
    private static UrlBuilder urlBuilder   = new UrlBuilder();
    public static void main(String[] args) {
        AirPortCodeSupporter airPortCodeSupporter = new AirPortCodeSupporterImpl();

        workWithAirportCodes( UrlSelector.getUrl(AMOSApiType.Metar, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Metar),
                airPortCodeSupporter.getAirportCodes());

        workWithAirportCodes( UrlSelector.getUrl(AMOSApiType.Taf, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Taf),
                airPortCodeSupporter.getAirportCodes());

        workWithoutAirportCodes(UrlSelector.getUrl(AMOSApiType.Sigmet, AMOSApiVersion.Normal),
                ParserCreator.create(AMOSApiType.Sigmet) );
    }

    private static void work(String url, String parameter, Parser parser) throws IOException {
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

    private static void workWithAirportCodes(String url, Parser parser, String[] airPortCodes) {
        try{
            for (String airportCode : airPortCodes) {
                work(url, UrlParameterBuilder.simpleBuild("icao", airportCode), parser);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void workWithoutAirportCodes(String url, Parser parser){
        try{
            work(url, null, parser);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
