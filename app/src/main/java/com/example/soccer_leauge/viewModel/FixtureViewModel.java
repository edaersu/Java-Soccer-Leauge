package com.example.soccer_leauge.viewModel;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.soccer_leauge.service.Api;
import com.example.soccer_leauge.service.IFixtureService;
import com.example.soccer_leauge.model.WeekMatchesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixtureViewModel extends ViewModel {

    public int control=0;
   // public MutableLiveData<List<WeekMatchesModel>>  week=new MutableLiveData<>();
    public MutableLiveData<List<List<WeekMatchesModel>>>  mfixture =new MutableLiveData<>();
    public List<List<WeekMatchesModel>>  temp_fixture_list =new ArrayList<List<WeekMatchesModel>>();


    public MutableLiveData<List<List<WeekMatchesModel>>> getWeekly() {
        if(mfixture==null){
            return new MutableLiveData<>();
        }
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Api api = new Api();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api.getApi())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        IFixtureService ifixture=retrofit.create(IFixtureService.class);

        for (int i=0;i<=41;i++){
            control=i;
            try {
                Call<List<WeekMatchesModel>> call=ifixture.getLeauges(i);
                call.enqueue((new Callback<List<WeekMatchesModel>>() {
                    @Override
                    public void onResponse(Call<List<WeekMatchesModel>> call, Response<List<WeekMatchesModel>> response) {
                        if (!response.isSuccessful()) {
                        }
                        List<WeekMatchesModel> res_week=response.body();
                        //week.setValue(res_week);
                        temp_fixture_list.add(res_week);
                        mfixture.setValue(temp_fixture_list);
                    }
                    @Override
                    public void onFailure(Call<List<WeekMatchesModel>> call, Throwable t) {
                        Log.d("week","hata");
                        System.out.println(t.getMessage());
                    }
                }));
            }
            catch (Exception e){
                break;
            }
        }

        return mfixture;

    }

}
