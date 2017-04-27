package com.attozoic.muzejirade.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.networking.ApiServices;
import com.attozoic.muzejirade.networking.PostsService;
import com.attozoic.muzejirade.ui.activities.ActivityMain;
import com.attozoic.muzejirade.ui.activities.ActivityPost;
import com.attozoic.muzejirade.ui.adapters.AdapterPosts;
import com.attozoic.muzejirade.utils.OnItemClickListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kresa on 4/10/17.
 */

public class FragmentPosts extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout swipeRefreshLayout;

    private AdapterPosts adapterPosts;

    private static FragmentPosts instance;

    public static FragmentPosts getInstance() {
        if (instance == null) {
            instance = new FragmentPosts();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerViewMain = (RecyclerView) view.findViewById(R.id.recyclerview_posts);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapterPosts = new AdapterPosts(new OnItemClickListener() {
            @Override
            public void onItemClick(Object item, View sharedElement) {
                openPostDetails((Post) item, (RelativeLayout) sharedElement);
            }
        });
        recyclerViewMain.setAdapter(adapterPosts);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refresh();
    }

    private void refresh() {
            swipeRefreshLayout.setRefreshing(true);
            getPosts();
    }

    private void getPosts() {
        Log.d("BlaBla", "getPosts");
        ApiServices.getPostService().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d("BlaBla", "onResponse " + response);
                adapterPosts.update(response.body());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("BlaBla", "onFailiure");
                t.printStackTrace();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onRefresh() {
        getPosts();
    }

    public void openPostDetails(Post post, RelativeLayout relativeLayout) {
        Intent intent = new Intent(getActivity(), ActivityPost.class);
        intent.putExtra("post", Parcels.wrap(post));
        startActivity(intent);
    }
}
