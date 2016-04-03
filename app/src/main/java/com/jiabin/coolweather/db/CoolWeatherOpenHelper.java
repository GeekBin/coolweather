package com.jiabin.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/3 16:09
 * @des 天气预报地区信息数据库，创建省份,城市和县表
 * @updateAuthor GeekBin
 * @updateDate $Data$
 * @updateDes ${TODO}$
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * 创建省份表
     */
    public static final String CREATE_PROVINCE = "create table Province(" + "id integer primary key autoincrement,"
            + "province_name text, "
            + "province_code text)";
    /**
     * 创建城市表
     */
    public static final String CREATE_CITY = "create table City(" + "id integer primary key autoincrement,"
            + "city_name text, "
            + "city_code text, "
            + "province_id integer)";
    /**
     * 创建国家表
     */
    public static final String CREATE_COUNTY = "create table County("
            + "county_name text, "
            + "county_code text, "
            + "city_id integer)";

    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建省表
        db.execSQL(CREATE_CITY);    //创建城市表
        db.execSQL(CREATE_COUNTY);  //创建县表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
