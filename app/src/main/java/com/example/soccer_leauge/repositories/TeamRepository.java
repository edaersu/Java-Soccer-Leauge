package com.example.soccer_leauge.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.soccer_leauge.api.Api;
import com.example.soccer_leauge.api.ITeam;
import com.example.soccer_leauge.model.TeamModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamRepository {

    private LiveData<List<TeamModel>> teams;
    private Context context;

    public TeamRepository(Application application) {
        context = application;
      //  celebs = celebrityDao.getAllCelebs();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Api api = new Api();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api.getApi()).addConverterFactory(GsonConverterFactory.create(gson)).build();

        ITeam iteam = retrofit.create(ITeam.class);
        Call<List<TeamModel>> call = iteam.getTeams();

        call.enqueue((new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {

                if (!response.isSuccessful()) {

                    return;

                }
                List<TeamModel> res = response.body();
                System.out.println(response.body());
                for (TeamModel team : res) {


                }
            }

            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {

                System.out.println(t.getMessage());
            }
        }));

    };

    public LiveData<List<TeamModel>> getAllCelebs() {
        return teams;
    }





}
