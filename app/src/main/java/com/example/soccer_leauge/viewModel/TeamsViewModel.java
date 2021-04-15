package com.example.soccer_leauge.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.soccer_leauge.service.Api;
import com.example.soccer_leauge.service.ITeamService;
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

public class TeamsViewModel extends ViewModel {

    MutableLiveData<List<TeamModel>> mteam=new MutableLiveData<>();
    List<TeamModel> teams_list=new ArrayList<TeamModel>();
    public LiveData<List<TeamModel>> getAllTeams(){
        if(mteam==null){
            getTeams();
        }
        return mteam;
    }

    public MutableLiveData<List<TeamModel>> getTeams() {
        if(mteam==null){
            return new MutableLiveData<>();
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Api api = new Api();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api.getApi()).addConverterFactory(GsonConverterFactory.create(gson)).build();

        ITeamService iteam = retrofit.create(ITeamService.class);
        Call<List<TeamModel>> call = iteam.getTeams();

        call.enqueue((new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {

                if (!response.isSuccessful()) {
                    return;
                }
                List<TeamModel> res = response.body();
                List<TeamModel> teams = new ArrayList<TeamModel>();
                System.out.println(response.body());
                for (TeamModel team : res) {

                    teams_list.add(team);
                    mteam.setValue(teams_list);
                }

            }

            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {
                Log.d("team","hata");
                System.out.println(t.getMessage());
            }
        }));

        return mteam;

    }


}
