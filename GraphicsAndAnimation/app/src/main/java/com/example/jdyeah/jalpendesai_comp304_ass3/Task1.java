package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Task1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // Get Line Thickness Spinner
        Spinner lineThickness = (Spinner)findViewById(R.id.line_thickness_spinner);

        // List of items in the lineThickness
        String[] thickness = {"20", "22", "24", "26", "28", "30"};

        //ArrayAdapter to attach the list items with Spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,thickness);
        lineThickness.setAdapter(arrayAdapter);
    }
}
