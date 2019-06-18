package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.jinbenyin_android.Adapter.Adapter;
import com.example.jinbenyin_android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullOrderActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullorder_xml);
        ButterKnife.bind(this);

        initUI();
    }

    public void initUI(){
        CommodityOrdersFragment commodityOrdersFragment = new CommodityOrdersFragment();
        MyOptometrySheetFragment myOptometrySheetFragment = new MyOptometrySheetFragment();
        mFragments.add(commodityOrdersFragment);
        mFragments.add(myOptometrySheetFragment);
        list.add("商品订单");
        list.add("我的验光单");

        tablayout.setupWithViewPager(view_pager);
        view_pager.setAdapter(new Adapter(getSupportFragmentManager(),mFragments,list));

    }
}
