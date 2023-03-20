package com.sorrymommy.amos.model.normal;

public class AirmetItem {
    private String tmDate;
    private String icaoCode;
    private String airportName;
    private String stTm;
    private String edTm;
    private String airmetMsg;

    public String getTmDate() {
        return tmDate;
    }

    public void setTmDate(String tmDate) {
        this.tmDate = tmDate;
    }

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

    public String getStTm() {
        return stTm;
    }

    public void setStTm(String stTm) {
        this.stTm = stTm;
    }

    public String getEdTm() {
        return edTm;
    }

    public void setEdTm(String edTm) {
        this.edTm = edTm;
    }

    public String getAirmetMsg() {
        return airmetMsg;
    }

    public void setAirmetMsg(String airmetMsg) {
        this.airmetMsg = airmetMsg;
    }
}
