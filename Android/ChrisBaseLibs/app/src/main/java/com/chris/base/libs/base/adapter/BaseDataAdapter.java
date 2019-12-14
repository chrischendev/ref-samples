package com.chris.base.libs.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.chris.base.libs.base.holder.BaseHolder;

import java.util.List;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.adapter
 * Created by Chris Chen on 2017/7/3 16:59.
 * Explain:封装的BaseAdapter基类
 */

public abstract class BaseDataAdapter<DataSetType, DataModel, Holder extends BaseHolder> extends BaseAdapter {
    public Context mContext;
    public DataSetType mData;

    public BaseDataAdapter(Context mContext, DataSetType mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        if (mData instanceof List) {
            return ((List<DataModel>) mData).size();
        } else {
            return ((DataModel[]) mData).length;
        }
    }

    @Override
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

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(layoutId(), null);
            holder = createHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        bindHolder(holder, position);
        return null;
    }

    /**
     * 列表项布局文件
     *
     * @return
     */
    protected abstract int layoutId();

    /**
     * 创建holder
     *
     * @param itemView
     * @return
     */
    protected abstract Holder createHolder(View itemView);

    /**
     * 绑定holder
     *
     * @param holder
     * @param position
     */
    protected abstract void bindHolder(Holder holder, int position);

    /**
     * 刷新数据
     *
     * @param mData
     */
    public void updateData(DataSetType mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void loadMore(DataSetType mData) {
        if (this.mData != null) {
            if (mData instanceof List) {
                ((List<DataModel>) this.mData).addAll((List<DataModel>) mData);
            } else {
                //todo 合并数组放后
            }
            notifyDataSetChanged();
        }
    }

}
