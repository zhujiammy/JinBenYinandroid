package com.example.jinbenyin_android;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.jinbenyin_android.View.HomeFragment;
import com.example.jinbenyin_android.View.MakeapPointmentFragment;
import com.example.jinbenyin_android.View.MeFragment;
import com.example.jinbenyin_android.View.ShoppingCartFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {


    private TextView tvToolTitle;
    Toolbar toolbar;
    private FragmentManager manager;
    private NavigationController navigationController;

    private HomeFragment homePage;//首页
    private MakeapPointmentFragment MakeapPointmentFragment;//预约
    private ShoppingCartFragment ShoppingCartFragment;//购物车
    private MeFragment mefragment;//我的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initUI();//初始化界面
    }


    private void initUI(){
        tvToolTitle = (TextView) findViewById(R.id.toolbar_title);
        tvToolTitle.setText(getResources().getString(R.string.homepage));
        tvToolTitle.setTextColor(Color.WHITE);
        PageBottomTabLayout tab = (PageBottomTabLayout) findViewById(R.id.tab);
        navigationController =tab.custom()
                .addItem(newItem(R.mipmap.glasses_noselect,R.mipmap.glasses_select,getResources().getString(R.string.homepage)))
                .addItem(newItem(R.mipmap.makeappointment_noselect,R.mipmap.makeappointment_select,getResources().getString(R.string.makeappointment)))
                .addItem(newItem(R.mipmap.ar,R.mipmap.ar,getResources().getString(R.string.ar)))
                .addItem(newItem(R.mipmap.shoppingcart_noselect,R.mipmap.shoppingcart_select,getResources().getString(R.string.shoppingcart)))
                .addItem(newItem(R.mipmap.me_noselect,R.mipmap.me_select,getResources().getString(R.string.me)))
                .build();
        navigationController.addTabItemSelectedListener(listener);

        homePage=new HomeFragment();
        MakeapPointmentFragment=new MakeapPointmentFragment();
        ShoppingCartFragment=new ShoppingCartFragment();
        mefragment=new MeFragment();

        manager=getSupportFragmentManager();
        //初次登陆，显示首页，隐藏其他
        FragmentTransaction transaction=manager.beginTransaction();
        toolbar.setVisibility(View.GONE);
        transaction.add(R.id.main_content,homePage);
        transaction.add(R.id.main_content,MakeapPointmentFragment);
        transaction.add(R.id.main_content,ShoppingCartFragment);
        transaction.add(R.id.main_content,mefragment);
        transaction.show(homePage);
        transaction.hide(MakeapPointmentFragment);
        transaction.hide(ShoppingCartFragment);
        transaction.hide(mefragment);
        transaction.commit();
    }
    OnTabItemSelectedListener listener=new OnTabItemSelectedListener() {
        @Override
        public void onSelected(int index, int old) {
            FragmentTransaction transaction=manager.beginTransaction();
            switch (index){
                //当选中首页id时，显示framelayout加载首页fragment
                case 0:
                    transaction.show(homePage);
                    transaction.hide(MakeapPointmentFragment);
                    transaction.hide(ShoppingCartFragment);
                    transaction.hide(mefragment);
                    toolbar.setVisibility(View.GONE);
                    tvToolTitle.setText(getResources().getString(R.string.homepage));
                    transaction.commit();
                    break;

                case 1:
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    transaction.hide(homePage);
                    transaction.show(MakeapPointmentFragment);
                    transaction.hide(ShoppingCartFragment);
                    transaction.hide(mefragment);
                    toolbar.setVisibility(View.GONE);
                    tvToolTitle.setText(getResources().getString(R.string.makeappointment));
                    transaction.commit();
                    break;

                case 3:
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    transaction.hide(homePage);
                    transaction.hide(MakeapPointmentFragment);
                    toolbar.setVisibility(View.GONE);
                    transaction.hide(mefragment);
                    transaction.show(ShoppingCartFragment);
                    tvToolTitle.setText(getResources().getString(R.string.shoppingcart));
                    toolbar.setVisibility(View.GONE);
                    transaction.commit();

                    break;

                case 4:
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    transaction.hide(homePage);
                    transaction.hide(MakeapPointmentFragment);
                    toolbar.setVisibility(View.VISIBLE);
                    transaction.hide(ShoppingCartFragment);
                    transaction.show(mefragment);
                    tvToolTitle.setText(getResources().getString(R.string.me));
                    toolbar.setVisibility(View.GONE);
                    transaction.commit();

                    break;


            }
        }

        @Override
        public void onRepeat(int index) {

        }
    };


    private BaseTabItem newItem(int drawable, int checkedDrawable, String text){
        NormalItemView normalItemView =new NormalItemView(this);
        normalItemView.initialize(drawable,checkedDrawable,text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(getResources().getColor(R.color.BLAK));
        return  normalItemView;

    }
}
