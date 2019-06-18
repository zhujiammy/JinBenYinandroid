package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.jinbenyin_android.Adapter.MyCollectionAdapter;
import com.example.jinbenyin_android.Interface.MyCollectionInterface;
import com.example.jinbenyin_android.Presenter.MyCollectionPresenter;
import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectionActivity extends AppCompatActivity implements View.OnClickListener, MyCollectionInterface.View {

    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.iv_back)
    ImageView iv_back;

    public MyCollectionAdapter adapter;
    public MyCollectionPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollection);
        ButterKnife.bind(this);
        InitUI();
        initEvent();
        presenter = new MyCollectionPresenter(this,this);
    }

    private void InitUI(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {

            }
        });
    }
    private void initEvent(){
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == iv_back){
            finish();
        }
    }

    @Override
    public void succeed() {

    }

    @Override
    public void failed() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onNothingData() {

    }
}
