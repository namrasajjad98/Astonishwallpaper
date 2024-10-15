package com.example.astonishwallpaper;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Image_Detailed extends AppCompatActivity {

    ImageView imageView , share , download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_detailed);

        imageView = findViewById(R.id.detailImage);
        share = findViewById(R.id.shareImage);
        download = findViewById(R.id.downloadImage);

        int imageRes = getIntent().getIntExtra("imageRes", 0);

        // Display the image using Glide
        Glide.with(this)
                .load(imageRes)
                .into(imageView);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shareImage();

            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                downloadImage();

            }
        });
        }

    // Method to share the image
    private void shareImage() {
        // Convert ImageView to a Bitmap
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        try {
            // Save bitmap to cache directory
            File cachePath = new File(getCacheDir(), "images");
            if (!cachePath.exists()) {
                cachePath.mkdirs(); // Create directory if it doesn't exist
            }
            File file = new File(cachePath, "image.png");
            try (FileOutputStream stream = new FileOutputStream(file)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            }

            // Get URI for the image
            Uri imageUri = FileProvider.getUriForFile(this, "com.example.astonishwallpaper.fileprovider", file);

            // Create a generic share intent
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            // Create chooser to allow user to pick an app
            Intent chooser = Intent.createChooser(shareIntent, "Share image via");
            startActivity(chooser);

            Toast.makeText(this, "Sharing image...", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error while sharing image.", Toast.LENGTH_SHORT).show();
        }
    }



    private void downloadImage() {
        // Convert ImageView to Bitmap
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        try {
            // Use MediaStore to save image in Android 10+ without needing permissions
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/astonish wallpaper");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
            values.put(MediaStore.Images.Media.IS_PENDING, true);

            Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            if (uri != null) {
                OutputStream fos = getContentResolver().openOutputStream(uri);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();

                values.put(MediaStore.Images.Media.IS_PENDING, false);
                getContentResolver().update(uri, values, null, null);

                Toast.makeText(this, "Image downloaded to gallery.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error while downloading image.", Toast.LENGTH_SHORT).show();
        }
    }

    }
