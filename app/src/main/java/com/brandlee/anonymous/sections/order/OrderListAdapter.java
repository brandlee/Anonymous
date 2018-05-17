package com.brandlee.anonymous.sections.order;

import android.content.Context;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseAdapter;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1203
 */
public class OrderListAdapter extends BaseAdapter<OrderEntity, OrderListViewHolder> {

    public OrderListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public OrderListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderListViewHolder(mInflater.inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void bindData(OrderListViewHolder holder, int position, OrderEntity data) {
        holder.renderData(data);
    }

}
