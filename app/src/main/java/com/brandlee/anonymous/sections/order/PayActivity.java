package com.brandlee.anonymous.sections.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.common.widget.passwordinputdialog.PassWordDialog;
import com.brandlee.anonymous.common.widget.passwordinputdialog.impl.DialogCompleteListener;
import com.brandlee.anonymous.entities.OrderEntity;

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
                String money = mMoneyEditText.getText().toString();
                if (TextUtils.isEmpty(money)) {
                    Toast.makeText(PayActivity.this, "请输入支付金额", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Float.valueOf(money) < 23.0) {
                    Toast.makeText(PayActivity.this, "低于最低支付金额，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Float.valueOf(money) > 3000.0) {
                    Toast.makeText(PayActivity.this, "超出待支付金额，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }


                new PassWordDialog(PayActivity.this).setTitle("请输入交易密码")
                        .setMoney(money).setCompleteListener(new DialogCompleteListener() {
                    @Override
                    public void dialogCompleteListener(String money, String pwd) {
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        startActivity(OrderDetailActivity.getItent(PayActivity.this, OrderEntity.TYPE_COMPLETE));
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
