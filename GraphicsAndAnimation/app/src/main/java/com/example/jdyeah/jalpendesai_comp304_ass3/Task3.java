package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Task3 extends AppCompatActivity {

    ImageView earth,moon;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        earth = findViewById(R.id.earth);
        moon = findViewById(R.id.moon);

        findViewById(R.id.tweenStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimations(earth,R.anim.rotation);
                //performAnimations(moon,R.anim.rotation);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.moon);

                moon.startAnimation(animation);

            }
        });

        findViewById(R.id.tweenStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                earth.clearAnimation();
                moon.clearAnimation();
            }
        });

    }
    public void performAnimations(ImageView image ,int animationID){
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                animationID);
        image.startAnimation(animation);
    }
}
