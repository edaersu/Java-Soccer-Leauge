package com.example.soccer_leauge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        View view= LayoutInflater.from(context).inflate(R.layout.fixture_item,container,false);

        TextView _1_1=view.findViewById(R.id._1_1);
        TextView _1_2=view.findViewById(R.id._1_2);
        TextView _1_3=view.findViewById(R.id._1_3);

        List<WeekMatchesModel> model=modelArrayList.get(position);

        _1_1.setText(model.get(0).getTeam1());
        _1_2.setText(model.get(0).getScore());
        _1_3.setText(model.get(0).getTeam2());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
