package com.brandlee.anonymous.sections.about;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseFragment;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.sections.setting.SettingActivity;

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
        mCreditManageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreditManagementActivity.class));
            }
        });
    }

    private void initToolbar() {
        mToolbar.viewLeft.setVisibility(View.INVISIBLE);
        mToolbar.viewRight.setVisibility(View.VISIBLE);
        mToolbar.tvRight.setText("设置");

        mToolbar.viewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
    }
}
