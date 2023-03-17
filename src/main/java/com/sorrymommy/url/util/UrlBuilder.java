package com.sorrymommy.url.util;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilder {

    public static final String URL_WITH_PARAMTER = "%s?%s";
    public static final String URL_WITHOUT_PARAMTER = "%s";

    public static URL build(String url, String parameter) throws MalformedURLException {
        if (parameter == null || parameter.isEmpty())
            return new URL(String.format(URL_WITHOUT_PARAMTER, url));

        return new URL(String.format(URL_WITH_PARAMTER, url, parameter));
    }

    public static URL build(String url) throws MalformedURLException {
        return build(url, null);
    }
}
