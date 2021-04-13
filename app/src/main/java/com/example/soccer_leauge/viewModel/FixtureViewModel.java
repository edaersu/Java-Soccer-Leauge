package com.example.soccer_leauge.viewModel;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.soccer_leauge.api.Api;
import com.example.soccer_leauge.api.IFixture;
import com.example.soccer_leauge.model.WeekMatchesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixtureViewModel extends ViewModel {

    public MutableLiveData<List<WeekMatchesModel>>  week=new MutableLiveData<>();

    public MutableLiveData<List<WeekMatchesModel>> getWeekly() {
        if(week==null){

            return new MutableLiveData<>();

        }
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Api api = new Api();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api.getApi()).addConverterFactory(GsonConverterFactory.create(gson)).build();

        IFixture ifixture=retrofit.create(IFixture.class);
        Call<List<WeekMatchesModel>> call=ifixture.getLeauges();

        call.enqueue((new Callback<List<WeekMatchesModel>>() {
            @Override
            public void onResponse(Call<List<WeekMatchesModel>> call, Response<List<WeekMatchesModel>> response) {

                if (!response.isSuccessful()) {
                }
                List<WeekMatchesModel> teams=response.body();
                week.setValue(teams);
            }

            @Override
            public void onFailure(Call<List<WeekMatchesModel>> call, Throwable t) {
                Log.d("team","hata");
                System.out.println(t.getMessage());
            }
        }));

        return week;

    }
}
