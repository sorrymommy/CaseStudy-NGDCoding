package com.sorrymommy.amos.model.normal;

public class WrngItem {
    private String tm;
    private String icaoCode;
    private String airportName;
    private String wrngType;
    private String validTm1;

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
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

    public String getWrngType() {
        return wrngType;
    }

    public void setWrngType(String wrngType) {
        this.wrngType = wrngType;
    }

    public String getValidTm1() {
        return validTm1;
    }

    public void setValidTm1(String validTm1) {
        this.validTm1 = validTm1;
    }

    public String getValidTm2() {
        return validTm2;
    }

    public void setValidTm2(String validTm2) {
        this.validTm2 = validTm2;
    }

    public String getWrngMsg() {
        return wrngMsg;
    }

    public void setWrngMsg(String wrngMsg) {
        this.wrngMsg = wrngMsg;
    }

    private String validTm2;
    private String wrngMsg;
}
