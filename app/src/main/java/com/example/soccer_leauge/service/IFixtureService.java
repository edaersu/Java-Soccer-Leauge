package com.example.soccer_leauge.service;

import com.example.soccer_leauge.model.WeekMatchesModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IFixtureService {

    @GET("leauge/{week}/.json")
    Call<List<WeekMatchesModel>> getLeauges(
            @Path("week") int week
    );

}
