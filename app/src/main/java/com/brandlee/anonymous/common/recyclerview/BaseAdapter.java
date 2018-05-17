package com.brandlee.anonymous.common.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1126
 */
public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public ArrayList<T> mDataSource;
    public Context mContext;
    public LayoutInflater mInflater;

    public BaseAdapter(Context mContext) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        mDataSource = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        bindData(holder, position, mDataSource.get(position));
    }

    public abstract void bindData(VH holder, int position, T data);

    public void refreshData(Collection<T> list) {
        if (list != null) {
            mDataSource.clear();
            mDataSource.addAll(list);
        } else {
            mDataSource.clear();
        }
        notifyDataSetChanged();
    }

    public void addData(Collection<T> list) {
        if (list != null) {
            mDataSource.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void addData(int position, Collection<T> list) {
        if (list != null) {
            mDataSource.addAll(position, list);
            notifyDataSetChanged();
        }
    }
}
