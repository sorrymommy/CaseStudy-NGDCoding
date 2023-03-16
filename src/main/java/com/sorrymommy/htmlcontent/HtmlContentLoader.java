package com.sorrymommy.htmlcontent;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlContentLoader {

    public static final String METHOD_GET = "GET";
    public static final String CONTENT_TYPE = "Content-type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String RESPONSE_CODE_S = "Response code: %s";
    public static final String HTTP_ERROR_CODE_S = "HTTP error code : %s";

    public String getAPIContent(URL url) throws IOException {
        //2. API 호출
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_GET);
        conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
        System.out.println(String.format(RESPONSE_CODE_S, conn.getResponseCode()));

        if (conn.getResponseCode() != HttpsURLConnection.HTTP_OK)
            throw new IOException(String.format(HTTP_ERROR_CODE_S, conn.getResponseCode()));

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();
    }
}
