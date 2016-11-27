package com.example.og.ogsn.classes;

/**
 * Created by og on 11/27/16.
 */

public class Friend {
    private String name;
    private String username;
    private String Picture ;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Friend(String name, String username, String picture, String id) {
        this.name = name;
        this.username = username;
        Picture = picture;
        this.id = id;
    }
}
