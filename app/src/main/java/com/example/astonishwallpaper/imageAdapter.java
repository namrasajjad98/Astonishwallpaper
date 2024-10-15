package com.example.astonishwallpaper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder> {
    Context context;
    int[] images;

    public imageAdapter(Context context, int[] images){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public imageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(images[position])
                .into(holder.shapeableImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Image_Detailed.class);
                intent.putExtra("imageRes",images[position]);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.images);
        }
    }
}