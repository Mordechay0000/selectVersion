package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.HashMap;
import java.util.Map;

public class CentralizedActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Map<String, SwitchMaterial> swiMap;
    private SwitchMaterial[] swiArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centralized);

        Bundle extras = getIntent().getExtras();

        swiMap = new HashMap<>();
        swiMap.put("internet", (SwitchMaterial) findViewById(R.id.centralized_switch_internet));
        swiMap.put("google_play_services", (SwitchMaterial) findViewById(R.id.centralized_switch_google_play_services));
        swiMap.put("google_play", (SwitchMaterial) findViewById(R.id.centralized_switch_google_play));
        swiMap.put("kosher_play", (SwitchMaterial) findViewById(R.id.centralized_switch_kosher_play));
        swiMap.put("install_packages", (SwitchMaterial) findViewById(R.id.centralized_switch_install_packages));
        swiMap.put("connect_to_computer", (SwitchMaterial) findViewById(R.id.centralized_switch_connect_to_computer));
        swiMap.put("system_app_player", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_player));
        swiMap.put("system_app_video", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_video));
        swiMap.put("system_app_camera", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_camera));
        swiMap.put("system_app_gallery", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_gallery));
        swiMap.put("system_app_file_explorer", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_file_explorer));
        swiMap.put("system_app_messages", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_messages));
        swiMap.put("system_app_remote", (SwitchMaterial) findViewById(R.id.centralized_switch_system_app_remote));

        swiArray = new SwitchMaterial[swiMap.values().size()];
        swiMap.values().toArray(swiArray);
        for (Map.Entry<String, SwitchMaterial> switchMaterial : swiMap.entrySet()) {
            switchMaterial.getValue().setOnCheckedChangeListener(this);
        }

        HashMap<String, Integer> valueMap = (HashMap<String, Integer>) getIntent().getSerializableExtra("valueArray");
        int[] valueArr = valueMap.values();

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
        if (buttonView == swiMap.get("internet")){
            {
                SwitchMaterial switchMaterial = swiMap.get("kosher_play");
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiMap.get("google_play_services");
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiMap.get("google_play");
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiMap.get("system_app_remote");
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        }
    }
}