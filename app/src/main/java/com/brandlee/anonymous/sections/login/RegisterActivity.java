package com.brandlee.anonymous.sections.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/24 2121
 */
public class RegisterActivity extends BaseActivity {

    private ImageView iv_close;
    private EditText et_phone_number;
    private EditText et_code;
    private TextView mSendCodeTextView;
    private TextView mConfirmTextView;
    private TextView tv_to_login;

    private MyCountDownTimer countDownTimer;  // 倒计时器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        countDownTimer = new MyCountDownTimer(120000L, 1000L);

        iv_close = findViewById(R.id.iv_close);
        et_phone_number = findViewById(R.id.et_phone_number);
        et_code = findViewById(R.id.et_code);
        mSendCodeTextView = findViewById(R.id.tv_send_code);
        mConfirmTextView = findViewById(R.id.tv_next_step);
        tv_to_login = findViewById(R.id.tv_to_login);

        mSendCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_phone_number.getText())) {
                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                countDownTimer.start();
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mConfirmTextView.setText("下一步");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_phone_number.getText())) {
                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(et_code.getText())) {
                    Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(RegisterActivity.this, RegisterStepTwoActivity.class));
                finish();
            }
        });

        tv_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    /**
     * @Description:计时器类
     * @return (返回值描述)
     */
    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            int countdown = (int) (l / 1000);
            mSendCodeTextView.setText(countdown + "s后重发");
            mSendCodeTextView.setBackgroundResource(R.drawable.shape_light_gray2_solid_radius_2);
            mSendCodeTextView.setEnabled(false);
        }

        @Override
        public void onFinish() {
            mSendCodeTextView.setText("重新发送");
            mSendCodeTextView.setBackgroundResource(R.drawable.shape_blue_solid_radius_2);
            mSendCodeTextView.setEnabled(true);
        }
    }
}
