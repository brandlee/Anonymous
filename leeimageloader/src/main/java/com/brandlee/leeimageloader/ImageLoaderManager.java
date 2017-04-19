package com.brandlee.leeimageloader;

import android.support.annotation.IdRes;
import android.widget.ImageView;

/**
 * @ClassName: ImageLoaderManager
 * @Description: 图片加载管理类
 * @Author liqi1
 * @Date 17/4/19
 */

public class ImageLoaderManager implements BaseImageLoaderStrategy {
    private static final ImageLoaderManager INSTANCE = new ImageLoaderManager();

    private BaseImageLoaderStrategy imageLoaderStrategy;

    private ImageLoaderManager() {
        // 默认使用Glide
        imageLoaderStrategy = new GlideImageLoaderStrategy();
    }

    public static ImageLoaderManager getInstance() {
        return INSTANCE;
    }

    /**
     * 策略模式的注入操作，实时替换图片加载策略
     *
     * @param imageLoaderStrategy
     */
    public void setImageLoaderStrategy(BaseImageLoaderStrategy imageLoaderStrategy) {
        if (imageLoaderStrategy != null) {
            this.imageLoaderStrategy = imageLoaderStrategy;
        }
    }

    @Override
    public void loadImage(ImageView imageView, String url) {
        imageLoaderStrategy.loadImage(imageView, url);
    }

    @Override
    public void loadImage(ImageView imageView, String url, @IdRes int placeholder) {
        imageLoaderStrategy.loadImage(imageView, url, placeholder);
    }
}
