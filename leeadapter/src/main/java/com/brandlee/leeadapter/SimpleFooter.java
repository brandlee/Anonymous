package com.brandlee.leeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @ClassName: SimpleFooter
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class SimpleFooter extends BaseFooter {
    private TextView loadMoreTv;
    private View containerView;

    public SimpleFooter(Context context, ViewGroup parent) {
        initView(context, parent);
    }

    public void initView(Context context, ViewGroup parent) {
        containerView = LayoutInflater.from(context).inflate(R.layout.lee_list_item_loadmore, parent, false);
        loadMoreTv = (TextView) containerView.findViewById(R.id.tv_load_more);
        containerView.setVisibility(View.GONE);
    }

    @Override
    public View getContainerView() {
        return containerView;
    }

    @Override
    public void setNoMoreDataView() {
        loadMoreTv.setText("没有更多了");
    }

    @Override
    public void setHasMoreDataView() {
        loadMoreTv.setText("加载更多...");
    }

    @Override
    public void setLoadMoreErrorView() {
        loadMoreTv.setText("加载失败");
    }

    @Override
    public void hideLoadMoreView() {
        containerView.setVisibility(View.GONE);
    }

    @Override
    public void showLoadMoreView() {
        containerView.setVisibility(View.VISIBLE);
    }
}
