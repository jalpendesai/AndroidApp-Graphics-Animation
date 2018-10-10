package com.example.jdyeah.jalpendesai_comp304_ass3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AlertDialog Box
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.dialog_name).setTitle(R.string.dialog_title);
//
//        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(),
//                        "YESsssszzz", Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });
//        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(),
//                        "NOoooo...", Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();

        final Intent task1 = new Intent(this,Task1.class);
        final Intent task2 = new Intent(this,Task2.class);
        final Intent task3 = new Intent(this,Task3.class);

        String[] tasks = {"task1", "task2", "task3"};
        ListAdapter tasksAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tasks);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(tasksAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String task = String.valueOf(adapterView.getItemAtPosition(i));

                if(task == "task1"){
                    //Toast.makeText(MainActivity.this, "Task1 ",Toast.LENGTH_SHORT).show();
                    startActivity(task1);
                }
                if(task == "task2"){
                    //Toast.makeText(MainActivity.this, "Task2 ",Toast.LENGTH_SHORT).show();
                    startActivity(task2);
                }
                if(task == "task3"){
                    //Toast.makeText(MainActivity.this, "Task3 ",Toast.LENGTH_SHORT).show();
                    startActivity(task3);
                }
            }
        });
    }



}
