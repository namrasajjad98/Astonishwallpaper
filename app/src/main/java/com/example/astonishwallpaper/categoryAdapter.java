package com.example.astonishwallpaper;

import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {
    Context context;
    int[] images;
    String[] texts;


    public categoryAdapter(Context context, int[] images, String[] texts){
        this.context = context;
        this.images = images;
        this.texts = texts;
    }

    @NonNull
    @Override
    public categoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(images[position])
                .into(holder.shapeableImageView);
        holder.categoryText.setText(texts[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImagesActivity.class);

                intent.putExtra("categoryName", texts[position]); // Pass the category name

                // Pass the image names for the selected category
                int[] categoryImages = getCategoryImages(position); // Get images for the clicked category
                intent.putExtra("imageNames", categoryImages);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    // Method to return images based on the selected category (position)
    private int[] getCategoryImages(int position) {
        switch (position) {
            case 0: // Category 1 (e.g., Simple)
                return new int[]{R.drawable.simple1,R.drawable.simple2,R.drawable.simple3,R.drawable.simple4,R.drawable.simple5};
            case 1: // Category 2 (e.g., Romantic)
                return new int[]{R.drawable.romentic1,R.drawable.romentic2,R.drawable.romentic3,R.drawable.romentic4,R.drawable.romentic5};
            case 2: // Category 3 (e.g., Flowers)
                return new int[]{R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5};
            case 3: // Category 4 (e.g., Nature)
                return new int[]{R.drawable.nature,R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5};
            case 4: // Category 5 (e.g., Music)
                return new int[]{R.drawable.music1,R.drawable.music2,R.drawable.music3,R.drawable.music4,R.drawable.music5};
            case 5:
                return new int[]{R.drawable.ocean1,R.drawable.ocean2,R.drawable.ocean3,R.drawable.ocean4,R.drawable.ocean5};
            case 6:
                return new int[]{R.drawable.spring1,R.drawable.spring2,R.drawable.spring3,R.drawable.spring4,R.drawable.spring5};
            case 7:
                  return new int[] {R.drawable.autmn1,R.drawable.autmn2,R.drawable.autmn3,R.drawable.autmn4,R.drawable.autmn5};
            case 8:
                return new int[] {R.drawable.moutain1,R.drawable.moutain2,R.drawable.moutain3,R.drawable.mountain4,R.drawable.mountain5};
            case 9:
                return new int[] {R.drawable.quote1,R.drawable.quote2,R.drawable.quote3,R.drawable.quote4,R.drawable.quote5};
            case 10:
                return new int[]{R.drawable.sunset1,R.drawable.sunset2,R.drawable.sunset3,R.drawable.sunset4,R.drawable.sunset5};
            case 11:
                return new int[]{R.drawable.snow1,R.drawable.snow2,R.drawable.sunset3,R.drawable.snow4,R.drawable.snow5};
            case 12:
                return new int[] {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5};
            case 13:
                return  new  int[] {R.drawable.travel1,R.drawable.travel2,R.drawable.travel3,R.drawable.travel4,R.drawable.travel5};
            case 14:
                return new int[] {R.drawable.vehicle,R.drawable.v1,R.drawable.v2,R.drawable.v3,R.drawable.travel5};
            case 15:
                return new int[] {R.drawable.pearl,R.drawable.pearl1,R.drawable.pearl2,R.drawable.pearl3,R.drawable.pearl4};
            case 16:
                return new int[]{R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5};
            case 17:
                return new int[]{R.drawable.artistic,R.drawable.art1,R.drawable.art2,R.drawable.art3,R.drawable.art4};
            case 18:
                return new int[] {R.drawable.magic,R.drawable.magic1,R.drawable.magic2,R.drawable.magic3,R.drawable.magic4};
            case 19:
                return new int[] {R.drawable.rain,R.drawable.rain1,R.drawable.rain2,R.drawable.rain3,R.drawable.rain4};
            case 20:
                return new int[] {R.drawable.magic,R.drawable.magic1,R.drawable.magic2,R.drawable.magic3,R.drawable.magic4};
            case 21:
                return new int[] {R.drawable.makeup1,R.drawable.makeup2,R.drawable.makeup3,R.drawable.makeup4,R.drawable.makeup5};
            case 22:
                return new int[] {R.drawable.tech1,R.drawable.tech2,R.drawable.tech3,R.drawable.tech4,R.drawable.tech5};
            case 23:
                return new int[] {R.drawable.study1,R.drawable.study2,R.drawable.study3,R.drawable.study4,R.drawable.study5};
            case 24:
                return new int[] {R.drawable.sad,R.drawable.sad1,R.drawable.sad2,R.drawable.sad3,R.drawable.sad4};
            case 25:
                return new int[] {R.drawable.gliter,R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4};
            case 26:
                return new int[] {R.drawable.animal1,R.drawable.animal2,R.drawable.animal3,R.drawable.animal4,R.drawable.animal5};
            case 27:
                return new int[] {R.drawable.kids,R.drawable.kid1,R.drawable.kid2,R.drawable.kid3,R.drawable.kid4};
            case 28:
                return new int[] {R.drawable.islamic,R.drawable.islamic1,R.drawable.islamic2,R.drawable.islamic3,R.drawable.islamic4};
            case 29:
                return new int[] {R.drawable.hd,R.drawable.hd1,R.drawable.hd2,R.drawable.hd3,R.drawable.hd4};
            // Add more categories as needed
            default:
                return new int[]{}; // Default images in case of no match
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        TextView categoryText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.imageGrid);
            categoryText = itemView.findViewById(R.id.categoryText);
        }
    }
}
