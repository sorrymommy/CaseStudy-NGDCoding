package com.sorrymommy.amos;

public class UrlSelector {
    private static final String BaseUrl = "http://amoapi.kma.go.kr/amoApi/";
    public static String getUrl(AMOSApiType apiType, AMOSApiVersion apiVersion){
        if (apiVersion == AMOSApiVersion.Normal) {
            return BaseUrl + apiType.toString().toLowerCase();
        } else {
            return BaseUrl + apiVersion.toString().toLowerCase() + "/" + apiType.toString();
        }
    }
}
