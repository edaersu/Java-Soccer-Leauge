package com.example.soccer_leauge.service;

import com.example.soccer_leauge.model.TeamModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ITeamService {

    @GET("teams.json")
    Call<List<TeamModel>> getTeams();
}
