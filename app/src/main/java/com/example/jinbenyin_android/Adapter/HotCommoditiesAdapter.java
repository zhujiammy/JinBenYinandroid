package com.example.jinbenyin_android.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinbenyin_android.R;
import com.example.jinbenyin_android.View.HomeFragment;

public class HotCommoditiesAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    //热门商品数据源

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private HomeFragment homeFragment;

    public HotCommoditiesAdapter(HomeFragment fragment){
        this.homeFragment = fragment;
    }

    private OnitemClickListener onitemClickListener=null;
    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //在onCreateViewHolder方法中，我们要根据不同的ViewType来返回不同的ViewHolder
        if (viewType == VIEW_TYPE_EMPTY) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_view_tab, viewGroup, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        View baseView;
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_data_xml, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    /**
     *
     * 复用getItemViewType方法，根据位置返回相应的ViewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //如果是0，就是头，否则则是其他的item

       /* if (data.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }*/
        //如果有数据，则使用ITEM的布局
        return VIEW_TYPE_ITEM;
    }

    @Override
    public void onClick(View v) {
        if(onitemClickListener!=null){
            onitemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public static interface OnitemClickListener{
        void onItemClick(View view, int position);
    }

    /**
     * 给GridView中的条目用的ViewHolder，里面只有一个TextView
     */
    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private ImageView prodouct_img;
        private TextView prodouct_name;
        private TextView prodouct_price;



        public BodyViewHolder(View itemView) {
            super(itemView);
            prodouct_img = (ImageView) itemView.findViewById(R.id.prodouct_img);
            prodouct_name = (TextView) itemView.findViewById(R.id.prodouct_name);
            prodouct_price = (TextView) itemView.findViewById(R.id.prodouct_price);


        }

    }
}
