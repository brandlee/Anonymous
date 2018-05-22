package com.brandlee.anonymous.common;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.brandlee.anonymous.R;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/16 2104
 */
public class BaseToolbarWrapper {
    public View rootView;
    public View viewLeft;
    public ImageView ivLeft;
    public View viewRight;
    public TextView tvRight;
    public TextView tvTitle;

    public BaseToolbarWrapper(View view) {
        rootView = view;
        viewLeft = view.findViewById(R.id.ll_left);
        ivLeft = view.findViewById(R.id.iv_left);
        viewRight = view.findViewById(R.id.ll_right);
        tvRight = view.findViewById(R.id.tv_right);
        tvTitle = view.findViewById(R.id.tv_title);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }
}
