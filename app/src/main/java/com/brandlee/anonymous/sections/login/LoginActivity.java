package com.brandlee.anonymous.sections.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.utils.Constant;
import com.brandlee.anonymous.utils.SharedPrefsUtils;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/24 2051
 */
public class LoginActivity extends BaseActivity {

    private ImageView iv_close;
    private EditText et_phone_number;
    private EditText et_password;
    private TextView tv_forget_password;
    private TextView tv_login;
    private TextView tv_to_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iv_close = findViewById(R.id.iv_close);
        et_phone_number = findViewById(R.id.et_phone_number);
        et_password = findViewById(R.id.et_password);
        tv_forget_password = findViewById(R.id.tv_forget_password);
        tv_login = findViewById(R.id.tv_login);
        tv_to_register = findViewById(R.id.tv_to_register);

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, FindLoginPasswordActivity.class));
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefsUtils.setBooleanPreference(LoginActivity.this, Constant.LOGIN_STATUS, true);
                finish();
            }
        });

        tv_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
