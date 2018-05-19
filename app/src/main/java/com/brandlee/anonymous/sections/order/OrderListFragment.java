package com.brandlee.anonymous.sections.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.entities.OrderEntity;

import java.util.ArrayList;

public class OrderListFragment extends Fragment {
    private static final String PARAM_ORDER_TYPE = "param_order_type";
    private static final String ARG_PARAM2 = "param2";

    private int mOrderType;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private OrderListAdapter mAdapter;
    private TextView mEmptyText;

    private ArrayList<OrderEntity> mOrderList;

    public OrderListFragment() {
    }

    public static OrderListFragment newInstance(int param1, String param2) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_ORDER_TYPE, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOrderType = getArguments().getInt(PARAM_ORDER_TYPE);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mOrderList = new ArrayList<>();
        if (mOrderType == OrderEntity.TYPE_WAIT_CONFIRM) {
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
        } else if (mOrderType == OrderEntity.TYPE_WAIT_PAY) {
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
        } else if (mOrderType == OrderEntity.TYPE_COMPLETE) {
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
            mOrderList.add(new OrderEntity(mOrderType));
        } else if (mOrderType == OrderEntity.TYPE_ALL) {
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_CONFIRM));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_CONFIRM));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_CONFIRM));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_PAY));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_PAY));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_PAY));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_WAIT_PAY));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_COMPLETE));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_COMPLETE));
            mOrderList.add(new OrderEntity(OrderEntity.TYPE_COMPLETE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
    }

    private void initView(View view) {
        mEmptyText = view.findViewById(R.id.tv_empty);
        mRecyclerView = view.findViewById(R.id.recyclerview_order);
        LinearLayoutManager mManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new OrderListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
//        if (mOrderType == OrderEntity.TYPE_WAIT_CONFIRM) {
//            mEmptyText.setVisibility(View.VISIBLE);
//            mRecyclerView.setVisibility(View.GONE);
//        } else {
        mEmptyText.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter.refreshData(mOrderList);
//        }
    }
}
