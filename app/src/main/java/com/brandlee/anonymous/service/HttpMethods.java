package com.brandlee.anonymous.service;

import com.brandlee.anonymous.entities.DailyEntity;
import com.brandlee.anonymous.entities.DataEntity;
import com.brandlee.anonymous.entities.SearchEntity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: HttpMethods
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class HttpMethods {
    public static final String BASE_URL = "http://gank.io/api/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private ContentService contentService;

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder().client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        contentService = retrofit.create(ContentService.class);
    }

    //获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取干货数据
     *
     * @param subscriber 由调用者传过来的观察者对象
     * @param category   类别
     * @param pagesize   请求数据个数
     * @param pagenum    页码
     */
    public void getData(Observer<DataEntity> subscriber, String category, String pagesize,
                        int pagenum) {
        contentService.getContent(category, pagesize, pagenum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 查询干货数据
     *
     * @param subscriber
     * @param keyword
     * @param category
     * @param pageindex
     */
    public void searchData(Observer<SearchEntity> subscriber, String keyword, String category, int pageindex) {
        contentService.search(category, keyword, pageindex)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取每日数据
     */
    public void getDailyData(Observer<DailyEntity> subscriber, int year, int month, int day) {
        contentService.getDaily(year, month, day)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }
}
