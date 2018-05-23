package com.brandlee.anonymous.sections.order;

import android.support.annotation.Nullable;
import android.view.View;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1205
 */
public class OrderListViewHolder extends BaseViewHolder<OrderEntity> {
    public OrderListViewHolder(final View itemView) {
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
            if (orderEntity.orderType == OrderEntity.TYPE_WAIT_CONFIRM) {
                setText(R.id.tv_order_status, "待确认");
                setVisible(R.id.tv_due, false);
                setVisible(R.id.tv_due_date, false);
                setVisible(R.id.tv_total,false);
            } else if (orderEntity.orderType == OrderEntity.TYPE_WAIT_PAY) {
                setText(R.id.tv_order_status, "待支付");
                setVisible(R.id.tv_due, true);
                setVisible(R.id.tv_due_date, true);
                setVisible(R.id.tv_total,true);
            }
        }
    }
}
