package com.bw.fivemonth2.net;

import com.bw.fivemonth2.bean.LoginBean;
import com.bw.fivemonth2.bean.RegisterBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 8:46
 * @Description: 用途：完成特定功能
 */
public interface ApiService {
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<LoginBean> loginUser(@FieldMap Map<String,String> param);

    @POST("user/v1/register")
    @FormUrlEncoded
    Observable<RegisterBean> registerUser(@FieldMap Map<String,String> param);
}
