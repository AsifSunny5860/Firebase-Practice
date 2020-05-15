package com.example.myproject;

import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OzzCafe extends AppCompatActivity {

    private CardView cardview;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozz_cafe);

        cardview =findViewById(R.id.Cardview);
        viewPager=findViewById(R.id.viewpager);

        int [] interior= {R.drawable.ozz1,R.drawable.ozz2,R.drawable.ozz3,R.drawable.ozz4,R.drawable.ozz5,R.drawable.ozz6,R.drawable.ozz7};
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

        CustomCSwipeAdapter customCSwipeAdapter=new CustomCSwipeAdapter(this);
        viewPager.setAdapter(customCSwipeAdapter);
    }
}
