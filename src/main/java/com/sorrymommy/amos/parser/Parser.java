package com.sorrymommy.amos.parser;

import java.util.Map;

public interface Parser {
    public Map<String, Object> parse(String xml);
}
