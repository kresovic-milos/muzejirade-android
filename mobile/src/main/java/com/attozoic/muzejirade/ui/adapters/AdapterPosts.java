package com.attozoic.muzejirade.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.attozoic.muzejirade.R;
import com.attozoic.muzejirade.entities.Post;
import com.attozoic.muzejirade.utils.HtmlUtils;
import com.attozoic.muzejirade.utils.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kresa on 4/10/17.
 */

public class AdapterPosts extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_POST = 0;
    private static final int ITEM_TYPE_LOAD_MORE_INDICATOR = 1;

    private boolean hasMore;

    private List<Post> posts;
    private OnItemClickListener onItemClickListener;
    private int lastPosition = -1;

    public AdapterPosts(OnItemClickListener onItemClickListener) {
        this.posts = new ArrayList<>();
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM_TYPE_LOAD_MORE_INDICATOR:
                View rootView = layoutInflater.inflate(R.layout.list_item_load_more, parent, false);
                return new LoadMoreViewHolder(rootView);
            case ITEM_TYPE_POST:
                rootView = layoutInflater.inflate(R.layout.list_item_post, parent, false);
                return new PostViewHolder(rootView);
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case ITEM_TYPE_LOAD_MORE_INDICATOR:
                break;
            case ITEM_TYPE_POST:
                final PostViewHolder holder = (PostViewHolder) viewHolder;
                final Post post = posts.get(position);

                Glide.with(holder.featuredIV.getContext()).load(post.getMainImageUrl()).dontAnimate().dontTransform().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.featuredIV);

                holder.titleTV.setText(HtmlUtils.htmlToSpanned(post.getTitle()));
                holder.categoryTV.setText(post.getCategory().getName());

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(post, holder.featuredIV);
                    }
                });

                if(position > lastPosition) {
                    Animation animation = AnimationUtils.loadAnimation(holder.cardView.getContext(), R.anim.up_to_bottom);
                    holder.itemView.startAnimation(animation);
                    lastPosition = position;
                }
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return hasMore ? posts.size() + 1 : posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == posts.size() ? ITEM_TYPE_LOAD_MORE_INDICATOR : ITEM_TYPE_POST;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView featuredIV;
        private TextView titleTV;
        private TextView categoryTV;

        PostViewHolder(View rootView) {
            super(rootView);
            cardView = (CardView) rootView.findViewById(R.id.cardview_post);
            featuredIV = (ImageView) rootView.findViewById(R.id.imageview_post);
            titleTV = (TextView) rootView.findViewById(R.id.textview_title);
            categoryTV = (TextView) rootView.findViewById(R.id.textview_category);
        }
    }

    class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        LoadMoreViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void update(List<Post> newPosts, boolean shouldClear) {
        if (shouldClear) {
            posts.clear();
        }
        posts.addAll(newPosts);

        hasMore = posts.size() > 0 && posts.size() % 10 == 0;

        notifyDataSetChanged();
    }

    public String getPage() {
        return posts.isEmpty() ? null : Long.toString(Long.parseLong(posts.get(posts.size() - 1).getCreatedAt()) - 1);
    }
}
