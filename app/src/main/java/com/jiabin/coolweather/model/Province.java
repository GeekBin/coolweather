package com.jiabin.coolweather.model;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/3 16:22
 * @des 省份的信息表
 * @updateAuthor GeekBin
 * @updateDate $Data$
 * @updateDes ${TODO}$
 */
public class Province {
    private int id;
    private String provinceName;

    public Province() {
    }

    public String getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        ProvinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    private String ProvinceCode;
}
