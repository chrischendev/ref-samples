package com.chris.base.libs.base.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * AiligouApp
 * com.alg.ailigou.library.base.adapter
 * Created by Chris Chen on 2017/8/2 10:25.
 * Explain:简单的Adapter，解决SimpleAdapter只能用TextView的问题(todo 未测试)
 */

public class BaseSimpleAdapter<DataModel> extends BaseAdapter {
    private Context context;
    private List<DataModel> dataList;//数据集合，限定ArrayList类型
    private
    @LayoutRes
    int layoutId;//列表项布局
    private
    @IdRes
    int[] views;//控件ID数组

    public BaseSimpleAdapter(Context context, List<DataModel> dataList, int layoutId, int[] views) {
        if (dataList != null && dataList.size() != views.length) {
            try {
                throw new Exception("数据集合应和控件数组的长度一致");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.context = context;
        this.dataList = dataList;
        this.layoutId = layoutId;
        this.views = views;
    }

    @Override
    public int getCount() {
        if (dataList == null) {
            return 0;
        } else {
            return dataList.size();
        }
    }

    @Override
    public DataModel getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.refreshView();
        return convertView;
    }

    class ViewHolder {
        private View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }

        public void refreshView() {
            View childView;
            for (int i = 0; i < views.length; i++) {
                childView = itemView.findViewById(views[i]);
                //判断控件的类型
                if (childView instanceof TextView) {//文本框
                    ((TextView) childView).setText(String.valueOf(dataList.get(i)));
                } else if (childView instanceof Button) {//按钮
                    ((Button) childView).setText(String.valueOf(dataList.get(i)));
                } else if (childView instanceof ImageView) {//图片框
                    Glide.with(context).load(String.valueOf(dataList.get(i))).into((ImageView) childView);
                }
            }
        }
    }
}
