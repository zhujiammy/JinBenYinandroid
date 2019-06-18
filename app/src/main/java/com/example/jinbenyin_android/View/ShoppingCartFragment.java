package com.example.jinbenyin_android.View;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinbenyin_android.R;

//购物车
public class ShoppingCartFragment extends Fragment implements View.OnClickListener {


    private View view;
    private ListView mListView;// 列表

    //private ListAdapter mListAdapter;// adapter
    private boolean isBatchModel;// 是否可删除模式
    private RelativeLayout mBottonLayout;
    private CheckBox mCheckAll; // 全选 全不选
    private TextView mEdit; // 切换到删除模式
    private TextView mPriceAll; // 商品总价
    private TextView mSelectNum; // 选中数量
    private TextView mDelete; // 删除 结算
    private double totalPrice = 0; // 商品总价
    private Handler mHandler;
    private LinearLayout emptyView;
    private Toolbar toolbar;
    int maxId = 0;

    private SharedPreferences sharedPreferences;
    private SparseArray<Boolean> mSelectState = new SparseArray<Boolean>();
    private MenuItem item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shoppingcartfragment_xml,container,false);
        initUI();
        initListener();
        return view;
    }


    private void initUI(){
        mBottonLayout = (RelativeLayout)view.findViewById(R.id.cart_rl_allprie_total);
        mCheckAll = (CheckBox) view.findViewById(R.id.check_box);
        mPriceAll = (TextView) view.findViewById(R.id.tv_cart_total);
        mSelectNum = (TextView) view.findViewById(R.id.tv_cart_select_num);
        mDelete = (TextView) view.findViewById(R.id.tv_cart_buy_or_del);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setSelector(R.drawable.list_selector);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void initListener()
    {
        mDelete.setOnClickListener(this);
        mCheckAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
