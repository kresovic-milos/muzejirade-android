package com.attozoic.muzejirade.networking;

import com.attozoic.muzejirade.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kresa on 4/14/17.
 */

public class RESTClient {

    private static Retrofit instance;

    private RESTClient() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(Constants.ServerAPI.ROOT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance;
    }
}
