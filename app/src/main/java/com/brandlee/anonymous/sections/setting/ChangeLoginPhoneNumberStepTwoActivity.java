package com.brandlee.anonymous.sections.setting;

import android.os.Bundle;
import android.os.CountDownTimer;
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
public class ChangeLoginPhoneNumberStepTwoActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private TextView mSendCodeTextView;
    private TextView mConfirmTextView;

    private MyCountDownTimer countDownTimer;  // 倒计时器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_phone_number_step_two);
        initToolbar();
        countDownTimer = new MyCountDownTimer(120000L, 1000L);

        mSendCodeTextView = findViewById(R.id.tv_send_code);
        mConfirmTextView = findViewById(R.id.tv_confirm);

        mSendCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangeLoginPhoneNumberStepTwoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("更改登录手机号");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
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
