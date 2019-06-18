package com.example.jinbenyin_android.Presenter;

import android.view.View;

import com.example.jinbenyin_android.Adapter.ActiveGoodsAdapter;
import com.example.jinbenyin_android.Adapter.HotCommoditiesAdapter;
import com.example.jinbenyin_android.Interface.HomeInterface;
import com.example.jinbenyin_android.View.HomeFragment;

public class HomePresenter {

    private HomeFragment homeFragment;
    private HomeInterface.View view ;

    public HomePresenter(HomeFragment fragment,HomeInterface.View view){
        this.homeFragment = fragment;
        this.view = view;

        //热门商品
        homeFragment.adapter = new HotCommoditiesAdapter(homeFragment);
        homeFragment.recyclerView.setAdapter(homeFragment.adapter);
        homeFragment.adapter.setOnitemClickListener(new HotCommoditiesAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        //活动商品
        homeFragment.activeGoodsAdapter = new ActiveGoodsAdapter(homeFragment);
        homeFragment.Active_Goods_recyclerView.setAdapter(homeFragment.activeGoodsAdapter);
        homeFragment.activeGoodsAdapter.setOnitemClickListener(new ActiveGoodsAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

}
