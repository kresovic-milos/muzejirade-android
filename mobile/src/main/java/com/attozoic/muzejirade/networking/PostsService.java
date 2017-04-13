package com.attozoic.muzejirade.networking;

import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Kresa on 4/10/17.
 */

public interface PostsService {

    @GET(Constants.ServerAPI.POSTS)
    Call<List<Post>> getPosts();

     class Factory{
        private static PostsService service;

        public static PostsService getInstance() {

            if(service == null){
           Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ServerAPI.ROOT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                service = retrofit.create(PostsService.class);
                return service;
        }
          return service;

        }
    }
}
