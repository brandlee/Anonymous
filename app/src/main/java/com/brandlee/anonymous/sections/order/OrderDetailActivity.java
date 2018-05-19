package com.brandlee.anonymous.sections.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.entities.OrderEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 2133
 */
public class OrderDetailActivity extends BaseActivity {
    public static final String PARAM_ORDER_TYPE = "param_order_type";
    private BaseToolbarWrapper mToolbar;

    private View mUnfinishedOrderLayout;
    private View mConfirmOrderLayout;
    private UnfinishedOrderWrapper mUnfinishedOrderWrapper;
    private ConfirmOrderWrapper mConfirmOrderWrapper;

    private TextView mUserAgreement;
    private TextView mPayDetailTextView;
    private TextView mConfirmTextView;

    private int orderType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        orderType = getIntent().getIntExtra(PARAM_ORDER_TYPE, OrderEntity.TYPE_WAIT_CONFIRM);

        initToolbar();

        initAgreement();

        initButton();

        mUnfinishedOrderLayout = findViewById(R.id.layout_unfinished_order);
        mConfirmOrderLayout = findViewById(R.id.layout_confirm_order);
        mUnfinishedOrderWrapper = new UnfinishedOrderWrapper(mUnfinishedOrderLayout);
        mConfirmOrderWrapper = new ConfirmOrderWrapper(mConfirmOrderLayout);

        if (orderType == OrderEntity.TYPE_WAIT_CONFIRM) {
            mConfirmOrderLayout.setVisibility(View.VISIBLE);
        } else {
            mUnfinishedOrderLayout.setVisibility(View.VISIBLE);
        }
    }

    private void initButton() {
        mPayDetailTextView = findViewById(R.id.tv_pay_detail);
        mConfirmTextView = findViewById(R.id.tv_confirm);

        if (orderType == OrderEntity.TYPE_WAIT_CONFIRM) {
            mPayDetailTextView.setVisibility(View.GONE);
            mConfirmTextView.setText("确认");
        } else if (orderType == OrderEntity.TYPE_WAIT_PAY) {
            mConfirmTextView.setText("支付");
        }

        mPayDetailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailActivity.this, PayDetailActivity.class));
            }
        });

        mConfirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailActivity.this, PayActivity.class));
            }
        });

    }

    private void initAgreement() {
        mUserAgreement = findViewById(R.id.tv_user_agreement);
        mUserAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("订单详情");
        mToolbar.viewRight.setVisibility(View.VISIBLE);
        mToolbar.tvRight.setText("查看协议");
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mToolbar.viewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public static Intent getItent(Context context, int orderType) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(PARAM_ORDER_TYPE, orderType);
        return intent;
    }
}
