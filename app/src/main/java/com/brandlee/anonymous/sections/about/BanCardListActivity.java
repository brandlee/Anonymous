package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.sections.login.FindLoginPasswordActivity;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1308
 */
public class BanCardListActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;
    private TextView tv_user_agreement;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bank_card_list);

        tv_user_agreement=findViewById(R.id.tv_user_agreement);
        tv_user_agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(BanCardListActivity.this);
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
        mToolbar.setTitle("银行卡信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
