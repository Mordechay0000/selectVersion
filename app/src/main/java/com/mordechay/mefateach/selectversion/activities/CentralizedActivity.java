package com.mordechay.mefateach.selectversion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mordechay.mefateach.selectversion.R;
import com.mordechay.mefateach.selectversion.data.Constants;

import java.util.HashMap;
import java.util.Map;

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

        int[] valueArray = extras.getIntArray("valueArray");

        for (int i = 0; i < swiArray.length; i++) {
            if (valueArray[i] == Constants.INDEFINITE || valueArray[i] == Constants.SWITCH_OFF){
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(false);
            } else if (valueArray[i] == Constants.SWITCH_ON) {
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(true);
            } else if (valueArray[i] == Constants.SWITCH_DISABLE_OFF) {
                swiArray[i].setEnabled(false);
                swiArray[i].setChecked(false);
            } else if (valueArray[i] == Constants.SWITCH_DISABLE_ON) {
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
            intent.putExtra("valueArray", valueArr);
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
        if (buttonView == swiArray[Constants.INTERNET]){
            {
                SwitchMaterial switchMaterial = swiArray[Constants.KOSHER_PLAY];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiArray[Constants.GOOGLE_PLAY_SERVICES];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiArray[Constants.GOOGLE_PLAY];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        } else if (buttonView == swiArray[Constants.SYSTEM_APP_VIDEO]) {
            {
                SwitchMaterial switchMaterial = swiArray[Constants.SYSTEM_APP_GALLERY];
                if (switchMaterial != null && !switchMaterial.isChecked()) {
                    switchMaterial.setChecked(false);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        } else if (buttonView == swiArray[Constants.SYSTEM_APP_GALLERY]) {
            {
                SwitchMaterial switchMaterial = swiArray[Constants.SYSTEM_APP_VIDEO];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        }
    }
}