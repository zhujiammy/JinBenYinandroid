package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinbenyin_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuccessfulReservationActivity extends AppCompatActivity implements View.OnClickListener {

    //预约成功
    @BindView(R.id.back_btn)
    Button back_btn;//返回

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successfulreservation_xml);
        ButterKnife.bind(this);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == back_btn){

            finish();
        }
    }
}
