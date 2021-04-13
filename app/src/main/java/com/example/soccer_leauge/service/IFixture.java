package com.example.soccer_leauge.service;

import com.example.soccer_leauge.model.WeekMatches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IFixture {

    @GET("leauge/0.json")
    Call<List<WeekMatches>> getLeauges();
}
