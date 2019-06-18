package com.example.jinbenyin_android.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinbenyin_android.Adapter.MyCouponAdapter;
import com.example.jinbenyin_android.Interface.MyCouponInterface;
import com.example.jinbenyin_android.Presenter.MyCouponPresenter;
import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.EditDialog;
import com.example.jinbenyin_android.Tools.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCouponActivity extends AppCompatActivity implements View.OnClickListener, MyCouponInterface.View {
    //我的优惠券


    @BindView(R.id.refreshLayout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.exchange_tv)
    TextView exchange_tv;//兑换
    public MyCouponAdapter adapter;
    public MyCouponPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoupon);
        ButterKnife.bind(this);
        InitUI();
        initEvent();
        presenter = new MyCouponPresenter(this,this);
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
        exchange_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == iv_back){
            finish();
        }
        if(v == exchange_tv){
            //兑换

            //点击弹出对话框
            final EditDialog editDialog = new EditDialog(this);
            editDialog.setTitle("兑换优惠券");
            editDialog.setYesOnclickListener("确定", new EditDialog.onYesOnclickListener() {
                @Override
                public void onYesClick(String phone) {

                }
            });
            editDialog.setNoOnclickListener("取消", new EditDialog.onNoOnclickListener() {
                @Override
                public void onNoClick() {
                    editDialog.dismiss();
                }
            });
            editDialog.show();
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
