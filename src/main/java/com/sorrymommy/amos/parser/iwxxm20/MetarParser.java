package com.sorrymommy.amos.parser.iwxxm20;

import com.sorrymommy.amos.model.iwxxm20.MetarItem;
import com.sorrymommy.amos.parser.DocumentUtil;
import com.sorrymommy.amos.parser.util.DocumentLoader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class MetarParser {

    public static final String MSG_TEXT = "msgText";
    public static final String GML_TIME_POSITION = "gml:timePosition";
    public static final String AIXM_NAME = "aixm:name";
    public static final String GML_POS = "gml:pos";
    public static final String IWXXM_AIR_TEMPERATURE = "iwxxm:airTemperature";
    public static final String IWXXM_DEWPOINT_TEMPERATURE = "iwxxm:dewpointTemperature";
    public static final String IWXXM_QNH = "iwxxm:qnh";
    public static final String IWXXM_MEAN_WIND_DIRECTION = "iwxxm:meanWindDirection";
    public static final String IWXXM_MEAN_WIND_SPEED = "iwxxm:meanWindSpeed";
    public static final String IWXXM_WIND_GUST_SPEED = "iwxxm:windGustSpeed";
    public static final String IWXXM_EXTREME_CLOCKWISE_WIND_DIRECTION = "iwxxm:extremeClockwiseWindDirection";
    public static final String IWXXM_EXTREME_COUNTER_CLOCKWISE_WIND_DIRECTION = "iwxxm:extremeCounterClockwiseWindDirection";
    public static final String IWXXM_PREVAILING_VISIBILITY = "iwxxm:prevailingVisibility";
    public static final String IWXXM_AMOUNT = "iwxxm:amount";
    public static final String XLINK_HREF = "xlink:href";
    public static final String IWXXM_BASE = "iwxxm:base";
    public static final String IWXXM_CLOUD_TYPE = "iwxxm:cloudType";
    public static final String AIXM_LOCATION_INDICATOR_ICAO = "aixm:locationIndicatorICAO";
    public static final String IWXXM_PRESENT_WEATHER = "iwxxm:presentWeather";

    public MetarItem parse(String xmlContent) {
        try {
            return doParsing(xmlContent);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private MetarItem doParsing(String xmlContent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        String tempXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlContent;

        Document document = DocumentLoader.load(tempXml);

        MetarItem item = new MetarItem();

        String[] tempArray = DocumentUtil.getTagContent(document, GML_POS).split(" ");

        item.setLatitude(tempArray.length >= 1 ? tempArray[0] : "");
        item.setLongitude(tempArray.length >= 2 ? tempArray[1] : "");
        item.setAltitude(tempArray.length >= 3 ? tempArray[2] : "");

        item.setMsgText(DocumentUtil.getTagContent(document, MSG_TEXT) );
        item.setPhenomenonTime(DocumentUtil.getTagContent(document, GML_TIME_POSITION) );
        item.setFeatureOfInterest(DocumentUtil.getTagContent(document, AIXM_NAME) );

        item.setAirTemperature(DocumentUtil.getTagContentAsInt(document, IWXXM_AIR_TEMPERATURE) );
        item.setDewpointTemperature(DocumentUtil.getTagContentAsInt(document, IWXXM_DEWPOINT_TEMPERATURE) );
        item.setAtmosphericPressure(DocumentUtil.getTagContentAsInt(document, IWXXM_QNH) );
        item.setWindDirection(DocumentUtil.getTagContent(document, IWXXM_MEAN_WIND_DIRECTION) );
        item.setWindSpeed(DocumentUtil.getTagContent(document, IWXXM_MEAN_WIND_SPEED) );

        item.setMaxWindSpeed(DocumentUtil.getTagContentAsInt(document, IWXXM_WIND_GUST_SPEED) );
        item.setExtremeClockwiseWindDirection(DocumentUtil.getTagContentAsInt(document, IWXXM_EXTREME_CLOCKWISE_WIND_DIRECTION) );
        item.setExtremeCounterClockwiseWindDirection(DocumentUtil.getTagContentAsInt(document, IWXXM_EXTREME_COUNTER_CLOCKWISE_WIND_DIRECTION) );

        item.setAerodromeHorizontalVisibility(DocumentUtil.getTagContent(document, IWXXM_PREVAILING_VISIBILITY));

        item.setAerodromeObservedCloudsAmount(DocumentUtil.getAttribute(document, IWXXM_AMOUNT, XLINK_HREF));
        item.setAerodromeObservedCloudsHeight(DocumentUtil.getTagContent(document, IWXXM_BASE));
        item.setAerodromeObservedCloudsType(DocumentUtil.getAttribute(document, IWXXM_CLOUD_TYPE, XLINK_HREF));

        item.setIcaoCode(DocumentUtil.getTagContent(document, AIXM_LOCATION_INDICATOR_ICAO) );
        item.setPresentWeather(DocumentUtil.getAttribute(document, IWXXM_PRESENT_WEATHER, XLINK_HREF) );

        return item;
    }
}
