package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.adapter.FixtureAdapter;
import com.example.soccer_leauge.databinding.ActivityFixturePageBinding;
import com.example.soccer_leauge.model.WeekMatchesModel;
import com.example.soccer_leauge.viewModel.FixtureViewModel;

import java.util.ArrayList;
import java.util.List;


public class FixturePage extends AppCompatActivity {

    private FixtureAdapter myAdapter;
    ViewPager viewPager;
    private ActivityFixturePageBinding activityFixturePageBinding;
    private FixtureViewModel weekmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fixture_page);

        activityFixturePageBinding= DataBindingUtil.setContentView(this,R.layout.activity_fixture_page);
        weekmodel=ViewModelProviders.of(this).get(FixtureViewModel.class);
        weekmodel.getWeekly().observe(this, new Observer<List<List<WeekMatchesModel>>>() {
            int i=0;
            List<List<WeekMatchesModel>> fixture_table=new ArrayList<List<WeekMatchesModel>>();
            List<WeekMatchesModel> temp=new ArrayList<WeekMatchesModel>();
            @Override
            public void onChanged(List<List<WeekMatchesModel>> lists) {
                if(lists.size()==42){
                    System.out.println("tamamlandı");
                    view(lists);
              }
                temp=lists.get(i);
                fixture_table.add(temp);
                i++;
            }
        });
    }

    private void view(List<List<WeekMatchesModel>> lists) {

        viewPager=findViewById(R.id.viewPager);
        myAdapter=new FixtureAdapter(FixturePage.this,lists);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100,0,100,0);
        viewPager.setCurrentItem(myAdapter.getCount()-1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}