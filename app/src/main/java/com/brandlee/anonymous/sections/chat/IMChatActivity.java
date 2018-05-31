package com.brandlee.anonymous.sections.chat;

import com.brandlee.anonymous.R;

import org.kymjs.chat.ChatActivity;
import org.kymjs.kjframe.KJActivity;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/28 2145
 */
public class IMChatActivity extends KJActivity {
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_im_chat);
        showActivity(aty, ChatActivity.class);
    }
}
