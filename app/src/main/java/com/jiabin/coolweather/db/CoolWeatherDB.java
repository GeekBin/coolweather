package com.jiabin.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jiabin.coolweather.model.City;
import com.jiabin.coolweather.model.County;
import com.jiabin.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/3 16:30
 * @des 封装一些常用的数据操作
 * @updateAuthor GeekBin
 * @updateDate $Data$
 * @updateDes ${TODO}$
 */
public class CoolWeatherDB {
    /**
     * 数据库名
     */
    public static final String DB_NAME = "cool_weather";

    /**
     * 数据库版本
     */
    public static final int VERSION = 1;

    private static CoolWeatherDB mCoolWeatherDB;
    private SQLiteDatabase mDatabase;

    /**
     * 私有化构造方法,得到
     */
    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        mDatabase = dbHelper.getWritableDatabase();
    }

    /**
     * 获取CoolWeatherDB的实例
     */
    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (mCoolWeatherDB == null) {
            mCoolWeatherDB = new CoolWeatherDB(context);
        }
        return mCoolWeatherDB;
    }

    /**
     * 将省份信息存储到数据库
     */

    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            mDatabase.insert("Province", null, values);
        }
    }

    /**
     * 从数据库中读取所有省份的信息
     */

    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<>();
        Cursor cursor = mDatabase.query("Province", null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 将城市实例存储到数据库
     */
    public void saveCity(City city) {
        if (city == null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            values.put("province_id", city.getProvinceId());
            mDatabase.insert("City", null, values);
        }
    }

    /**
     * 根据省份查询城市信息
     */

    public List<City> loadCities(int provinceId) {
        List<City> list = new ArrayList<>();
        Cursor cursor = mDatabase.query("City", null, "province_id = ?", new String[]{String.valueOf(provinceId)},
                null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                list.add(city);
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 将县的信息保存到数据库
     */
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            values.put("city_id", county.getCityId());
            mDatabase.insert("County", null, values);
        }
    }

    /**
     * 根据城市查询下属的县级信息
     */
    public List<County> loadCounty(int cityId) {
        List<County> list = new ArrayList<>();
        Cursor cursor = mDatabase.query("County", null, "city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);
        if(cursor!=null)
        {
            while (cursor.moveToNext()){
                County county=new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cityId);
                list.add(county);
            }
            cursor.close();
        }
        return list;
    }
}
