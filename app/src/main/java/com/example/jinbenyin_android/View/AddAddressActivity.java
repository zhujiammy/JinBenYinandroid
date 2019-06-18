package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener {

    //新增地址
    @BindView(R.id.select_address_bt)
    TextView select_address_bt;//选择地区
    @BindView(R.id.address_et)
    EditText address_et;//具体地址
    @BindView(R.id.Save_Address_btn)
    Button Save_Address_btn;//保存地址
    @BindView(R.id.iv_back)
    ImageView iv_back;//返回

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_address);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent(){
        select_address_bt.setOnClickListener(this);
        Save_Address_btn.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == iv_back){
            finish();
        }

    }
}
