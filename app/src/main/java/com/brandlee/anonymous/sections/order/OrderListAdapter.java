package com.brandlee.anonymous.sections.order;

import android.content.Context;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseAdapter;
import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1203
 */
public class OrderListAdapter extends BaseAdapter<OrderEntity, BaseViewHolder> {

    public OrderListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSource.get(position).orderType;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == OrderEntity.TYPE_COMPLETE) {
            return new OrderListCompleteViewHolder(mInflater.inflate(R.layout.item_order_complete, parent, false));
        }
        return new OrderListViewHolder(mInflater.inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void bindData(BaseViewHolder holder, int position, OrderEntity data) {
        holder.renderData(data);
    }

}
