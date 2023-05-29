package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class CentralizedActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private SwitchMaterial[] swiArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centralized);

        swiArray = new SwitchMaterial[]{
                findViewById(R.id.centralized_switch_internet),

                findViewById(R.id.centralized_switch_google_play_services),
                findViewById(R.id.centralized_switch_google_play),
                findViewById(R.id.centralized_switch_kosher_play),

                findViewById(R.id.centralized_switch_install_packages),
                findViewById(R.id.centralized_switch_connect_to_computer)
        };

        for (SwitchMaterial switchMaterial : swiArray) {
            switchMaterial.setOnCheckedChangeListener(this);
        }

        Button btnNext = findViewById(R.id.centralized_btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.centralized_btn_next){

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}