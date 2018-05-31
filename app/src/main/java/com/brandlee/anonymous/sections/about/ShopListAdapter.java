package com.brandlee.anonymous.sections.about;

import android.content.Context;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseAdapter;
import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.ShopEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1500
 */
public class ShopListAdapter extends BaseAdapter<ShopEntity, BaseViewHolder> {
    public ShopListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSource.get(position).type;
    }

    @Override
    public void bindData(BaseViewHolder holder, int position, ShopEntity data) {
        holder.renderData(data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ShopEntity.TYPE_EMPTY)
            return new ShopListEmptyViewHolder(mInflater.inflate(R.layout.item_shop_empty, parent, false));
        return new ShopListViewHolder(mInflater.inflate(R.layout.item_shop, parent, false));
    }
}
