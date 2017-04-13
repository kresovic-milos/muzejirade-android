package com.attozoic.muzejirade.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.networking.PostsService;
import com.attozoic.muzejirade.ui.adapters.AdapterPosts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kresa on 4/10/17.
 */

public class FragmentPosts extends BaseFragment {

    List<Post> posts;

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
        posts = new ArrayList<>();
        getPosts();
    }

    private void getPosts() {
        Log.d("BlaBla", "getPosts");
        PostsService.Factory.getInstance().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d("BlaBla", "" + response);
                posts = response.body();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("BlaBla", "onFailiure");
            }
        });

    }
}
