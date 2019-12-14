package com.chris.base.libs.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.base.libs.base.holder.BaseRecyclerHolder;

import java.util.List;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.adapter
 * Created by Chris Chen on 2017/7/3 17:18.
 * Explain:RecyclerView的Adapter基类
 */

public abstract class BaseRecyclerAdapter<DataSetType, DataModel, Holder extends BaseRecyclerHolder> extends RecyclerView.Adapter {
    protected Context mContext;
    protected DataSetType mData;
    protected View itemView;
    protected OnItemClickListener onItemClickListener;


    public BaseRecyclerAdapter(Context mContext, DataSetType mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (onItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, position);
                }
            });
        }
        refreshView((Holder) holder, position);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(mContext).inflate(layoutId(), parent, false);
        return createViewHolder(itemView);
    }

    /**
     * 布局文件
     *
     * @return
     */
    protected abstract int layoutId();

    /**
     * 创建ViewHolder
     *
     * @param itemView
     * @return
     */
    protected abstract Holder createViewHolder(View itemView);

    /**
     * 刷新数据
     *
     * @param holder
     * @param position
     */
    protected abstract void refreshView(Holder holder, int position);

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        if (mData instanceof List) {
            return ((List<DataModel>) mData).size();
        } else {
            return ((DataModel[]) mData).length;
        }
    }

    /**
     * 获取列表项数据
     *
     * @param position
     * @return
     */
    public DataModel getItem(int position) {
        if (mData == null) {
            return null;
        }
        if (mData instanceof List) {
            return ((List<DataModel>) mData).get(position);
        } else {
            return ((DataModel[]) mData)[position];
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 更新数据
     *
     * @param mData
     */
    public void updateData(DataSetType mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param mData
     */
    public void loadMore(DataSetType mData) {
        if (this.mData != null) {
            //只判断新数据
            if (mData instanceof List) {
                ((List<DataModel>) this.mData).addAll((List<DataModel>) mData);
            } else {
                //合并两个数组稍后 todo
            }
            notifyDataSetChanged();
        }
    }

    /**
     * 列表项点击事件监听
     */
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

}
