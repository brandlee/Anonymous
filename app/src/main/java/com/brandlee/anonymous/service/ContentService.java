package com.brandlee.anonymous.service;

import com.brandlee.anonymous.entities.DailyEntity;
import com.brandlee.anonymous.entities.DataEntity;
import com.brandlee.anonymous.entities.SearchEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @ClassName: ContentService
 * @Description: 请求接口
 * @Author liqi1
 * @Date 17/4/18
 */

public interface ContentService {
/* category:  福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * pagesize： 数字，大于0
     * pagenum ： 数字，大于0 */

    @GET("data/{category}/{pagesize}/{pagenum}")
    Observable<DataEntity> getContent(
            @Path("category") String category, @Path("pagesize") String pagesize,
            @Path("pagenum") int pagenum);

    /**
     * 获取某天的干货
     */
    @GET("day/{date}")
    Observable<DataEntity> getRecentlyGanHuo(@Path("date") String date);

    /**
     * 搜索
     */
    @GET("search/query/{keyword}/category/{category}/count/20/page/{pageIndex}")
    Observable<SearchEntity> search(@Path("category") String category, @Path("keyword") String keyword,
                                    @Path("pageIndex") int pageIndex);

    @GET("history/content/10/{pageIndex}")
    Observable<DataEntity> getRecently(
            @Path("pageIndex") int pageIndex);

    /**
     * @param year  year
     * @param month month
     * @param day   day
     * @return Observable<GankDaily>
     */
    @GET("day/{year}/{month}/{day}")
    Observable<DailyEntity> getDaily(@Path("year") int year,
                                     @Path("month") int month, @Path("day") int day);
}
