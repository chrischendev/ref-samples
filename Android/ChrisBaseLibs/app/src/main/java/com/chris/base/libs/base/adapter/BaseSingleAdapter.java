package com.chris.base.libs.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import butterknife.ButterKnife;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.adapter
 * Created by Chris Chen on 2017/7/3 16:59.
 * Explain:封装的BaseAdapter基类把ViewHolder置于内部，并且限制数据类型为List,减少工作量
 * ViewHolder继承还需要处理 todo 未测试
 */

public abstract class BaseSingleAdapter<DataModel> extends BaseAdapter {
    public Context mContext;
    public List<DataModel> mData;

    public BaseSingleAdapter(Context mContext, List<DataModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public DataModel getItem(int position) {
        if (mData == null) {
            return null;
        }
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(layoutId(), null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
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
     * 绑定holder
     *
     * @param holder
     * @param position
     */
    protected abstract void bindHolder(ViewHolder holder, int position);

    /**
     * 刷新数据
     *
     * @param mData
     */
    public void updateData(List<DataModel> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param mData
     */
    public void loadMore(List<DataModel> mData) {
        if (mData instanceof List) {
            this.mData.addAll(mData);
        }
        notifyDataSetChanged();
    }

    /**
     * 内置的ViewHolder
     */
    class ViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

}
