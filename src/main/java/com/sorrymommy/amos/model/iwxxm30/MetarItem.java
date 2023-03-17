package com.sorrymommy.amos.model.iwxxm30;

import java.util.Date;

public class MetarItem {
    private String icaoCode;
    private String airportName;
    private String metarMsg;
    private String phenomenonTime;
    private Date featureOfInterest;
    private float Latitude;
    private float Longitude;
    private float Altitude;
    private float airTemperature;
    private float dewpointTemperature;
    private float atmosphericPressure;
    private float windDirection;
    private float windSpeed;
    private float maxWindSpeed;
    private float windDirectionBegin;
    private float windDirectionEnd;
    private int visibility;
    private String cloudAmount;
    private float cloudHeight;
    private String cloudType;
    private String presentWeather;

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getMetarMsg() {
        return metarMsg;
    }

    public void setMetarMsg(String metarMsg) {
        this.metarMsg = metarMsg;
    }
}
