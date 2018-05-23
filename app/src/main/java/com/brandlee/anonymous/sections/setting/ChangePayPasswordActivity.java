package com.brandlee.anonymous.sections.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/23 1935
 */
public class ChangePayPasswordActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private EditText mOneEditText;
    private TextView mConfirmTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pay_password);
        initToolbar();

        mOneEditText = findViewById(R.id.et_phone_number);
        mOneEditText.setHint("请输入原支付密码");
        mConfirmTextView = findViewById(R.id.tv_confirm);


        mConfirmTextView.setText("下一步");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePayPasswordActivity.this, ChangePayPasswordStepTwoActivity.class));
                finish();
            }
        });

    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("更改支付密码");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
