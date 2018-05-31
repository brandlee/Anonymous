package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.ShopEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1500
 */
public class ShopListViewHolder extends BaseViewHolder<ShopEntity> {
    public TextView tv_verify_ing;
    public TextView tv_verify_failed;
    public TextView tv_edit;
    public ImageView iv_available_after_certificated;

    public ShopListViewHolder(final View itemView) {
        super(itemView);
        tv_verify_ing = itemView.findViewById(R.id.tv_verify_ing);
        tv_verify_failed = itemView.findViewById(R.id.tv_verify_failed);
        tv_edit = itemView.findViewById(R.id.tv_edit);
        iv_available_after_certificated = itemView.findViewById(R.id.iv_available_after_certificated);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), ShopInfoActivity.class));
            }
        });
    }

    @Override
    public void renderData(@Nullable ShopEntity shopEntity) {
        switch (shopEntity.type) {
            case ShopEntity.TYPE_AVALIABLE_AFTER_CERTIFICATED:
                tv_verify_ing.setVisibility(View.GONE);
                tv_verify_failed.setVisibility(View.GONE);
                tv_edit.setVisibility(View.INVISIBLE);
                iv_available_after_certificated.setVisibility(View.VISIBLE);
                break;
            case ShopEntity.TYPE_EDIT:
                tv_verify_ing.setVisibility(View.GONE);
                tv_verify_failed.setVisibility(View.GONE);
                tv_edit.setVisibility(View.VISIBLE);
                iv_available_after_certificated.setVisibility(View.GONE);
                break;
            case ShopEntity.TYPE_VERIFY_ING:
                tv_verify_ing.setVisibility(View.VISIBLE);
                tv_verify_failed.setVisibility(View.GONE);
                tv_edit.setVisibility(View.VISIBLE);
                iv_available_after_certificated.setVisibility(View.GONE);
                break;
            case ShopEntity.TYPE_VERIFY_FAILED:
                tv_verify_ing.setVisibility(View.GONE);
                tv_verify_failed.setVisibility(View.VISIBLE);
                tv_edit.setVisibility(View.INVISIBLE);
                iv_available_after_certificated.setVisibility(View.GONE);
                break;
        }
    }
}
