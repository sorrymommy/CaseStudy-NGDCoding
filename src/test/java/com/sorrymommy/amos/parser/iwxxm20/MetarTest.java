package com.sorrymommy.amos.parser.iwxxm20;

import com.sorrymommy.amos.model.iwxxm20.MetarItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MetarTest {
    @Test
    public void parse_OK_returnItemsValues(){
        com.sorrymommy.amos.parser.iwxxm20.MetarParser parser = new com.sorrymommy.amos.parser.iwxxm20.MetarParser();

        MetarItem item = parser.parse(xmlContent);

        Assertions.assertTrue(item.getMsgText().equals("METAR RKSI 190700Z 28005KT 250V320 2500 BR FEW005 07/04 Q1020 NOSIG="));
        Assertions.assertTrue(item.getPhenomenonTime().equals("2023-03-19T07:00:00Z"));
        Assertions.assertTrue(item.getFeatureOfInterest().equals("INCHEON INTERNATIONAL AIRPORT"));
        Assertions.assertEquals(item.getLatitude(), "37.28");
        Assertions.assertEquals(item.getLongitude(), "126.26");
        Assertions.assertEquals(item.getAltitude(), "7.0");
        Assertions.assertEquals(item.getAirTemperature(), 7);
        Assertions.assertEquals(item.getDewpointTemperature(), 4);
        Assertions.assertEquals(item.getAtmosphericPressure(), 1020);

        Assertions.assertTrue(item.getWindDirection().equals("280"));
        Assertions.assertTrue(item.getMaxWindSpeed() == 0);
        Assertions.assertTrue(item.getExtremeClockwiseWindDirection() == 320);
        Assertions.assertTrue(item.getExtremeCounterClockwiseWindDirection() == 250);
        Assertions.assertTrue(item.getAerodromeHorizontalVisibility().equals("02500"));
        Assertions.assertTrue(item.getAerodromeObservedCloudsAmount().equals("http://codes.wmo.int/bufr4/codeflag/0-20-008/1"));
        Assertions.assertTrue(item.getAerodromeObservedCloudsHeight().equals("500"));
        Assertions.assertTrue(item.getAerodromeObservedCloudsType().equals("http://codes.wmo.int/bufr4/codeflag/0-20-012/7"));
        Assertions.assertTrue(item.getPresentWeather().equals("http://codes.wmo.int/306/4678/BR"));
    }

    private static final String xmlContent = "<iwxxm:METAR xmlns:aixm=\"http://www.aixm.aero/schema/5.1.1\" xmlns:gml=\"http://www.opengis.net/gml/3.2\" xmlns:iwxxm=\"http://icao.int/iwxxm/2.0\" xmlns:metce=\"http://def.wmo.int/metce/2013\" xmlns:om=\"http://www.opengis.net/om/2.0\" xmlns:sams=\"http://www.opengis.net/samplingSpatial/2.0\" xmlns:sf=\"http://www.opengis.net/sampling/2.0\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" automatedStation=\"false\" gml:id=\"metar-RKSI-20230319070000Z\" permissibleUsage=\"OPERATIONAL\" status=\"NORMAL\" xsi:schemaLocation=\"http://icao.int/iwxxm/2.0 http://schemas.wmo.int/iwxxm/2.0/iwxxm.xsd http://def.wmo.int/metce/2013 http://schemas.wmo.int/metce/1.2/metce.xsd http://www.opengis.net/samplingSpatial/2.0 http://schemas.opengis.net/samplingSpatial/2.0/spatialSamplingFeature.xsd\">\n" +
            "<iwxxm:extension>\n" +
            "<msgText>METAR RKSI 190700Z 28005KT 250V320 2500 BR FEW005 07/04 Q1020 NOSIG=</msgText>\n" +
            "</iwxxm:extension>\n" +
            "<iwxxm:observation>\n" +
            "<om:OM_Observation gml:id=\"obs-RKSI-20230319070000Z\">\n" +
            "<om:type xlink:href=\"http://codes.wmo.int/49-2/observation-type/IWXXM/1.0/MeteorologicalAerodromeObservation\"/>\n" +
            "<om:phenomenonTime>\n" +
            "<gml:TimeInstant gml:id=\"ti-20230319070000Z\">\n" +
            "<gml:timePosition>2023-03-19T07:00:00Z</gml:timePosition>\n" +
            "</gml:TimeInstant>\n" +
            "</om:phenomenonTime>\n" +
            "<om:resultTime xlink:href=\"#ti-20230319070000Z\"/>\n" +
            "<om:procedure>\n" +
            "<metce:Process gml:id=\"p-49-2-metar\">\n" +
            "<gml:description>WMO No. 49 Volume 2 Meteorological Service for International Air Navigation APPENDIX 3 TECHNICAL SPECIFICATIONS RELATED TO METEOROLOGICAL OBSERVATIONS AND REPORTS</gml:description>\n" +
            "</metce:Process>\n" +
            "</om:procedure>\n" +
            "<om:observedProperty xlink:href=\"http://codes.wmo.int/49-2/observable-property/MeteorologicalAerodromeObservation\"/>\n" +
            "<om:featureOfInterest>\n" +
            "<sams:SF_SpatialSamplingFeature gml:id=\"sp-RKSI\">\n" +
            "<sf:type xlink:href=\"http://www.opengis.net/def/samplingFeatureType/OGC-OM/2.0/SF_SamplingPoint\"/>\n" +
            "<sf:sampledFeature>\n" +
            "<aixm:AirportHeliport gml:id=\"aerodrome-RKSI\">\n" +
            "<aixm:timeSlice>\n" +
            "<aixm:AirportHeliportTimeSlice gml:id=\"aerodrome-RKSI-ts\">\n" +
            "<gml:validTime/>\n" +
            "<aixm:interpretation>BASELINE</aixm:interpretation>\n" +
            "<aixm:designator>RKSI</aixm:designator>\n" +
            "<aixm:name>INCHEON INTERNATIONAL AIRPORT</aixm:name>\n" +
            "<aixm:locationIndicatorICAO>RKSI</aixm:locationIndicatorICAO>\n" +
            "</aixm:AirportHeliportTimeSlice>\n" +
            "</aixm:timeSlice>\n" +
            "</aixm:AirportHeliport>\n" +
            "</sf:sampledFeature>\n" +
            "<sams:shape>\n" +
            "<gml:Point axisLabels=\"Latitude Longitude Altitude\" gml:id=\"obs-point-RKSI\" srsName=\"http://www.opengis.net/def/crs/EPSG/0/4979\" uomLabels=\"deg deg m\">\n" +
            "<gml:pos>37.28 126.26 7.0</gml:pos>\n" +
            "</gml:Point>\n" +
            "</sams:shape>\n" +
            "</sams:SF_SpatialSamplingFeature>\n" +
            "</om:featureOfInterest>\n" +
            "<om:result>\n" +
            "<iwxxm:MeteorologicalAerodromeObservationRecord cloudAndVisibilityOK=\"false\" gml:id=\"observation-record-RKSI-20230319070000Z\">\n" +
            "<iwxxm:airTemperature uom=\"Cel\">7</iwxxm:airTemperature>\n" +
            "<iwxxm:dewpointTemperature uom=\"Cel\">4</iwxxm:dewpointTemperature>\n" +
            "<iwxxm:qnh uom=\"hPa\">1020</iwxxm:qnh>\n" +
            "<iwxxm:surfaceWind>\n" +
            "<iwxxm:AerodromeSurfaceWind variableWindDirection=\"false\">\n" +
            "<iwxxm:meanWindDirection uom=\"deg\">280</iwxxm:meanWindDirection>\n" +
            "<iwxxm:meanWindSpeed uom=\"[kn_i]\">005</iwxxm:meanWindSpeed>\n" +
            "<iwxxm:extremeClockwiseWindDirection uom=\"deg\">320</iwxxm:extremeClockwiseWindDirection>\n" +
            "<iwxxm:extremeCounterClockwiseWindDirection uom=\"deg\">250</iwxxm:extremeCounterClockwiseWindDirection>\n" +
            "</iwxxm:AerodromeSurfaceWind>\n" +
            "</iwxxm:surfaceWind>\n" +
            "<iwxxm:visibility>\n" +
            "<iwxxm:AerodromeHorizontalVisibility>\n" +
            "<iwxxm:prevailingVisibility uom=\"m\">02500</iwxxm:prevailingVisibility>\n" +
            "</iwxxm:AerodromeHorizontalVisibility>\n" +
            "</iwxxm:visibility>\n" +
            "<iwxxm:presentWeather xlink:href=\"http://codes.wmo.int/306/4678/BR\"/>\n" +
            "<iwxxm:cloud>\n" +
            "<iwxxm:AerodromeObservedClouds>\n" +
            "<iwxxm:layer>\n" +
            "<iwxxm:CloudLayer>\n" +
            "<iwxxm:amount xlink:href=\"http://codes.wmo.int/bufr4/codeflag/0-20-008/1\"/>\n" +
            "<iwxxm:base uom=\"[ft_i]\">500</iwxxm:base>\n" +
            "<iwxxm:cloudType xlink:href=\"http://codes.wmo.int/bufr4/codeflag/0-20-012/7\" xlink:title=\"Stratus\"/>\n" +
            "</iwxxm:CloudLayer>\n" +
            "</iwxxm:layer>\n" +
            "</iwxxm:AerodromeObservedClouds>\n" +
            "</iwxxm:cloud>\n" +
            "</iwxxm:MeteorologicalAerodromeObservationRecord>\n" +
            "</om:result>\n" +
            "</om:OM_Observation>\n" +
            "</iwxxm:observation>\n" +
            "<iwxxm:trendForecast>\n" +
            "<om:OM_Observation gml:id=\"trend-fcst-1\">\n" +
            "<om:type xlink:href=\"http://codes.wmo.int/49-2/observation-type/IWXXM/1.0/MeteorologicalAerodromeTrendForecast\"/>\n" +
            "<om:phenomenonTime xlink:href=\"#ti-20230319070000Z\"/>\n" +
            "<om:resultTime xlink:href=\"#ti-20230319070000Z\"/>\n" +
            "<om:procedure xlink:href=\"#p-49-2-metar\"/>\n" +
            "<om:observedProperty xlink:href=\"http://codes.wmo.int/49-2/observable-property/MeteorologicalAerodromeTrendForecast\"/>\n" +
            "<om:featureOfInterest xlink:href=\"#sp-RKSI\"/>\n" +
            "<om:result>\n" +
            "<iwxxm:MeteorologicalAerodromeTrendForecastRecord changeIndicator=\"NO_SIGNIFICANT_CHANGES\" cloudAndVisibilityOK=\"false\" gml:id=\"trend-fcst-record-1-20230319070000Z\"/>\n" +
            "</om:result>\n" +
            "</om:OM_Observation>\n" +
            "</iwxxm:trendForecast>\n" +
            "</iwxxm:METAR>";
}
