package com.example.myproject;

import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Guha extends AppCompatActivity {
    private CardView cardview;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guha);

        cardview =findViewById(R.id.Cardview);
        viewPager=findViewById(R.id.viewpager);
        int [] interior ={R.drawable.guha1,R.drawable.guha2,R.drawable.guha3,R.drawable.guha4,R.drawable.guha5,R.drawable.guha6};

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

            Custom1SwipeAdapter custom1SwipeAdapter = new Custom1SwipeAdapter(this);
            viewPager.setAdapter(custom1SwipeAdapter);

    }

}
