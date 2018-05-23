package com.brandlee.anonymous.sections.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/22 2012
 */
public class ChangeLoginPasswordActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private LinearLayout mTwoLayout;
    private View mTwoView;
    private EditText mOneEditText;
    private TextView mConfirmTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_password);
        initToolbar();

        mTwoLayout = findViewById(R.id.ll_layout_two);
        mTwoView = findViewById(R.id.view_layout_two);
        mTwoLayout.setVisibility(View.GONE);
        mTwoView.setVisibility(View.GONE);
        mOneEditText = findViewById(R.id.et_phone_number);
        mOneEditText.setHint("请输入原登录密码");
        mConfirmTextView = findViewById(R.id.tv_confirm);


        mConfirmTextView.setText("下一步");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangeLoginPasswordActivity.this, ChangeLoginPasswordStepTwoActivity.class));
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
