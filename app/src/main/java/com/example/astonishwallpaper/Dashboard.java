package com.example.astonishwallpaper;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        recyclerView=findViewById(R.id.categoryRecycler);

        int[] images = {R.drawable.simple_category,R.drawable.romentic,R.drawable.flower,R.drawable.nature,R.drawable.music
                ,R.drawable.ocean,R.drawable.spring,R.drawable.autumn,R.drawable.mountain,R.drawable.quotescover,R.drawable.sunset
                ,R.drawable.snow,R.drawable.princess,R.drawable.travel,R.drawable.vehicle,R.drawable.pearl_cover,R.drawable.foodie
                ,R.drawable.artistic_cover,R.drawable.magic_cover,R.drawable.rain_cover,R.drawable.fantacy_cover,R.drawable.makeup,R.drawable.techniqal,R.drawable.study,R.drawable.sad_cover, R.drawable.glitter_cover
                ,R.drawable.animal,R.drawable.kids_cover,R.drawable.islamic_cover,R.drawable.hd};


        String[] texts = {"Simple", "Romantic","Flowers","Nature","Music","Ocean","Spring","Autumn","Mountain","Quote","Sunset"
        ,"Snow White","Princess","Travel","Vehicle","Pearl","Foodie","Artistic","Magic","Rain","Fantasy","Makeup","Technical","Study","Sad and Alone","Glitter"
        ,"Animals","Kids","Islamic","HD Wallpaper"};


        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,3);


        recyclerView.setLayoutManager(gridLayoutManager);

        categoryAdapter categoryAdapter = new categoryAdapter(this, images,texts);
        recyclerView.setAdapter(categoryAdapter);

    }
}