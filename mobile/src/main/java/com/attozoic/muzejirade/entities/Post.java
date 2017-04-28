package com.attozoic.muzejirade.entities;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Kresa on 4/10/17.
 */

@Parcel
public class Post extends BaseEntity {

    private String id;
    private Renderable title;
    private Renderable content;
    private Renderable excerpt;
    @SerializedName("_embedded")
    private Embedded embedded;

    private String featuredImageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Renderable getTitle() {
        return title;
    }

    public void setTitle(Renderable renderable) {
        this.title = renderable;
    }

    public Renderable getContent() {
        return content;
    }

    public void setContent(Renderable content) {
        this.content = content;
    }

    public Renderable getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Renderable excerpt) {
        this.excerpt = excerpt;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public String getFeaturedImageUrl() {
        String baseUrl = embedded.getFeaturedMedia().get(0).getSourceUrl();
        return baseUrl;//new StringBuilder(baseUrl).insert(baseUrl.length() - 4, "-225x136").toString();
    }

    public Category getCategory() {
        return embedded.getTerm().get(0).get(0);
    }
}
