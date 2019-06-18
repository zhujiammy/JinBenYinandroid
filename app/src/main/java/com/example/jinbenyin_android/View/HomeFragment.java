package com.example.jinbenyin_android.View;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jinbenyin_android.Adapter.ActiveGoodsAdapter;
import com.example.jinbenyin_android.Adapter.HotCommoditiesAdapter;
import com.example.jinbenyin_android.Interface.HomeInterface;
import com.example.jinbenyin_android.Presenter.HomePresenter;
import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.RecyclerViewEmptySupport;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

//首页
public class HomeFragment extends Fragment implements View.OnClickListener, HomeInterface.View {

    private View view;
    @BindView(R.id.recyclerView)
    public RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    @BindView(R.id.refreshLayoutActive_Goods)
    RefreshLayout refreshLayoutActive_Goods;
    @BindView(R.id.Active_Goods_recyclerView)
    public RecyclerViewEmptySupport Active_Goods_recyclerView;

    public HotCommoditiesAdapter adapter;
    public ActiveGoodsAdapter activeGoodsAdapter;
    public HomePresenter presenter;

    @BindView(R.id.Opticcenter_lin)
    RelativeLayout Opticcenter_lin;//视光中心
    @BindView(R.id.goods_lin)
    RelativeLayout goods_lin;//商品选购

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fullScreen(getActivity());
        view = inflater.inflate(R.layout.home_page_xml,container,false);
        ButterKnife.bind(this,view);
        initUI();
        initEvent();
        presenter = new HomePresenter(this,this);
        return view;
    }


    public void initUI(){

        //热门商品
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableRefresh(false);
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
        //活动商品
        Active_Goods_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        refreshLayoutActive_Goods.setEnableLoadMore(false);
        refreshLayoutActive_Goods.setEnableRefresh(false);
        refreshLayoutActive_Goods.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }
        });
        refreshLayoutActive_Goods.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {

            }
        });



    }

    public void initEvent(){
        Opticcenter_lin.setOnClickListener(this);
        goods_lin.setOnClickListener(this);
    }


    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }


    @Override
    public void onClick(View v) {

        if(v ==Opticcenter_lin){
            //视光中心
            Intent  intent = new Intent(getActivity(),OpticCenterActivity.class);
            startActivity(intent);

        }
        if(v == goods_lin){
            Intent intent = new Intent(getActivity(),GoodSActivity.class);
            startActivity(intent);
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
