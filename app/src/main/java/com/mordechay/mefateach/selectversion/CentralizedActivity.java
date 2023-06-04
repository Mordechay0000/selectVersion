package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Bundle extras = getIntent().getExtras();

        swiArray = new SwitchMaterial[]{
                findViewById(R.id.centralized_switch_internet),

                findViewById(R.id.centralized_switch_google_play_services),
                findViewById(R.id.centralized_switch_google_play),
                findViewById(R.id.centralized_switch_kosher_play),

                findViewById(R.id.centralized_switch_install_packages),
                findViewById(R.id.centralized_switch_connect_to_computer),

                findViewById(R.id.centralized_switch_system_app_player),
                findViewById(R.id.centralized_switch_system_app_video),
                findViewById(R.id.centralized_switch_system_app_camera),
                findViewById(R.id.centralized_switch_system_app_gallery),
                findViewById(R.id.centralized_switch_system_app_file_explorer),
                findViewById(R.id.centralized_switch_system_app_messages),
                findViewById(R.id.centralized_switch_system_app_remote)
        };
        for (SwitchMaterial switchMaterial : swiArray) {
            switchMaterial.setOnCheckedChangeListener(this);
        }

        int[] valueArr = extras.getIntArray("valueArray");

        for (int i = 0; i < swiArray.length; i++) {
            if (valueArr[i] == Constants.INDEFINITE || valueArr[i] == Constants.SWITCH_OFF){
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(false);
            } else if (valueArr[i] == Constants.SWITCH_ON) {
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(true);
            } else if (valueArr[i] == Constants.SWITCH_DISABLE_OFF) {
                swiArray[i].setEnabled(false);
                swiArray[i].setChecked(false);
            } else if (valueArr[i] == Constants.SWITCH_DISABLE_ON) {
                swiArray[i].setEnabled(false);
                swiArray[i].setChecked(true);
            }
        }

        Button btnNext = findViewById(R.id.centralized_btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.centralized_btn_next){
            int[] valueArr = getFromSwitch();
            Intent intent = new Intent();
            intent.setClass(this, ViewResult.class);
            startActivity(intent);
        }
    }

    private int[] getFromSwitch() {
        int[] valueArr = new int[swiArray.length];
        for (int i = 0; i < swiArray.length; i++) {
            valueArr[i] = swiArray[i].isEnabled() ? swiArray[i].isChecked() ? Constants.SWITCH_ON : Constants.SWITCH_OFF : swiArray[i].isChecked() ? Constants.SWITCH_DISABLE_ON : Constants.SWITCH_DISABLE_OFF;
        }
        return valueArr;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}