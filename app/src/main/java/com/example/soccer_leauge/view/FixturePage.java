package com.example.soccer_leauge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.adapter.FixtureAdapter;
import com.example.soccer_leauge.model.WeekMatchesModel;
import com.example.soccer_leauge.viewModel.FixtureViewModel;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

public class FixturePage extends AppCompatActivity {

    public Toolbar toolbar;
    public Switch mode_switch;
    private FixtureAdapter myAdapter;
    ViewPager viewPager;
    private FixtureViewModel weekmodel;
    public GifImageView animation;
    TextView week_number;
    boolean isDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_page);
        Bundle bundle = getIntent().getExtras();
        isDark = bundle.getBoolean("dark_mode");
        mode_switch=findViewById(R.id.switch_dark_mode);
        mode_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on){
                if(on && !isDark)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isDark=true;
                }


            }

        });
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);;

        weekmodel = ViewModelProviders.of(this).get(FixtureViewModel.class);
        weekmodel.getWeekly().observe(this, new Observer<List<List<WeekMatchesModel>>>() {
            int i = 0;
            List<List<WeekMatchesModel>> fixture_table = new ArrayList<List<WeekMatchesModel>>();
            List<WeekMatchesModel> temp = new ArrayList<WeekMatchesModel>();
            @Override
            public void onChanged(List<List<WeekMatchesModel>> lists) {
                if (lists.size() == 42) {
                    System.out.println("tamamlandı");
                    view(lists);
                }
                temp = lists.get(i);
                fixture_table.add(temp);
                i++;
            }
        });
    }

    private void view(List<List<WeekMatchesModel>> lists) {

        week_number=findViewById(R.id.week_number);
        animation=findViewById(R.id.progress_bar);
        viewPager=findViewById(R.id.viewPager);
        toolbar=findViewById(R.id.toolbar);
        mode_switch=findViewById(R.id.switch_dark_mode);
        mode_switch.setChecked(isDark);

        myAdapter=new FixtureAdapter(FixturePage.this,lists);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100,0,100,0);
        viewPager.setCurrentItem(33);

        animation.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
        week_number.setVisibility(View.VISIBLE);
        toolbar.setVisibility(View.VISIBLE);
        mode_switch.setVisibility(View.VISIBLE);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                week_number=findViewById(R.id.week_number);
                if(position<=20){
                    week_number.setText("1. Devre / "+String.valueOf(position+1)+" . Hafta");
                }
                else{
                    week_number.setText("2. Devre / "+String.valueOf(position+1)+" . Hafta");
                }

            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                }
            };
}