package com.sorrymommy.amos;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.sorrymommy.amos.ApiType.Metar;

public class UrlBuilder {
    private ApiType apiType;
    private String airportCode;
    public UrlBuilder add(ApiType apiType){
        if (apiType == null)
            throw new IllegalArgumentException("apiType is empty");

        this.apiType = apiType;

        return this;
    }

    public UrlBuilder add(String airportCode){
        if ("".equals(airportCode.trim()))
            throw new IllegalArgumentException("airportCode is empty");

        this.airportCode = airportCode;

        return this;
    }


    public URL build() throws MalformedURLException {
        if (this.apiType == null)
            throw new IllegalArgumentException("apiType is empty");

        if ( ( (this.apiType == Metar) || (this.apiType == ApiType.Taf) ) &&
             ("".equals(airportCode.trim())) )
            throw new IllegalArgumentException("airportCode is empty");

        String url = "";

        switch (this.apiType){
            case Metar:
                url = "http://amoapi.kma.go.kr/amoApi/metar";
                break;
            //TODO API별로 주소나 파라메터구성이 모두 다를 것이다.
        }

        if (!"".equals(airportCode))
            url += String.format("?icao=%s", URLEncoder.encode(airportCode, StandardCharsets.UTF_8));

        return new URL(url);
    }
}
