package com.attozoic.muzejirade.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.ui.activities.ActivityPost;
import com.attozoic.muzejirade.utils.ScreenUtils;
import com.bumptech.glide.Glide;

/**
 * Created by Kresa on 4/26/17.
 */

public class FragmentPostDetails extends BaseFragment {

    private static FragmentPostDetails instance;

    public static FragmentPostDetails getInstance() {
        if (instance == null) {
            instance = new FragmentPostDetails();
        }

        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post_details, container, false);

        WebView webView = (WebView) view.findViewById(R.id.webView_content);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        int widthPixels = ScreenUtils.getWidthPixels(getActivity());

        StringBuilder htmlData = new StringBuilder("<html>");
        htmlData.append("<head><title>contenttttttttttt</title></head>");
        htmlData.append("\n");
        htmlData.append("<body>");
        htmlData.append("\n");
        htmlData.append(getPost().getContent());
        htmlData.append("\n");

        StringBuilder scriptData = new StringBuilder("<script>");
        scriptData.append("\n");
        scriptData.append("var newWidth = " + widthPixels + ";");
        scriptData.append("\n");
        scriptData.append("var images = document.getElementsByTagName('img'); for(var i = 0; i < images.length; i++) { ");
        scriptData.append("\n");
        scriptData.append("var originalWidth = images[i].offsetWidth; var originalHeight = images[i].offsetHeight; var proportion = newWidth / originalWidth;");
        scriptData.append("\n");
        scriptData.append("var newHeight = originalHeight * proportion;");
        scriptData.append("\n");
        scriptData.append("images[i].style.width = newWidth + 'px'; images[i].style.height = newHeight + 'px'; }");
        scriptData.append("\n");
        scriptData.append("</script>");
        scriptData.append("\n");

        htmlData.append(scriptData);
        htmlData.append("</body>");
        htmlData.append("\n");
        htmlData.append("</html>");

        Log.d("BlaBla", scriptData.toString());

        webView.loadData(htmlData.toString(), "text/html", "UTF-8");

        return view;
    }

    private Post getPost() {
        return ((ActivityPost) getActivity()).getPost();
    }
}
