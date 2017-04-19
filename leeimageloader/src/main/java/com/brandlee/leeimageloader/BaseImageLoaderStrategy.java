package com.brandlee.leeimageloader;

import android.support.annotation.IdRes;
import android.widget.ImageView;

/**
 * @ClassName: BaseImageLoaderStrategy
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public interface BaseImageLoaderStrategy {
    /**
     * 加载图片无占位图
     *
     * @param imageView
     * @param url
     */
    void loadImage(ImageView imageView, String url);

    /**
     * 加载图片有占位图
     *
     * @param imageView
     * @param url
     * @param placeholder
     */
    void loadImage(ImageView imageView, String url, @IdRes int placeholder);

}
