package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.SinWaveView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPromotion extends AppCompatActivity {

    //我的推广

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypromotion);
        ButterKnife.bind(this);

    }
}
