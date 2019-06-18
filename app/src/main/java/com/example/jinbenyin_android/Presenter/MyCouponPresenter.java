package com.example.jinbenyin_android.Presenter;

import android.view.View;

import com.example.jinbenyin_android.Adapter.MyCouponAdapter;
import com.example.jinbenyin_android.Interface.MyCouponInterface;
import com.example.jinbenyin_android.View.MyCouponActivity;

public class MyCouponPresenter {

    private MyCouponActivity activity;
    private MyCouponInterface.View view;
    public MyCouponPresenter(MyCouponActivity activity,MyCouponInterface.View view){
        this.activity = activity;
        this.view = view;

        activity.adapter = new MyCouponAdapter(activity);
        activity.recyclerView.setAdapter(activity.adapter);
        activity.adapter.setOnitemClickListener(new MyCouponAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}
