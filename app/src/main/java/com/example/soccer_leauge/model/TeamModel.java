package com.example.soccer_leauge.model;

import com.google.gson.annotations.SerializedName;

public class TeamModel {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;

    public TeamModel(String name, int id) {
        this.name = name;
        this.id = id;
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
