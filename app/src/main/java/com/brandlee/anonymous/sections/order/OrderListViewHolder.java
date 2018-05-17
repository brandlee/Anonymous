package com.brandlee.anonymous.sections.order;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1205
 */
public class OrderListViewHolder extends BaseViewHolder<OrderEntity> {
    public OrderListViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, OrderDetailActivity.class));
            }
        });
    }

    @Override
    public void renderData(@Nullable OrderEntity orderEntity) {

    }
}
