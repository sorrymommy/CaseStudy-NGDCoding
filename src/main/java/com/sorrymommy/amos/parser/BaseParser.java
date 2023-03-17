package com.sorrymommy.amos.parser;

import java.util.Map;

public abstract class BaseParser {
    abstract public Map<String, Object> parse(String xmlContent);
}
