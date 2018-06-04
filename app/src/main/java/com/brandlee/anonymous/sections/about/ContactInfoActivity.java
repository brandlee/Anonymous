package com.brandlee.anonymous.sections.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 2055
 */
public class ContactInfoActivity extends BaseActivity {
    private BaseToolbarWrapper mToolbar;
    private TextView mRelationTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        mRelationTextView = findViewById(R.id.tv_marriage);
        mRelationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relationActionSheetDialog();
            }
        });
        initToolbar();
    }

    private void relationActionSheetDialog() {
        final String[] stringItems = {
                "父母",
                "配偶",
                "子女"};
        final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, null);
        dialog.title("与法人关系")
                .titleTextSize_SP(14.5f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                mRelationTextView.setText(stringItems[position]);
                dialog.dismiss();
            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("联系人信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
