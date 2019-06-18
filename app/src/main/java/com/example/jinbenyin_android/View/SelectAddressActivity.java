package com.example.jinbenyin_android.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAddressActivity extends AppCompatActivity implements View.OnClickListener {
    //选择地址

    @BindView(R.id.Add_Address_btn)
    LinearLayout Add_Address_btn;//新增地址
    @BindView(R.id.iv_back)
    ImageView iv_back;//返回
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectaddress);
        ButterKnife.bind(this);
        initEvent();
    }

    public void initEvent(){
        iv_back.setOnClickListener(this);
        Add_Address_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == iv_back){
            //返回
            finish();
        }
        if(v == Add_Address_btn){
            //新增地址
            intent = new Intent(this,AddAddressActivity.class);
            startActivity(intent);

        }
    }
}
