package com.example.og.ogsn.classes;

/**
 * Created by og on 11/27/16.
 */

public class Message {
    private String id;
    private String text;
    private String username;

    public Message(String id, String text, String username) {
        this.id = id;
        this.text = text;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}