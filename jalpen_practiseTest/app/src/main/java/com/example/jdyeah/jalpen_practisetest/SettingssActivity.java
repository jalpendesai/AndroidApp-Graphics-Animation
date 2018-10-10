package com.example.jdyeah.jalpen_practisetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SettingssActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingss);

        //
        final ListView lvSettings=(ListView)findViewById(R.id.listView);
        //handle the item click event
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=null;
                String selectedSetting = (String)lvSettings.getItemAtPosition(position);
                //
                switch (position)
                {
                    case 0:
                        intent = new Intent(SettingssActivity.this,StorageActivity.class);
                        intent.putExtra("selectedSetting",selectedSetting );

                        startActivity(intent);
                        break;
                }


            }
        });
    }

}
