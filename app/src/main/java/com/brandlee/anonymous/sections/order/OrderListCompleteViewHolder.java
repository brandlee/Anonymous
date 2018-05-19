package com.brandlee.anonymous.sections.order;

import android.support.annotation.Nullable;
import android.view.View;

import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 1843
 */
public class OrderListCompleteViewHolder extends BaseViewHolder<OrderEntity> {
    public OrderListCompleteViewHolder(final View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemView.getTag() != null)
                    mContext.startActivity(OrderDetailActivity.getItent(mContext, (int) itemView.getTag()));
            }
        });
    }

    @Override
    public void renderData(@Nullable OrderEntity orderEntity) {
        if (orderEntity != null) {
            itemView.setTag(orderEntity.orderType);
        }
    }
}
