package com.bw.fivemonth2.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 8:42
 * @Description: 用途：完成特定功能
 */
public class RetrofitUtil {
    private static RetrofitUtil instance;
    private final OkHttpClient okhttp;
    private final Retrofit retrofit;

    private RetrofitUtil(){
        okhttp = new OkHttpClient.Builder()
                .connectTimeout( 5, TimeUnit.SECONDS )
                .readTimeout( 5, TimeUnit.SECONDS )
                .addInterceptor( new HttpLoggingInterceptor().setLevel( HttpLoggingInterceptor.Level.BODY ) )
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl( "http://mobile.bwstudent.com/small/" )
                .client( okhttp )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
    }
    public static RetrofitUtil getInstance(){
        if (instance == null) {
            synchronized (RetrofitUtil.class){
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }
}
