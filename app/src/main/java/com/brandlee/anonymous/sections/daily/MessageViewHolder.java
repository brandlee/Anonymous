package com.brandlee.anonymous.sections.daily;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.brandlee.anonymous.common.recyclerview.BaseViewHolder;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/30 2204
 */
public class MessageViewHolder extends BaseViewHolder {
    public MessageViewHolder(final View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), MessageDetailActivity.class));
            }
        });
    }

    @Override
    public void renderData(@Nullable Object o) {

    }
}
