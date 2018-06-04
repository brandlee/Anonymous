package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 2131
 */
public class BankCardInfoStepTwoActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private TextView mSendCodeTextView;
    private MyCountDownTimer countDownTimer;  // 倒计时器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card_info_step_two);
        countDownTimer = new MyCountDownTimer(120000L, 1000L);
        mSendCodeTextView = findViewById(R.id.tv_send_code);
        mSendCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

        initToolbar();
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("银行卡信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
