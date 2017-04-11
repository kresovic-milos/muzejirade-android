package com.attozoic.muzejirade.networking;

/**
 * Created by Kresa on 4/10/17.
 */

public interface RequestCompleteListener {

    public void onSuccess(Object response);
    public void onFailiure();
    public void onError();
}
