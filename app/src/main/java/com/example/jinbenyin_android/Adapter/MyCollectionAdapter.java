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
import com.example.jinbenyin_android.View.GoodSActivity;
import com.example.jinbenyin_android.View.HomeFragment;
import com.example.jinbenyin_android.View.MyCollectionActivity;

public class MyCollectionAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    //商品数据源

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private MyCollectionActivity activity;

    public MyCollectionAdapter(MyCollectionActivity activity){
        this.activity = activity;
    }

    private OnitemClickListener onitemClickListener=null;


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
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mycollection_data, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BodyViewHolder linearViewHolder= (BodyViewHolder) viewHolder;
        linearViewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return 20;
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
    public void onClick(View view) {
        if(onitemClickListener!=null){
            onitemClickListener.onItemClick(view,(int)view.getTag());
        }


    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    public static interface OnitemClickListener{
        void onItemClick(View view, int position);
    }

    /**
     * 给GridView中的条目用的ViewHolder，里面只有一个TextView
     */
    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private ImageView prodouct_img,add_cart;
        private TextView sku_name;
        private TextView sku_Price;

        public BodyViewHolder(View itemView) {
            super(itemView);
            prodouct_img = (ImageView) itemView.findViewById(R.id.prodouct_img);
            sku_name = (TextView) itemView.findViewById(R.id.sku_name);
            sku_Price = (TextView) itemView.findViewById(R.id.sku_Price);
            add_cart = (ImageView) itemView.findViewById(R.id.add_cart);


        }

    }
}
