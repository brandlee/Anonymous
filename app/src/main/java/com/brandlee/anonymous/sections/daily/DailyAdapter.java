package com.brandlee.anonymous.sections.daily;

import android.support.v7.widget.RecyclerView;

import com.brandlee.anonymous.entities.DailyEntity;
import com.brandlee.leeadapter.BaseAdapter;
import com.brandlee.leeadapter.BaseViewHolder;

/**
 * @ClassName: DailyAdapter
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class DailyAdapter extends BaseAdapter<DailyEntity> {
    public DailyAdapter(RecyclerView mRecyclerView) {
        super(mRecyclerView);
    }

    @Override
    protected int getAdapterLayout() {
        return 0;
    }

    @Override
    protected void bindData(BaseViewHolder holder, DailyEntity data) {

    }
}
