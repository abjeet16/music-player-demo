package com.example.animal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycalListAdapter extends RecyclerView.Adapter<recycalListAdapter.MyViewHolder> {
    Context context;
    public static ArrayList<sportItem> sportsList;

    itemClickLisner listener;

    public recycalListAdapter(Context context, ArrayList<sportItem> sportsList,itemClickLisner listener) {
        this.context = context;
        this.sportsList = sportsList;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(
                R.layout.list_layout,
                parent,
                false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.ballPhoto.setImageResource(sportsList.get(position).smallImage);
        holder.sportName.setText(sportsList.get(position).name);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(sportsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ballPhoto;
        TextView sportName;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sportName = itemView.findViewById(R.id.sportName);
            ballPhoto = itemView.findViewById(R.id.ballPhoto);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
