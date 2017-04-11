package com.attozoic.muzejirade.networking;

import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kresa on 4/10/17.
 */

public class RESTClientRetrofit implements RESTClient {

    private static RESTClientRetrofit instance;

    private Retrofit retrofit;

    public static RESTClientRetrofit getInstance() {
        if (instance == null) {
            instance = new RESTClientRetrofit();
        }
        return instance;
    }

    private RESTClientRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ServerAPI.ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void fireRequest(final RequestCompleteListener requestCompleteListener) {
        PostsService postsService = retrofit.create(PostsService.class);
        Call<List<Post>> postsCall = postsService.getPosts();

        postsCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                requestCompleteListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
                requestCompleteListener.onFailiure();
            }
        });


    }
}
