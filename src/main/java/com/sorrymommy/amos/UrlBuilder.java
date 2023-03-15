package com.sorrymommy.amos;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlBuilder {
    public URL getUrl(String apiType, String airportCode) throws MalformedURLException {
        if ("".equals(apiType.trim()))
            throw new IllegalArgumentException("apiType is empty");

        if (("metar".equals(apiType)) && ("".equals(airportCode.trim())))
            throw new IllegalArgumentException("airportCode is empty");

        String url = "";

        switch (apiType){
            case "metar":
                url = "http://amoapi.kma.go.kr/amoApi/metar";
                break;
            //TODO API별로 주소나 파라메터구성이 모두 다를 것이다.
        }

        if (!"".equals(airportCode))
            url += "?" + URLEncoder.encode("icao", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(airportCode, StandardCharsets.UTF_8);

        return new URL(url);
    }
}
