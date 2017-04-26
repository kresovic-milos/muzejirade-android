package com.attozoic.muzejirade.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.bumptech.glide.Glide;

import static com.attozoic.muzejirade.R.id.imageView;

/**
 * Created by Kresa on 4/26/17.
 */

public class FragmentPostDetails extends BaseFragment {

    private Post post;

    private static FragmentPostDetails instance;

    public static FragmentPostDetails getInstance(Post post) {
        if (instance == null) {
            instance = new FragmentPostDetails();
        }

        instance.post = post;

        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post_details, container, false);


            ImageView imageView = (ImageView) view.findViewById(R.id.imageview_post);
            Glide.with(imageView.getContext()).load(post.getFeaturedImageUrl()).into(imageView);
            TextView titleTV = (TextView) view.findViewById(R.id.textview_title);
            titleTV.setText(post.getTitle().getRendered());

        return view;
    }
}
