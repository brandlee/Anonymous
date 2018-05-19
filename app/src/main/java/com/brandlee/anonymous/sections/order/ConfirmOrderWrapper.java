package com.brandlee.anonymous.sections.order;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseWrapper;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/19 1810
 */
public class ConfirmOrderWrapper extends BaseWrapper {
    public TextView mServiceTextView;

    public ConfirmOrderWrapper(View view) {
        super(view);
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
