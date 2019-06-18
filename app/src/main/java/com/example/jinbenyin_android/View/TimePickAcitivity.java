package com.example.jinbenyin_android.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinbenyin_android.R;
import com.necer.MyLog;
import com.necer.calendar.Miui9Calendar;
import com.necer.entity.NDate;
import com.necer.listener.OnCalendarChangedListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimePickAcitivity extends AppCompatActivity implements OnCalendarChangedListener, View.OnClickListener {

    @BindView(R.id.miui9Calendar)
    public Miui9Calendar miui9Calendar;
    @BindView(R.id.tv_day)
    public TextView tv_day;//日
    @BindView(R.id.tv_month)
    public TextView tv_month;//月
    @BindView(R.id.tv_year)
    public TextView tv_year;//年
    private int isshow = 1;

    @BindView(R.id.shoumonth)
    ImageView shoumonth;//是否显示月视图

    @BindView(R.id.iv_back)
    ImageView iv_back;//返回



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeappointment_xml);
        ButterKnife.bind(this);
        iniEvent();
    }

    public void iniEvent(){

        iv_back.setOnClickListener(this);
        shoumonth.setOnClickListener(this);
        miui9Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarDateChanged(NDate date,boolean isClick) {
                MyLog.d("date:::" + date.localDate);
                MyLog.d("date:::" + date.lunar.lunarYearStr);
                MyLog.d("date:::" + date.lunar.lunarMonthStr);
                MyLog.d("date:::" + date.lunar.lunarDayStr);
                MyLog.d("date:::" + date.lunar.isLeap);
                MyLog.d("date:::" + date.lunar.leapMonth);

                tv_month.setText(date.localDate.getMonthOfYear() + "月");
                tv_year.setText(date.localDate.getYear() + "年");

                tv_day.setText(date.localDate.getDayOfMonth()+"日");


                MyLog.d("isClickisClickisClick:::" + isClick);

            }

            @Override
            public void onCalendarStateChanged(boolean isMonthSate) {
                MyLog.d("OnCalendarChangedListener:::" + isMonthSate);
            }
        });
    }

    @Override
    public void onCalendarDateChanged(NDate date, boolean isClick) {

    }

    @Override
    public void onCalendarStateChanged(boolean isMonthSate) {

    }

    @Override
    public void onClick(View v) {
        if(v == iv_back){
            finish();
        }
        if(v == shoumonth){
            if(isshow == 1){
                miui9Calendar.toMonth();
                isshow = 2;
            }else if(isshow == 2){
                miui9Calendar.toWeek();
                isshow = 1;
            }


        }
    }
}
