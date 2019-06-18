package com.example.jinbenyin_android.Presenter;

import android.view.View;

import com.example.jinbenyin_android.Adapter.MyCollectionAdapter;
import com.example.jinbenyin_android.Interface.MyCollectionInterface;
import com.example.jinbenyin_android.View.MyCollectionActivity;

public class MyCollectionPresenter {

    private MyCollectionActivity activity;
    private MyCollectionInterface.View view;
    public MyCollectionPresenter(MyCollectionActivity activity,MyCollectionInterface.View view){
        this.activity = activity;
        this.view = view;

        activity.adapter = new MyCollectionAdapter(activity);
        activity.recyclerView.setAdapter(activity.adapter);
        activity.adapter.setOnitemClickListener(new MyCollectionAdapter.OnitemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}
