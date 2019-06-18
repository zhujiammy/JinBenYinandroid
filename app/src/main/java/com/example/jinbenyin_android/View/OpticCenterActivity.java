package com.example.jinbenyin_android.View;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.Tools.LinChart.MyMarkerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
//验光中心

public class OpticCenterActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    final String[] quarters = new String[]{"6.5", "6.6", "6.7", "6.8"};
    @BindView(R.id.chart1)
    LineChart chart;//左眼
    @BindView(R.id.chart2)
    LineChart chart2;//右眼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opticcenter_xml);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI(){


        //自定义设置X轴的值为 => 日期
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return quarters[(int) value];
            }
        };



        chart = findViewById(R.id.chart1);

        // background color
        chart.setBackgroundColor(Color.WHITE);

        // disable description text
        chart.getDescription().setEnabled(false);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // set listeners
        chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);

        // create marker to display box when values are selected
/*        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);

        // Set the marker to the chart
        mv.setChartView(chart);
        chart.setMarker(mv);*/

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        // chart.setScaleXEnabled(true);
        // chart.setScaleYEnabled(true);

        // force pinch zoom along both axis
        chart.setPinchZoom(true);

        {   // // Create Limit Lines // //

            //获取X轴
            XAxis xl = chart.getXAxis();
            //启用X轴
            xl.setEnabled(true);
            //设置X轴避免图表或屏幕的边缘的第一个和最后一个轴中的标签条目被裁剪
            xl.setAvoidFirstLastClipping(true);
            //设置X轴底部显示
            xl.setPosition(XAxis.XAxisPosition.BOTTOM);
            //设置竖网格
            xl.setDrawGridLines(true);
            //设置X轴文字大小
            xl.setTextSize(10f);
            //设置X轴单位间隔
            xl.setGranularity(1f);
            //设置X轴值
            xl.setValueFormatter(formatter);

            //获取Y轴(左)
            YAxis yl = chart.getAxisLeft();
            //设置Y轴文字在外部显示
            yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            //Y轴字体
            yl.setTextSize(10f);
            //设置Y轴最大值
            yl.setAxisMaximum(1f);
            //设置Y轴起始值
            yl.setAxisMinimum(0f);

            //获取Y轴(右)
            YAxis yl2 = chart.getAxisRight();
            //禁用右侧Y轴
            yl2.setEnabled(false);

            //数据
            ArrayList<Entry> values = new ArrayList<>();
            values.add(new Entry(0, 0.2f));
            values.add(new Entry(1, 0.3f));
            values.add(new Entry(2, 0.5f));
            values.add(new Entry(3, 0.3f));
            LineDataSet set1 = new LineDataSet(values,"");
            set1.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
// TODO Auto-generated method stub
                    return ""+value;    //
                }
            });
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

            if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
                set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
                set1.setValues(values);

                set1.notifyDataSetChanged();
                chart.getData().notifyDataChanged();
                chart.notifyDataSetChanged();
            } else {

                set1.enableDashedLine(10f, 5f, 0f);

                // black lines and points
                set1.setColor(getResources().getColor(R.color.CircleColor));
                set1.setCircleColor(getResources().getColor(R.color.CircleColor));
                set1.setValueTextColor(getResources().getColor(R.color.CircleColor));

                set1.setDrawValues(true);
                // line thickness and point size
                set1.setLineWidth(2f);
                set1.setCircleRadius(3f);
                // draw points as solid circles
                set1.setDrawCircleHole(false);
                // customize legend entry
                set1.setFormLineWidth(1f);
                set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
                set1.setFormSize(15.f);

                // text size of values
                set1.setValueTextSize(9f);
                set1.setValueTextSize(14f);
                // draw selection line as dashed
                set1.enableDashedHighlightLine(10f, 5f, 0f);

                // set the filled area
                set1.setDrawFilled(true);
                set1.setFillFormatter(new IFillFormatter() {
                    @Override
                    public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                        return chart.getAxisLeft().getAxisMinimum();
                    }
                });

                // set color of filled area
                if (Utils.getSDKInt() >= 18) {
                    // drawables only supported on api level 18 and above
                    Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                    set1.setFillDrawable(drawable);
                } else {
                    set1.setFillColor(Color.BLACK);
                }

                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                LineData data = new LineData(dataSets);

                // set data
                chart.setData(data);
            }

            // draw points over time
            chart.animateX(1000);
            // get the legend (only possible after setting data)
            Legend l = chart.getLegend();

            // draw legend entries as lines
            l.setForm(Legend.LegendForm.EMPTY);
        }





        chart2 = findViewById(R.id.chart2);

        // background color
        chart2.setBackgroundColor(Color.WHITE);

        // disable description text
        chart2.getDescription().setEnabled(false);

        // enable touch gestures
        chart2.setTouchEnabled(true);

        // set listeners
        chart2.setOnChartValueSelectedListener(this);
        chart2.setDrawGridBackground(false);

        // create marker to display box when values are selected
