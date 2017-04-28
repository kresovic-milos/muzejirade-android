package com.attozoic.muzejirade.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.ui.fragments.FragmentPostDetails;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

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

        supportPostponeEnterTransition();

        ImageView imageView = (ImageView) findViewById(R.id.imageview_post);
        Glide.with(imageView.getContext()).load(getPost().getFeaturedImageUrl()).dontAnimate().dontTransform()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }
        }).into(imageView);
//        TextView titleTV = (TextView) findViewById(R.id.textview_title);
//        titleTV.setText(getPost().getTitle().getRendered());

        goTo(FragmentPostDetails.getInstance());
    }

    public Post getPost() {
        return post;
    }
}
