package com.brandlee.leeimageloader;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * @ClassName: GlideImageLoaderStrategy
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy {

    @Override
    public void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .dontAnimate()
                .placeholder(imageView.getDrawable())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, Uri uri) {
        Glide.with(imageView.getContext())
                .load(uri)
                .dontAnimate()
                .placeholder(imageView.getDrawable())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, String url, @IdRes int placeholder) {
        Glide.with(imageView.getContext())
                .load(url)
                .dontAnimate()
                .placeholder(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
