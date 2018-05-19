package com.brandlee.anonymous.sections.order;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseWrapper;
import com.brandlee.anonymous.common.widget.ExpandAnimation;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 1807
 */
public class UnfinishedOrderWrapper extends BaseWrapper {
    public TextView mGenerateCollapse;
    public TextView mConfirmCollapse;
    public LinearLayout mOrderGenerateInfoLayout;
    public LinearLayout mOrderConfirmInfoLayout;

    public UnfinishedOrderWrapper(View view) {
        super(view);
        mGenerateCollapse = view.findViewById(R.id.tv_collapse_expand);
        mConfirmCollapse = view.findViewById(R.id.tv_collapse_expand_confirm);
        mOrderGenerateInfoLayout = view.findViewById(R.id.layout_order_info_generation);
        mOrderConfirmInfoLayout = view.findViewById(R.id.layout_order_info_confirm);

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
    }
}
