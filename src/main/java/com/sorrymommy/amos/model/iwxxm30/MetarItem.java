package com.sorrymommy.amos.model.iwxxm30;

import java.util.Date;

public class MetarItem {
    private String msgText;
    private Date issueTime;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getAerodrome() {
        return aerodrome;
    }

    public void setAerodrome(String aerodrome) {
        this.aerodrome = aerodrome;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getAltitude() {
        return Altitude;
    }

    public void setAltitude(float altitude) {
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

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirectionBegin() {
        return windDirectionBegin;
    }

    public void setWindDirectionBegin(int windDirectionBegin) {
        this.windDirectionBegin = windDirectionBegin;
    }

    public int getWindDirectionEnd() {
        return windDirectionEnd;
    }

    public void setWindDirectionEnd(int windDirectionEnd) {
        this.windDirectionEnd = windDirectionEnd;
    }

    public int getAerodromeHorizontalVisibility() {
        return AerodromeHorizontalVisibility;
    }

    public void setAerodromeHorizontalVisibility(int aerodromeHorizontalVisibility) {
        AerodromeHorizontalVisibility = aerodromeHorizontalVisibility;
    }

    public String getAerodromeObservedCloudsAmount() {
        return AerodromeObservedCloudsAmount;
    }

    public void setAerodromeObservedCloudsAmount(String aerodromeObservedCloudsAmount) {
        AerodromeObservedCloudsAmount = aerodromeObservedCloudsAmount;
    }

    public float getAerodromeObservedCloudsHeight() {
        return AerodromeObservedCloudsHeight;
    }

    public void setAerodromeObservedCloudsHeight(float aerodromeObservedCloudsHeight) {
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

    private String aerodrome;
    private float Latitude;
    private float Longitude;
    private float Altitude;
    private int airTemperature;
    private int dewpointTemperature;
    private int atmosphericPressure;
    private String windDirection;
    private int windSpeed;
    private int windDirectionBegin;
    private int windDirectionEnd;
    private int AerodromeHorizontalVisibility;
    private String AerodromeObservedCloudsAmount;
    private float AerodromeObservedCloudsHeight;
    private String AerodromeObservedCloudsType;
    private String presentWeather;

}
