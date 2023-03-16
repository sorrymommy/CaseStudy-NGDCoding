package com.sorrymommy.amos;

import java.util.HashMap;
import java.util.Map;

public class UrlParameterBuilder {
    public static final String PAMETER_PAIR = "%s=%s";

    private Map<String, String> parameters = new HashMap<>();
    public void clear(){
        parameters.clear();
    }
    public UrlParameterBuilder add(String key, String value){
        parameters.put(key, value);

        return this;
    }

    public String build(){
        StringBuilder sb = new StringBuilder();
        for(String key : parameters.keySet()) {
            sb.append(String.format(PAMETER_PAIR, key, parameters.get(key)));
        }
        return sb.toString();
    }

    public static String simpleBuild(String key, String value){
        return String.format(PAMETER_PAIR, key, value);
    }
}
