package com.attozoic.muzejirade.ui.activities;

import android.support.v7.widget.Toolbar;

import com.attozoic.muzejirade.R;

/**
 * Created by Kresa on 4/27/17.
 */

public class ToolbarActivity extends BaseActivity {

    protected Toolbar toolbar;

    protected void setUpActionBar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(title);
            //getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blackboard_small));
        }
    }
}
