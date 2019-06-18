package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinbenyin_android.Adapter.Adapter;
import com.example.jinbenyin_android.Adapter.Adapters;
import com.example.jinbenyin_android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommodityOrdersFragment extends Fragment {

    //商品订单
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.commodityorders_xml,container,false);
        ButterKnife.bind(this,view);
        initUI();
        return view;
    }

    public void initUI(){
        AllOrdersFragment allOrdersFragment = new AllOrdersFragment();
        PaymentMadeFragment paymentMadeFragment = new PaymentMadeFragment();
        ToShippedFragment toShippedFragment = new ToShippedFragment();
        ToReceivedFragment toReceivedFragment = new ToReceivedFragment();
        ToEvaluatedFragment toEvaluatedFragment = new ToEvaluatedFragment();
        CompletedFragment completedFragment = new CompletedFragment();

        mFragments.add(allOrdersFragment);
        mFragments.add(paymentMadeFragment);
        mFragments.add(toShippedFragment);
        mFragments.add(toReceivedFragment);
        mFragments.add(toEvaluatedFragment);
        mFragments.add(completedFragment);

        list.add("全部订单");
        list.add("待付款");
        list.add("待发货");
        list.add("待收货");
        list.add("待评价");
        list.add("已完成");

        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapters(getChildFragmentManager(),mFragments,list));

    }
}
