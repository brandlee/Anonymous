package com.brandlee.leeadapter;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * @ClassName: OnItemClickListener
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public interface OnItemClickListener {
    /**
     * 响应点击事件监听回调
     *
     * @param view     响应事件的view
     * @param position item所在的位置
     */
    void onItemClick(@NonNull View view, int position);
}
