package com.sorrymommy.amos;

import com.sorrymommy.amos.types.AMOSApiType;
import com.sorrymommy.amos.types.AMOSApiVersion;
import com.sorrymommy.amos.util.UrlSelector;
import com.sorrymommy.htmlcontent.HtmlContentLoader;
import com.sorrymommy.url.util.UrlBuilder;
import com.sorrymommy.url.util.UrlParameterBuilder;

import java.net.URL;

public class XMLLoader {
    public static final String ICAO = "icao";
    public static String getContent(AMOSApiType apiType, AMOSApiVersion apiVersion, String airportCode){
        HtmlContentLoader loader = new HtmlContentLoader();
        try{
            URL Url = UrlBuilder.build( UrlSelector.getUrl(apiType, apiVersion),
                    UrlParameterBuilder.simpleBuild(ICAO, airportCode) );

            String xmlContent = loader.getContent( Url );

            return xmlContent;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static String getContent(AMOSApiType apiType, AMOSApiVersion apiVersion) {
        try{
            return getContent(apiType, apiVersion, null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
