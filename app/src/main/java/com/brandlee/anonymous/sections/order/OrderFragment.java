package com.brandlee.anonymous.sections.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.common.BaseToolbarWrapper;
import com.brandlee.anonymous.common.viewpager.CommonPagerAdapter;
import com.brandlee.anonymous.common.viewpager.PagerManager;
import com.brandlee.anonymous.common.widget.SlidableViewPager;
import com.brandlee.anonymous.entities.OrderEntity;
import com.flyco.tablayout.SlidingTabLayout;

public class OrderFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private BaseToolbarWrapper mToolbar;
    private SlidingTabLayout mTabLayout;
    private SlidableViewPager mViewPager;
    private PagerManager mPagerManager;
    private CommonPagerAdapter mPagerAdapter;

    private final String[] mTitles = {
            "待确认", "待支付", "已完成", "全部"
    };

    public OrderFragment() {
    }

    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mToolbar = new BaseToolbarWrapper(view.findViewById(R.id.toolbar));
        mToolbar.setTitle("订单");

        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.viewpager);

        initViewPager();
    }

    private void initViewPager() {
        mPagerManager = new PagerManager();
        mPagerManager.addFragment(OrderListFragment.newInstance(OrderEntity.TYPE_WAIT_CONFIRM, ""), mTitles[0]);
        mPagerManager.addFragment(OrderListFragment.newInstance(OrderEntity.TYPE_WAIT_PAY, ""), mTitles[1]);
        mPagerManager.addFragment(OrderListFragment.newInstance(OrderEntity.TYPE_COMPLETE, ""), mTitles[2]);
        mPagerManager.addFragment(OrderListFragment.newInstance(OrderEntity.TYPE_ALL, ""), mTitles[3]);
        mPagerAdapter = new CommonPagerAdapter(getChildFragmentManager(), mPagerManager);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setViewPager(mViewPager);
    }
}
