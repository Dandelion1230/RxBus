package com.android.rxjava2_samples.snackbar;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.rxjava2_samples.R;

/**
 * Created by Administrator on 2016/12/13.
 */

public class SnackBarUtils {

    // 显示默认短时间的SnackBar
    public static void shortShow(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
    // 显示默认长时间的SnackBar
    public static void longShow(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
    // 显示带有Action的SnackBar
    public static void actionShow(View view, String message, String actionStr, int actionTextColor, View.OnClickListener onClickListener) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setActionTextColor(actionTextColor)
                .setAction(actionStr, onClickListener)
                .show();
    }

    // 显示不同文字颜色和背景的SnackBar
    public static void colorShow(View view, String message,int textColor, int bgColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        View v = snackbar.getView();
        if (v != null) {
            ((TextView) v.findViewById(R.id.snackbar_text)).setTextColor(textColor);
            v.setBackgroundColor(bgColor);
        }
        snackbar.show();
    }

    // 显示带有图片的SnackBar
    public static void imageShow(Activity activity, View view, String message, int imageId) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        View v = snackbar.getView();
        //设置icon
        ImageView iconImage=new ImageView(activity);
        iconImage.setImageResource(imageId);
        //icon插入布局
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) v;
        snackbarLayout.addView(iconImage,0);
        //设置按钮为蓝色
        snackbar.show();
    }
}
