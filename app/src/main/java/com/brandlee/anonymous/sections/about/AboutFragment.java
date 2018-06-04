package com.brandlee.anonymous.sections.about;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseFragment;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.sections.login.LoginActivity;
import com.brandlee.anonymous.sections.setting.SettingActivity;
import com.brandlee.anonymous.utils.Constant;
import com.brandlee.anonymous.utils.SharedPrefsUtils;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

import org.kymjs.chat.ChatActivity;

/**
 * iPhone 8 Copy 24
 */
public class AboutFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private BaseToolbarWrapper mToolbar;
    private LinearLayout mCreditManageLayout;
    private LinearLayout ll_shop;
    private LinearLayout ll_bank_card;
    private LinearLayout ll_invite_profit;
    private LinearLayout ll_customer_manager;
    private LinearLayout ll_online_service;

    private TextView tv_copy;

    private ImageView iv_avatar;
    private TextView tv_user_name;
    private LinearLayout ll_code;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = new BaseToolbarWrapper(view.findViewById(R.id.toolbar));
        initToolbar();

        mCreditManageLayout = view.findViewById(R.id.ll_credit_manage);
        ll_shop = view.findViewById(R.id.ll_shop);
        ll_bank_card = view.findViewById(R.id.ll_bank_card);
        ll_invite_profit = view.findViewById(R.id.ll_invite_profit);
        ll_customer_manager = view.findViewById(R.id.ll_customer_manager);
        ll_online_service = view.findViewById(R.id.ll_online_service);

        tv_copy = view.findViewById(R.id.tv_copy);

        mCreditManageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreditManagementActivity.class));
            }
        });

        ll_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ShopListActivity.class));
            }
        });

        ll_bank_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BanCardListActivity.class));
            }
        });

        ll_invite_profit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), InviteProfitActivity.class));
            }
        });

        ll_customer_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog(getContext());
                materialDialog.content("400-111-2345")
                        .btnText("放弃", "拨打")
                        .show();
                materialDialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                materialDialog.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "400-111-2345"));
                                startActivity(intent);
                                materialDialog.dismiss();
                            }
                        });
            }
        });

        ll_online_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });

        tv_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clipboard("184750");
            }
        });

        iv_avatar = view.findViewById(R.id.iv_avatar);
        tv_user_name = view.findViewById(R.id.tv_user_name);
        ll_code = view.findViewById(R.id.ll_code);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean booleanPreference = SharedPrefsUtils.getBooleanPreference(getContext(), Constant.LOGIN_STATUS, false);
                if (!booleanPreference) {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
            }
        });
    }

    private void initToolbar() {
        mToolbar.viewLeft.setVisibility(View.INVISIBLE);
        mToolbar.viewRight.setVisibility(View.VISIBLE);
        mToolbar.setTitle("我的");
        mToolbar.tvRight.setText("设置");

        mToolbar.viewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
    }

    private void clipboard(String value) {
        // 复制到剪贴板
        ClipboardManager cmb = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("text", value);
        if (cmb != null) {
            cmb.setPrimaryClip(clip);
            Toast.makeText(getContext(), "复制成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        boolean booleanPreference = SharedPrefsUtils.getBooleanPreference(getContext(), Constant.LOGIN_STATUS, false);
        if (!booleanPreference) {
            tv_user_name.setText("点击头像登录");
            ll_code.setVisibility(View.INVISIBLE);
        } else {
            tv_user_name.setText("王大锤");
            ll_code.setVisibility(View.VISIBLE);
        }
    }
}
