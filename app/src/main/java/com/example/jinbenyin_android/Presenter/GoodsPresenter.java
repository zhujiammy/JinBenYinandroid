package com.example.jinbenyin_android.Presenter;

import android.view.View;

import com.example.jinbenyin_android.Adapter.GoodSAdapter;
import com.example.jinbenyin_android.Interface.GoodsInterface;
import com.example.jinbenyin_android.View.GoodSActivity;

public class GoodsPresenter {

    private GoodSActivity goodSActivity;
    private GoodsInterface.View view;

    public GoodsPresenter(GoodSActivity activity,GoodsInterface.View view){
        this.goodSActivity = activity;
        this.view = view;

        goodSActivity.adapter = new GoodSAdapter(activity);
        goodSActivity.recyclerView.setAdapter(goodSActivity.adapter);
        goodSActivity.adapter.setOnitemClickListener(new GoodSAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}
