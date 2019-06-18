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
    }
}
