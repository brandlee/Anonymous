package com.brandlee.anonymous.common.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @Description: 自定义ViewPager，支持设置横向滑动
 * @Link: https://stackoverflow.com/questions/9650265/how-do-disable-paging-by-swiping-with-finger-in-viewpager-but-still-be-able-to-s
 * @Author: liqi
 * @Date: 2017/08/22 1039
 */
public class SlidableViewPager extends ViewPager {

    private boolean enabled = false;
    private boolean hasScrollAnim = false;

    public SlidableViewPager(Context context) {
        super(context);
    }

    public SlidableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.enabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.enabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, hasScrollAnim);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setHasScrollAnim(boolean hasScrollAnim) {
        this.hasScrollAnim = hasScrollAnim;
    }
}