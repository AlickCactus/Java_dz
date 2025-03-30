package com.example.javadz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyRow>{

    private ArrayList<MainActivity.ModelImage> image;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<MainActivity.ModelImage> image){
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent,false);
        return new RecyclerViewAdapter.MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        Picasso.get().load(this.image.get(position).getUrl()).into(holder.iv);
    }

    class MyRow extends RecyclerView.ViewHolder{
        ImageView imgView;

        public MyRow(@NonNull View itemView){
            super(itemView);
            this.imgView = itemView.findViewById(R.id.imgView);
        }
    }

    @Override
    public  int getItemCount(){
        return this.image.size();
    }

}
