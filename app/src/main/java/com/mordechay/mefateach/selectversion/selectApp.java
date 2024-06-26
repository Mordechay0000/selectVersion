package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.mordechay.mefateach.selectversion.activities.ViewResult;

public class selectApp extends AppCompatActivity implements View.OnClickListener {
    Bundle extras;
    Button next;
    Button back;
    int[] valueArray;
    Switch[] swiArray;
    int id = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_app);

        extras = getIntent().getExtras();
        next = findViewById(R.id.button112);
        back = findViewById(R.id.button114);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        valueArray = extras.getIntArray("valueArray");
        swiArray = new Switch[]{
                findViewById(R.id.centralized_switch_system_app_player),
                findViewById(R.id.centralized_switch_system_app_video),
                findViewById(R.id.centralized_switch_system_app_camera),
                findViewById(R.id.centralized_switch_system_app_gallery),
                findViewById(R.id.centralized_switch_system_app_file_explorer),
                findViewById(R.id.centralized_switch_system_app_messages),
                findViewById(R.id.centralized_switch_system_app_remote)
        };

        int a = 0;
        for(int i = id; a <= swiArray.length -1; i++){
            if(valueArray[a + id] == 2){
                swiArray[a].setChecked(true);
            }
            a = a +1;
        }
    }

    @Override
    public void onClick(View v) {
        if(v == next){
            int a = 0;
            for(int i = id; a <=  swiArray.length -1; i++){
                Log.e("error", String.valueOf(a));
                if(swiArray[a].isChecked()){
                    valueArray[a + id] = 2;
                }else{
                    valueArray[a + id] = 1;
                }
                a = a +1;
            }
           Intent i = new Intent(this, ViewResult.class);
            i.putExtra("valueArray",valueArray);
            startActivity(i);
        }else if(v == back){
           this.onBackPressed();
        }

    }
}