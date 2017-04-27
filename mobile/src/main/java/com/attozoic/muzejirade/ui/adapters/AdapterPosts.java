package com.attozoic.muzejirade.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.utils.HtmlUtils;
import com.attozoic.muzejirade.utils.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kresa on 4/10/17.
 */

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.PostViewHolder> {

    private List<Post> posts;
    private OnItemClickListener onItemClickListener;

    public AdapterPosts(OnItemClickListener onItemClickListener) {
        this.posts = new ArrayList<>();
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public AdapterPosts.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_item_post, parent, false);
        return new PostViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final AdapterPosts.PostViewHolder holder, int position) {

        final Post post = posts.get(position);

        Glide.with(holder.featuredIV.getContext()).load(post.getFeaturedImageUrl()).into(holder.featuredIV);

        holder.titleTV.setText(HtmlUtils.htmlToSpanned(post.getTitle().getRendered()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(post, holder.relativeLayout);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private RelativeLayout relativeLayout;
        private ImageView featuredIV;
        private TextView titleTV;

        public PostViewHolder(View rootView) {
            super(rootView);
            cardView = (CardView) rootView.findViewById(R.id.cardview_post);
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativelayout_post);
            featuredIV = (ImageView) rootView.findViewById(R.id.imageview_post);
            titleTV = (TextView) rootView.findViewById(R.id.textview_title);
        }
    }

    public void update(List<Post> newPosts, boolean shouldClear) {
        if (shouldClear) {
            posts.clear();
        }
        posts.addAll(newPosts);
        notifyDataSetChanged();
    }
}
