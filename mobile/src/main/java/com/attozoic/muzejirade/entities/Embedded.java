package com.attozoic.muzejirade.entities;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Kresa on 4/14/17.
 */

@Parcel
public class Embedded extends BaseEntity {

    @SerializedName("wp:featuredmedia")
    private List<FeaturedMedia> featuredMedia;

    public List<FeaturedMedia> getFeaturedMedia() {
        return featuredMedia;
    }

    public void setFeaturedMedia(List<FeaturedMedia> featuredMedia) {
        this.featuredMedia = featuredMedia;
    }
}
