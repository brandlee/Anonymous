package com.brandlee.anonymous.sections.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.entities.PayDetailEntity;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 2003
 */
public class PayDetailActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;
    private RecyclerView mRecyclerView;
    private PayDetailAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_detail);

        initToolbar();

        mRecyclerView = findViewById(R.id.recyclerview_order);
        LinearLayoutManager mManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new PayDetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<PayDetailEntity> mOrderList = new ArrayList<>();
        mOrderList.add(new PayDetailEntity());
        mOrderList.add(new PayDetailEntity());
        mAdapter.refreshData(mOrderList);
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("支付明细");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
