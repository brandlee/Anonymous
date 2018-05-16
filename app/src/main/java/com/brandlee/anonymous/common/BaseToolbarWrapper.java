package com.brandlee.anonymous.common;

import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/16 2104
 */
public class BaseToolbarWrapper {
    public View viewLeft;
    public View viewRight;
    public TextView tvRight;
    public TextView tvTitle;

    public BaseToolbarWrapper(View view) {
        viewLeft = view.findViewById(R.id.ll_left);
        viewRight = view.findViewById(R.id.ll_right);
        tvRight = view.findViewById(R.id.tv_right);
        tvTitle = view.findViewById(R.id.tv_title);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }
}
