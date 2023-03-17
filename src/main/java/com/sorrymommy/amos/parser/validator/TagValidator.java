package com.sorrymommy.amos.parser.validator;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TagValidator {
    public static boolean validate(Document document, String[] tags) {
        for(String tag : tags){
            if (validate(document, tag) == false)
                return false;
        }

        return true;
    }

    public static boolean validate(Document document, String tag) {
        NodeList tempNodeList = document.getElementsByTagName(tag);

        if (tempNodeList == null)
            throw new RuntimeException(String.format("%s is null", tag));

        return true;
    }
}
