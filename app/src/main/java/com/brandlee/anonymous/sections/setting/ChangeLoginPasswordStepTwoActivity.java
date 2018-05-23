package com.brandlee.anonymous.sections.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/22 2012
 */
public class ChangeLoginPasswordStepTwoActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private TextView mConfirmTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_password);
        initToolbar();

        mConfirmTextView = findViewById(R.id.tv_confirm);

        mConfirmTextView.setText("确认");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangeLoginPasswordStepTwoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

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
