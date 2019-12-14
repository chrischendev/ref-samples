package com.chris.base.libs.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chris.base.libs.manager.UtilsManager;

/**
 * com.alg.ailigouapp.library.utils
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 17:28
 * Explain:图片加载工具类
 */

public class ImageUtils extends UtilsManager {
    /**
     * 加载一个图片url
     *
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void load(Context context, String imgUrl, ImageView imageView) {
        if (imgUrl != null && imgUrl.indexOf(",") != -1) {
            Glide.with(context).load(imgUrl.split(",")[0]).into(imageView);
        } else {
            Glide.with(context).load(imgUrl).into(imageView);
        }
    }

}
