package com.brandlee.anonymous.sections.daily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.widget.NumberRunningTextView;
import com.brandlee.anonymous.entities.OrderEntity;
import com.brandlee.anonymous.sections.about.IdentityVerifyActivity;
import com.brandlee.anonymous.sections.order.OrderDetailActivity;
import com.brandlee.anonymous.sections.setting.AuthorizationActivity;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;

import org.kymjs.chat.ChatActivity;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView mToSeeTextView;
    private LinearLayout mStatusContainerLayout;

    private NumberRunningTextView tv_number;

    private ImageView iv_massage;
    private ImageView iv_service;
    private ImageView iv_eye;

    private boolean isEyeOpen = true;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        mToSeeTextView = view.findViewById(R.id.tv_to_see);
        mToSeeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionSheetDialog();
            }
        });

        mStatusContainerLayout = view.findViewById(R.id.ll_container);
        mStatusContainerLayout.removeAllViews();
        View inflate1 = View.inflate(getContext(), R.layout.layout_apply_page, null);
        TextView tv_apply = inflate1.findViewById(R.id.tv_apply);
        tv_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), IdentityVerifyActivity.class));
            }
        });
        mStatusContainerLayout.addView(inflate1);

        tv_number = view.findViewById(R.id.tv_number);
        tv_number.setContent("80,000.00");

        iv_massage = view.findViewById(R.id.iv_massage);
        iv_service = view.findViewById(R.id.iv_service);
        iv_eye = view.findViewById(R.id.iv_eye);

        iv_massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MessageActivity.class));
            }
        });
        iv_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });

        iv_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEyeOpen) {
                    isEyeOpen = false;
                    iv_eye.setImageResource(R.drawable.icon_eye_close);
                    tv_number.setText("********");
                } else {
                    isEyeOpen = true;
                    iv_eye.setImageResource(R.drawable.icon_eye_open);
                    tv_number.setText("80,000.00");
                }
            }
        });
        return view;
    }


    private void actionSheetDialog() {
        final String[] stringItems = {
                "已登录未申请授信",
                "已登录申请授信审核中",
                "已登录审核未通过",
                "已登录申请授信审核成功",
                "已登录已获得申请授信且已授权，未下单"};
        final ActionSheetDialog dialog = new ActionSheetDialog(getContext(), stringItems, null);
        dialog.title("设置状态")
                .titleTextSize_SP(14.5f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mStatusContainerLayout.removeAllViews();
                        View inflate1 = View.inflate(getContext(), R.layout.layout_apply_page, null);
                        TextView tv_apply = inflate1.findViewById(R.id.tv_apply);
                        tv_apply.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getContext(), IdentityVerifyActivity.class));
                            }
                        });
                        mStatusContainerLayout.addView(inflate1);
                        break;
                    case 1:
                        mStatusContainerLayout.removeAllViews();
                        mStatusContainerLayout.addView(View.inflate(getContext(), R.layout.layout_verifing, null));
                        break;
                    case 2:
                        mStatusContainerLayout.removeAllViews();
                        mStatusContainerLayout.addView(View.inflate(getContext(), R.layout.layout_verify_denied, null));
                        break;
                    case 3:
                        mStatusContainerLayout.removeAllViews();
                        View viewVerifyPass = View.inflate(getContext(), R.layout.layout_verify_passed, null);
                        View goToAuth = viewVerifyPass.findViewById(R.id.tv_go_to_auth);
                        goToAuth.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getContext(), AuthorizationActivity.class));
                            }
                        });
                        mStatusContainerLayout.addView(viewVerifyPass);
                        break;
                    case 4:
                        mStatusContainerLayout.removeAllViews();
                        View inflate = View.inflate(getContext(), R.layout.layout_home_order_container, null);
                        FrameLayout layout_home_order_one = inflate.findViewById(R.id.layout_home_order_one);
                        FrameLayout layout_home_order_two = inflate.findViewById(R.id.layout_home_order_two);
                        layout_home_order_one.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(OrderDetailActivity.getItent(getContext(), OrderEntity.TYPE_WAIT_CONFIRM));
                            }
                        });
                        layout_home_order_two.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(OrderDetailActivity.getItent(getContext(), OrderEntity.TYPE_WAIT_PAY));
                            }
                        });
                        mStatusContainerLayout.addView(inflate);
                        break;
                }
                dialog.dismiss();
            }
        });
    }
}
