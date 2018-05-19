package com.brandlee.anonymous.common;

import android.content.Context;
import android.view.View;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 1808
 */
public abstract class BaseWrapper {

    public View mRootView;
    public Context mContext;

    public BaseWrapper(View view) {
        mRootView = view;
        mContext = view.getContext();
    }
}
