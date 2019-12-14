package com.chris.base.libs.base.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.adapter
 * Created by Chris Chen on 2017/7/4 14:23.
 * Explain:
 */

public class BaseCursorAdapter extends CursorAdapter {
    public BaseCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
