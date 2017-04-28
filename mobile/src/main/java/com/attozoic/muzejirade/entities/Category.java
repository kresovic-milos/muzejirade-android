package com.attozoic.muzejirade.entities;

import org.parceler.Parcel;

/**
 * Created by Kresa on 4/27/17.
 */

@Parcel
public class Category extends BaseEntity {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
