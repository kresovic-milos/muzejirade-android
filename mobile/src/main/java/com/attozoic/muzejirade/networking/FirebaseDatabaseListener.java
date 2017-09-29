package com.attozoic.muzejirade.networking;

/**
 * Created by Kresa on 5/16/17.
 */

public interface FirebaseDatabaseListener<T> {

    public void onSuccess(T result);
    public void onError(String error);
}
