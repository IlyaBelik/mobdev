package com.example.mob_lab1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.MyViewHolder> {
    private List<Water> WaterList;
    private WaterListener listener;

    public interface WaterListener {
        void onItemClick(Water trip);
    }

    public WaterAdapter(List<Water> WaterList, WaterListener waterListener) {
        this.WaterList = WaterList;
        this.listener = waterListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView level_of_water, coordinates, date_of_test, name_of_point;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            level_of_water = itemView.findViewById(R.id.level_of_water);
            coordinates = itemView.findViewById(R.id.coordinates);
            date_of_test = itemView.findViewById(R.id.date_of_test);
            name_of_point = itemView.findViewById(R.id.name_of_point);
            image = itemView.findViewById(R.id.image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(WaterList.get(getAdapterPosition()));
                }
            });

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iteam_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Water trip = WaterList.get(position);
        holder.coordinates.setText("Coords:" + trip.getcoordinates());
        holder.level_of_water.setText("level_of_w:" + trip.getlevel_of_water());
        holder.date_of_test.setText(trip.getdate_of_test());
        holder.name_of_point.setText("Name: " + trip.getName());
        Picasso.get().load(trip.getImg()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return WaterList.size();
    }


}
