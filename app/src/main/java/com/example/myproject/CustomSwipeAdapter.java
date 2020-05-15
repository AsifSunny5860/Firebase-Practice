package com.example.myproject;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter {

    private  int[] interior={R.drawable.nandos1,R.drawable.nandos2,R.drawable.nandos3,R.drawable.nandos4,R.drawable.nandos5,R.drawable.nandos6,R.drawable.nandos7,R.drawable.nandos8,R.drawable.nandos9,R.drawable.nandos10,R.drawable.nandos11,R.drawable.nandos12,R.drawable.nandos13,R.drawable.nandos14,R.drawable.nandos15,R.drawable.nandos16,R.drawable.nandos17};
    private Context context;
    private LayoutInflater layoutInflater;
    boolean isImageFitToScreen;

    public CustomSwipeAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return interior.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.item,container,false);
        final ImageView imageView = item_view.findViewById(R.id.imageViewID);
        TextView textView = item_view.findViewById(R.id.image_count);
        imageView.setImageResource(interior[position]);
        textView.setText("Foodmenu" );

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
