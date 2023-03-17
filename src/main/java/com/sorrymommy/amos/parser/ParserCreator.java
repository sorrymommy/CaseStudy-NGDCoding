package com.sorrymommy.amos.parser;

import com.sorrymommy.amos.AMOSApiType;

public class ParserCreator {
    public static Parser create(AMOSApiType apiType){
        switch (apiType){
            case Metar:
                return new MetarParser();
            case Taf:
                return new TafParser();
            case Sigmet:
                return new SigmetParser();
            default:
                return null;
        }
    }
}
