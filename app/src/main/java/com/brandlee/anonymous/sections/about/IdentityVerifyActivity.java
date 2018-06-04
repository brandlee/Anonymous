package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
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
 * @Date: 2018/05/21 1924
 */
public class IdentityVerifyActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;
    private TextView tv_identity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_verify);

        initToolbar();
        tv_identity = findViewById(R.id.tv_identity);
        tv_identity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(IdentityVerifyActivity.this);
                materialDialog.content("申请信用额度需通过申请人身份验证。请确保以下信息为您本人的真实信息。通过验证后将无法修改")
                        .btnText("知道了")
                        .show();
                materialDialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                materialDialog.dismiss();
                            }
                        });
            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("信用管理");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
