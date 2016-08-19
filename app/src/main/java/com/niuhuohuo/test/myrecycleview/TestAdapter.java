package com.niuhuohuo.test.myrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qnhlli on 2016/8/19.
 */
public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //设置item的两种类型
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    //数据集
    public List<Integer> mdatas;

    private TextView test1,test2;

    public TestAdapter(List<Integer> datas) {
        super();
        this.mdatas = datas;
    }

    private ItemClickListener mItemClickListener;
    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test1, parent, false);

            return new TextVideoHolder(view);

        } else if (viewType == TYPE_NORMAL) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test2, parent, false);
            return new SubTextViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextVideoHolder) {

            test1.setText("文具");

        } else if (holder instanceof SubTextViewHolder) {

            test2.setText("签字笔");

        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1) {
            return TYPE_NORMAL;
        } else {
            return TYPE_HEADER;
        }
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    public class TextVideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextVideoHolder(View itemView) {
            super(itemView);
            test1 = (TextView) itemView.findViewById(R.id.tv_test1);
            test1.setOnClickListener(this);
        }
        //点击
        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.OnItemClick(v, getPosition());
            }
        }
    }

    public class SubTextViewHolder extends RecyclerView.ViewHolder {

        public SubTextViewHolder(View itemView) {
            super(itemView);
            test2 = (TextView) itemView.findViewById(R.id.tv_test2);
        }
    }

}

