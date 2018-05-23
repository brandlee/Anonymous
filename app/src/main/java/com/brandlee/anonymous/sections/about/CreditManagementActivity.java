package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private LinearLayout ll_user_info;
    private LinearLayout ll_service_agreement;
    private LinearLayout ll_material_verify;

    private TextView tv_user_info;
    private TextView tv_service_agreement;
    private TextView tv_material_verify;

    private View tab_user_info;
    private View tab_service_agreement;
    private View tab_material_verify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_management);

        initToolbar();

        mContainerLayout = findViewById(R.id.ll_manager_container);

        ll_user_info = findViewById(R.id.ll_user_info);
        ll_service_agreement = findViewById(R.id.ll_service_agreement);
        ll_material_verify = findViewById(R.id.ll_material_verify);

        tv_user_info = findViewById(R.id.tv_user_info);
        tv_service_agreement = findViewById(R.id.tv_service_agreement);
        tv_material_verify = findViewById(R.id.tv_material_verify);

        tab_user_info = findViewById(R.id.tab_user_info);
        tab_service_agreement = findViewById(R.id.tab_service_agreement);
        tab_material_verify = findViewById(R.id.tab_material_verify);

        mContainerLayout.removeAllViews();
        View userInfoView = View.inflate(this, R.layout.layout_credit_manger_user_info, null);
        CMUserInfoWrapper cmUserInfoWrapper = new CMUserInfoWrapper(userInfoView);
        mContainerLayout.addView(userInfoView);

        tab_service_agreement.setVisibility(View.INVISIBLE);
        tab_material_verify.setVisibility(View.INVISIBLE);

        ll_user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab_user_info.setVisibility(View.VISIBLE);
                tab_service_agreement.setVisibility(View.INVISIBLE);
                tab_material_verify.setVisibility(View.INVISIBLE);

                mContainerLayout.removeAllViews();
                View userInfoView = View.inflate(CreditManagementActivity.this, R.layout.layout_credit_manger_user_info, null);
                CMUserInfoWrapper cmUserInfoWrapper = new CMUserInfoWrapper(userInfoView);
                mContainerLayout.addView(userInfoView);
            }
        });

        ll_service_agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab_user_info.setVisibility(View.INVISIBLE);
                tab_service_agreement.setVisibility(View.VISIBLE);
                tab_material_verify.setVisibility(View.INVISIBLE);

                mContainerLayout.removeAllViews();
                View userInfoView = View.inflate(CreditManagementActivity.this, R.layout.layout_credit_manger_service_agreement, null);
                mContainerLayout.addView(userInfoView);
            }
        });

        ll_material_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab_user_info.setVisibility(View.INVISIBLE);
                tab_service_agreement.setVisibility(View.INVISIBLE);
                tab_material_verify.setVisibility(View.VISIBLE);

                mContainerLayout.removeAllViews();
                View userInfoView = View.inflate(CreditManagementActivity.this, R.layout.layout_credit_manager_material_wait_verify, null);
                mContainerLayout.addView(userInfoView);
            }
        });
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
