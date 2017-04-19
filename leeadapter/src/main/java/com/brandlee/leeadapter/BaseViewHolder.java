package com.brandlee.leeadapter;

import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @ClassName: BaseViewHolder
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    private OnItemClickListener mOnItemClickListener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    };

    /**
     * 设置是否响应点击事件
     *
     * @param resId     响应点击事件的view id
     * @param clickable true响应点击事件， false不响应点击事件
     * @return
     */
    public BaseViewHolder setClickable(@IdRes int resId, boolean clickable) {
        View view = find(resId);
        if (view != null) {
            view.setOnClickListener(view == null ? null : mOnClickListener);
        }
        return this;
    }

    /**
     * 根据当前的id查找对应的view控件
     *
     * @param viewId view id
     * @param <T>    子view的具体类型
     * @return 返回当前id对应的子view控件，没有则返回null
     */
    @CheckResult
    public <T extends View> T find(@IdRes int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    public BaseViewHolder setText(@IdRes int resId, CharSequence text) {
        TextView textView = find(resId);
        if (textView != null) {
            textView.setText(text);
        }
        return this;
    }

    public BaseViewHolder setText(@IdRes int resId, @StringRes int stringId) {
        TextView textView = find(resId);
        if (textView != null) {
            textView.setText(stringId);
        }
        return this;
    }
}
