package com.sorrymommy.amos.model.iwxxm20;

import java.util.Date;

public class MetarItem {
    private String msgText;
    private String phenomenonTime;
    private String featureOfInterest;
    private String Latitude;
    private String Longitude;
    private String Altitude;
    private int airTemperature;
    private int dewpointTemperature;
    private int atmosphericPressure;
    private String windDirection;
    private String windSpeed;
    private int maxWindSpeed;
    private int extremeClockwiseWindDirection;
    private int extremeCounterClockwiseWindDirection;
    private String AerodromeHorizontalVisibility;
    private String AerodromeObservedCloudsAmount;
    private String AerodromeObservedCloudsHeight;
    private String icaoCode;

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getPhenomenonTime() {
        return phenomenonTime;
    }

    public void setPhenomenonTime(String phenomenonTime) {
        this.phenomenonTime = phenomenonTime;
    }

    public String getFeatureOfInterest() {
        return featureOfInterest;
    }

    public void setFeatureOfInterest(String featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getAltitude() {
        return Altitude;
    }

    public void setAltitude(String altitude) {
        Altitude = altitude;
    }

    public int getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(int airTemperature) {
        this.airTemperature = airTemperature;
    }

    public int getDewpointTemperature() {
        return dewpointTemperature;
    }

    public void setDewpointTemperature(int dewpointTemperature) {
        this.dewpointTemperature = dewpointTemperature;
    }

    public int getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(int atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setMaxWindSpeed(int maxWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
    }

    public int getExtremeClockwiseWindDirection() {
        return extremeClockwiseWindDirection;
    }

    public void setExtremeClockwiseWindDirection(int extremeClockwiseWindDirection) {
        this.extremeClockwiseWindDirection = extremeClockwiseWindDirection;
    }

    public int getExtremeCounterClockwiseWindDirection() {
        return extremeCounterClockwiseWindDirection;
    }

    public void setExtremeCounterClockwiseWindDirection(int extremeCounterClockwiseWindDirection) {
        this.extremeCounterClockwiseWindDirection = extremeCounterClockwiseWindDirection;
    }

    public String getAerodromeHorizontalVisibility() {
        return AerodromeHorizontalVisibility;
    }

    public void setAerodromeHorizontalVisibility(String aerodromeHorizontalVisibility) {
        AerodromeHorizontalVisibility = aerodromeHorizontalVisibility;
    }

    public String getAerodromeObservedCloudsAmount() {
        return AerodromeObservedCloudsAmount;
    }

    public void setAerodromeObservedCloudsAmount(String aerodromeObservedCloudsAmount) {
        AerodromeObservedCloudsAmount = aerodromeObservedCloudsAmount;
    }

    public String getAerodromeObservedCloudsHeight() {
        return AerodromeObservedCloudsHeight;
    }

    public void setAerodromeObservedCloudsHeight(String aerodromeObservedCloudsHeight) {
        AerodromeObservedCloudsHeight = aerodromeObservedCloudsHeight;
    }

    public String getAerodromeObservedCloudsType() {
        return AerodromeObservedCloudsType;
    }

    public void setAerodromeObservedCloudsType(String aerodromeObservedCloudsType) {
        AerodromeObservedCloudsType = aerodromeObservedCloudsType;
    }

    public String getPresentWeather() {
        return presentWeather;
    }

    public void setPresentWeather(String presentWeather) {
        this.presentWeather = presentWeather;
    }

    private String AerodromeObservedCloudsType;
    private String presentWeather;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
