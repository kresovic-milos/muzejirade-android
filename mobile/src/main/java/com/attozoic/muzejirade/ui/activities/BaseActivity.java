package com.attozoic.muzejirade.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.attozoic.muzejirade.R;

/**
 * Created by Kresa on 4/27/17.
 */

public class BaseActivity extends AppCompatActivity {

    public void goTo(Fragment fragment) {
        goTo(fragment, false);
    }

    public void goTo(Fragment fragment, boolean addToBackStack) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            int containerId = R.id.framelayout_main;

            if (addToBackStack) {
                transaction.add(containerId, fragment).addToBackStack(null).commit();
            } else {
                transaction.replace(containerId, fragment).commit();
            }
        }
    }
}
