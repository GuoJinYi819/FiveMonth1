package com.bw.fivemonth1.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.fivemonth1.App;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:38
 * @Description: 用途：完成特定功能
 */
public class SpUtil {
    //单例
    private static SpUtil instance;
    private final SharedPreferences sp;
    public static final String SP_USERID = "userId";
    public static final String SP_SESSIONID = "sessionId";
    private final SharedPreferences.Editor edit;

    private SpUtil(){
        sp = App.context.getSharedPreferences( "sp", Context.MODE_PRIVATE );
        edit = sp.edit();
    }
    public static SpUtil getInstance(){
        if (instance == null) {
            synchronized (SpUtil.class){
                if (instance == null) {
                    instance = new SpUtil();
                }
            }
        }
        return instance;
    }

    //存
    public void setData(String key,String value){
        edit.putString( key,value );
        edit.commit();
    }
    public void setData(String key,int value){
        edit.putInt( key,value );
        edit.commit();
    }

    //取
    public String getSesstion(String key){
        String str = sp.getString( key, "" );
        return str;
    }

    public int getUserId(String key){
        int anInt = sp.getInt( key, 0 );
        return anInt;
    }
}
