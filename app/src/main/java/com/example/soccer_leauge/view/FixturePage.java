package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.soccer_leauge.R;
import com.example.soccer_leauge.model.WeekMatches;
import com.example.soccer_leauge.service.IFixture;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixturePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_page);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit =new Retrofit.Builder().baseUrl("https://soccer-leauge-default-rtdb.firebaseio.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        IFixture ifixture=retrofit.create(IFixture.class);
        Call<List<WeekMatches>> call=ifixture.getLeauges();

        call.enqueue((new Callback<List<WeekMatches>>() {
            @Override
            public void onResponse(Call<List<WeekMatches>> call, Response<List<WeekMatches>> response) {
                if(!response.isSuccessful()){


                }
                List<WeekMatches> teams=response.body();
                System.out.println("body");
                System.out.println(response.body());

            }
            @Override
            public void onFailure(Call<List<WeekMatches>> call, Throwable t) {
                System.out.println("error");
                System.out.println(t.getMessage());
            }
        }));

    }
}