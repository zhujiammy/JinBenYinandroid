package com.example.jinbenyin_android.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//预约
public class MakeapPointmentFragment extends Fragment implements View.OnClickListener {


    private View view;
    @BindView(R.id.makeappointment_bt)
    public Button makeappointment_bt;//预约按钮
    @BindView(R.id.phone_number)
    public EditText phone_number;
    @BindView(R.id.Add_Address_btn)
    LinearLayout Add_Address_btn;//添加地址
    @BindView(R.id.add_time_bt)
    LinearLayout add_time_bt;//添加预约时间
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.makeappointmentfragment_xml,container,false);
        ButterKnife.bind(this,view);
        initEvent();
        return view;

    }

    public void initEvent(){

        makeappointment_bt.setOnClickListener(this);
        Add_Address_btn.setOnClickListener(this);
        add_time_bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == makeappointment_bt){

            //预约
            intent = new Intent(getActivity(),SuccessfulReservationActivity.class);
            startActivity(intent);
        }
        if(v == Add_Address_btn){
            //添加地址
            intent = new Intent(getActivity(),SelectAddressActivity.class);
            startActivity(intent);
        }

        if(v == add_time_bt){
            //添加预约时间
            intent = new Intent(getActivity(),TimePickAcitivity.class);
            startActivity(intent);

        }
    }
}
