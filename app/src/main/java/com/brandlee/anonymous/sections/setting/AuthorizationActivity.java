package com.brandlee.anonymous.sections.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 1547
 */
public class AuthorizationActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;
    private LinearLayout mAuthContainerLayout;
    private TextView mAuthTextView;
    private TextView mAuthFinishTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        initToolbar();

        mAuthContainerLayout = findViewById(R.id.ll_auth_container);

        mAuthTextView = findViewById(R.id.tv_auth);
        mAuthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthContainerLayout.setVisibility(View.GONE);
                mAuthFinishTextView.setVisibility(View.VISIBLE);
            }
        });

        mAuthFinishTextView = findViewById(R.id.tv_auth_finish);
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("新商盟授权");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
