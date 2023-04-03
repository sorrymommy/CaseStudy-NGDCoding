package com.sorrymommy.amos;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.sorrymommy.amos.ApiType.Metar;

public class UrlBuilder {
    public static final String EXCEPTION_ApiTypeIsEmpty = "apiType is empty";
    public static final String EXCEPTION_AirportCodeIsEmpty = "airportCode is empty";
    private ApiType apiType;
    private String airportCode;
    public UrlBuilder add(ApiType apiType){
        if (apiType == null)
            throw new IllegalArgumentException(EXCEPTION_ApiTypeIsEmpty);

        this.apiType = apiType;

        return this;
    }
    public UrlBuilder add(String airportCode){
        if ("".equals(airportCode.trim()))
            throw new IllegalArgumentException(EXCEPTION_AirportCodeIsEmpty);

        this.airportCode = airportCode;

        return this;
    }
    public URL build() throws MalformedURLException {
        if (this.apiType == null)
            throw new IllegalArgumentException(EXCEPTION_ApiTypeIsEmpty);

        boolean mustIncludeAirportCodeAPI = ( (this.apiType == Metar) || (this.apiType == ApiType.Taf) );

        if ( mustIncludeAirportCodeAPI && ("".equals(airportCode.trim())) )
            throw new IllegalArgumentException(EXCEPTION_AirportCodeIsEmpty);

        String url = "";

        switch (this.apiType){
            case Metar:
                url = "http://amoapi.kma.go.kr/amoApi/metar";
                break;
            //TODO API별로 주소나 파라메터구성이 모두 다를 것이다.
        }

        if ( mustIncludeAirportCodeAPI && (!"".equals(airportCode.trim())) )
            url += String.format("?icao=%s", URLEncoder.encode(airportCode, StandardCharsets.UTF_8));

        return new URL(url);
    }
}
