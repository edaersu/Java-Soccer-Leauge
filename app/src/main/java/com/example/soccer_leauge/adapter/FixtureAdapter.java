package com.example.soccer_leauge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.model.WeekMatchesModel;

import java.util.ArrayList;
import java.util.List;

public class FixtureAdapter extends PagerAdapter {

    private Context context;
    private List<List<WeekMatchesModel>> modelArrayList;


    public FixtureAdapter(Context context, List<List<WeekMatchesModel>> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.fixture_item,container,false);
        List<WeekMatchesModel> week_match_list=modelArrayList.get(position);

        /// week_match_list -> custom adapter yaz, çağır

/*
/// listview ile kullanım şekli
        List<String> s_team1_list=new ArrayList<>();
        List<String> s_team2_list=new ArrayList<>();
        List<String> s_score_list=new ArrayList<>();

        for (WeekMatchesModel wm:week_match_list) {
            s_team1_list.add(wm.getTeam1());
            s_team2_list.add(wm.getTeam2());
            s_score_list.add(wm.getScore());
        }
        ListView l_team1,l_team2,l_score;
        l_team1=view.findViewById(R.id.team1);
        l_team2=view.findViewById(R.id.team2);
        l_score=view.findViewById(R.id.score);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), R.layout.fixture_item_row, s_team1_list);
        l_team1.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(view.getContext(), R.layout.team_item, s_score_list);
        l_score.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(view.getContext(), R.layout.fixture_item_row, s_team2_list);
        l_team2.setAdapter(adapter3);
 */

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
