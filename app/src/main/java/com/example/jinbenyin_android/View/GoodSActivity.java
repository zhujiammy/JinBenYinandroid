package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jinbenyin_android.Adapter.GoodSAdapter;
import com.example.jinbenyin_android.Interface.GoodsInterface;
import com.example.jinbenyin_android.Presenter.GoodsPresenter;
import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodSActivity extends AppCompatActivity implements View.OnClickListener, GoodsInterface.View {

    @BindView(R.id.back_btn)
    ImageView back_btn;//返回
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    @BindView(R.id.screen_lin)
    LinearLayout screen_lin;//筛选
    private GoodsPresenter presenter;
    public GoodSAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mDrawerContent;
    @BindView(R.id.iv_stick)
    public ImageView ivStick;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_xml);
        ButterKnife.bind(this);
        InitUI();
        initEvent();
        presenter = new GoodsPresenter(GoodSActivity.this,this);

    }

    private void InitUI(){
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
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

        //设置滑动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取第一个可见位置
                    int firstVisibleItemPosition = linearManager.findFirstVisibleItemPosition();
                    //当滑动到第十个以上时显示置顶图标
                    if (firstVisibleItemPosition>10) {
                        ivStick.setVisibility(View.VISIBLE);
                    }else {
                        ivStick.setVisibility(View.GONE);
                    }
                }
            }
        });
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerContent = (FrameLayout)findViewById(R.id.drawer_content);
        Fragment fragment = new FilterFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.drawer_content,fragment).commit();
    }

    public void initEvent(){
        back_btn.setOnClickListener(this);
        screen_lin.setOnClickListener(this);
        ivStick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == back_btn){
            finish();
        }
        if(v == screen_lin){
            //筛选
            mDrawerLayout.openDrawer(mDrawerContent);
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
