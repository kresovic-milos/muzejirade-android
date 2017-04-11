package com.attozoic.muzejirade.entities;

/**
 * Created by Kresa on 4/10/17.
 */

public class Post extends BaseEntity {

    private String id;
    private Renderable title;
    private Renderable content;

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
}
