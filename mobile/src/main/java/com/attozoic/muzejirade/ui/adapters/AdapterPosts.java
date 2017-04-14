package com.attozoic.muzejirade.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Kresa on 4/10/17.
 */

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.PostViewHolder> {

    List<Post> posts;

    public AdapterPosts() {
        this.posts = new ArrayList<>();
    }

    @Override
    public AdapterPosts.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_item_post, parent, false);
        return new PostViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(AdapterPosts.PostViewHolder holder, int position) {

        Post post = posts.get(position);

        Glide.with(holder.featuredIV.getContext()).load(post.getFeaturedImageUrl()).into(holder.featuredIV);

        holder.titleTV.setText(post.getTitle().getRendered());

//        String htmlExcerpt = post.getExcerpt().getRendered();
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            holder.titleTV.setText(Html.fromHtml(htmlExcerpt, Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            holder.titleTV.setText(Html.fromHtml(htmlExcerpt));
//        }

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private ImageView featuredIV;
        private TextView titleTV;

        public PostViewHolder(View rootView) {
            super(rootView);
            featuredIV = (ImageView) rootView.findViewById(R.id.imageview_post);
            titleTV = (TextView) rootView.findViewById(R.id.textview_title);
        }
    }

    public void update(List<Post> newPosts) {
        posts.addAll(newPosts);
        notifyDataSetChanged();
    }
}
