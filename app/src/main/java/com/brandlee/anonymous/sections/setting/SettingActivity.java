package com.brandlee.anonymous.sections.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.utils.Constant;
import com.brandlee.anonymous.utils.SharedPrefsUtils;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/14 2207
 */
public class SettingActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private LinearLayout mChangeLoginPasswordLayout;
    private LinearLayout mChangeLoginPhoneNumberLayout;
    private LinearLayout mChangePayPasswordLayout;
    private LinearLayout mAuthLayout;

    private TextView tv_logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initToolbar();

        mChangeLoginPasswordLayout = findViewById(R.id.ll_change_login_password);
        mChangeLoginPhoneNumberLayout = findViewById(R.id.ll_change_login_phone_number);
        mChangePayPasswordLayout = findViewById(R.id.ll_change_pay_password);
        mAuthLayout = findViewById(R.id.ll_auth);

        tv_logout = findViewById(R.id.tv_logout);

        mChangeLoginPasswordLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ChangeLoginPasswordActivity.class));
            }
        });

        mChangeLoginPhoneNumberLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ChangeLoginPhoneNumberActivity.class));
            }
        });

        mChangePayPasswordLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ChangePayPasswordActivity.class));
            }
        });

        mAuthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, AuthorizationActivity.class));
            }
        });

        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefsUtils.setBooleanPreference(SettingActivity.this, Constant.LOGIN_STATUS, false);
                Toast.makeText(SettingActivity.this, "退出登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("设置");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
