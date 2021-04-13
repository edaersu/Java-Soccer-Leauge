package com.example.soccer_leauge.model;

import com.google.gson.annotations.SerializedName;

public class WeekMatches {

    @SerializedName("team1")
    private String team1;
    @SerializedName("team2")
    private String team2;
    @SerializedName("score")
    private String score;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
