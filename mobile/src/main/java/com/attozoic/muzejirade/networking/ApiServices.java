package com.attozoic.muzejirade.networking;

/**
 * Created by Kresa on 4/14/17.
 */

public class ApiServices {

    private ApiServices() {}

    public static PostsService getPostService() {
        return RESTClient.getInstance().create(PostsService.class);
    }
}
