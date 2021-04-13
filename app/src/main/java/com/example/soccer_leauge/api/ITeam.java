package com.example.soccer_leauge.api;

import com.example.soccer_leauge.model.TeamModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ITeam {

    @GET("teams.json")
    Call<List<TeamModel>> getTeams();
}
