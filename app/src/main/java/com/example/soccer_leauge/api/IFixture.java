package com.example.soccer_leauge.api;

import com.example.soccer_leauge.model.WeekMatchesModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IFixture {

    @GET("leauge/0.json")
    Call<List<WeekMatchesModel>> getLeauges();
}