/*        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);

        // Set the marker to the chart
        mv.setChartView(chart);
        chart.setMarker(mv);*/

        // enable scaling and dragging
        chart2.setDragEnabled(true);
        chart2.setScaleEnabled(true);
        // chart.setScaleXEnabled(true);
        // chart.setScaleYEnabled(true);

        // force pinch zoom along both axis
        chart2.setPinchZoom(true);

        {   // // Create Limit Lines // //

            //获取X轴
            XAxis xl = chart2.getXAxis();
            //启用X轴
            xl.setEnabled(true);
            //设置X轴避免图表或屏幕的边缘的第一个和最后一个轴中的标签条目被裁剪
            xl.setAvoidFirstLastClipping(true);
            //设置X轴底部显示
            xl.setPosition(XAxis.XAxisPosition.BOTTOM);
            //设置竖网格
            xl.setDrawGridLines(true);
            //设置X轴文字大小
            xl.setTextSize(10f);
            //设置X轴单位间隔
            xl.setGranularity(1f);
            //设置X轴值
            xl.setValueFormatter(formatter);

            //获取Y轴(左)
            YAxis yl = chart2.getAxisLeft();
            //设置Y轴文字在外部显示
            yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            //Y轴字体
            yl.setTextSize(10f);
            //设置Y轴最大值
            yl.setAxisMaximum(1f);
            //设置Y轴起始值
            yl.setAxisMinimum(0f);

            //获取Y轴(右)
            YAxis yl2 = chart2.getAxisRight();
            //禁用右侧Y轴
            yl2.setEnabled(false);

            //数据
            ArrayList<Entry> values = new ArrayList<>();
            values.add(new Entry(0, 0.4f));
            values.add(new Entry(1, 0.4f));
            values.add(new Entry(2, 0.6f));
            values.add(new Entry(3, 0.5f));
            LineDataSet set1 = new LineDataSet(values,"");
            set1.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
// TODO Auto-generated method stub
                    return ""+value;    //
                }
            });
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

            if (chart2.getData() != null && chart2.getData().getDataSetCount() > 0) {
                set1 = (LineDataSet) chart2.getData().getDataSetByIndex(0);
                set1.setValues(values);

                set1.notifyDataSetChanged();
                chart2.getData().notifyDataChanged();
                chart2.notifyDataSetChanged();
            } else {

                set1.enableDashedLine(10f, 5f, 0f);

                // black lines and points
                set1.setColor(getResources().getColor(R.color.CircleColerRight));
                set1.setCircleColor(getResources().getColor(R.color.CircleColerRight));
                set1.setValueTextColor(getResources().getColor(R.color.CircleColerRight));

                set1.setDrawValues(true);
                // line thickness and point size
                set1.setLineWidth(2f);
                set1.setCircleRadius(3f);
                // draw points as solid circles
                set1.setDrawCircleHole(false);
                // customize legend entry
                set1.setFormLineWidth(1f);
                set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
                set1.setFormSize(15.f);

                // text size of values
                set1.setValueTextSize(9f);
                set1.setValueTextSize(14f);
                // draw selection line as dashed
                set1.enableDashedHighlightLine(10f, 5f, 0f);

                // set the filled area
                set1.setDrawFilled(true);
                set1.setFillFormatter(new IFillFormatter() {
                    @Override
                    public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                        return chart2.getAxisLeft().getAxisMinimum();
                    }
                });

                // set color of filled area
                if (Utils.getSDKInt() >= 18) {
                    // drawables only supported on api level 18 and above
                    Drawable drawable = ContextCompat.getDrawable(this, R.drawable.rightchart);
                    set1.setFillDrawable(drawable);
                } else {
                    set1.setFillColor(Color.BLACK);
                }

                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                LineData data = new LineData(dataSets);

                // set data
                chart2.setData(data);
            }

            // draw points over time
            chart2.animateX(1000);
            // get the legend (only possible after setting data)
            Legend l = chart2.getLegend();

            // draw legend entries as lines
            l.setForm(Legend.LegendForm.EMPTY);
        }

    }






  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.line, menu);
        return true;
    }*/

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {



    }

    @Override
    public void onNothingSelected() {

        Log.i("Nothing selected", "Nothing selected.");

    }
}
