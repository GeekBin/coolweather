package com.jiabin.coolweather.model;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/3 16:26
 * @des 县级单位信息表
 * @updateAuthor GeekBin
 * @updateDate $Data$
 * @updateDes ${TODO}$
 */
public class County {
    public County() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;
}
