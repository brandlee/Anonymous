package com.brandlee.anonymous.sections.order;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseWrapper;
import com.brandlee.anonymous.common.widget.ExpandAnimation;
import com.brandlee.anonymous.entities.OrderEntity;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 1807
 */
public class UnfinishedOrderWrapper extends BaseWrapper {
    public TextView mGenerateCollapse;
    public TextView mConfirmCollapse;
    public TextView tv_complete_time;
    public ImageView iv_order_status;
    public LinearLayout mOrderGenerateInfoLayout;
    public LinearLayout mOrderConfirmInfoLayout;
    public TextView mServiceTextView;

    public UnfinishedOrderWrapper(View view, int orderType) {
        super(view);
        mGenerateCollapse = view.findViewById(R.id.tv_collapse_expand);
        mConfirmCollapse = view.findViewById(R.id.tv_collapse_expand_confirm);
        tv_complete_time = view.findViewById(R.id.tv_complete_time);
        iv_order_status = view.findViewById(R.id.iv_order_status);
        mOrderGenerateInfoLayout = view.findViewById(R.id.layout_order_info_generation);
        mOrderConfirmInfoLayout = view.findViewById(R.id.layout_order_info_confirm);

        if (orderType == OrderEntity.TYPE_WAIT_PAY) {
            tv_complete_time.setVisibility(View.GONE);
            mOrderConfirmInfoLayout.setVisibility(View.GONE);
        } else {
            iv_order_status.setImageResource(R.drawable.icon_order_complete);
        }

        mGenerateCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpandAnimation animation = new ExpandAnimation(mGenerateCollapse, mOrderGenerateInfoLayout, 500);
                mOrderGenerateInfoLayout.startAnimation(animation);
            }
        });

        mConfirmCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpandAnimation animation = new ExpandAnimation(mConfirmCollapse, mOrderConfirmInfoLayout, 500);
                mOrderConfirmInfoLayout.startAnimation(animation);
            }
        });

        mServiceTextView = view.findViewById(R.id.tv_service);
        mServiceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(mContext);
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
                                mContext.startActivity(intent);
                                materialDialog.dismiss();
                            }
                        });
            }
        });
    }
}
