package com.example.soccer_leauge.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.soccer_leauge.R;
import com.example.soccer_leauge.databinding.ActivityHomePageBinding;
import com.example.soccer_leauge.model.TeamModel;
import com.example.soccer_leauge.viewModel.TeamsViewModel;
import com.example.soccer_leauge.viewModel.FixtureViewModel;

import java.util.ArrayList;
import java.util.List;

public class TeamPage extends AppCompatActivity {
    public Button btn_fikstur;
    public  ListView listemiz;
    public TextView tv_header;
    public ProgressBar progressBar;

    private ActivityHomePageBinding activityHomePageBinding;
    private TeamsViewModel denemviewmodel;
    private FixtureViewModel weekmodel;
    public List<TeamModel> api_team_list;
    public List<String> team_name_list_str;

    public LiveData<List<TeamModel>> live_team_data;

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_home_page);

        activityHomePageBinding=DataBindingUtil.setContentView(this,R.layout.activity_home_page);
        denemviewmodel=ViewModelProviders.of(this).get(TeamsViewModel.class);

        denemviewmodel.getTeams().observe(this, new Observer<List<TeamModel>>() {

            @Override
            public void onChanged(List<TeamModel> teamModels) {
                System.out.println(teamModels.size());
                System.out.println("sizee");
                if(teamModels.size()==21){
                    listele(teamModels);
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
    public void listele(List<TeamModel> gelenlist){
        listemiz=findViewById(R.id.listview);
        btn_fikstur=findViewById(R.id.fikstur);
        tv_header=findViewById(R.id.takim_listesi_header);
        progressBar=findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.GONE);
        tv_header.setVisibility(View.VISIBLE);
        listemiz.setVisibility(View.VISIBLE);
        btn_fikstur.setVisibility(View.VISIBLE);


        System.out.println(gelenlist);
        List<String> hello=new ArrayList<String>();
        for (TeamModel t:gelenlist ) {
            hello.add(t.getName());
        }

        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, R.layout.team_item, hello);
        listemiz.setAdapter(mHistory);
    }

}