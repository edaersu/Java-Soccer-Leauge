package com.example.soccer_leauge.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccer_leauge.R;
import com.example.soccer_leauge.model.TeamModel;
import com.example.soccer_leauge.model.WeekMatchesModel;

import java.util.List;

public class WeekMatchesAdapter extends RecyclerView.Adapter<WeekMatchesAdapter.ViewHolder> {

   private LayoutInflater layoutInflater;
   private List<WeekMatchesModel> data;

   WeekMatchesAdapter(Context context,List<WeekMatchesModel> data){
       this.layoutInflater=LayoutInflater.from(context);
       this.data=data;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=layoutInflater.inflate(R.layout.week_match_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeekMatchesModel temp=data.get(position);

        holder.team1.setText(temp.getTeam1());
        holder.team2.setText(temp.getTeam2());
        holder.score.setText(temp.getScore());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView team1,score,team2;

        public ViewHolder(View itemview){
            super(itemview);
            team1=itemview.findViewById(R.id.team1);
            team2=itemview.findViewById(R.id.team2);
            score=itemview.findViewById(R.id.score);



        }
    }


    /// her week in her maçı için text tanımlanıp ona set edilecek
    //weekmatchrow kullanılacsk !!!


}
