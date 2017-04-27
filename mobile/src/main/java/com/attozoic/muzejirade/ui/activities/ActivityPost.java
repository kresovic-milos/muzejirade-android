package com.attozoic.muzejirade.ui.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.ui.fragments.FragmentPostDetails;

import org.parceler.Parcel;
import org.parceler.Parcels;

/**
 * Created by Kresa on 4/27/17.
 */

public class ActivityPost extends ToolbarActivity {

    private Post post;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        post = Parcels.unwrap(getIntent().getParcelableExtra("post"));
        setUpActionBar(post.getTitle().getRendered());

        goTo(FragmentPostDetails.getInstance());
    }

    public Post getPost() {
        return post;
    }
}
