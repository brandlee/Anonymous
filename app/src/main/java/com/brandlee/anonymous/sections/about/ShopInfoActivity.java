package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseActivity;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.leeimageloader.ImageLoaderManager;
import com.cretin.www.externalmaputilslibrary.OpenExternalMapAppUtils;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/21 2110
 */
public class ShopInfoActivity extends BaseActivity {
    private static final int REQUEST_CODE_CHOOSE_POSITIVE = 0x001;
    private static final int REQUEST_CODE_CHOOSE_NEGATIVE = 0x002;
    private static final int REQUEST_CODE_CHOOSE_HOLD = 0x003;
    private static final int REQUEST_CODE_CHOOSE_YINGYE = 0x004;

    private BaseToolbarWrapper mToolbar;
    private TextView tv_time_picker;
    private TextView tv_shop_address;

    private LinearLayout mPositiveIDCardLayout;
    private LinearLayout mNegativeIDCardLayout;
    private LinearLayout mHoldIDCardLayout;
    private LinearLayout mYingYeIDCardLayout;

    private FrameLayout fl_yancao;
    private FrameLayout fl_diannei;
    private FrameLayout fl_dianwai;
    private FrameLayout fl_yingye;

    private TextView tv_yancao;
    private TextView tv_diannei;
    private TextView tv_dianwai;
    private TextView tv_yingye;

    private ImageView mPositiveIDCardImageView;
    private ImageView mNegativeIDCardImageView;
    private ImageView mHoldIDCardImageView;
    private ImageView mYingYeCardImageView;

    private ImageView mAddPositiveIDCardImageView;
    private ImageView mAddNegativeIDCardImageView;
    private ImageView mAddHoldIDCardImageView;
    private ImageView mAddYingYeIDCardImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        initToolbar();

        fl_yancao = findViewById(R.id.fl_yancao);
        fl_diannei = findViewById(R.id.fl_diannei);
        fl_dianwai = findViewById(R.id.fl_dianwai);
        fl_yingye = findViewById(R.id.fl_yingye);

        tv_yancao = findViewById(R.id.tv_yancao);
        tv_diannei = findViewById(R.id.tv_diannei);
        tv_dianwai = findViewById(R.id.tv_dianwai);
        tv_yingye = findViewById(R.id.tv_yingye);

        tv_time_picker = findViewById(R.id.tv_time_picker);
        tv_shop_address = findViewById(R.id.tv_shop_address);

        tv_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog mDialogYearMonthDay = new TimePickerDialog.Builder()
                        .setType(Type.YEAR_MONTH_DAY)
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                Date d1 = new Date(millseconds);
                                String t1 = format.format(d1);
                                tv_time_picker.setText(t1);
                            }
                        })
                        .setThemeColor(getResources().getColor(R.color.select_tab_text))
                        .build();
                mDialogYearMonthDay.show(getSupportFragmentManager(), "year_month_day");
            }
        });

        tv_shop_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenExternalMapAppUtils.openMapMarker(ShopInfoActivity.this, "113.933012", "22.538673", "title", "content", "sunny", false, true);
            }
        });

        mPositiveIDCardLayout = findViewById(R.id.ll_yan_cao_card);
        mNegativeIDCardLayout = findViewById(R.id.ll_dian_nei_card);
        mHoldIDCardLayout = findViewById(R.id.ll_dian_wai_card);
        mYingYeIDCardLayout = findViewById(R.id.ll_ying_ye_card);

        mPositiveIDCardImageView = findViewById(R.id.iv_yan_cao_card);
        mNegativeIDCardImageView = findViewById(R.id.iv_dian_nei_card);
        mHoldIDCardImageView = findViewById(R.id.iv_dian_wai_card);
        mYingYeCardImageView = findViewById(R.id.iv_ying_ye_card);

        mAddPositiveIDCardImageView = findViewById(R.id.iv_add_yan_cao_card);
        mAddNegativeIDCardImageView = findViewById(R.id.iv_add_dian_nei_card);
        mAddHoldIDCardImageView = findViewById(R.id.iv_add_dian_wai_card);
        mAddYingYeIDCardImageView = findViewById(R.id.iv_add_ying_ye_card);

        mPositiveIDCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(ShopInfoActivity.this)
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
                Matisse.from(ShopInfoActivity.this)
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
                Matisse.from(ShopInfoActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE_HOLD); // 设置作为标记的请求码
            }
        });

        mYingYeIDCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(ShopInfoActivity.this)
                        .choose(MimeType.allOf()) // 选择 mime 的类型
                        .countable(true)
                        .maxSelectable(1) // 图片选择的最多数量
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f) // 缩略图的比例
                        .imageEngine(new GlideEngine()) // 使用的图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE_YINGYE); // 设置作为标记的请求码
            }
        });
    }

    private void initToolbar() {
        mToolbar = new BaseToolbarWrapper(findViewById(R.id.toolbar));
        mToolbar.setTitle("店铺信息");
        mToolbar.viewRight.setVisibility(View.GONE);
        mToolbar.viewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
            fl_yancao.setVisibility(View.VISIBLE);
            tv_yancao.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_green_hook_small, 0);
            ImageLoaderManager.getInstance().loadImage(mPositiveIDCardImageView, uris.get(0));
        } else if (requestCode == REQUEST_CODE_CHOOSE_NEGATIVE && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddNegativeIDCardImageView.setVisibility(View.GONE);
            mNegativeIDCardImageView.setVisibility(View.VISIBLE);
            fl_diannei.setVisibility(View.VISIBLE);
            tv_diannei.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_green_hook_small, 0);
            ImageLoaderManager.getInstance().loadImage(mNegativeIDCardImageView, uris.get(0));
        } else if (requestCode == REQUEST_CODE_CHOOSE_HOLD && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddHoldIDCardImageView.setVisibility(View.GONE);
            mHoldIDCardImageView.setVisibility(View.VISIBLE);
            fl_dianwai.setVisibility(View.VISIBLE);
            tv_dianwai.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_green_hook_small, 0);
            ImageLoaderManager.getInstance().loadImage(mHoldIDCardImageView, uris.get(0));
        } else if (requestCode == REQUEST_CODE_CHOOSE_YINGYE && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            mAddYingYeIDCardImageView.setVisibility(View.GONE);
            mYingYeCardImageView.setVisibility(View.VISIBLE);
            fl_yingye.setVisibility(View.VISIBLE);
            tv_yingye.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_green_hook_small, 0);
            ImageLoaderManager.getInstance().loadImage(mHoldIDCardImageView, uris.get(0));
        }
    }
}
