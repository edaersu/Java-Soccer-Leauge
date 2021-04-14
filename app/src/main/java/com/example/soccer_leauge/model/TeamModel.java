package com.example.soccer_leauge.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamModel {


    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    private int image;

    public TeamModel() {

    }

    public TeamModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
