package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.databinding.ActivityHomePageBinding;
import com.example.soccer_leauge.model.TeamModel;
import com.example.soccer_leauge.viewModel.TeamsViewModel;
import com.example.soccer_leauge.viewModel.FixtureViewModel;
import java.util.List;

public class TeamPage extends AppCompatActivity {
    Button btn_fikstur;

    private ActivityHomePageBinding activityHomePageBinding;
    private TeamsViewModel denemviewmodel;
    private FixtureViewModel weekmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_home_page);
        activityHomePageBinding=DataBindingUtil.setContentView(this,R.layout.activity_home_page);

        denemviewmodel=ViewModelProviders.of(this).get(TeamsViewModel.class);
        weekmodel=ViewModelProviders.of(this).get(FixtureViewModel.class);

        denemviewmodel.getTeams().observe(this, new Observer<List<TeamModel>>() {
            @Override
            public void onChanged(List<TeamModel> teamModels) {
                System.out.println(teamModels.size());
                System.out.println("sizeeeeeeeeeeeeeeeeeeeee");
            }
        });




        // fikstür sayfasına geç
        btn_fikstur=findViewById(R.id.fikstur);
        btn_fikstur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(TeamPage.this, FixturePage.class);//Optional parameters
                TeamPage.this.startActivity(myIntent);
            }
        });
    }

}