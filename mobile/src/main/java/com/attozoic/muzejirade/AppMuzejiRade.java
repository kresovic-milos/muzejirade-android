package com.attozoic.muzejirade;

import android.app.Application;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Kresa on 4/27/17.
 */

public class AppMuzejiRade extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String token = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // send token to web service ??
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("tokens/android");
        // then store your token ID
        ref.push().setValue(token);
    }
}
