package com.brandlee.anonymous.sections.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/24 2035
 */
public class LoginSplashActivity extends BaseActivity {
    private TextView tv_to_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_splash);

        tv_to_login = findViewById(R.id.tv_to_login);

        tv_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSplashActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
