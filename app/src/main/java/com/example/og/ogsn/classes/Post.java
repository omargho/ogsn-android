package com.example.og.ogsn.classes;

/**
 * Created by og on 11/8/16.
 */

public class Post {
    private String username;
    private String completeName;
    private String postText;

    public Post(String username, String completeName, String postText, String postImgUrl) {
        this.username = username;
        this.completeName = completeName;
        this.postText = postText;
        this.postImgUrl = postImgUrl;
    }

    private String postImgUrl;
    public Post(){
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }
}
