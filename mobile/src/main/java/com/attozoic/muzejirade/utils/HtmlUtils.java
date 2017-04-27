package com.attozoic.muzejirade.utils;

import android.text.Html;
import android.text.Spanned;
import android.view.View;

/**
 * Created by Kresa on 4/14/17.
 */

public class HtmlUtils {

    @SuppressWarnings("deprecation")
    public static Spanned htmlToSpanned(String htmlString) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(htmlString);
        }
    }
}
