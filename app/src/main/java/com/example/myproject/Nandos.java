package com.example.myproject;

import android.content.Intent;
import android.graphics.BitmapFactory;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Nandos extends AppCompatActivity {

    private CardView cardview;
    private ViewPager viewPager;
    private Button mapButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nandos);


         mapButton=findViewById(R.id.mapButton);
         cardview =findViewById(R.id.Cardview);
         viewPager=findViewById(R.id.viewpager);

         mapButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Nandos.this,MapActivity.class);
                 startActivity(intent);

             }
         });

        int [] menu= {R.drawable.nana,R.drawable.nano,R.drawable.nanooo1,R.drawable.nandosss,R.drawable.nando_s,R.drawable.nandosbanani,R.drawable.nandogulshan};

        LinearLayout Gallery = findViewById(R.id.gallery);
        for (int i = 0; i < menu.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(3, 3, 3, 3);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), menu[i]));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Gallery.addView(imageView);
        }

        CustomSwipeAdapter adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
