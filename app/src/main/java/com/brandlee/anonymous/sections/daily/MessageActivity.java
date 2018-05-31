package com.brandlee.anonymous.sections.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.entities.MessageEntity;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/30 2203
 */
public class MessageActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private RecyclerView recyclerview_msg;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        recyclerview_msg = findViewById(R.id.recyclerview_msg);

        initToolbar();

        recyclerview_msg.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessageAdapter(this);
        recyclerview_msg.setAdapter(messageAdapter);

        ArrayList<MessageEntity> list = new ArrayList<>();
        list.add(new MessageEntity());
        list.add(new MessageEntity());
        list.add(new MessageEntity());
        list.add(new MessageEntity());
        list.add(new MessageEntity());

        messageAdapter.refreshData(list);
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("我的信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
