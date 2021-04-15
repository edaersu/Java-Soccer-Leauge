package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toolbar;

import com.example.soccer_leauge.R;
import com.example.soccer_leauge.model.TeamModel;
import com.example.soccer_leauge.viewModel.TeamsViewModel;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class TeamPage extends AppCompatActivity {
    public Button btn_fikstur;
    public  ListView listemiz;
    public GifImageView animation;
    private TeamsViewModel teamViewModel;
    public Toolbar toolbar;
    public Switch mode_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_home_page);

        teamViewModel=ViewModelProviders.of(this).get(TeamsViewModel.class);

        teamViewModel.getTeams().observe(this, new Observer<List<TeamModel>>() {

            @Override
            public void onChanged(List<TeamModel> teamModels) {
                System.out.println(teamModels.size());
                System.out.println("sizee");
                if(teamModels.size()==21){
                    list_team(teamModels);
                }
            }
        });
        btn_fikstur=findViewById(R.id.fikstur);
        btn_fikstur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(TeamPage.this, FixturePage.class);//Optional parameters
                TeamPage.this.startActivity(myIntent);
            }
        });
    }
    public void list_team(List<TeamModel> teamModels){
        listemiz=findViewById(R.id.listview);
        btn_fikstur=findViewById(R.id.fikstur);
        animation=findViewById(R.id.progress_bar);
        toolbar=findViewById(R.id.toolbar);
        mode_switch=findViewById(R.id.switch_dark_mode);

        animation.setVisibility(View.GONE);
        listemiz.setVisibility(View.VISIBLE);
        btn_fikstur.setVisibility(View.VISIBLE);
        toolbar.setVisibility(View.VISIBLE);
        mode_switch.setVisibility(View.VISIBLE);

        System.out.println(teamModels);
        List<String> team_names_list=new ArrayList<String>();
        for (TeamModel t:teamModels ) {
            team_names_list.add(t.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.team_item, team_names_list);
        listemiz.setAdapter(adapter);
    }

}