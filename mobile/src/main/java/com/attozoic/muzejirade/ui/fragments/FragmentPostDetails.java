package com.attozoic.muzejirade.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionInflater;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.ui.activities.ActivityPost;
import com.attozoic.muzejirade.utils.ScreenUtils;

import java.io.IOException;
import java.io.InputStream;

import static android.R.id.input;

/**
 * Created by Kresa on 4/26/17.
 */

public class FragmentPostDetails extends BaseFragment {

    private static FragmentPostDetails instance;

    private WebView webView;

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

        webView = (WebView) view.findViewById(R.id.webView_content);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        webView.loadUrl(getPost().getContent());
    }

    private Post getPost() {
        return ((ActivityPost) getActivity()).getPost();
    }
}