package com.jiabin.coolweather.model;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/3 16:24
 * @des 城市信息实体类
 * @updateAuthor GeekBin
 * @updateDate $Data$
 * @updateDes ${TODO}$
 */
public class City {
    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    private int id;
    private String cityName;
    private String cityCode;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    private int provinceId;
}
