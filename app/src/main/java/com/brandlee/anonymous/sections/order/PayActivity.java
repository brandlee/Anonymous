package com.brandlee.anonymous.sections.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.common.widget.passwordinputdialog.PassWordDialog;
import com.brandlee.anonymous.common.widget.passwordinputdialog.impl.DialogCompleteListener;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 2108
 */
public class PayActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;

    private EditText mMoneyEditText;
    private TextView mAllMoneyTextView;
    private TextView mPayTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initToolbar();

        mMoneyEditText = findViewById(R.id.et_money);
        mAllMoneyTextView = findViewById(R.id.tv_all_money);
        mPayTextView = findViewById(R.id.tv_to_pay);

        mAllMoneyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoneyEditText.setText("3000.00");
            }
        });

        mPayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PassWordDialog(PayActivity.this).setTitle("请输入交易密码")
                        .setSubTitle("到账金额(元)")
                        .setMoney("100.00").setCompleteListener(new DialogCompleteListener() {
                    @Override
                    public void dialogCompleteListener(String money, String pwd) {
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("支付");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
