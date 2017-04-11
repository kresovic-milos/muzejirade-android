package com.attozoic.muzejirade.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.networking.RESTClientRetrofit;
import com.attozoic.muzejirade.networking.RequestCompleteListener;
import com.attozoic.muzejirade.ui.adapters.AdapterPosts;

/**
 * Created by Kresa on 4/10/17.
 */

public class FragmentPosts extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("BlaBla", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        RecyclerView recyclerViewMain = (RecyclerView) view.findViewById(R.id.recyclerview_posts);
        AdapterPosts adapterPosts = new AdapterPosts();
        recyclerViewMain.setAdapter(adapterPosts);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getPosts();
    }

    private void getPosts() {
        Log.d("BlaBla", "getPosts");
        RESTClientRetrofit.getInstance().fireRequest(new RequestCompleteListener() {
            @Override
            public void onSuccess(Object response) {
                Log.d("BlaBla", "" + response);
            }

            @Override
            public void onFailiure() {
                Log.d("BlaBla", "onFailiure");
            }

            @Override
            public void onError() {

            }
        });
    }
}
