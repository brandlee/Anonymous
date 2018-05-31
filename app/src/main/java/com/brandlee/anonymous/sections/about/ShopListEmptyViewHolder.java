package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;
import com.brandlee.anonymous.entities.ShopEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1500
 */
public class ShopListEmptyViewHolder extends BaseViewHolder<ShopEntity> {

    public ShopListEmptyViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), ShopInfoActivity.class));
            }
        });
    }

    @Override
    public void renderData(@Nullable ShopEntity shopEntity) {
    }
}
