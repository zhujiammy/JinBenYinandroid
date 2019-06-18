package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountManagementActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView iv_back;//返回

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountmanagement_xml);
        ButterKnife.bind(this);

        initEvent();
    }

    private void initEvent(){
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== iv_back){
            finish();
        }
    }
}
