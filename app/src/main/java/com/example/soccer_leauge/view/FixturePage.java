package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.databinding.ActivityFixturePageBinding;
import com.example.soccer_leauge.model.WeekMatchesModel;
import com.example.soccer_leauge.viewModel.FixtureViewModel;
import java.util.List;


public class FixturePage extends AppCompatActivity {

    private ActivityFixturePageBinding activityFixturePageBinding;
    private FixtureViewModel weekmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fixture_page);

        activityFixturePageBinding= DataBindingUtil.setContentView(this,R.layout.activity_fixture_page);

        weekmodel=ViewModelProviders.of(this).get(FixtureViewModel.class);
        weekmodel.getWeekly().observe(this, new Observer<List<WeekMatchesModel>>() {
            @Override
            public void onChanged(List<WeekMatchesModel> weekMatches) {
                System.out.println("SİZE");
                System.out.println(weekMatches.size());
                System.out.println(weekMatches.get(4).getTeam1());
            }
        });




    }
}