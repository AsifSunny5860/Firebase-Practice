package com.example.myproject;

import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CheeseFactory extends AppCompatActivity {

    private CardView cardview;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese_factory);

        cardview =findViewById(R.id.Cardview);
        viewPager=findViewById(R.id.viewpager);

        int [] interior= {R.drawable.cf2,R.drawable.cf3,R.drawable.cf4,R.drawable.cf5};
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

        CustomR1SwipeAdapter customR1SwipeAdapter = new CustomR1SwipeAdapter(this);
        viewPager.setAdapter(customR1SwipeAdapter);
    }
}
