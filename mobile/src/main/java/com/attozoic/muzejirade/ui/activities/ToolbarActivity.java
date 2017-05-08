package com.attozoic.muzejirade.ui.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;

import com.attozoic.muzejirade.R;

/**
 * Created by Kresa on 4/27/17.
 */

public class ToolbarActivity extends BaseActivity {

    protected Toolbar toolbar;

    protected void setUpActionBar(String title) {
        setUpActionBar(title, null);
    }

    protected void setUpActionBar(String title, String subtitle) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setSubtitle(subtitle);
            //getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blackboard_small));
        }
    }

    protected void setUpAppBar(String title) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
    }
}
