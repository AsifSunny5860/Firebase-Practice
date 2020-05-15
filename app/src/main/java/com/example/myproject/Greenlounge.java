package com.example.myproject;

import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Greenlounge extends AppCompatActivity {

    private CardView cardview;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenlounge);

        cardview =findViewById(R.id.Cardview);
        viewPager=findViewById(R.id.viewpager);

        int [] interior= {R.drawable.gc1,R.drawable.gc2,R.drawable.gc3,R.drawable.gc4,R.drawable.gc5,R.drawable.gc6,R.drawable.gc7,R.drawable.gc8};
        LinearLayout Gallery = findViewById(R.id.gallery);
        for (int i = 0; i < interior.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(3, 3, 3, 3);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), interior[i]));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Gallery.addView(imageView);
        }

        CustomP1SwipeAdapter customP1SwipeAdapter = new CustomP1SwipeAdapter(this);
        viewPager.setAdapter(customP1SwipeAdapter);
    }
}
