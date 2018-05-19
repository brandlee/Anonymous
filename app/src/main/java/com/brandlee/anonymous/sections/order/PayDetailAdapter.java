package com.brandlee.anonymous.sections.order;

import android.content.Context;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseAdapter;
import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.PayDetailEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 2017
 */
public class PayDetailAdapter extends BaseAdapter<PayDetailEntity, BaseViewHolder> {
    public PayDetailAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public void bindData(BaseViewHolder holder, int position, PayDetailEntity data) {

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PayDetailViewHolder(mInflater.inflate(R.layout.item_pay_detail, parent, false));
    }
}
