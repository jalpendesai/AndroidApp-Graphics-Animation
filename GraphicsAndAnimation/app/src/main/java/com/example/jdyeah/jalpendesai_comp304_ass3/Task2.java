package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Task2 extends AppCompatActivity {

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
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.1Frame);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.2Frame);

    }

    void stopAnimation(){

    }

}
