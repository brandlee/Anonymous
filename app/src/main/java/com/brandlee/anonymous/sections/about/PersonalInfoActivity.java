package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.leeimageloader.ImageLoaderManager;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 2032
 */
public class PersonalInfoActivity extends BaseActivity {
    private static final int REQUEST_CODE_CHOOSE_POSITIVE = 0x001;
    private static final int REQUEST_CODE_CHOOSE_NEGATIVE = 0x002;
    private static final int REQUEST_CODE_CHOOSE_HOLD = 0x003;
    private BaseToolbarWrapper mToolbar;

    private TextView mRelationTextView;
    private TextView mMarriageTextView;

    private LinearLayout mPositiveIDCardLayout;
    private LinearLayout mNegativeIDCardLayout;
    private LinearLayout mHoldIDCardLayout;

    private ImageView mPositiveIDCardImageView;
    private ImageView mNegativeIDCardImageView;
    private ImageView mHoldIDCardImageView;

    private ImageView mAddPositiveIDCardImageView;
    private ImageView mAddNegativeIDCardImageView;
    private ImageView mAddHoldIDCardImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        initToolbar();

        mRelationTextView = findViewById(R.id.tv_relation);
        mMarriageTextView = findViewById(R.id.tv_marriage);

        mPositiveIDCardLayout = findViewById(R.id.ll_positive_id_card);
        mNegativeIDCardLayout = findViewById(R.id.ll_negative_id_card);
        mHoldIDCardLayout = findViewById(R.id.ll_hand_id_card);

        mPositiveIDCardImageView = findViewById(R.id.iv_positive_id_card);
        mNegativeIDCardImageView = findViewById(R.id.iv_negative_id_card);
        mHoldIDCardImageView = findViewById(R.id.iv_hold_id_card);

        mAddPositiveIDCardImageView = findViewById(R.id.iv_add_positive_id_card);
        mAddNegativeIDCardImageView = findViewById(R.id.iv_add_negative_id_card);
        mAddHoldIDCardImageView = findViewById(R.id.iv_add_hold_id_card);

        setClickListener();
    }

    private void setClickListener() {
        mRelationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relationActionSheetDialog();
            }
        });

        mMarriageTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marriageActionSheetDialog();
            }
        });

        mPositiveIDCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(PersonalInfoActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE_POSITIVE); // 设置作为标记的请求码
            }
        });

        mNegativeIDCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(PersonalInfoActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE_NEGATIVE); // 设置作为标记的请求码
            }
        });

        mHoldIDCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(PersonalInfoActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE_HOLD); // 设置作为标记的请求码
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE_POSITIVE && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddPositiveIDCardImageView.setVisibility(View.GONE);
            mPositiveIDCardImageView.setVisibility(View.VISIBLE);
            ImageLoaderManager.getInstance().loadImage(mPositiveIDCardImageView, uris.get(0));
        } else if (requestCode == REQUEST_CODE_CHOOSE_NEGATIVE && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddNegativeIDCardImageView.setVisibility(View.GONE);
            mNegativeIDCardImageView.setVisibility(View.VISIBLE);
            ImageLoaderManager.getInstance().loadImage(mNegativeIDCardImageView, uris.get(0));
        } else if (requestCode == REQUEST_CODE_CHOOSE_HOLD && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddHoldIDCardImageView.setVisibility(View.GONE);
            mHoldIDCardImageView.setVisibility(View.VISIBLE);
            ImageLoaderManager.getInstance().loadImage(mHoldIDCardImageView, uris.get(0));
        }
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("个人信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void relationActionSheetDialog() {
        final String[] stringItems = {
                "本人",
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

    private void marriageActionSheetDialog() {
        final String[] stringItems = {
                "已婚",
                "未婚",
                "离异",
                "丧偶"};
        final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, null);
        dialog.title("婚姻状况")
                .titleTextSize_SP(14.5f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMarriageTextView.setText(stringItems[position]);
                dialog.dismiss();
            }
        });
    }
}
