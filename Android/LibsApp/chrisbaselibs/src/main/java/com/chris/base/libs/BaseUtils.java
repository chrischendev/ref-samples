package com.chris.base.libs;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Chris Chan
 * on 2019/7/5 16:58
 * use for:
 */
public class BaseUtils {
    public static void show(Context context, CharSequence msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
