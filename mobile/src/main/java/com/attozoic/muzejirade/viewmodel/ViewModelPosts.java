package com.attozoic.muzejirade.viewmodel;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.repositories.RepositoryPosts;

import java.util.List;

/**
 * Created by Kresa on 5/22/17.
 */

public class ViewModelPosts extends ViewModel {



    private RepositoryPosts repositoryPosts;

    private final MutableLiveData<String> pageInput = new MutableLiveData();

    public final LiveData<List<Post>> posts = Transformations.switchMap(pageInput, new Function<String, LiveData<List<Post>>>() {
        @Override
        public LiveData<List<Post>> apply(String page) {
            return repositoryPosts.getPosts(page);
        }
    });

    public ViewModelPosts() {
        this.repositoryPosts = new RepositoryPosts();
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }

    public void setPage(String page) {
        this.pageInput.setValue(page);
    }
}
