package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 1642
 */
public class CreditManagementActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private LinearLayout mContainerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_management);

        initToolbar();

        mContainerLayout = findViewById(R.id.ll_manager_container);

        mContainerLayout.removeAllViews();
        View userInfoView = View.inflate(this, R.layout.layout_credit_manger_user_info, null);
        CMUserInfoWrapper cmUserInfoWrapper = new CMUserInfoWrapper(userInfoView);
        mContainerLayout.addView(userInfoView);
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.rootView.setBackgroundResource(0);
        mToolbar.ivLeft.setImageResource(R.drawable.icon_arrow_left_white);
        mToolbar.setTitle("信用管理");
        mToolbar.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.white));
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
