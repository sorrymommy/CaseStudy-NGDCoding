package com.sorrymommy.amos;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilder {

    public static final String URL_PARAMTER = "%s?%s";

    public URL build(String url, String parameter) throws MalformedURLException {
        String tempUrl = String.format(URL_PARAMTER, url, parameter);

        return new URL(tempUrl);
    }
}
