package com.brandlee.anonymous.sections.daily;

import android.content.Context;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.recyclerview.BaseAdapter;
import com.brandlee.anonymous.entities.MessageEntity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/30 2203
 */
public class MessageAdapter extends BaseAdapter<MessageEntity, MessageViewHolder> {
    public MessageAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public void bindData(MessageViewHolder holder, int position, MessageEntity data) {
        holder.renderData(data);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(mInflater.inflate(R.layout.item_message, parent, false));
    }
}
