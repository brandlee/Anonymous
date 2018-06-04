package com.brandlee.anonymous.sections.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/24 2147
 */
public class FindLoginPasswordActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private TextView mSendCodeTextView;
    private TextView mConfirmTextView;
    private TextView tv_service;

    private MyCountDownTimer countDownTimer;  // 倒计时器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_login_password);
        countDownTimer = new MyCountDownTimer(120000L, 1000L);
        mSendCodeTextView = findViewById(R.id.tv_send_code);
        mSendCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

        mConfirmTextView = findViewById(R.id.tv_confirm);
        tv_service = findViewById(R.id.tv_service);
        mConfirmTextView.setText("下一步");
        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindLoginPasswordActivity.this, FindLoginPasswordStepTwoActivity.class));
                finish();
            }
        });

        tv_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(FindLoginPasswordActivity.this);
                materialDialog.content("400-111-2345")
                        .btnText("放弃", "拨打")
                        .show();
                materialDialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                materialDialog.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "400-111-2345"));
                                startActivity(intent);
                                materialDialog.dismiss();
                            }
                        });
            }
        });

        initToolbar();
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("找回登录密码");
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
