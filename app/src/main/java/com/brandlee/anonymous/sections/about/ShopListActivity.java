package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.entities.ShopEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1457
 */
public class ShopListActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private RecyclerView mRecyclerview;
    private ShopListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        initToolbar();

        mRecyclerview = findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ShopListAdapter(this);
        mRecyclerview.setAdapter(mAdapter);

        List<ShopEntity> shopList = new ArrayList<>();
        shopList.add(new ShopEntity(ShopEntity.TYPE_AVALIABLE_AFTER_CERTIFICATED));
        shopList.add(new ShopEntity(ShopEntity.TYPE_EDIT));
        shopList.add(new ShopEntity(ShopEntity.TYPE_VERIFY_ING));
        shopList.add(new ShopEntity(ShopEntity.TYPE_VERIFY_FAILED));
        shopList.add(new ShopEntity(ShopEntity.TYPE_EMPTY));
        mAdapter.refreshData(shopList);
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("店铺");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
