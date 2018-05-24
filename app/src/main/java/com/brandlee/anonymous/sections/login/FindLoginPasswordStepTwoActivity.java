package com.brandlee.anonymous.sections.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.utils.Constant;
import com.brandlee.anonymous.utils.SharedPrefsUtils;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/24 2202
 */
public class FindLoginPasswordStepTwoActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private EditText et_phone_number;
    private EditText et_confirm_password;
    private TextView mConfirmTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_login_password_step_two);

        et_phone_number = findViewById(R.id.et_phone_number);
        et_confirm_password = findViewById(R.id.et_confirm_password);

        mConfirmTextView = findViewById(R.id.tv_confirm);
        mConfirmTextView.setText("确认");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefsUtils.setBooleanPreference(FindLoginPasswordStepTwoActivity.this, Constant.LOGIN_STATUS, true);
                finish();
            }
        });
        initToolbar();
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("更改登录密码");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
