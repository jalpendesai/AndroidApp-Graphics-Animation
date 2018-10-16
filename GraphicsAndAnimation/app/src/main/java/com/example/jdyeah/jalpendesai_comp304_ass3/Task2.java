package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Task2 extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        // Start Button
        final Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        // Stop Button
        final Button btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }

    void startAnimation(){
        ImageView imgView = (ImageView)findViewById(R.id.imageView_Girl);
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame9);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int duration = 250;

        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);  // loop continuously

        mframeAnimation.addFrame(frame1,duration);
        mframeAnimation.addFrame(frame2,duration);
        mframeAnimation.addFrame(frame3,duration);
        mframeAnimation.addFrame(frame4,duration);
        mframeAnimation.addFrame(frame5,duration);
        mframeAnimation.addFrame(frame6,duration);
        mframeAnimation.addFrame(frame7,duration);
        mframeAnimation.addFrame(frame8,duration);
        mframeAnimation.addFrame(frame9,duration);

        imgView.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();

    }

    void stopAnimation(){

        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }

}
