package com.example.myproject;

import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CherryDrops extends AppCompatActivity {

    private CardView cardview;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cherry_drops);

        cardview =findViewById(R.id.Cardview);
        viewPager=findViewById(R.id.viewpager);

        int [] interior= {R.drawable.cp2,R.drawable.cp3,R.drawable.cp4,R.drawable.cp5,R.drawable.cp9};
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
        CustomC1SwipeAdapter customC1SwipeAdapter =new CustomC1SwipeAdapter(this);
        viewPager.setAdapter(customC1SwipeAdapter);
    }
}
