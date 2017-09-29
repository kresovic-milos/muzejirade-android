package com.attozoic.muzejirade.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.networking.FirebaseDatabaseListener;
import com.attozoic.muzejirade.networking.PostsServiceFirebase;

import java.util.List;

/**
 * Created by Kresa on 5/22/17.
 */

public class RepositoryPosts {

    public LiveData<List<Post>> getPosts(String page) {

        final MutableLiveData<List<Post>> data = new MutableLiveData<>();

        PostsServiceFirebase postsServiceFirebase = new PostsServiceFirebase();
        postsServiceFirebase.getPosts(page, new FirebaseDatabaseListener<List<Post>>() {

                    @Override
                    public void onSuccess(List<Post> response){

                        data.setValue(response);


//                        boolean shouldClear = page == null;
//                        adapterPosts.update((List<Post>) response, shouldClear);
//
//                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError (String error){
                        Log.d("BlaBla", "onFailiure " + error);

//                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

        return data;
    }
}
