package com.example.astonishwallpaper;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    public GridSpacingItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing;

        // Add top margin only for the first row to avoid double space between items
        if (parent.getChildAdapterPosition(view) < 2) {
            outRect.top = spacing;
        } else {
            outRect.top = 0;
        }
    }

}
