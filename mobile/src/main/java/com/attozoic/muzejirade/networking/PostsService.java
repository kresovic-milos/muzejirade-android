package com.attozoic.muzejirade.networking;

import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kresa on 4/10/17.
 */

public interface PostsService {

    @GET(Constants.ServerAPI.POSTS)
    Call<List<Post>> getPosts();
}
