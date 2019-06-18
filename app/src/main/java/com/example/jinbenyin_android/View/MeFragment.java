package com.example.jinbenyin_android.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

//我的
public class MeFragment extends Fragment implements View.OnClickListener {


    private View view;
    @BindView(R.id.Opticcenter_bt)
    RelativeLayout Opticcenter_bt;//验光中心
    @BindView(R.id.FullOrder_lin)
    RelativeLayout FullOrder_lin;//全部订单
    @BindView(R.id.MyCollection_lin)
    RelativeLayout MyCollection_lin;//我的收藏
    @BindView(R.id.MyCoupon_lin)
    RelativeLayout MyCoupon_lin;//我的优惠券
    @BindView(R.id.MyPromotion_lin)
    RelativeLayout MyPromotion_lin;//我的推广
    private Intent intent;
    @BindView(R.id.profile_image)
    CircleImageView profile_image;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mefragment_xml,container,false);
        ButterKnife.bind(this,view);
        initEvent();
        return view;

    }

    private void initEvent(){
        Opticcenter_bt.setOnClickListener(this);
        profile_image.setOnClickListener(this);
        FullOrder_lin.setOnClickListener(this);
        MyCollection_lin.setOnClickListener(this);
        MyCoupon_lin.setOnClickListener(this);
        MyPromotion_lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == Opticcenter_bt){
            intent = new Intent(getActivity(),OpticCenterActivity.class);
            startActivity(intent);
        }
        if(v == profile_image){
            intent = new Intent(getActivity(),PersonalInformationActivity.class);
            startActivity(intent);
        }
        if(v == FullOrder_lin){
            intent = new Intent(getActivity(),FullOrderActivity.class);
            startActivity(intent);
        }

        if(v == MyCollection_lin){
            intent = new Intent(getActivity(),MyCollectionActivity.class);
            startActivity(intent);
        }
        if(v == MyCoupon_lin){
            intent = new Intent(getActivity(),MyCouponActivity.class);
            startActivity(intent);
        }
        if(v == MyPromotion_lin){
            intent = new Intent(getActivity(),MyPromotion.class);
            startActivity(intent);
        }
    }
}
