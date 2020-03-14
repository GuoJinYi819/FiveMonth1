package com.bw.fivemonth1.net;

import com.bw.fivemonth1.bean.LoginBean;
import com.bw.fivemonth1.bean.RegisterBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 14:56
 * @Description: 用途：完成特定功能
 */
public interface ApiService {

    //登入
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<LoginBean> loginUser(@FieldMap Map<String,String> param);

    //注册
    @POST("user/v1/register")
    @FormUrlEncoded
    Observable<RegisterBean> registerUser(@FieldMap Map<String,String> param);

}
