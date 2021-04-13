package com.example.soccer_leauge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.soccer_leauge.model.TeamModel;
import com.example.soccer_leauge.service.ITeam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.team_name);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit =new Retrofit.Builder().baseUrl("https://soccer-leauge-default-rtdb.firebaseio.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        ITeam iteam=retrofit.create(ITeam.class);
        Call<List<TeamModel>> call=iteam.getTeams();

        call.enqueue((new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {
                if(!response.isSuccessful()){
                    tv.setText(response.code());
                    return;

                }
                List<TeamModel> teams=response.body();
                System.out.println(response.body());
                for (TeamModel team:teams){
                    String content="";
                    content+=team.getName();
                    tv.append(content);
                    System.out.println(team);
                }
            }
            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {
                tv.setText(t.getMessage());
                System.out.println(t.getMessage());
            }
        }));
    }
}