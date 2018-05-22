package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseWrapper;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 1940
 */
public class CMUserInfoWrapper extends BaseWrapper {
    public RelativeLayout mIdentityVerifyLayout;
    public RelativeLayout mPersonalInfoLayout;
    public RelativeLayout mShopInfoLayout;
    public RelativeLayout mBankCardInfoLayout;
    public RelativeLayout mContactInfoLayout;

    public CMUserInfoWrapper(View view) {
        super(view);
        mIdentityVerifyLayout = view.findViewById(R.id.rl_identity_verify);
        mPersonalInfoLayout = view.findViewById(R.id.rl_personal_info);
        mShopInfoLayout = view.findViewById(R.id.rl_shop_info);
        mBankCardInfoLayout = view.findViewById(R.id.rl_bank_card_info);
        mContactInfoLayout = view.findViewById(R.id.rl_contact_info);

        mIdentityVerifyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, IdentityVerifyActivity.class));
            }
        });

        mPersonalInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, PersonalInfoActivity.class));
            }
        });

        mShopInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ShopInfoActivity.class));
            }
        });

        mBankCardInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, BankCardInfoActivity.class));
            }
        });

        mContactInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ContactInfoActivity.class));
            }
        });
    }
}
