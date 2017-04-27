package com.attozoic.muzejirade.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Kresa on 4/27/17.
 */

public class ScreenUtils {

    private static DisplayMetrics displayMetrics;

    private static DisplayMetrics getDisplayMetrics(Context context) {
        if (displayMetrics == null) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            displayMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int getHeightPixels(Context context) {
        float density  = getDisplayMetrics(context).density;
        return (int) (getDisplayMetrics(context).heightPixels / density);
    }

    public static int getWidthPixels(Context context) {
        float density  = getDisplayMetrics(context).density;
        return (int) (getDisplayMetrics(context).widthPixels / density);
    }

}