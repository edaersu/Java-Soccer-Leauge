package com.example.soccer_leauge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.soccer_leauge.R;
import com.example.soccer_leauge.model.WeekMatchesModel;

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
        View view= LayoutInflater.from(context).inflate(R.layout.fixture_page_view_item,container,false);
        List<WeekMatchesModel> week_match_list=modelArrayList.get(position);

        /// week_match_list -> custom adapter yaz, çağır


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
