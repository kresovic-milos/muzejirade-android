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
        goTo(fragment, false, null);
    }

    public void goTo(Fragment fragment, boolean addToBackStack, RelativeLayout relativeLayout) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int containerId = R.id.framelayout_main;

        if (fragment != null) {
            if (addToBackStack) {
                transaction.add(containerId, fragment).addToBackStack(null).addSharedElement(relativeLayout, ViewCompat.getTransitionName(relativeLayout)).commit();
            } else {
                transaction.replace(containerId, fragment).commit();
            }
        }
    }
}
