package com.attozoic.muzejirade.ui.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
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
import com.attozoic.muzejirade.ui.activities.ActivityPost;
import com.attozoic.muzejirade.ui.adapters.AdapterPosts;
import com.attozoic.muzejirade.utils.EndlessRecyclerViewScrollListener;
import com.attozoic.muzejirade.utils.OnItemClickListener;

import org.parceler.Parcels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.attozoic.muzejirade.R.id.imageView;

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
                openPostDetails((Post) item, sharedElement);
            }
        });
        recyclerViewMain.setAdapter(adapterPosts);
        recyclerViewMain.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) recyclerViewMain.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                getPosts(page);

                if (page == 1) {
                    this.resetState();
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refresh();
    }

    private void refresh() {
        swipeRefreshLayout.setRefreshing(true);
        getPosts(1);
    }

    private void getPosts(final int page) {
        Log.d("BlaBla", "getPosts");
        ApiServices.getPostService().getPosts(Integer.toString(page)).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d("BlaBla", "onResponse " + response);
                boolean shouldClear = page == 1;
                adapterPosts.update(response.body(), shouldClear);

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
        getPosts(1);
    }

    public void openPostDetails(Post post, View sharedElement) {
        Intent intent = new Intent(getActivity(), ActivityPost.class);
        intent.putExtra("post", Parcels.wrap(post));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), sharedElement, ViewCompat.getTransitionName(sharedElement));
            getActivity().startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
