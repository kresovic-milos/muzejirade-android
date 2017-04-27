package com.attozoic.muzejirade.entities;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Kresa on 4/14/17.
 */

@Parcel
public class FeaturedMedia {

    @SerializedName("source_url")
    private String sourceUrl;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
