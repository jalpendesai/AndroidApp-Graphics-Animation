package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Task1 extends Activity {

    ImageView reusableImageView;
    //
    int startx = 10;
    int starty = 10;
    int endx=10;
    int endy=10;

    EditText xEditView,yEditView;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    Handler mHandler = new Handler();
    //
    boolean down = false;
    int up = 0;
    int right = 0;
    int left = 0;
    String length_thickness = "20";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);


        xEditView = findViewById(R.id.txtX);
        xEditView.setText(String.valueOf(0));
        xEditView.setFocusable(false);

        yEditView = findViewById(R.id.txtY);
        yEditView.setText(String.valueOf(0));
        yEditView.setFocusable(false);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);

        // Get Line Thickness Spinner
        final Spinner lineThickness = (Spinner)findViewById(R.id.line_thickness_spinner);

        // List of items in the lineThickness
        String[] thickness = {"20", "22", "24", "26", "28", "30"};

        //ArrayAdapter to attach the list items with Spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,thickness);
        lineThickness.setAdapter(arrayAdapter);

        lineThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                length_thickness = lineThickness.getSelectedItem().toString();
                paint.setStrokeWidth(Integer.parseInt(length_thickness));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        length_thickness = lineThickness.getSelectedItem().toString();
//
//        paint.setStrokeWidth(Integer.parseInt(length_thickness));


//        lineThickness.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String thickness = String.valueOf(adapterView.getItemAtPosition(i));
//                length_thickness = Integer.parseInt(thickness);
//                paint.setStrokeWidth(length_thickness);
//            }
//        });

        // RadioButton For Color
        RadioGroup radioGroup = findViewById(R.id.rbtnGroup);
        final RadioButton rRed = findViewById(R.id.rbtn_Red);
        final RadioButton rGreen = findViewById(R.id.rbtn_Green);
        final RadioButton rYellow = findViewById(R.id.rbtn_Yellow);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rRed.isChecked()){
                    paint.setColor(Color.RED);
                }
                if(rGreen.isChecked()){
                    paint.setColor(Color.GREEN);
                }
                if(rYellow.isChecked()){
                    paint.setColor(Color.YELLOW);
                }
            }
        });

        //Arrow Buttons
        ImageButton btnUp = findViewById(R.id.btn_UP);
        ImageButton btnDown = findViewById(R.id.btn_DOWN);
        ImageButton btnLeft = findViewById(R.id.btn_LEFT);
        ImageButton btnRight = findViewById(R.id.btn_RIGHT);

//        btnDown.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch(motionEvent.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        endy=endy+5;
//                        drawLine(canvas);
//                        return true;
//                }
//                return false;
//            }
//        });


        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy+5;
                drawLine(canvas);
                reusableImageView.invalidate();
                yEditView.setText(String.valueOf(endy));
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine(canvas);
                reusableImageView.invalidate();
                xEditView.setText(String.valueOf(endx));
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-5;
                drawLine(canvas);
                reusableImageView.invalidate();
                yEditView.setText(String.valueOf(endy));
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLine(canvas);
                reusableImageView.invalidate();
                xEditView.setText(String.valueOf(endx));
            }
        });



        //creating a bitmap as content view for the canvas
		/*bitmap = Bitmap.createBitmap((int) getWindowManager()
		        .getDefaultDisplay().getWidth(), (int) getWindowManager()
		        .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);*/
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //
        reusableImageView = findViewById(R.id.ImageViewForDrawing);
        //setting a bitmap as content view for the image
        reusableImageView.setImageBitmap(bitmap);
        //reusableImageView.setVisibility(View.VISIBLE);

        //draw the green rectangle on the image view
        //reusableImageView.setImageResource(R.drawable.green_rect);
    }// end of onCreate


    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.WHITE);
    }
    //
    public void moveRect(Canvas canvas)
    {
        //canvas.translate(endx-startx, endy-starty);
        reusableImageView.setTranslationX(endx - startx);
        reusableImageView.setTranslationY(endy - starty);
        reusableImageView.setColorFilter(Color.GREEN);
    }

    public void drawLine(Canvas canvas)
    {
        //textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,1000,1000,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes





//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        switch(keyCode)
//        {
//
//            case KeyEvent.KEYCODE_S:
//            //case down = true:
//                //reusableImageView.setVisibility(View.VISIBLE);
//                //reusableImageView.setFocusable(true);
//                //reusableImageView.requestFocus();
//                endy=endy+5;
//                drawLine( canvas);
//                //moveRect(canvas);
//                //reusableImageView.invalidate();
//
//                return true;
//
//            case KeyEvent.KEYCODE_W:
//                //reusableImageView.setVisibility(View.VISIBLE);
//                reusableImageView.setFocusable(true);
//                reusableImageView.requestFocus();
//                endy=endy-5;
//                drawLine( canvas);
//                //moveRect(canvas);
//                reusableImageView.invalidate();
//
//                return true;
//            case KeyEvent.KEYCODE_D:
//                //reusableImageView.setVisibility(View.VISIBLE);
//                reusableImageView.setFocusable(true);
//                reusableImageView.requestFocus();
//                endx=endx+5;
//                drawLine(canvas);
//                //moveRect(canvas);
//                reusableImageView.invalidate();
//
//                return true;
//
//        }
//        return false;
//    }
}
