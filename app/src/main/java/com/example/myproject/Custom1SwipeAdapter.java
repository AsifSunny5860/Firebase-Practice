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

public class Custom1SwipeAdapter extends PagerAdapter {

    private int[] menu={R.drawable.guha7,R.drawable.guha8,R.drawable.guha9};
    private Context context;
    private LayoutInflater layoutInflater;
    boolean isImageFitToScreen;

    public Custom1SwipeAdapter(Context context){
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
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        textView.setText("Foodmenu : " +position);


        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
