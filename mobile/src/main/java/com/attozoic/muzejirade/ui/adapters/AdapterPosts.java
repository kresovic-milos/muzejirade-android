package com.attozoic.muzejirade.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;

import java.util.ArrayList;
import java.util.List;

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
        holder.titleTV.setText(posts.get(position).getTitle().getRendered());
    }

    @Override
    public int getItemCount() {
         return 20;
       // return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV;

        public PostViewHolder(View rootView) {
            super(rootView);
            titleTV = (TextView) rootView.findViewById(R.id.textview_title);
        }
    }

    public void update(List<Post> newPosts) {
        posts.addAll(newPosts);
        notifyDataSetChanged();
    }
}
