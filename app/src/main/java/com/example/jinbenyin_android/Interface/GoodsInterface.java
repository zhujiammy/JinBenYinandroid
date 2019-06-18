package com.example.jinbenyin_android.Interface;

public interface GoodsInterface {

    //view
    interface View{
        void succeed();
        void failed();
        void onRefresh();
        void onLoadMore();
        void onNothingData();
    }
    //presenter
    interface Presenter{
    }

}
