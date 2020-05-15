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

public class CustomP1SwipeAdapter extends PagerAdapter {

    private int[] menu={R.drawable.gc9,R.drawable.gc10,R.drawable.gc11,R.drawable.gc12,R.drawable.gc13,R.drawable.gc14,R.drawable.gc15,R.drawable.gc16};
    private Context context;
    private LayoutInflater layoutInflater;
    boolean isImageFitToScreen;

    public CustomP1SwipeAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return menu.length;
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
        imageView.setImageResource(menu[position]);
        textView.setText("Foodmenu");
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);


        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
